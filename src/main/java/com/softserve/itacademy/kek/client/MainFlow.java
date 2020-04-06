package com.softserve.itacademy.kek.client;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.softserve.itacademy.kek.client.utils.ModelUtils;
import com.softserve.itacademy.kek.rest.model.ListWrapperDto;
import com.softserve.itacademy.kek.rest.model.Order;
import com.softserve.itacademy.kek.rest.model.OrderEvent;
import com.softserve.itacademy.kek.rest.model.OrderEventTypes;
import com.softserve.itacademy.kek.rest.model.Registration;
import com.softserve.itacademy.kek.rest.model.SignIn;
import com.softserve.itacademy.kek.rest.model.Tenant;
import com.softserve.itacademy.kek.rest.model.Token;
import com.softserve.itacademy.kek.rest.model.User;

public class MainFlow {
    private final static Logger LOGGER = LoggerFactory.getLogger(MainFlow.class);
    private final static String HOST = "http://localhost:8080/api/v1";
    private final static KekRestClient KEK_API = new KekRestClient(HOST);

    public static void main(String[] args) {
        // ------- TENANT -----
        Token tenantToken = getTokenFor("Tenant");
        LOGGER.info("\n\n STEP 2: User for tenant was authenticated, token={}", tenantToken.getToken());

        User tenantProfile = KEK_API.profile(tenantToken.getToken());
        LOGGER.info("\n\n STEP 3: Get tenant guid={}", tenantProfile.getGuid());

        final Tenant tenant = KEK_API.addTenant(ModelUtils.getTenantForUserGuid(tenantProfile.getGuid()),
                tenantToken.getToken());
        LOGGER.info("\n\n STEP 4: Added new tenant {} for user guid={}",
                tenant,
                tenantProfile.getGuid());

        // ------- CUSTOMER -----
        Token customerToken = getTokenFor("Customer");
        LOGGER.info("\n\n STEP 5: Customer was authenticated, token={}", customerToken.getToken());

        User customerProfile = KEK_API.profile(customerToken.getToken());
        LOGGER.info("\n\n STEP 6: Customer has guid={}", customerProfile.getGuid());

        //System automatically added actor (customer) and role CUSTOMER
        //System automatically added event (EventDTO) and event_type CREATED
        final Order orderStub = ModelUtils.getOrderFor(tenant);
        final ListWrapperDto<Order> orderList = KEK_API.addOrder(ModelUtils.getSingletonOrderList(orderStub),
                customerToken.getToken());
        final Order order = orderList.getList().get(0);
        LOGGER.info("\n\n STEP 7: Added new order {} from customer guid={} for tenant guid={}",
                order,
                customerProfile.getGuid(),
                tenant.getGuid());

        // ------- CURRIER -----
        Token currierToken = getTokenFor("Currier");
        LOGGER.info("\n\n STEP 8: Currier was authenticated, token={}", currierToken.getToken());

        User currierProfile = KEK_API.profile(currierToken.getToken());
        LOGGER.info("\n\n STEP 9: Currier has guid={}", currierProfile.getGuid());

        //Currier takes order: Currier add event (EventDTO, user_guid(currier)), event_type ASSIGNED
        //System automatically added actor (user_guid(currier)) and role CURRIER
        final OrderEvent eventAssigned = KEK_API.addEvent(
                order.getGuid(),
                ModelUtils.getOrderEvent(order, OrderEventTypes.ASSIGNED),
                currierToken.getToken());

        LOGGER.info("\n\n STEP 10: Added new event {} for orderGuid={}", eventAssigned, order.getGuid());


        //http://localhost:8080/api/v1/tracking/orders/ead016d6-8734-4493-a6c8-4435fe570342/
        //http://localhost:8080/#/app-sse-controller/ead016d6-8734-4493-a6c8-4435fe570342
        //Currier started delivery: Currier add event (EventDTO, user_guid(currier)), event_type STARTED
        //System automatically added actor (user_guid(currier)) and role CURRIER (this step only if CURRIER is changed to another user)
        Delivery delivery = new Delivery(order, currierToken.getToken());
        Thread deliveryThread = new Thread(delivery);
        // deliveryThread.setDaemon(true);
        deliveryThread.start();

        // to delivery process will be started (add an order event)
        try {
            deliveryThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
//
//        //Customer send request to track order
//        LOGGER.info("\n\n START TRACKING ORDER: order guid = {}", order.getGuid());
//
//        final String url = String.format("http://localhost:8080/api/v1/orders/%s/tracking/", order.getGuid()); //"c9d50a7b-5e67-403c-aeed-1a78fe124bc7");
//
//        final SseClient sseClient = new SseClient();
//
//        sseClient.open(url);
//
//        try {
//            Thread.sleep(15000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//
//        sseClient.close();
//
//        delivery.setCompleted(true);
//
        //Currier finished delivery: Currier added event (EventDTO, user_guid(currier)) with event_type DELIVERED
        final OrderEvent eventDelivered = KEK_API.addEvent(
                order.getGuid(),
                ModelUtils.getOrderEvent(order, OrderEventTypes.DELIVERED),
                currierToken.getToken());
        LOGGER.info("\n\n STEP 11: Added new event {} for orderGuid={}", eventDelivered, order.getGuid());
    }


    private static Token getTokenFor(final String role) {
        final Registration registration = ModelUtils.getRegistrationWithName(role);
        KEK_API.userRegistration(registration);
        LOGGER.info("\n\n STEP 1: Register new user for {}, user email: {}", role, registration.getEmail());

        SignIn signInData = ModelUtils.getSignInData(registration.getEmail(), registration.getPassword());
        return KEK_API.signIn(signInData);
    }

}
