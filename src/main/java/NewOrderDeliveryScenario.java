import java.io.IOException;
import java.net.URI;
import java.net.http.HttpResponse;

import com.google.gson.Gson;
import dto.Order;
import dto.OrderEvent;
import dto.OrderEventTypes;
import dto.Tenant;
import dto.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import utils.DtoUtils;

//TODO:: Change Steps to Tests with priority
public class NewOrderDeliveryScenario {
    public static final String HOST = "http://localhost:8080/api/v1";
    private final static Logger LOGGER = LoggerFactory.getLogger(NewOrderDeliveryScenario.class);
    private final static SyncHttpClient SYNC_HTTP_CLIENT = new SyncHttpClient();

    //Prerequired steps: Create user, create tenant
    public static void main(String[] args) throws IOException, InterruptedException {
        LOGGER.info("\n\n Prerequired steps 1: Adding new user - userForCustomer");
        User userForCustomer = DtoUtils.getUser();
        URI usersEndpoint = URI.create(String.format("%s/users", HOST));
        String jsonUser = new Gson().toJson(userForCustomer);
        final HttpResponse<String> response = SYNC_HTTP_CLIENT.sendPOST(jsonUser, usersEndpoint,
                "user", User.class);
        User obj = new Gson().fromJson(response.body(), User.class);
        String customerGuid = obj.getGuid();

        LOGGER.info("\n\n Prerequired steps 2: Adding new user - userForTenant");
        User userForTenant = DtoUtils.getUser();
        userForTenant.setName("Deliverer");
        String jsonDeliverer = new Gson().toJson(userForTenant);
        final HttpResponse<String> postDelivererResponse = SYNC_HTTP_CLIENT.sendPOST(jsonDeliverer, usersEndpoint,
                "user", User.class);
        User delivererFromResponce = new Gson().fromJson(postDelivererResponse.body(), User.class);
        String delivererGuid = delivererFromResponce.getGuid();

        LOGGER.info("\n\n Prerequired steps 3: Adding new user - userForTenant");
        User userForCurier = DtoUtils.getUser();
        userForTenant.setName("Curier");
        String jsonCurier = new Gson().toJson(userForCurier);
        final HttpResponse<String> postCurierResponse = SYNC_HTTP_CLIENT.sendPOST(jsonCurier, usersEndpoint,
                "user", User.class);
        User curierFromResponce = new Gson().fromJson(postDelivererResponse.body(), User.class);
        String curierGuid = curierFromResponce.getGuid();

        LOGGER.info("\n\n Prerequired steps 3: Adding new tenant for userForTenant name {}", delivererFromResponce.getName());
        Tenant tenant = DtoUtils.getTenantFor(userForTenant);
        URI tenantEndpoint = URI.create(String.format("%s/tenants", HOST));
        String jsonTenant = new Gson().toJson(tenant);
        final HttpResponse<String> addTenantResponse = SYNC_HTTP_CLIENT.sendPOST(jsonTenant, tenantEndpoint,
                "tenant", Tenant.class);
        Tenant createdTenant = new Gson().fromJson(addTenantResponse.body(), Tenant.class);

        LOGGER.info("\n\n Steps 1: Adding new order from user {} for tenant {}",
                userForCustomer.getName(), userForTenant.getName());
        Order order = DtoUtils.getOrderFor(userForCustomer, createdTenant);
        URI orderEndpoint = URI.create(String.format("%s/orders", HOST));
        String jsonOrder = new Gson().toJson(order);
        final HttpResponse<String> addOrderResponse = SYNC_HTTP_CLIENT.sendPOST(jsonOrder, orderEndpoint,
                "order", Order.class);


        LOGGER.info("\n\n Steps 2: Tenant {} check order {}", tenant.getName(), order.getGuid());
        URI currentOrderEndpoint = URI.create(String.format("%s/orders/%s", HOST, order.getGuid()));
        SYNC_HTTP_CLIENT.sendGET(currentOrderEndpoint, "order");

        LOGGER.info("\n\n Steps 3: Tenant {} confirm order {}", tenant.getName(), order.getGuid());
        LOGGER.debug("\n\n Adding new event for order {} with Type CONFIRMED", order.getGuid());
        OrderEvent orderEvent = DtoUtils.getOrderEventFor(userForTenant, order, OrderEventTypes.CREATED);
        URI eventEndpoint = URI.create(String.format("%s/orders/%s/events", HOST, order.getGuid()));
        String jsonOrderEvent = new Gson().toJson(orderEvent);
        SYNC_HTTP_CLIENT.sendPOST(jsonOrderEvent, eventEndpoint, "event", OrderEvent.class);


        //TODO:: Add endpoint into KEK App
        LOGGER.info("\n\n Steps 4: Check, that system automatically added actor (tenant {}) for event {} ",
                tenant.getName(), orderEvent.getGuid());

        //TODO:: Add endpoint into KEK App
        //System automaticaly assigned curier to order (added row to actor table)
        //Do we need to add one more table (curier) like we have tenant or we have this info in user table
        // (get users, who are curriers at the same time)
        LOGGER.info("\n\n Steps 5: Tenant {} assign curier for order {} for event {}",
                tenant.getName(), order.getGuid(), orderEvent.getGuid());
        LOGGER.info("\n\n Adding curier actor {} for order {}", order.getGuid());

        //TODO:: Change endpoint to KEK APP to get last added event to current order
        LOGGER.info("\n\n Steps 6: Check, that system automatically added event with type {} for order {}",
                OrderEventTypes.ASSIGNED, orderEvent.getGuid());

        LOGGER.info("\n\n Steps 7: Add event for order {} with type {}", orderEvent.getGuid(), OrderEventTypes.STARTED);
        OrderEvent startedOrderEvent = DtoUtils.getOrderEventFor(userForCurier, order, OrderEventTypes.STARTED);
        String jsonStartedOrderEvent = new Gson().toJson(startedOrderEvent);
        SYNC_HTTP_CLIENT.sendPOST(jsonStartedOrderEvent, eventEndpoint, "event", OrderEvent.class);


        LOGGER.info("\n\n Steps 8: Client send request to get geolocation of an order {}");


        LOGGER.info("\n\n Steps 9: User (who is actor and curier) added new event for order {}", OrderEventTypes.DELIVERED);
        OrderEvent deliveredOrderEvent = DtoUtils.getOrderEventFor(userForCurier, order, OrderEventTypes.DELIVERED);
        String jsonDeliveredOrderEvent = new Gson().toJson(deliveredOrderEvent);
        SYNC_HTTP_CLIENT.sendPOST(jsonDeliveredOrderEvent, eventEndpoint, "event", OrderEvent.class);

    }

}