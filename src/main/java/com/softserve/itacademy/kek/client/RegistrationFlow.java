package com.softserve.itacademy.kek.client;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.softserve.itacademy.kek.rest.api.OrdersApi;
import com.softserve.itacademy.kek.rest.api.RegistrationApi;
import com.softserve.itacademy.kek.rest.api.TenantsApi;
import com.softserve.itacademy.kek.rest.api.UsersApi;
import com.softserve.itacademy.kek.rest.model.Registration;
import com.softserve.itacademy.kek.rest.model.SessionDto;

import static com.softserve.itacademy.kek.client.utils.ModelUtils.getRegistrationWithName;

public class RegistrationFlow {

    private final static Logger LOGGER = LoggerFactory.getLogger(MainFlow.class);
    private final static String HOST = "http://localhost:8080/api/v1";
    private final static OrdersApi ordersApi = RestClientFactory.createRestApiClient(OrdersApi.class, HOST);
    private final static TenantsApi tenantApi = RestClientFactory.createRestApiClient(TenantsApi.class, HOST);
    private final static UsersApi usersApi = RestClientFactory.createRestApiClient(UsersApi.class, HOST);
    private final static RegistrationApi registrationApi = RestClientFactory.createRestApiClient(RegistrationApi.class, HOST);


    public static void main(String[] args) {
        final Registration registration = getRegistrationWithName("Tenant4", "mrttterrtyty.acoustic@gmail.com");
        SessionDto sessionDtoId = registrationApi.userRegistration(registration);
        System.out.println("sessionId: " + sessionDtoId);
    }
}
