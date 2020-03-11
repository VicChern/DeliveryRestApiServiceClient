package com.softserve.itacademy.kek.rest.api;

import com.softserve.itacademy.kek.rest.model.Order;
import com.softserve.itacademy.kek.rest.model.OrderEvent;
import com.softserve.itacademy.kek.rest.model.OrderEventList;
import com.softserve.itacademy.kek.rest.model.OrderList;
import com.softserve.itacademy.kek.rest.model.ResponseEntity;

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
public interface OrdersApi {

    /**
     * addEvent
     *
     */
    @POST
    @Path("/orders/{guid}/events")
    @Consumes({ "application/vnd.softserve.event+json" })
    @Produces({ "application/vnd.softserve.event+json" })
    @ApiOperation(value = "addEvent", tags={  })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "OK", response = OrderEvent.class),
        @ApiResponse(code = 201, message = "Created"),
        @ApiResponse(code = 401, message = "Unauthorized"),
        @ApiResponse(code = 403, message = "Forbidden"),
        @ApiResponse(code = 404, message = "Not Found") })
    public OrderEvent addEvent(@PathParam("guid") String guid, OrderEvent orderEvent);

    /**
     * addOrder
     *
     */
    @POST
    @Path("/orders")
    @Consumes({ "application/vnd.softserve.orderlist+json" })
    @Produces({ "application/vnd.softserve.orderlist+json" })
    @ApiOperation(value = "addOrder", tags={  })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "OK", response = OrderList.class),
        @ApiResponse(code = 201, message = "Created"),
        @ApiResponse(code = 401, message = "Unauthorized"),
        @ApiResponse(code = 403, message = "Forbidden"),
        @ApiResponse(code = 404, message = "Not Found") })
    public OrderList addOrder(OrderList newOrderList);

    /**
     * deleteOrder
     *
     */
    @DELETE
    @Path("/orders/{guid}")
    @Produces({ "*/*" })
    @ApiOperation(value = "deleteOrder", tags={  })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "OK", response = ResponseEntity.class),
        @ApiResponse(code = 204, message = "No Content"),
        @ApiResponse(code = 401, message = "Unauthorized"),
        @ApiResponse(code = 403, message = "Forbidden") })
    public ResponseEntity deleteOrder(@PathParam("guid") String guid);

    /**
     * getEvents
     *
     */
    @GET
    @Path("/orders/{guid}/events")
    @Produces({ "application/vnd.softserve.eventlist+json" })
    @ApiOperation(value = "getEvents", tags={  })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "OK", response = OrderEventList.class),
        @ApiResponse(code = 401, message = "Unauthorized"),
        @ApiResponse(code = 403, message = "Forbidden"),
        @ApiResponse(code = 404, message = "Not Found") })
    public OrderEventList getEvents(@PathParam("guid") String guid);

    /**
     * getOrderList
     *
     */
    @GET
    @Path("/orders")
    @Produces({ "application/vnd.softserve.orderlist+json" })
    @ApiOperation(value = "getOrderList", tags={  })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "OK", response = OrderList.class),
        @ApiResponse(code = 401, message = "Unauthorized"),
        @ApiResponse(code = 403, message = "Forbidden"),
        @ApiResponse(code = 404, message = "Not Found") })
    public OrderList getOrderList();

    /**
     * getOrder
     *
     */
    @GET
    @Path("/orders/{guid}")
    @Produces({ "application/vnd.softserve.order+json" })
    @ApiOperation(value = "getOrder", tags={  })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "OK", response = Order.class),
        @ApiResponse(code = 401, message = "Unauthorized"),
        @ApiResponse(code = 403, message = "Forbidden"),
        @ApiResponse(code = 404, message = "Not Found") })
    public Order getOrder(@PathParam("guid") String guid);

    /**
     * modifyOrder
     *
     */
    @PUT
    @Path("/orders/{guid}")
    @Consumes({ "application/vnd.softserve.order+json" })
    @Produces({ "application/vnd.softserve.order+json" })
    @ApiOperation(value = "modifyOrder", tags={  })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "OK", response = Order.class),
        @ApiResponse(code = 201, message = "Created"),
        @ApiResponse(code = 401, message = "Unauthorized"),
        @ApiResponse(code = 403, message = "Forbidden"),
        @ApiResponse(code = 404, message = "Not Found") })
    public Order modifyOrder(@PathParam("guid") String guid, Order order);
}

