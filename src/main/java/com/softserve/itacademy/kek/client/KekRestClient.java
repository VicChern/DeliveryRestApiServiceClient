package com.softserve.itacademy.kek.client;

import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import com.softserve.itacademy.kek.rest.api.OrdersApi;
import com.softserve.itacademy.kek.rest.api.TenantsApi;
import com.softserve.itacademy.kek.rest.api.UsersApi;
import com.softserve.itacademy.kek.rest.model.Address;
import com.softserve.itacademy.kek.rest.model.Order;
import com.softserve.itacademy.kek.rest.model.OrderEvent;
import com.softserve.itacademy.kek.rest.model.Tenant;
import com.softserve.itacademy.kek.rest.model.TenantProperty;
import com.softserve.itacademy.kek.rest.model.User;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

public class KekRestClient implements OrdersApi, TenantsApi, UsersApi
{
    private OrdersApi ordersApi;
    private TenantsApi tenantsApi;
    private UsersApi usersApi;

    public KekRestClient(String endpointUrl)
    {
        this.ordersApi = RestClientFactory.createRestApiClient(OrdersApi.class, endpointUrl);
        this.tenantsApi = RestClientFactory.createRestApiClient(TenantsApi.class, endpointUrl);
        this.usersApi = RestClientFactory.createRestApiClient(UsersApi.class, endpointUrl);
    }

    @Override
    @ApiResponses({
            @ApiResponse(code = 200, message = "The list of order event objects", response = OrderEvent.class, responseContainer = "List")})
    @ApiOperation(value = "Adds an order event", tags = {})
    @Produces({"application/vnd.softserve.event+json"})
    @Consumes({"application/vnd.softserve.event+json"})
    @Path("/orders/{guid}/events")
    @POST
    public List<OrderEvent> addEvent(String guid, OrderEvent event)
    {
        return ordersApi.addEvent(guid, event);
    }

    @Override
    @ApiResponses({
            @ApiResponse(code = 200, message = "The newly created order object", response = Order.class)})
    @ApiOperation(value = "Creates a new order", tags = {})
    @Produces({"application/vnd.softserve.order+json"})
    @Consumes({"application/vnd.softserve.order+json"})
    @Path("/orders")
    @POST
    public Order addOrder(Order order)
    {
        return ordersApi.addOrder(order);
    }

    @Override
    @ApiResponses({
            @ApiResponse(code = 200, message = "Successful operation")})
    @ApiOperation(value = "Deletes the specific order", tags = {})
    @Path("/orders/{guid}")
    @DELETE
    public void deleteOrder(String guid)
    {
        ordersApi.deleteOrder(guid);
    }

    @Override
    @ApiResponses({
            @ApiResponse(code = 200, message = "The list of order event objects", response = OrderEvent.class, responseContainer = "List")})
    @ApiOperation(value = "Finds the specific order events", tags = {})
    @Produces({"application/vnd.softserve.event+json"})
    @Path("/orders/{guid}/events")
    @GET
    public List<OrderEvent> getEvents(String guid)
    {
        return ordersApi.getEvents(guid);
    }

    @Override
    @ApiResponses({
            @ApiResponse(code = 200, message = "The order object", response = Order.class)})
    @ApiOperation(value = "Finds the specific order", tags = {})
    @Produces({"application/vnd.softserve.order+json"})
    @Path("/orders/{guid}")
    @GET
    public Order getOrder(String guid)
    {
        return ordersApi.getOrder(guid);
    }

    @Override
    @ApiResponses({
            @ApiResponse(code = 200, message = "The order object", response = Order.class)})
    @ApiOperation(value = "Searches for orders", tags = {})
    @Produces({"application/vnd.softserve.order+json"})
    @Path("/orders")
    @GET
    public Order getOrderList()
    {
        return ordersApi.getOrderList();
    }

    @Override
    @ApiResponses({
            @ApiResponse(code = 200, message = "The modified order object", response = Order.class)})
    @ApiOperation(value = "Modifies the specific order", tags = {})
    @Produces({"application/vnd.softserve.order+json"})
    @Consumes({"application/vnd.softserve.order+json"})
    @Path("/orders/{guid}")
    @PUT
    public Order modifyOrder(String guid, Order order)
    {
        return ordersApi.modifyOrder(guid, order);
    }

    @Override
    @ApiResponses({
            @ApiResponse(code = 200, message = "The newly created tenant object", response = Tenant.class)})
    @ApiOperation(value = "Creates a new tenant", tags = {})
    @Produces({"application/vnd.softserve.tenant+json"})
    @Consumes({"application/vnd.softserve.tenant+json"})
    @Path("/tenants")
    @POST
    public Tenant addTenant(Tenant tenant)
    {
        return tenantsApi.addTenant(tenant);
    }

    @Override
    @ApiResponses({
            @ApiResponse(code = 200, message = "List of added tenant addresses", response = Address.class, responseContainer = "List")})
    @ApiOperation(value = "Adds a new addresses", tags = {})
    @Produces({"application/vnd.softserve.address+json"})
    @Consumes({"application/vnd.softserve.address+json"})
    @Path("/tenants/{guid}/addresses")
    @POST
    public List<Address> addTenantAddresses(String guid, List<Address> addresses)
    {
        return tenantsApi.addTenantAddresses(guid, addresses);
    }

    @Override
    @ApiResponses({
            @ApiResponse(code = 200, message = "List of added tenant properties", response = TenantProperty.class, responseContainer = "List")})
    @ApiOperation(value = "Adds tenant properties", tags = {})
    @Produces({"application/vnd.softserve.tenantproperty+json"})
    @Consumes({"application/vnd.softserve.tenantproperty+json"})
    @Path("/tenants/{guid}/properties")
    @POST
    public List<TenantProperty> addTenantProperties(String guid, List<TenantProperty> properties)
    {
        return tenantsApi.addTenantProperties(guid, properties);
    }

    @Override
    @ApiResponses({
            @ApiResponse(code = 200, message = "Successful operation")})
    @ApiOperation(value = "Deletes the specific tenant", tags = {})
    @Path("/tenants/{guid}")
    @DELETE
    public void deleteTenant(String guid)
    {
        tenantsApi.deleteTenant(guid);
    }

    @Override
    @ApiResponses({
            @ApiResponse(code = 200, message = "Successful operation")})
    @ApiOperation(value = "Deletes the specific tenant address", tags = {})
    @Path("/tenants/{guid}/addresses/{addrguid}")
    @DELETE
    public void deleteTenantAddress(String guid, String addrguid)
    {
        tenantsApi.deleteTenantAddress(guid, addrguid);
    }

    @Override
    @ApiResponses({
            @ApiResponse(code = 200, message = "Successful operation")})
    @ApiOperation(value = "Deletes the specific tenant property", tags = {})
    @Path("/tenants/{guid}/properties/{propguid}")
    @DELETE
    public void deleteTenantProperty(String guid, String propguid)
    {
        tenantsApi.deleteTenantProperty(guid, propguid);
    }

    @Override
    @ApiResponses({
            @ApiResponse(code = 200, message = "The tenant object", response = Tenant.class)})
    @ApiOperation(value = "Finds the specific tenant", tags = {})
    @Produces({"application/vnd.softserve.tenant+json"})
    @Path("/tenants/{guid}")
    @GET
    public Tenant getTenant(String guid)
    {
        return tenantsApi.getTenant(guid);
    }

    @Override
    @ApiResponses({
            @ApiResponse(code = 200, message = "Specific tenant address", response = Address.class)})
    @ApiOperation(value = "Finds specific address of the specific tenant", tags = {})
    @Produces({"application/vnd.softserve.address+json"})
    @Path("/tenants/{guid}/addresses/{addrguid}")
    @GET
    public Address getTenantAddress(String guid, String addrguid)
    {
        return tenantsApi.getTenantAddress(guid, addrguid);
    }

    @Override
    @ApiResponses({
            @ApiResponse(code = 200, message = "List of tenant addresses", response = Address.class, responseContainer = "List")})
    @ApiOperation(value = "Finds addressess of the specific tenant", tags = {})
    @Produces({"application/vnd.softserve.address+json"})
    @Path("/tenants/{guid}/addresses")
    @GET
    public List<Address> getTenantAddresses(String guid)
    {
        return tenantsApi.getTenantAddresses(guid);
    }

    @Override
    @ApiResponses({
            @ApiResponse(code = 200, message = "List of tenants", response = Tenant.class, responseContainer = "List")})
    @ApiOperation(value = "Searches for tenants", tags = {})
    @Produces({"application/vnd.softserve.tenant+json"})
    @Path("/tenants")
    @GET
    public List<Tenant> getTenantList()
    {
        return tenantsApi.getTenantList();
    }

    @Override
    @ApiResponses({
            @ApiResponse(code = 200, message = "List of tenant properties", response = TenantProperty.class, responseContainer = "List")})
    @ApiOperation(value = "Finds properties of the specific tenant", tags = {})
    @Produces({"application/vnd.softserve.tenantproperty+json"})
    @Path("/tenants/{guid}/properties")
    @GET
    public List<TenantProperty> getTenantProperties(String guid)
    {
        return tenantsApi.getTenantProperties(guid);
    }

    @Override
    @ApiResponses({
            @ApiResponse(code = 200, message = "Specific tenant tenant property", response = TenantProperty.class)})
    @ApiOperation(value = "Finds specific property of the specific tenant", tags = {})
    @Produces({"application/vnd.softserve.tenantproperty+json"})
    @Path("/tenants/{guid}/properties/{propguid}")
    @GET
    public TenantProperty getTenantProperty(String guid, String propguid)
    {
        return tenantsApi.getTenantProperty(guid, propguid);
    }

    @Override
    @ApiResponses({
            @ApiResponse(code = 200, message = "The modified tenant object", response = Tenant.class)})
    @ApiOperation(value = "Modifies the specific tenant", tags = {})
    @Produces({"application/vnd.softserve.tenant+json"})
    @Consumes({"application/vnd.softserve.tenant+json"})
    @Path("/tenants/{guid}")
    @PUT
    public Tenant modifyTenant(String guid, Tenant tenant)
    {
        return tenantsApi.modifyTenant(guid, tenant);
    }

    @Override
    @ApiResponses({
            @ApiResponse(code = 200, message = "The modified address object", response = Address.class)})
    @ApiOperation(value = "Modifies the specific tenant address", tags = {})
    @Produces({"application/vnd.softserve.address+json"})
    @Consumes({"application/vnd.softserve.address+json"})
    @Path("/tenants/{guid}/addresses/{addrguid}")
    @PUT
    public Address modifyTenantAddress(String guid, String addrguid, Address address)
    {
        return tenantsApi.modifyTenantAddress(guid, addrguid, address);
    }

    @Override
    @ApiResponses({
            @ApiResponse(code = 200, message = "The modified tenant property object", response = TenantProperty.class)})
    @ApiOperation(value = "Modifies the specific tenant property", tags = {})
    @Produces({"application/vnd.softserve.tenantproperty+json"})
    @Consumes({"application/vnd.softserve.tenantproperty+json"})
    @Path("/tenants/{guid}/properties/{propguid}")
    @PUT
    public TenantProperty modifyTenantProperty(String guid, String propguid, TenantProperty property)
    {
        return tenantsApi.modifyTenantProperty(guid, propguid, property);
    }

    @Override
    @ApiResponses({
            @ApiResponse(code = 200, message = "The newly created user object", response = User.class)})
    @ApiOperation(value = "Creates a new user", tags = {})
    @Produces({"application/vnd.softserve.user+json"})
    @Consumes({"application/vnd.softserve.user+json"})
    @Path("/users")
    @POST
    public User addUser(User user)
    {
        return usersApi.addUser(user);
    }

    @Override
    @ApiResponses({
            @ApiResponse(code = 200, message = "List of added user addresses", response = Address.class, responseContainer = "List")})
    @ApiOperation(value = "Adds a new addresses", tags = {})
    @Produces({"application/vnd.softserve.address+json"})
    @Consumes({"application/vnd.softserve.address+json"})
    @Path("/users/{guid}/addresses")
    @POST
    public List<Address> addUserAddresses(String guid, List<Address> addresses)
    {
        return usersApi.addUserAddresses(guid, addresses);
    }

    @Override
    @ApiResponses({
            @ApiResponse(code = 200, message = "Successful operation")})
    @ApiOperation(value = "Deletes the specific user", tags = {})
    @Path("/users/{guid}")
    @DELETE
    public void deleteUser(String guid)
    {
        usersApi.deleteUser(guid);
    }

    @Override
    @ApiResponses({
            @ApiResponse(code = 200, message = "Successful operation")})
    @ApiOperation(value = "Deletes the specific user address", tags = {})
    @Path("/users/{guid}/addresses/{addrguid}")
    @DELETE
    public void deleteUserAddress(String guid, String addrguid)
    {
        usersApi.deleteUserAddress(guid, addrguid);
    }

    @Override
    @ApiResponses({
            @ApiResponse(code = 200, message = "The user object", response = User.class)})
    @ApiOperation(value = "Finds the specific user", tags = {})
    @Produces({"application/vnd.softserve.user+json"})
    @Path("/users/{guid}")
    @GET
    public User getUser(String guid)
    {
        return usersApi.getUser(guid);
    }

    @Override
    @ApiResponses({
            @ApiResponse(code = 200, message = "Specific user address", response = Address.class)})
    @ApiOperation(value = "Finds addressess of the specific user", tags = {})
    @Produces({"application/vnd.softserve.address+json"})
    @Path("/users/{guid}/addresses/{addrguid}")
    @GET
    public Address getUserAddress(String guid, String addrguid)
    {
        return usersApi.getUserAddress(guid, addrguid);
    }

    @Override
    @ApiResponses({
            @ApiResponse(code = 200, message = "List of user addresses", response = Address.class, responseContainer = "List")})
    @ApiOperation(value = "Finds addressess of the specific user", tags = {})
    @Produces({"application/vnd.softserve.address+json"})
    @Path("/users/{guid}/addresses")
    @GET
    public List<Address> getUserAddresses(String guid)
    {
        return usersApi.getUserAddresses(guid);
    }

    @Override
    @ApiResponses({
            @ApiResponse(code = 200, message = "List of users", response = User.class, responseContainer = "List")})
    @ApiOperation(value = "Searches for users", tags = {})
    @Produces({"application/vnd.softserve.user+json"})
    @Path("/users")
    @GET
    public List<User> getUserList()
    {
        return usersApi.getUserList();
    }

    @Override
    @ApiResponses({
            @ApiResponse(code = 200, message = "The modified user object", response = User.class)})
    @ApiOperation(value = "Modifies the specific user", tags = {})
    @Produces({"application/vnd.softserve.user+json"})
    @Consumes({"application/vnd.softserve.user+json"})
    @Path("/users/{guid}")
    @PUT
    public User modifyUser(String guid, User user)
    {
        return usersApi.modifyUser(guid, user);
    }

    @Override
    @ApiResponses({
            @ApiResponse(code = 200, message = "The modified address object", response = Address.class)})
    @ApiOperation(value = "Modifies the specific user address", tags = {})
    @Produces({"application/vnd.softserve.address+json"})
    @Consumes({"application/vnd.softserve.address+json"})
    @Path("/users/{guid}/addresses/{addrguid}")
    @PUT
    public Address modifyUserAddress(String guid, String addrguid, Address address)
    {
        return usersApi.modifyUserAddress(guid, addrguid, address);
    }
}