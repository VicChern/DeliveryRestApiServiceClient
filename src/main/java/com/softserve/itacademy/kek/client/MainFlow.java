package com.softserve.itacademy.kek.client;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.sse.SseEventSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.softserve.itacademy.kek.client.utils.ModelUtils;
import com.softserve.itacademy.kek.rest.model.ListWrapperDto;
import com.softserve.itacademy.kek.rest.model.Order;
import com.softserve.itacademy.kek.rest.model.OrderEvent;
import com.softserve.itacademy.kek.rest.model.OrderEventTypes;
import com.softserve.itacademy.kek.rest.model.Registration;
import com.softserve.itacademy.kek.rest.model.TemporaryDto;
import com.softserve.itacademy.kek.rest.model.Tenant;

import static com.softserve.itacademy.kek.client.utils.ModelUtils.getRegistrationWithName;

public class MainFlow
{
    private final static Logger LOGGER = LoggerFactory.getLogger(MainFlow.class);
    private final static String HOST = "http://localhost:8080/api/v1";
    private final static KekRestClient KEK_API = new KekRestClient(HOST);

    public static void main(String[] args)
    {
        final Registration tenantRegistration = getRegistrationWithName("Tenant");
        TemporaryDto temporaryDto = KEK_API.userRegistration(tenantRegistration);
        String tenantUserGuid = temporaryDto.getUserGuid();
        LOGGER.info("\n\n STEP 1: Register new user for tenant, user guid: {}", tenantUserGuid);


        final Tenant tenant = KEK_API.addTenant(ModelUtils.getTenantForUserGuid(tenantUserGuid), temporaryDto.getSessionId());
        LOGGER.info("\n\n STEP 2: Added new tenant {} for user guid={}",
                tenant,
                tenantUserGuid);


        final Registration customerRegistration = getRegistrationWithName("Customer");
        TemporaryDto customerTemporaryDto = KEK_API.userRegistration(customerRegistration);
        String customerGuid = customerTemporaryDto.getUserGuid();
        LOGGER.info("\n\n STEP 3: Register new user for customer, user guid: {}", customerGuid);


        //System automatically added actor (customer) and role CUSTOMER
        //System automatically added event (EventDTO) and event_type CREATED
        final Order orderStub = ModelUtils.getOrderFor(tenant);
        final ListWrapperDto<Order> orderList = KEK_API.addOrder(ModelUtils.getSingletonOrderList(orderStub),
                customerTemporaryDto.getSessionId());
        final Order order = orderList.getList().get(0);
        LOGGER.info("\n\n STEP 4: Added new order {} from customer guid={} for tenant guid={}",
                order,
                customerGuid,
                tenant.getGuid());

        final Registration currierRegistration = getRegistrationWithName("Currier");
        TemporaryDto currierTemporaryDto = KEK_API.userRegistration(currierRegistration);
        String currierGuid = currierTemporaryDto.getUserGuid();
        LOGGER.info("\n\n STEP 5: Register new user for customer, user guid: {}", currierGuid);

        //Currier takes order: Currier add event (EventDTO, user_guid(currier)), event_type ASSIGNED
        //System automatically added actor (user_guid(currier)) and role CURRIER
        final OrderEvent eventAssigned = KEK_API.addEvent(
                order.getGuid(),
                ModelUtils.getOrderEvent(order, OrderEventTypes.ASSIGNED),
                currierTemporaryDto.getSessionId());

        LOGGER.info("\n\n STEP 6: Added new event {} for orderGuid={}, for currier guid: {}",
                eventAssigned,
                order.getGuid(),
                currierRegistration.getGuid());

//http://localhost:8080/api/v1/orders/e5e010a3-2da8-47db-8d5a-c4a6c6f41281/tracking/
        //Currier started delivery: Currier add event (EventDTO, user_guid(currier)), event_type STARTED
        //System automatically added actor (user_guid(currier)) and role CURRIER (this step only if CURRIER is changed to another user)
        Delivery delivery = new Delivery(order, currierTemporaryDto.getSessionId());
        Thread deliveryThread = new Thread(delivery);
        deliveryThread.setDaemon(true);
        deliveryThread.start();

        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        delivery.setCompleted(true);

        //Customer send request to get geolocation of an order
        LOGGER.info("\n\n START TRACKING ORDER: order guid = {}", order.getGuid());

        final String url = String.format("http://localhost:8080/api/v1/orders/%s/tracking/", order.getGuid()); //"c9d50a7b-5e67-403c-aeed-1a78fe124bc7");

        final Client client = ClientBuilder.newClient();
        final WebTarget target = client.target(url);

        try (SseEventSource source = SseEventSource.target(target).build()) {
            source.register(
                    (inboundSseEvent) -> LOGGER.info("\n\n TRACKING ORDER: geolocation {}", inboundSseEvent.readData())
            );
            source.open();
            Thread.sleep(15000);
        } catch (Exception ex) {
            LOGGER.error("SSE doesn't work", ex);
        }

        client.close();

        //Currier finished delivery: Currier added event (EventDTO, user_guid(currier)) with event_type DELIVERED
        final OrderEvent eventDelivered = KEK_API.addEvent(
                order.getGuid(),
                ModelUtils.getOrderEvent(order, OrderEventTypes.DELIVERED),
                currierTemporaryDto.getSessionId());
        LOGGER.info("\n\n STEP 7: Added new event {} for orderGuid={}", eventDelivered, order.getGuid());

    }
}
