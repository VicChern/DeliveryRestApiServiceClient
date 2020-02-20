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
        final User user1 = getUserWithName("Currier");
        User userForCustomer = usersApi.addUser(user1);

        final User user2 = getUserWithName("Customer");
        User userForCurrier = usersApi.addUser(user2);

        final User user3 = getUserWithName("Tenant");
        User userForTenant = usersApi.addUser(user3);
        LOGGER.info("\n\n STEP 1: Added new users: for customer {}, for currier {}, for tenant {}",
                user1, user2, user3);

        AddressList addresses = usersApi.addUserAddresses(userForCustomer.getGuid(), ModelUtils.getAddresses());
        LOGGER.info("\n\n STEP 2: Added addresses {} for user guid={}", addresses, userForCustomer.getGuid());

        Tenant tenant = tenantApi.addTenant(ModelUtils.getTenantFor(userForTenant));
        LOGGER.info("\n\n STEP 3: Added new tenant {} for user guid={}, name={}",
                tenant,
                userForTenant.getGuid(),
                userForTenant.getName());

        Order order = ordersApi.addOrder(ModelUtils.getOrderFor(userForCustomer, tenant));
        LOGGER.info("\n\n STEP 4: Added new order {} from user guid={} for tenant guid={}",
                order,
                userForCustomer.getGuid(),
                userForTenant.getGuid());

        //System automatically added actor (user_guid(customer)) and role CUSTOMER
//System automatically added event (EventDTO) and event_type CREATED

        OrderEvent eventCreated = ordersApi.addEvent(userForCustomer.getGuid(),
                ModelUtils.getOrderEventFor(OrderEventTypes.CREATED));
        LOGGER.info("\n\n STEP 4: Added new event {} for orderGuid={}", order.getGuid(), eventCreated);

//Currier takes order: Currier add event (EventDTO, user_guid(currier)), event_type ASSIGNED
//System automatically added actor (user_guid(currier)) and role CURRIER

        OrderEvent eventAssigned = ordersApi.addEvent(userForCustomer.getGuid(),
                ModelUtils.getOrderEventFor(OrderEventTypes.ASSIGNED));
        LOGGER.info("\n\n STEP 4: Added new event {} for orderGuid={}", order.getGuid(), eventAssigned);

//Currier started delivery: Currier add event (EventDTO, user_guid(currier)), event_type STARTED
//System automatically added actor (user_guid(currier)) and role CURRIER (this step only if CURRIER is chenged to another user)

        OrderEvent eventStarted = ordersApi.addEvent(userForCustomer.getGuid(),
                ModelUtils.getOrderEventFor(OrderEventTypes.STARTED));
        LOGGER.info("\n\n STEP 4: Added new event {} for orderGuid={}", order.getGuid(), eventStarted);

//Customer send request to get geolocation of an order

//Currier finished delivery: Currier added event (EventDTO, user_guid(currier)) with event_type DELIVERED
        OrderEvent eventDelivered = ordersApi.addEvent(userForCustomer.getGuid(),
                ModelUtils.getOrderEventFor(OrderEventTypes.DELIVERED));
        LOGGER.info("\n\n STEP 4: Added new event {} for orderGuid={}", order.getGuid(), eventDelivered);

//Tenant guid send request to get all information about events of actor (what role had user (currier, admin...)
// at different time for what order)

    }
}
