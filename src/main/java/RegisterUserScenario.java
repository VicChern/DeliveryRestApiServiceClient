import java.io.IOException;
import java.net.URI;
import java.net.http.HttpResponse;

import com.google.gson.Gson;
import dto.AddressesList;
import dto.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import utils.DtoUtils;

public class RegisterUserScenario {
    public static final String HOST = "http://localhost:8080/api/v1";
    private final static Logger LOGGER = LoggerFactory.getLogger(RegisterUserScenario.class);
    private final static SyncHttpClient SYNC_HTTP_CLIENT = new SyncHttpClient();

    public static void main(String[] args) throws IOException, InterruptedException {
        User user = DtoUtils.getUser();

        LOGGER.info("\n\n STEP 1: Get all users");
        URI usersEndpoint = URI.create(String.format("%s/users", HOST));
        SYNC_HTTP_CLIENT.sendGET(usersEndpoint, "user");

        LOGGER.info("\n\n STEP 2: Adding not valid user");
        user.setName(null);
        String jsonUser1 = new Gson().toJson(user);
        SYNC_HTTP_CLIENT.sendPOSTFromJson(jsonUser1, usersEndpoint, "user", User.class);

        LOGGER.info("\n\n STEP 3: Adding completely new user");
        user.setName("Julia");
        String jsonUser = new Gson().toJson(user);
        final HttpResponse<String> response = SYNC_HTTP_CLIENT.sendPOSTFromJson(jsonUser, usersEndpoint,
                "user", User.class);
        User obj = new Gson().fromJson(response.body(), User.class);
        String userGuid = obj.getGuid();

        LOGGER.info("\n\n STEP 4: Adding user's addresses");
        AddressesList addresses = DtoUtils.getAddresses();
        String jsonAddresses = new Gson().toJson(addresses);

        //TODO:: json prettyPrinting for List
        URI addressesEndpoint = URI.create(String.format("%s/users/%s/addresses", HOST, userGuid));
        SYNC_HTTP_CLIENT.sendPOSTFromJson(jsonAddresses, addressesEndpoint, "address", AddressesList.class);
    }
}
