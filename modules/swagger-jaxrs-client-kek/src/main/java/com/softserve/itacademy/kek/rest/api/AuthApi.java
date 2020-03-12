package com.softserve.itacademy.kek.rest.api;


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
public interface AuthApi  {

    /**
     * getCallback
     *
     */
    @DELETE
    @Path("/callback")
    @Produces({ "*/*" })
    @ApiOperation(value = "getCallback", tags={  })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "OK"),
        @ApiResponse(code = 204, message = "No Content"),
        @ApiResponse(code = 401, message = "Unauthorized"),
        @ApiResponse(code = 403, message = "Forbidden") })
    public void getCallbackUsingDELETE();

    /**
     * getCallback
     *
     */
    @GET
    @Path("/callback")
    @Produces({ "*/*" })
    @ApiOperation(value = "getCallback", tags={  })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "OK"),
        @ApiResponse(code = 401, message = "Unauthorized"),
        @ApiResponse(code = 403, message = "Forbidden"),
        @ApiResponse(code = 404, message = "Not Found") })
    public void getCallbackUsingGET();

    /**
     * getCallback
     *
     */
    @HEAD
    @Path("/callback")
    @Consumes({ "application/json" })
    @Produces({ "*/*" })
    @ApiOperation(value = "getCallback", tags={  })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "OK"),
        @ApiResponse(code = 204, message = "No Content"),
        @ApiResponse(code = 401, message = "Unauthorized"),
        @ApiResponse(code = 403, message = "Forbidden") })
    public void getCallbackUsingHEAD();

    /**
     * getCallback
     *
     */
    @OPTIONS
    @Path("/callback")
    @Consumes({ "application/json" })
    @Produces({ "*/*" })
    @ApiOperation(value = "getCallback", tags={  })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "OK"),
        @ApiResponse(code = 204, message = "No Content"),
        @ApiResponse(code = 401, message = "Unauthorized"),
        @ApiResponse(code = 403, message = "Forbidden") })
    public void getCallbackUsingOPTIONS();

    /**
     * getCallback
     *
     */
    @PATCH
    @Path("/callback")
    @Consumes({ "application/json" })
    @Produces({ "*/*" })
    @ApiOperation(value = "getCallback", tags={  })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "OK"),
        @ApiResponse(code = 204, message = "No Content"),
        @ApiResponse(code = 401, message = "Unauthorized"),
        @ApiResponse(code = 403, message = "Forbidden") })
    public void getCallbackUsingPATCH();

    /**
     * getCallback
     *
     */
    @POST
    @Path("/callback")
    @Consumes({ "application/json" })
    @Produces({ "*/*" })
    @ApiOperation(value = "getCallback", tags={  })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "OK"),
        @ApiResponse(code = 201, message = "Created"),
        @ApiResponse(code = 401, message = "Unauthorized"),
        @ApiResponse(code = 403, message = "Forbidden"),
        @ApiResponse(code = 404, message = "Not Found") })
    public void getCallbackUsingPOST();

    /**
     * getCallback
     *
     */
    @PUT
    @Path("/callback")
    @Consumes({ "application/json" })
    @Produces({ "*/*" })
    @ApiOperation(value = "getCallback", tags={  })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "OK"),
        @ApiResponse(code = 201, message = "Created"),
        @ApiResponse(code = 401, message = "Unauthorized"),
        @ApiResponse(code = 403, message = "Forbidden"),
        @ApiResponse(code = 404, message = "Not Found") })
    public void getCallbackUsingPUT();

    /**
     * login
     *
     */
    @GET
    @Path("/login")
    @Produces({ "*/*" })
    @ApiOperation(value = "login", tags={  })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "OK"),
        @ApiResponse(code = 401, message = "Unauthorized"),
        @ApiResponse(code = 403, message = "Forbidden"),
        @ApiResponse(code = 404, message = "Not Found") })
    public void loginUsingGET();

    /**
     * profile
     *
     */
    @GET
    @Path("/profile")
    @Produces({ "*/*" })
    @ApiOperation(value = "profile", tags={  })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "OK", response = String.class),
        @ApiResponse(code = 401, message = "Unauthorized"),
        @ApiResponse(code = 403, message = "Forbidden"),
        @ApiResponse(code = 404, message = "Not Found") })
    public String profileUsingGET(@QueryParam("authenticated")Boolean authenticated, @QueryParam("authorities[0].authority")String authorities0Authority, @QueryParam("credentials")Map<String, String> credentials, @QueryParam("details")Map<String, String> details, @QueryParam("principal")Map<String, String> principal);
}

