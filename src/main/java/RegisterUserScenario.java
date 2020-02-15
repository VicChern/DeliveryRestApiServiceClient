import java.io.IOException;
import java.net.URI;
import java.net.http.HttpResponse;
import java.nio.file.Path;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import utils.HttpClientUtils;

public class RegisterUserScenario {
    private final static URI USERS_URI = HttpClientUtils.createFor("/api/v1/users");
    private final static SyncHttpClient syncHttpClient = new SyncHttpClient();
    private static final Logger LOGGER = LoggerFactory.getLogger(RegisterUserScenario.class);

    //TODO: Add authentication requests
    public static void main(String[] args) throws IOException, InterruptedException {
        LOGGER.info("STEP 1: Get all users");
        HttpResponse<String> users = syncHttpClient.sendGET(USERS_URI, "user");

        //1.2. Try to add user that already exist
        LOGGER.info("STEP 2: Get all users");

        //1.3. Add completely new user
        LOGGER.info("STEP 3: Adding completely new user");
        Path body = Path.of("src/main/resources/request-bodies/user.json");
        HttpResponse<String> response = syncHttpClient.sendPOST(body, USERS_URI, "user");

        //1.4. Add user addresses
        LOGGER.info("STEP 4: Adding user's addresses");

    }
}
