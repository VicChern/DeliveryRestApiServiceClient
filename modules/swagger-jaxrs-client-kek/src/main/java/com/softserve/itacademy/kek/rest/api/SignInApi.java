package com.softserve.itacademy.kek.rest.api;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import com.softserve.itacademy.kek.rest.model.SignIn;
import com.softserve.itacademy.kek.rest.model.Token;

/**
 * KEK
 *
 * <p>BaaS for delivery services like Glovo, Uber or even for regular mail.
 */
@Path("/")
@Api(value = "/", description = "")
public interface SignInApi {

    /**
     * signIn
     */
    @POST
    @Path("/signin")
    @Consumes({"application/vnd.softserve.signin+json"})
    @Produces({"application/vnd.softserve.token+json"})
    @ApiOperation(value = "signIn", tags = {})
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK", response = Token.class),
            @ApiResponse(code = 201, message = "Created"),
            @ApiResponse(code = 401, message = "Unauthorized"),
            @ApiResponse(code = 403, message = "Forbidden"),
            @ApiResponse(code = 404, message = "Not Found")})
    Token signIn(SignIn signInData);
}

