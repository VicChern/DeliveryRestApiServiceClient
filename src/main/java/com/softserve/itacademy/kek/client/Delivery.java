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
import com.softserve.itacademy.kek.rest.model.Order;
import com.softserve.itacademy.kek.rest.model.OrderEvent;
import com.softserve.itacademy.kek.rest.model.OrderEventTypes;

public class Delivery implements Runnable {
    private final static Logger LOGGER = LoggerFactory.getLogger(Delivery.class);
    private static final String ROUTE_TXT = "./src/main/resources/route.txt";
    private Queue<String> geoLocations = new LinkedList<>();

    private Order order;
    private String token;

    {
        try (BufferedReader br = Files.newBufferedReader(Paths.get(ROUTE_TXT))) {
            geoLocations = br.lines().collect(Collectors.toCollection(LinkedList::new));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Delivery(Order order, String token) {
        this.order = order;
        this.token = token;
    }

    @Override
    public void run() {
        while (!geoLocations.isEmpty()) {
            try {
                Thread.sleep(3000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            String payload = geoLocations.poll();

            final OrderEvent event = MainFlow.getKekApi().addEvent(order.getGuid(),
                    ModelUtils.getOrderEvent(order, OrderEventTypes.STARTED, payload),
                    token);

            LOGGER.info("\n\n DELIVERY: Added new event {} for orderGuid={}", event, order.getGuid());
        }
    }

}
