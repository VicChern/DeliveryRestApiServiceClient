package com.softserve.itacademy.kek.rest.api;

import com.softserve.itacademy.kek.rest.model.Order;
import com.softserve.itacademy.kek.rest.model.OrderEvent;

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
 * Kinda Express King
 *
 * <p>BaaS for delivery services like Glovo, Uber or even for regular mail. Also, a simple web front-end should be provided as an example of a typical consumer's app.
 *
 */
@Path("/")
@Api(value = "/", description = "")
public interface OrdersApi  {

    /**
     * Adds an order event
     *
     */
    @POST
    @Path("/orders/{guid}/events")
    @Consumes({ "application/vnd.softserve.event+json" })
    @Produces({ "application/vnd.softserve.event+json" })
    @ApiOperation(value = "Adds an order event", tags={  })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "The list of order event objects", response = OrderEvent.class, responseContainer = "List") })
    public List<OrderEvent> addEvent(@PathParam("guid") String guid, OrderEvent event);

    /**
     * Creates a new order
     *
     */
    @POST
    @Path("/orders")
    @Consumes({ "application/vnd.softserve.order+json" })
    @Produces({ "application/vnd.softserve.order+json" })
    @ApiOperation(value = "Creates a new order", tags={  })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "The newly created order object", response = Order.class) })
    public Order addOrder(Order order);

    /**
     * Deletes the specific order
     *
     */
    @DELETE
    @Path("/orders/{guid}")
    @ApiOperation(value = "Deletes the specific order", tags={  })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Successful operation") })
    public void deleteOrder(@PathParam("guid") String guid);

    /**
     * Finds the specific order events
     *
     */
    @GET
    @Path("/orders/{guid}/events")
    @Produces({ "application/vnd.softserve.event+json" })
    @ApiOperation(value = "Finds the specific order events", tags={  })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "The list of order event objects", response = OrderEvent.class, responseContainer = "List") })
    public List<OrderEvent> getEvents(@PathParam("guid") String guid);

    /**
     * Finds the specific order
     *
     */
    @GET
    @Path("/orders/{guid}")
    @Produces({ "application/vnd.softserve.order+json" })
    @ApiOperation(value = "Finds the specific order", tags={  })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "The order object", response = Order.class) })
    public Order getOrder(@PathParam("guid") String guid);

    /**
     * Searches for orders
     *
     * Finds all orders
     *
     */
    @GET
    @Path("/orders")
    @Produces({ "application/vnd.softserve.order+json" })
    @ApiOperation(value = "Searches for orders", tags={  })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "The order object", response = Order.class) })
    public Order getOrderList();

    /**
     * Modifies the specific order
     *
     */
    @PUT
    @Path("/orders/{guid}")
    @Consumes({ "application/vnd.softserve.order+json" })
    @Produces({ "application/vnd.softserve.order+json" })
    @ApiOperation(value = "Modifies the specific order", tags={  })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "The modified order object", response = Order.class) })
    public Order modifyOrder(@PathParam("guid") String guid, Order order);
}

