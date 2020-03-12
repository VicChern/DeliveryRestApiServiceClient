package com.softserve.itacademy.kek.rest.api;

import com.softserve.itacademy.kek.rest.model.SseEmitter;
import java.util.UUID;

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
public interface SseApi  {

    /**
     * trackOrder
     *
     */
    @GET
    @Path("/orders/{orderGuid}/tracking/")
    @Produces({ "*/*" })
    @ApiOperation(value = "trackOrder", tags={  })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "OK", response = SseEmitter.class),
        @ApiResponse(code = 401, message = "Unauthorized"),
        @ApiResponse(code = 403, message = "Forbidden"),
        @ApiResponse(code = 404, message = "Not Found") })
    public SseEmitter trackOrderUsingGET(@PathParam("orderGuid") UUID orderGuid);
}

