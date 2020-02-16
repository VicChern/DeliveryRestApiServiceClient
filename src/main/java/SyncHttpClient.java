import java.io.IOException;
import java.lang.reflect.Type;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import utils.Parsers;

import static org.springframework.http.HttpHeaders.ACCEPT;
import static org.springframework.http.HttpHeaders.CONTENT_TYPE;

//TODO:: Logger request body
public class SyncHttpClient {
    private static final String APPLICATION_VND_SOFTSERVE = "application/vnd.softserve";
    private static final String JSON = "json";
    private final static Logger LOGGER = LoggerFactory.getLogger(SyncHttpClient.class);


    private final HttpClient httpClient = HttpClient.newBuilder()
            .version(HttpClient.Version.HTTP_2)
            .build();


    HttpResponse<String> sendGET(final URI kekUri, final String typeName) throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .GET()
                .uri(kekUri)
                .headers(CONTENT_TYPE, String.format("%s.%s+%s", APPLICATION_VND_SOFTSERVE, typeName, JSON),
                        ACCEPT, String.format("%s.%s+%s", APPLICATION_VND_SOFTSERVE, typeName, JSON))
                .build();

        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

        LOGGER.info("<< GET Kek REST API Call: >>\n{}\n{}", request.uri(), request.headers());
        if (response.statusCode() == 200 || response.statusCode() == 202) {
            LOGGER.info("\n Responce: Success!\n Status code: {}\n {}", response.statusCode(), response.body());
        } else {
            LOGGER.info("\n Responce: Failure! Status Code:{}", response.statusCode());
        }
        return response;
    }


    public HttpResponse<String> sendPOST(final String json, final URI kekUri, final String typeName, Type type)
            throws IOException, InterruptedException {

        // add json header
        HttpRequest request = HttpRequest.newBuilder()
                .POST(HttpRequest.BodyPublishers.ofString(json))
                .uri(kekUri)
                .headers(CONTENT_TYPE, String.format("%s.%s+%s", APPLICATION_VND_SOFTSERVE, typeName, JSON),
                        ACCEPT, String.format("%s.%s+%s", APPLICATION_VND_SOFTSERVE, typeName, JSON))
                .build();

        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

        //String prettyJsonBody = Parsers.jsonPrettyPrinting(response.body(), type);

        LOGGER.info("<< POST Kek REST API Call: >>\n{}\n{}", request.uri(), request.headers());
        if (response.statusCode() == 200 || response.statusCode() == 202) {
            LOGGER.info("\n Responce: Success!\n Status code: {}\n {}", response.statusCode(), response.body());
        } else {
            LOGGER.info("\n Responce: Failure! Status Code: {}", response.statusCode());
        }
        return response;

    }
}
