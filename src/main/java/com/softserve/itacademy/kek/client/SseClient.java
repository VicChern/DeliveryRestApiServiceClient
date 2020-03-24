package com.softserve.itacademy.kek.client;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.sse.SseEventSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SseClient {
    private final static Logger logger = LoggerFactory.getLogger(MainFlow.class);
    private final Client client;
    private SseEventSource source;

    public SseClient() {
        client = ClientBuilder.newClient();
    }

    public void open(String url) {
        closeEventSource();

        final WebTarget target = client.target(url);
        source = SseEventSource.target(target).build();

        try {
            source.register(
                    (inboundSseEvent) -> logger.info("\n\n TRACKING ORDER: geolocation {}\n", inboundSseEvent.readData()),
                    (throwable) -> logger.error("Tracking error", throwable)
            );
            source.open();
        } catch (Exception ex) {
            logger.error("Tracking error", ex);
        }
    }

    public void close() {
        closeEventSource();
        client.close();
    }

    private void closeEventSource() {
        if ((source != null) && (source.isOpen()))
            source.close();
    }
}