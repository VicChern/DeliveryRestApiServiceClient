import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.file.Path;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SyncHttpClient {
    private static final String CONTENT_TYPE = "Content-Type";
    private static final String ACCEPT = "Accept";
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

        LOGGER.info("\n\n<< GET Kek REST API Call: >>\n{}\n{}", request.uri(), request.headers());
        if (response.statusCode() == 200 || response.statusCode() == 202) {
            LOGGER.info("\n Responce: Success!\n Status code: {}\n {}", response.statusCode(), response.body());
        } else {
            LOGGER.info("\n Responce: Failure! Status Code:{}", response.statusCode());
        }
        return response;
    }



    HttpResponse<String> sendPOST(final Path jsonPath, final URI kekUri, final String typeName)
            throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .POST(HttpRequest.BodyPublishers.ofFile(jsonPath))
                .uri(kekUri)
                .headers(CONTENT_TYPE, String.format("%s.%s+%s", APPLICATION_VND_SOFTSERVE, typeName, JSON),
                        ACCEPT, String.format("%s.%s+%s", APPLICATION_VND_SOFTSERVE, typeName, JSON))
                .build();

        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

        LOGGER.info("\n\n << POST Kek REST API Call: >>\n{}\n{}", request.uri(), request.headers());
        if (response.statusCode() == 200 || response.statusCode() == 202) {
            LOGGER.info("\n Responce: Success!\n Status code: {}\n {}", response.statusCode(), response.body());
        } else {
            LOGGER.info("\n Responce: Failure! Status Code:{}", response.statusCode());
        }
        return response;
    }
}
