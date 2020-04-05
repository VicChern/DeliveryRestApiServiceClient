package com.softserve.itacademy.kek.rest.api;

import com.softserve.itacademy.kek.rest.model.SignIn;
import com.softserve.itacademy.kek.rest.model.Token;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;
import java.util.Map;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.MediaType;
import org.apache.cxf.jaxrs.ext.multipart.*;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.ApiResponse;
import io.swagger.jaxrs.PATCH;

/**
 * KEK
 *
 * <p>BaaS for delivery services like Glovo, Uber or even for regular mail.
 *
 */
@Path("/")
@Api(value = "/", description = "")
public interface SignInApi  {

    /**
     * signIn
     *
     */
    @POST
    @Path("/signin")
    @Consumes({ "application/vnd.softserve.signin+json" })
    @Produces({ "application/vnd.softserve.token+json" })
    @ApiOperation(value = "signIn", tags={  })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "OK", response = Token.class),
        @ApiResponse(code = 201, message = "Created"),
        @ApiResponse(code = 401, message = "Unauthorized"),
        @ApiResponse(code = 403, message = "Forbidden"),
        @ApiResponse(code = 404, message = "Not Found") })
    public Token signIn(SignIn signInData);
}

