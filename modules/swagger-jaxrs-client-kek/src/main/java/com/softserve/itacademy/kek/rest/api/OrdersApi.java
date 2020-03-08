package com.softserve.itacademy.kek.rest.api;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import com.softserve.itacademy.kek.rest.model.ErrorList;
import com.softserve.itacademy.kek.rest.model.Order;
import com.softserve.itacademy.kek.rest.model.OrderEvent;
import com.softserve.itacademy.kek.rest.model.OrderEventList;
import com.softserve.itacademy.kek.rest.model.OrderList;

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
    @Path("/orders/{orderGuid}/{actorGuid}/events")
    @Consumes({ "application/vnd.softserve.event+json" })
    @Produces({ "application/vnd.softserve.event+json", "application/vnd.softserve.errorList+json" })
    @ApiOperation(value = "Adds an order event", tags={  })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "The list of order event objects", response = OrderEvent.class),
            @ApiResponse(code = 400, message = "Fields validation failed", response = ErrorList.class) })
    public OrderEvent addEvent(@PathParam("orderGuid") String orderGuid, @PathParam("actorGuid") String actorGuid, OrderEvent event);

    /**
     * Creates a new order
     *
     */
    @POST
    @Path("/orders/{customerGuid}")
    @Consumes({ "application/vnd.softserve.orderList+json" })
    @Produces({ "application/vnd.softserve.orderList+json", "application/vnd.softserve.errorList+json" })
    @ApiOperation(value = "Creates a new order", tags={  })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "The newly created order object", response = Order.class),
            @ApiResponse(code = 400, message = "Fields validation failed", response = ErrorList.class) })
    public OrderList addOrder(OrderList orderList, @PathParam("customerGuid") String customerGuid);

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
    @Produces({ "application/vnd.softserve.eventList+json" })
    @ApiOperation(value = "Finds the specific order events", tags={  })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "The list of order event objects", response = OrderEventList.class) })
    public OrderEventList getEvents(@PathParam("guid") String guid);

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
    @Produces({ "application/vnd.softserve.orderList+json" })
    @ApiOperation(value = "Searches for orders", tags={  })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "The order object", response = OrderList.class) })
    public OrderList getOrderList();

    /**
     * Modifies the specific order
     *
     */
    @PUT
    @Path("/orders/{guid}")
    @Consumes({ "application/vnd.softserve.order+json" })
    @Produces({ "application/vnd.softserve.order+json", "application/vnd.softserve.errorList+json" })
    @ApiOperation(value = "Modifies the specific order", tags={  })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "The modified order object", response = Order.class),
            @ApiResponse(code = 400, message = "Fields validation failed", response = ErrorList.class) })
    public Order modifyOrder(@PathParam("guid") String guid, Order order);
}

