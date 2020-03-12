package com.softserve.itacademy.kek.client;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.softserve.itacademy.kek.client.utils.ModelUtils;
import com.softserve.itacademy.kek.rest.api.OrdersApi;
import com.softserve.itacademy.kek.rest.api.RegistrationApi;
import com.softserve.itacademy.kek.rest.api.TenantsApi;
import com.softserve.itacademy.kek.rest.api.UsersApi;
import com.softserve.itacademy.kek.rest.model.Registration;
import com.softserve.itacademy.kek.rest.model.TemporaryDto;
import com.softserve.itacademy.kek.rest.model.Tenant;

import static com.softserve.itacademy.kek.client.utils.ModelUtils.getRegistrationWithName;

public class RegistrationFlow {

    private final static Logger LOGGER = LoggerFactory.getLogger(MainFlow.class);
    private final static String HOST = "http://localhost:8080/api/v1";
    private final static OrdersApi ordersApi = RestClientFactory.createRestApiClient(OrdersApi.class, HOST);
    private final static TenantsApi tenantApi = RestClientFactory.createRestApiClient(TenantsApi.class, HOST);
    private final static UsersApi usersApi = RestClientFactory.createRestApiClient(UsersApi.class, HOST);
    private final static RegistrationApi registrationApi = RestClientFactory.createRestApiClient(RegistrationApi.class, HOST);


    public static void main(String[] args) {

        final Registration tenantRegistration = getRegistrationWithName("Tenant2", "marina.acoustic2.acoustic@gmail.com");
        TemporaryDto temporaryDto = registrationApi.userRegistration(tenantRegistration);
        String tenantUserGuid = temporaryDto.getUserGuid();
        LOGGER.info("\n\n STEP 1: Register new user for tenant, user guid: {}", tenantUserGuid);


        final Tenant tenant = tenantApi.addTenant(ModelUtils.getTenantForUserGuid(tenantUserGuid), temporaryDto.getSessionId());
        LOGGER.info("\n\n STEP 2: Added new tenant {} for user guid={}",
                tenant,
                tenantUserGuid);


        final Registration customerRegistration = getRegistrationWithName("Customer2", "customer.acoustic@gmail.com");
        TemporaryDto customerTemporaryDto = registrationApi.userRegistration(customerRegistration);
        String customerGuid = customerTemporaryDto.getUserGuid();
        LOGGER.info("\n\n STEP 3: Register new user for customer, user guid: {}", customerGuid);




    }
}
