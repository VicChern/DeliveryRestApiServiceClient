package com.softserve.itacademy.kek.client;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.softserve.itacademy.kek.client.utils.ModelUtils;
import com.softserve.itacademy.kek.rest.api.OrdersApi;
import com.softserve.itacademy.kek.rest.api.TenantsApi;
import com.softserve.itacademy.kek.rest.api.UsersApi;
import com.softserve.itacademy.kek.rest.model.Address;
import com.softserve.itacademy.kek.rest.model.Order;
import com.softserve.itacademy.kek.rest.model.OrderEventTypes;
import com.softserve.itacademy.kek.rest.model.Tenant;
import com.softserve.itacademy.kek.rest.model.User;


public class MainFlow
{
    private final static Logger LOGGER = LoggerFactory.getLogger(MainFlow.class);
    private final static String HOST = "http://localhost:8080/api/v1";
    private final static OrdersApi ordersApi = RestClientFactory.createRestApiClient(OrdersApi.class, HOST);
    private final static TenantsApi tenantApi = RestClientFactory.createRestApiClient(TenantsApi.class, HOST);
    private final static UsersApi usersApi = RestClientFactory.createRestApiClient(UsersApi.class, HOST);


    public static void main(String[] args)
    {
        final User user1 = ModelUtils.getUserWithName("Currier");
        User userForCustomer = usersApi.addUser(user1);

        final User user2 = ModelUtils.getUserWithName("Customer");
        User userForCurrier = usersApi.addUser(user2);

        final User user3 = ModelUtils.getUserWithName("Tenant");
        User userForTenant = usersApi.addUser(user3);
        LOGGER.info("\n\n STEP 1: Added new users: for customer {}, for currier {}, for tenant {}",
                user1, user2, user3);

        List<Address> addresses = usersApi.addUserAddresses(userForCustomer.getGuid(), ModelUtils.getAddresses());
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

        //TODO:: in Kek app create endpoint /assignCurrier that accept (user_currier_guid, order_guid, eventDTO)
        //TODO:: for this endpoint required service that will store event with type ASSIGNED and actor with ROLE CURRIER
        //Tenant assign currier: Tenant add event (order_guid, user_guid(tenant), event_type ASSIGNED)
        //System automatically added actor (tenant_ID, user_tenant(currier), time)

        //Currier accept delivery: User currier add event (order_guid, user_guid(currier), event_type STARTED)
        //System automatically added actor (tenant_ID, user_guid(currier), time)

        //User customer send request to get geolocation of an order

        //Currier  delivery: User currier add event (order_guid, user_guid(currier), event_type DELIVERED)
        //System automatically added actor (tenant_ID, user_guid(currier), time)

        //Tenant guid send request to get all information about events of actor (what role had user (currier, admin...)
        // for order)
    }
}
