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
        final Registration tenantRegistration = ModelUtils.getRegistrationWithName("Tenant");
        KEK_API.userRegistration(tenantRegistration);
        LOGGER.info("\n\n STEP 1: Register new user for tenant, user email: {}", tenantRegistration.getEmail());

        SignIn signInData = ModelUtils.getSignInData(tenantRegistration.getEmail(), tenantRegistration.getPassword());
        Token tenantToken = KEK_API.signIn(signInData);
        LOGGER.info("\n\n STEP 2: User was authenticated, token={}", tenantToken.getToken());

        User tenantProfile = KEK_API.profile(tenantToken.getToken());
        LOGGER.info("\n\n STEP 3: User for tenant has guid={}", tenantProfile.getGuid());

        final Tenant tenant = KEK_API.addTenant(ModelUtils.getTenantForUserGuid(tenantProfile.getGuid()),
                tenantToken.getToken());
        LOGGER.info("\n\n STEP 2: Added new tenant {} for user guid={}",
                tenant,
                tenantProfile.getGuid());

        // ------- CUSTOMER -----
        final Registration customerRegistration = ModelUtils.getRegistrationWithName("Customer");
        KEK_API.userRegistration(customerRegistration);
        LOGGER.info("\n\n STEP 4: Register new user for customer, user email: {}", customerRegistration.getEmail());

        SignIn signInDataForCustomer = ModelUtils.getSignInData(customerRegistration.getEmail(), customerRegistration.getPassword());
        Token customerToken = KEK_API.signIn(signInDataForCustomer);
        LOGGER.info("\n\n STEP 5: Customer was authenticated, token={}", customerToken.getToken());

        User customerProfile = KEK_API.profile(customerToken.getToken());
        LOGGER.info("\n\n STEP 3: Customer has guid={}", customerProfile.getGuid());

        //System automatically added actor (customer) and role CUSTOMER
        //System automatically added event (EventDTO) and event_type CREATED
        final Order orderStub = ModelUtils.getOrderFor(tenant);
        final ListWrapperDto<Order> orderList = KEK_API.addOrder(ModelUtils.getSingletonOrderList(orderStub),
                customerToken.getToken());
        final Order order = orderList.getList().get(0);
        LOGGER.info("\n\n STEP 4: Added new order {} from customer guid={} for tenant guid={}",
                order,
                customerProfile.getGuid(),
                tenant.getGuid());

        // ------- CURRIER -----
        final Registration currierRegistration = ModelUtils.getRegistrationWithName("Currier");
        KEK_API.userRegistration(currierRegistration);
        LOGGER.info("\n\n STEP 6: Register new user for customer, user email: {}", currierRegistration.getEmail());

        SignIn signInDataForCurrier = ModelUtils.getSignInData(currierRegistration.getEmail(), currierRegistration.getPassword());
        Token currierToken = KEK_API.signIn(signInDataForCurrier);
        LOGGER.info("\n\n STEP 7: Currier was authenticated, token={}", currierToken.getToken());

        User currierProfile = KEK_API.profile(currierToken.getToken());
        LOGGER.info("\n\n STEP 3: Currier has guid={}", currierProfile.getGuid());

        //Currier takes order: Currier add event (EventDTO, user_guid(currier)), event_type ASSIGNED
        //System automatically added actor (user_guid(currier)) and role CURRIER
        final OrderEvent eventAssigned = KEK_API.addEvent(
                order.getGuid(),
                ModelUtils.getOrderEvent(order, OrderEventTypes.ASSIGNED),
                currierToken.getToken());

        LOGGER.info("\n\n STEP 6: Added new event {} for orderGuid={}, for currier guid: {}",
                eventAssigned,
                order.getGuid(),
                currierRegistration.getGuid());


        //http://localhost:8080/api/v1/orders/b03ac67c-1c31-4760-a386-49948d0217a4/tracking/
        //http://localhost:8080/#/app-sse-controller/d1ddada9-fe8d-4e7d-9035-4c0c523c6b7c
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
        LOGGER.info("\n\n STEP 7: Added new event {} for orderGuid={}", eventDelivered, order.getGuid());
    }
}
