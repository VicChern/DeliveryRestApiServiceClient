import java.io.IOException;
import java.net.URI;
import java.net.http.HttpResponse;

import com.google.gson.Gson;
import dto.Order;
import dto.Tenant;
import dto.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import utils.DtoUtils;

/**
 * NEW ORDER SCENARIO
 * 1. Registered User creates a new order request.
 * 2. Validate request and throw an error if the request wasn't valid
 * 3. Information about the order is stored in the database.
 * 4. If the order is accepted, the client receives a notification with the tracking number of the order
 * 5. If the order is not accepted, the system sends the response message about the error.
 */
//TODO:: Change Steps to Tests with priority
public class NewOrderScenario {
    public static final String HOST = "http://localhost:8080/api/v1";
    private final static Logger LOGGER = LoggerFactory.getLogger(NewOrderScenario.class);
    private final static SyncHttpClient SYNC_HTTP_CLIENT = new SyncHttpClient();

    //Prerequired steps: Create user, create tenant
    public static void main(String[] args) throws IOException, InterruptedException {
        LOGGER.info("\n\n Prerequired steps 1: Adding new user - customer");
        User customer = DtoUtils.getUser();
        URI usersEndpoint = URI.create(String.format("%s/users", HOST));
        String jsonUser = new Gson().toJson(customer);
        final HttpResponse<String> response = SYNC_HTTP_CLIENT.sendPOSTFromJson(jsonUser, usersEndpoint,
                "user", User.class);
        User obj = new Gson().fromJson(response.body(), User.class);
        String customerGuid = obj.getGuid();

        LOGGER.info("\n\n Prerequired steps 2: Adding new user - deliverer");
        User deliverer = DtoUtils.getUser();
        deliverer.setName("Deliverer");
        String jsonDeliverer = new Gson().toJson(deliverer);
        final HttpResponse<String> postDelivererResponse = SYNC_HTTP_CLIENT.sendPOSTFromJson(jsonDeliverer, usersEndpoint,
                "user", User.class);
        User delivererFromResponce = new Gson().fromJson(postDelivererResponse.body(), User.class);
        String delivererGuid = delivererFromResponce.getGuid();

        LOGGER.info("\n\n Prerequired steps 3: Adding new tenant for deliverer name {}", delivererFromResponce.getName());
        Tenant tenant = DtoUtils.getTenantFor(deliverer);
        URI tenantEndpoint = URI.create(String.format("%s/tenants", HOST));
        String jsonTenant = new Gson().toJson(tenant);
        final HttpResponse<String> addTenantResponse = SYNC_HTTP_CLIENT.sendPOSTFromJson(jsonTenant, tenantEndpoint,
                "tenant", Tenant.class);
        Tenant createdTenant = new Gson().fromJson(addTenantResponse.body(), Tenant.class);

        LOGGER.info("\n\n Steps 1: Adding new order from user {} for tenant {}",
                customer.getName(), deliverer.getName());
        Order order = DtoUtils.getOrderFor(customer, createdTenant);
        URI orderEndpoint = URI.create(String.format("%s/orders", HOST));
        String jsonOrder = new Gson().toJson(order);
        final HttpResponse<String> addOrderResponse = SYNC_HTTP_CLIENT.sendPOSTFromJson(jsonOrder, orderEndpoint,
                "order", Order.class);
    }

}