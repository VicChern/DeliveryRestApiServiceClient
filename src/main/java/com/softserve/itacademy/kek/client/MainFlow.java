package com.softserve.itacademy.kek.client;

import java.util.List;

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
        User userForCustomer = usersApi.addUser(user1);

        final User user2 = getUserWithName("Currier");
        User userForCurrier = usersApi.addUser(user2);

        final User user3 = getUserWithName("Tenant");
        final User userForTenant = usersApi.addUser(user3);
        LOGGER.info("\n\n STEP 1: Added new users: for customer {}, for currier {}, for tenant {}",
                user1, user2, user3);

        final AddressList addresses = usersApi.addUserAddresses(userForCustomer.getGuid(), ModelUtils.getAddresses());
        LOGGER.info("\n\n STEP 2: Added addresses {} for customer guid={}", addresses, userForCustomer.getGuid());

        final Tenant tenant = tenantApi.addTenant(ModelUtils.getTenantFor(userForTenant));
        LOGGER.info("\n\n STEP 3: Added new tenant {} for user guid={}, name={}",
                tenant,
                userForTenant.getGuid(),
                userForTenant.getName());

        final Order order = ModelUtils.getOrderFor(userForCustomer, tenant);

        //System automatically added actor (user_guid(customer)) and role CUSTOMER
        //System automatically added event (EventDTO) and event_type CREATED
        final OrderList orderList = ordersApi.addOrder(ModelUtils.getSingletonOrderList(order), userForCustomer.getGuid());
        final Order savedOrder = orderList.getOrderList().get(0);
        LOGGER.info("\n\n STEP 4: Added new order {} from customer guid={} for tenant guid={}",
                savedOrder,
                userForCustomer.getGuid(),
                tenant.getGuid());

        //Currier takes order: Currier add event (EventDTO, user_guid(currier)), event_type ASSIGNED
        //System automatically added actor (user_guid(currier)) and role CURRIER
        final OrderEvent eventAssigned = ordersApi.addEvent(savedOrder.getGuid(), userForCurrier.getGuid(),
                ModelUtils.getOrderEventForOrder(savedOrder, OrderEventTypes.ASSIGNED));
        LOGGER.info("\n\n STEP 4: Added new event {} for orderGuid={}",  eventAssigned, savedOrder.getGuid());


        //Currier started delivery: Currier add event (EventDTO, user_guid(currier)), event_type STARTED
        //System automatically added actor (user_guid(currier)) and role CURRIER (this step only if CURRIER is changed to another user)
        final OrderEvent eventStarted1 = ordersApi.addEvent(savedOrder.getGuid(), userForCurrier.getGuid(),
                ModelUtils.getOrderEventForOrder(savedOrder, OrderEventTypes.STARTED));
        LOGGER.info("\n\n STEP 4: Added new event {} for orderGuid={}", eventStarted1, savedOrder.getGuid());

        final OrderEvent eventStarted2 = ordersApi.addEvent(savedOrder.getGuid(), userForCurrier.getGuid(),
                ModelUtils.getOrderEventForOrder(savedOrder, OrderEventTypes.STARTED));
        LOGGER.info("\n\n STEP 4: Added new event {} for orderGuid={}", eventStarted2, savedOrder.getGuid());

        final OrderEvent eventStarted3 = ordersApi.addEvent(savedOrder.getGuid(), userForCurrier.getGuid(),
                ModelUtils.getOrderEventForOrder(savedOrder, OrderEventTypes.STARTED));
        LOGGER.info("\n\n STEP 4: Added new event {} for orderGuid={}", eventStarted3, savedOrder.getGuid());

        //Customer send request to get geolocation of an order

        //Currier finished delivery: Currier added event (EventDTO, user_guid(currier)) with event_type DELIVERED
        final OrderEvent eventDelivered = ordersApi.addEvent(savedOrder.getGuid(), userForCurrier.getGuid(),
                ModelUtils.getOrderEventForOrder(savedOrder, OrderEventTypes.DELIVERED));
        LOGGER.info("\n\n STEP 4: Added new event {} for orderGuid={}", eventDelivered, savedOrder.getGuid());

        //Tenant guid send request to get all information about events of actor (what role had user (currier, admin...)
        // at different time for what order)

    }
}
