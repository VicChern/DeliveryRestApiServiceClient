package com.softserve.itacademy.kek.rest.api;

import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import com.softserve.itacademy.kek.rest.model.User;

/**
 * KEK
 *
 * <p>BaaS for delivery services like Glovo, Uber or even for regular mail.
 */
@Path("/")
@Api(value = "/", description = "")
public interface AuthApi {

    /**
     * profile
     */
    @GET
    @Path("/profile")
    @Produces({"application/vnd.softserve.user+json"})
    @ApiOperation(value = "profile", tags = {})
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK", response = User.class),
            @ApiResponse(code = 401, message = "Unauthorized"),
            @ApiResponse(code = 403, message = "Forbidden"),
            @ApiResponse(code = 404, message = "Not Found")})
    User profile(@HeaderParam("Authorization") String token);
}

