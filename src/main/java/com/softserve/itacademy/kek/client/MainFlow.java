package com.softserve.itacademy.kek.client;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.softserve.itacademy.kek.client.utils.ModelUtils;
import com.softserve.itacademy.kek.rest.model.ListWrapperDto;
import com.softserve.itacademy.kek.rest.model.Order;
import com.softserve.itacademy.kek.rest.model.OrderEvent;
import com.softserve.itacademy.kek.rest.model.OrderEventTypes;
import com.softserve.itacademy.kek.rest.model.Registration;
import com.softserve.itacademy.kek.rest.model.Tenant;
import com.softserve.itacademy.kek.rest.model.Token;
import com.softserve.itacademy.kek.rest.model.User;

public class MainFlow {
    private final static Logger LOGGER = LoggerFactory.getLogger(MainFlow.class);
    private final static String HOST = "http://localhost:8080/api/v1";
    private final static KekRestClient KEK_API = new KekRestClient(HOST);

    public static void main(String[] args) {

        // ------- TENANT -----
        final Registration tenantRegistration = ModelUtils.getRegistrationWithName("Tenant");
        Token tenantToken = KEK_API.userRegistration(tenantRegistration);
        LOGGER.info("\n\n STEP 1: Register new user for {}, user email: {}", "Tenant", tenantRegistration.getEmail());

        User tenantProfile = KEK_API.profile(tenantToken.getToken());
        LOGGER.info("\n\n STEP 2: Get tenant guid={}", tenantProfile.getGuid());

        final Tenant tenant = KEK_API.addTenant(ModelUtils.getTenantForUserGuid(tenantProfile.getGuid()),
                tenantToken.getToken());
        LOGGER.info("\n\n STEP 3: Added new tenant {} for user guid={}",
                tenant,
                tenantProfile.getGuid());

        // ------- CUSTOMER -----
        final Registration customerRegistration = ModelUtils.getRegistrationWithName("Customer");
        Token customerToken = KEK_API.userRegistration(customerRegistration);
        LOGGER.info("\n\n STEP 4: Register customer with email: {}", customerRegistration.getEmail());

        User customerProfile = KEK_API.profile(customerToken.getToken());
        LOGGER.info("\n\n STEP 5: Customer has guid={}", customerProfile.getGuid());

        //System automatically added actor (customer) and role CUSTOMER
        //System automatically added event (EventDTO) and event_type CREATED
        final Order orderStub = ModelUtils.getOrderFor(tenant);
        final ListWrapperDto<Order> orderList = KEK_API.addOrder(ModelUtils.getSingletonOrderList(orderStub),
                customerToken.getToken());
        final Order order = orderList.getList().get(0);
        LOGGER.info("\n\n STEP 6: Added new order {} from customer guid={} for tenant guid={}",
                order,
                customerProfile.getGuid(),
                tenant.getGuid());

        // ------- CURRIER -----
        final Registration currierRegistration = ModelUtils.getRegistrationWithName("Currier");
        Token currierToken = KEK_API.userRegistration(currierRegistration);
        LOGGER.info("\n\n STEP 7: Register customer with email: {}", currierRegistration.getEmail());

        User currierProfile = KEK_API.profile(currierToken.getToken());
        LOGGER.info("\n\n STEP 8: Currier has guid={}", currierProfile.getGuid());

        //Currier takes order: Currier add event (EventDTO, user_guid(currier)), event_type ASSIGNED
        //System automatically added actor (user_guid(currier)) and role CURRIER
        final OrderEvent eventAssigned = KEK_API.addEvent(
                order.getGuid(),
                ModelUtils.getOrderEvent(order, OrderEventTypes.ASSIGNED),
                currierToken.getToken());

        LOGGER.info("\n\n STEP 9: Added new event {} for orderGuid={}", eventAssigned, order.getGuid());


        //http://localhost:8080/api/v1/tracking/orders/27d132aa-32d6-47e2-9034-b583ce7b6523/
        //http://localhost:8080/#/app-sse-controller/27d132aa-32d6-47e2-9034-b583ce7b6523
        //Currier started delivery: Currier add event (EventDTO, user_guid(currier)), event_type STARTED
        //System automatically added actor (user_guid(currier)) and role CURRIER (this step only if CURRIER is changed to another user)
        Delivery delivery = new Delivery(order, currierToken.getToken());
        Thread deliveryThread = new Thread(delivery);
        deliveryThread.start();
        try {
            deliveryThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //Currier finished delivery: Currier added event (EventDTO, user_guid(currier)) with event_type DELIVERED
        final OrderEvent eventDelivered = KEK_API.addEvent(
                order.getGuid(),
                ModelUtils.getOrderEvent(order, OrderEventTypes.DELIVERED),
                currierToken.getToken());
        LOGGER.info("\n\n STEP 10: Added new event {} for orderGuid={}", eventDelivered, order.getGuid());
    }

    public static KekRestClient getKekApi() {
        return KEK_API;
    }
}
