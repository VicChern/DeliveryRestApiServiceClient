package com.softserve.itacademy.kek.rest.api;

import com.softserve.itacademy.kek.rest.model.Registration;
import com.softserve.itacademy.kek.rest.model.TemporaryDto;

import javax.ws.rs.*;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.ApiResponse;

/**
 * KEK
 *
 * <p>BaaS for delivery services like Glovo, Uber or even for regular mail.
 *
 */
@Path("/")
@Api(value = "/", description = "")
public interface RegistrationApi  {


    /**
     * userRegistration
     *
     */
    @POST
    @Path("/registration")
    @Consumes({ "application/vnd.softserve.registrationUser+json" })
    @Produces({ "application/vnd.softserve.session+json" })
    @ApiOperation(value = "userRegistration", tags={  })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 201, message = "Created"),
            @ApiResponse(code = 401, message = "Unauthorized"),
            @ApiResponse(code = 403, message = "Forbidden"),
            @ApiResponse(code = 404, message = "Not Found") })
    public TemporaryDto userRegistration(Registration userData);
}

