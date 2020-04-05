package com.softserve.itacademy.kek.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.LinkedList;
import java.util.Queue;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.softserve.itacademy.kek.client.utils.ModelUtils;
import com.softserve.itacademy.kek.rest.api.OrdersApi;
import com.softserve.itacademy.kek.rest.model.Order;
import com.softserve.itacademy.kek.rest.model.OrderEvent;
import com.softserve.itacademy.kek.rest.model.OrderEventTypes;

public class Delivery implements Runnable {
    private final static Logger LOGGER = LoggerFactory.getLogger(Delivery.class);
    private final static String HOST = "http://localhost:8080/api/v1";
    private static final String ROUTE_TXT = "./src/main/resources/route.txt";
    private final static OrdersApi ordersApi = RestClientFactory.createRestApiClient(OrdersApi.class, HOST);
    private Queue<String> geolocations = new LinkedList<>();
    private Order order;
    private String token;
    private volatile boolean completed;

    public Delivery(Order order, String token) {
        this.order = order;
        this.token = token;
    }

    {
        try (BufferedReader br = Files.newBufferedReader(Paths.get(ROUTE_TXT))) {
            geolocations = br.lines().collect(Collectors.toCollection(LinkedList::new));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        while (!geolocations.isEmpty()) {
            if (completed)
                break;

            try {
                Thread.sleep(3000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            String payload = geolocations.peek();

            final OrderEvent event = ordersApi.addEvent(order.getGuid(),
                    ModelUtils.getOrderEvent(order, OrderEventTypes.STARTED, payload),
                    token);

            LOGGER.info("\n\n DELIVERY: Added new event {} for orderGuid={}", event, order.getGuid());

            geolocations.poll();
        }
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public boolean getCompleted() {
        return this.completed;
    }
}
