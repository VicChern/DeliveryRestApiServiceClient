package com.softserve.itacademy.kek.client;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.softserve.itacademy.kek.client.utils.ModelUtils;
import com.softserve.itacademy.kek.rest.api.OrdersApi;
import com.softserve.itacademy.kek.rest.api.TenantsApi;
import com.softserve.itacademy.kek.rest.api.UsersApi;
import com.softserve.itacademy.kek.rest.model.AddressList;
import com.softserve.itacademy.kek.rest.model.Order;
import com.softserve.itacademy.kek.rest.model.OrderEvent;
import com.softserve.itacademy.kek.rest.model.OrderEventTypes;
import com.softserve.itacademy.kek.rest.model.OrderList;
import com.softserve.itacademy.kek.rest.model.Tenant;
import com.softserve.itacademy.kek.rest.model.User;


import static com.softserve.itacademy.kek.client.utils.ModelUtils.getUserWithName;


public class MainFlow
{
    private final static Logger LOGGER = LoggerFactory.getLogger(MainFlow.class);
    private final static String HOST = "http://localhost:8080/api/v1";
    private final static OrdersApi ordersApi = RestClientFactory.createRestApiClient(OrdersApi.class, HOST);
    private final static TenantsApi tenantApi = RestClientFactory.createRestApiClient(TenantsApi.class, HOST);
    private final static UsersApi usersApi = RestClientFactory.createRestApiClient(UsersApi.class, HOST);


    public static void main(String[] args)
    {
        final User user1 = getUserWithName("Customer");
        User customer = usersApi.addUser(user1);

        final User user2 = getUserWithName("Currier");
        User currier = usersApi.addUser(user2);

        final User user3 = getUserWithName("Tenant");
        final User userForTenant = usersApi.addUser(user3);
        LOGGER.info("\n\n STEP 1: Added new users: for customer {}, for currier {}, for tenant {}",
                user1, user2, user3);

        final AddressList addresses = usersApi.addUserAddresses(customer.getGuid(), ModelUtils.getAddresses());
        LOGGER.info("\n\n STEP 2: Added addresses {} for customer guid={}", addresses, customer.getGuid());

        final Tenant tenant = tenantApi.addTenant(ModelUtils.getTenantFor(userForTenant));
        LOGGER.info("\n\n STEP 3: Added new tenant {} for user guid={}, name={}",
                tenant,
                userForTenant.getGuid(),
                userForTenant.getName());

        //System automatically added actor (user_guid(customer)) and role CUSTOMER
        //System automatically added event (EventDTO) and event_type CREATED
        final Order orderStub = ModelUtils.getOrderFor(customer, tenant);
        final OrderList orderList = ordersApi.addOrder(ModelUtils.getSingletonOrderList(orderStub), customer.getGuid());
        final Order order = orderList.getOrderList().get(0);
        LOGGER.info("\n\n STEP 4: Added new order {} from customer guid={} for tenant guid={}",
                order,
                customer.getGuid(),
                tenant.getGuid());

        //Currier takes order: Currier add event (EventDTO, user_guid(currier)), event_type ASSIGNED
        //System automatically added actor (user_guid(currier)) and role CURRIER
        final OrderEvent eventAssigned = ordersApi.addEvent(order.getGuid(), currier.getGuid(),
                ModelUtils.getOrderEvent(order, OrderEventTypes.ASSIGNED));
        LOGGER.info("\n\n STEP 5: Added new event {} for orderGuid={}",  eventAssigned, order.getGuid());

//http://localhost:8080/api/v1/orders/e5e010a3-2da8-47db-8d5a-c4a6c6f41281/tracking/
        //Currier started delivery: Currier add event (EventDTO, user_guid(currier)), event_type STARTED
        //System automatically added actor (user_guid(currier)) and role CURRIER (this step only if CURRIER is changed to another user)
        Delivery delivery = new Delivery(currier, order);
        Thread thread = new Thread(delivery);
        thread.start();

        try{
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //Customer send request to get geolocation of an order

        //Currier finished delivery: Currier added event (EventDTO, user_guid(currier)) with event_type DELIVERED
        final OrderEvent eventDelivered = ordersApi.addEvent(order.getGuid(), currier.getGuid(),
                ModelUtils.getOrderEvent(order, OrderEventTypes.DELIVERED));
        LOGGER.info("\n\n STEP 6: Added new event {} for orderGuid={}", eventDelivered, order.getGuid());

    }

}
