package com.softserve.itacademy.kek.client;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.KeyManager;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.Security;
import java.security.cert.X509Certificate;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;
import org.apache.cxf.configuration.jsse.TLSClientParameters;
import org.apache.cxf.jaxrs.client.ClientConfiguration;
import org.apache.cxf.jaxrs.client.JAXRSClientFactory;
import org.apache.cxf.jaxrs.client.WebClient;
import org.apache.cxf.transport.http.HTTPConduit;
import org.apache.cxf.transports.http.configuration.HTTPClientPolicy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RestClientFactory {

    public static final Long DEFAULT_TIMEOUT = 60 * 1000L; // 1 min
    public static final String KEK_REST_TRACING_PARAM = "kekRestTracing";
    private static final Logger logger = LoggerFactory.getLogger(RestClientFactory.class);
    private static boolean restTracingEnabled = false;

    static {

        // removing SSLv3 from disabled list (GC still use it)
        Security.setProperty("jdk.tls.disabledAlgorithms", "");

        // useful for debugging
        System.getProperties().put(KEK_REST_TRACING_PARAM, String.valueOf(true));

        String jvmParam = System.getProperty(KEK_REST_TRACING_PARAM);
        String envParam = System.getenv(KEK_REST_TRACING_PARAM);
        restTracingEnabled = Boolean.parseBoolean(jvmParam) || Boolean.parseBoolean(envParam);

        logger.info("{} = {}", KEK_REST_TRACING_PARAM, restTracingEnabled);
    }

    public static boolean isRestTracingEnabled() {
        return restTracingEnabled;
    }

    private static void hackSSL(ClientConfiguration configuration, int timeout) {

        HTTPConduit httpConduit = configuration.getHttpConduit();

        HTTPClientPolicy httpClientPolicy = httpConduit.getClient();
        httpClientPolicy.setReceiveTimeout(timeout);
        httpClientPolicy.setConnectionTimeout(timeout);

        configuration.setSynchronousTimeout(timeout);

        TLSClientParameters tlsParams = new TLSClientParameters();
        tlsParams.setSecureSocketProtocol("TLS");
        tlsParams.setKeyManagers(new KeyManager[0]);

        TrustManager[] trustAllCerts = new TrustManager[]{
                new X509TrustManager() {
                    public X509Certificate[] getAcceptedIssuers() {

                        return null;
                    }

                    public void checkClientTrusted(X509Certificate[] certs, String authType) {

                    }

                    public void checkServerTrusted(X509Certificate[] certs, String authType) {

                    }
                }
        };

        tlsParams.setTrustManagers(trustAllCerts);

        tlsParams.setDisableCNCheck(true);

        HostnameVerifier allHostsValid = (hostname, session) -> true;

        tlsParams.setHostnameVerifier(allHostsValid);

        try {
            SSLContext sslContext = SSLContext.getInstance("TLS");
            sslContext.init(new KeyManager[0], trustAllCerts, new SecureRandom());
            SSLSocketFactory socketFactory = sslContext.getSocketFactory();
            tlsParams.setSSLSocketFactory(socketFactory);
        } catch (KeyManagementException | NoSuchAlgorithmException ex) {
            logger.error("Can't init SSL/TLS for rest client", ex);
            System.exit(-1);
        }

        httpConduit.setTlsClientParameters(tlsParams);
    }

    public static <T> T createRestApiClient(Class<T> clientClass, String endpointUrl) {

        return createRestApiClient(clientClass, endpointUrl, DEFAULT_TIMEOUT);
    }

    public static <T> T createRestApiClient(Class<T> clientClass,
                                            String endpointUrl,
                                            Long timeout) {

        ObjectMapper mapper = new ObjectMapper()
                .setSerializationInclusion(JsonInclude.Include.NON_NULL);

        JacksonJsonProvider provider = new JacksonJsonProvider(mapper);
        provider.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);

        List providers = Collections.singletonList(provider);

        T restApiProxy = JAXRSClientFactory.create(endpointUrl, clientClass, providers);

        org.apache.cxf.jaxrs.client.Client client = WebClient.client(restApiProxy);

        ClientConfiguration config = WebClient.getConfig(client);

        int timeoutInt = Optional.of(timeout).orElse(DEFAULT_TIMEOUT).intValue();

        //hackSSL(config, timeoutInt);

        return restApiProxy;
    }
}
