package utils;

import java.net.URI;
import java.util.Map;

import org.springframework.web.util.UriComponentsBuilder;

public class HttpClientUtils {

    public static URI createFor(String kekPath) {
        return UriComponentsBuilder.newInstance()
                .scheme("http")
                .host("localhost")
                .port(8080)
                .path(kekPath)
                .build()
                .toUri();
    }
}
