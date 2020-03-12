package com.softserve.itacademy.kek.client;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.softserve.itacademy.kek.client.utils.ModelUtils;
import com.softserve.itacademy.kek.rest.api.OrdersApi;
import com.softserve.itacademy.kek.rest.api.RegistrationApi;
import com.softserve.itacademy.kek.rest.api.TenantsApi;
import com.softserve.itacademy.kek.rest.api.UsersApi;
import com.softserve.itacademy.kek.rest.model.Order;
import com.softserve.itacademy.kek.rest.model.OrderEvent;
import com.softserve.itacademy.kek.rest.model.OrderEventTypes;
import com.softserve.itacademy.kek.rest.model.OrderList;
import com.softserve.itacademy.kek.rest.model.Registration;
import com.softserve.itacademy.kek.rest.model.TemporaryDto;
import com.softserve.itacademy.kek.rest.model.Tenant;

import static com.softserve.itacademy.kek.client.utils.ModelUtils.getRegistrationWithName;

public class MainFlow
{
    private final static Logger LOGGER = LoggerFactory.getLogger(MainFlow.class);
    private final static String HOST = "http://localhost:8080/api/v1";
    private final static OrdersApi ordersApi = RestClientFactory.createRestApiClient(OrdersApi.class, HOST);
    private final static TenantsApi tenantApi = RestClientFactory.createRestApiClient(TenantsApi.class, HOST);
    private final static UsersApi usersApi = RestClientFactory.createRestApiClient(UsersApi.class, HOST);
    private final static RegistrationApi registrationApi = RestClientFactory.createRestApiClient(RegistrationApi.class, HOST);

    public static void main(String[] args)
    {
        final Registration tenantRegistration = getRegistrationWithName("Tenant2", "marina2.acoustic.acoustic@gmail.com");
        TemporaryDto temporaryDto = registrationApi.userRegistration(tenantRegistration);
        String tenantUserGuid = temporaryDto.getUserGuid();
        LOGGER.info("\n\n STEP 1: Register new user for tenant, user guid: {}", tenantUserGuid);


        final Tenant tenant = tenantApi.addTenant(ModelUtils.getTenantForUserGuid(tenantUserGuid), temporaryDto.getSessionId());
        LOGGER.info("\n\n STEP 2: Added new tenant {} for user guid={}",
                tenant,
                tenantUserGuid);


        final Registration customerRegistration = getRegistrationWithName("Customer2", "customer2.acoustic@gmail.com");
        TemporaryDto customerTemporaryDto = registrationApi.userRegistration(customerRegistration);
        String customerGuid = customerTemporaryDto.getUserGuid();
        LOGGER.info("\n\n STEP 3: Register new user for customer, user guid: {}", customerGuid);


        //System automatically added actor (customer) and role CUSTOMER
        //System automatically added event (EventDTO) and event_type CREATED
        final Order orderStub = ModelUtils.getOrderFor(tenant);
        final OrderList orderList = ordersApi.addOrder(ModelUtils.getSingletonOrderList(orderStub), customerTemporaryDto.getSessionId());
        final Order order = orderList.getOrderList().get(0);
        LOGGER.info("\n\n STEP 4: Added new order {} from customer guid={} for tenant guid={}",
                order,
                customerGuid,
                tenant.getGuid());


        final Registration currierRegistration = getRegistrationWithName("Currier2", "currier2.acoustic@gmail.com");
        TemporaryDto currierTemporaryDto = registrationApi.userRegistration(currierRegistration);
        String currierGuid = currierTemporaryDto.getUserGuid();
        LOGGER.info("\n\n STEP 5: Register new user for customer, user guid: {}", currierGuid);

        //Currier takes order: Currier add event (EventDTO, user_guid(currier)), event_type ASSIGNED
        //System automatically added actor (user_guid(currier)) and role CURRIER
        final OrderEvent eventAssigned = ordersApi.addEvent(
                order.getGuid(),
                ModelUtils.getOrderEvent(order, OrderEventTypes.ASSIGNED),
                currierTemporaryDto.getSessionId());

        LOGGER.info("\n\n STEP 6: Added new event {} for orderGuid={}, for currier guid: {}",
                eventAssigned,
                order.getGuid(),
                currierRegistration.getGuid());

        //Currier started delivery: Currier add event (EventDTO, user_guid(currier)), event_type STARTED
        //System automatically added actor (user_guid(currier)) and role CURRIER (this step only if CURRIER is changed to another user)
        Delivery delivery = new Delivery(order, currierTemporaryDto.getSessionId());
        Thread thread = new Thread(delivery);
        thread.start();

        try{
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //Customer send request to get geolocation of an order

        //Currier finished delivery: Currier added event (EventDTO, user_guid(currier)) with event_type DELIVERED
        final OrderEvent eventDelivered = ordersApi.addEvent(
                order.getGuid(),
                ModelUtils.getOrderEvent(order, OrderEventTypes.DELIVERED),
                currierTemporaryDto.getSessionId());
        LOGGER.info("\n\n STEP 7: Added new event {} for orderGuid={}", eventDelivered, order.getGuid());

    }

}
