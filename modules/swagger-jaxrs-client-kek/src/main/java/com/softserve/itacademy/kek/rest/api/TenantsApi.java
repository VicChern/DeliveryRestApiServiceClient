package com.softserve.itacademy.kek.rest.api;

import javax.ws.rs.Consumes;
import javax.ws.rs.CookieParam;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import com.softserve.itacademy.kek.rest.model.Address;
import com.softserve.itacademy.kek.rest.model.ListWrapperDto;
import com.softserve.itacademy.kek.rest.model.ResponseEntity;
import com.softserve.itacademy.kek.rest.model.Tenant;
import com.softserve.itacademy.kek.rest.model.TenantProperty;

/**
 * KEK
 *
 * <p>BaaS for delivery services like Glovo, Uber or even for regular mail.
 */
@Path("/")
@Api(value = "/", description = "")
public interface TenantsApi {

    /**
     * addTenantAddresses
     */
    @POST
    @Path("/tenants/{guid}/addresses")
    @Consumes({"application/vnd.softserve.addressList+json"})
    @Produces({"application/vnd.softserve.addressList+json"})
    @ApiOperation(value = "addTenantAddresses", tags = {})
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK", response = ListWrapperDto.class),
            @ApiResponse(code = 201, message = "Created"),
            @ApiResponse(code = 401, message = "Unauthorized"),
            @ApiResponse(code = 403, message = "Forbidden"),
            @ApiResponse(code = 404, message = "Not Found")})
    ListWrapperDto<Address> addTenantAddresses(@PathParam("guid") String guid, ListWrapperDto<Address> newAddresses);

    /**
     * addTenantProperties
     */
    @POST
    @Path("/tenants/{guid}/properties")
    @Consumes({"application/vnd.softserve.tenantproperty+json"})
    @Produces({"application/vnd.softserve.tenantproperty+json"})
    @ApiOperation(value = "addTenantProperties", tags = {})
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK", response = ListWrapperDto.class),
            @ApiResponse(code = 201, message = "Created"),
            @ApiResponse(code = 401, message = "Unauthorized"),
            @ApiResponse(code = 403, message = "Forbidden"),
            @ApiResponse(code = 404, message = "Not Found")})
    ListWrapperDto<TenantProperty> addTenantProperties(@PathParam("guid") String guid,
                                                       ListWrapperDto<TenantProperty> tenantPropertiesList);

    /**
     * addTenant
     */
    @POST
    @Path("/tenants")
    @Consumes({"application/vnd.softserve.tenant+json"})
    @Produces({"application/vnd.softserve.tenant+json"})
    @ApiOperation(value = "addTenant", tags = {})
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK", response = Tenant.class),
            @ApiResponse(code = 201, message = "Created"),
            @ApiResponse(code = 401, message = "Unauthorized"),
            @ApiResponse(code = 403, message = "Forbidden"),
            @ApiResponse(code = 404, message = "Not Found")})
    Tenant addTenant(Tenant tenant, @HeaderParam("Authorization") String token);

    /**
     * deleteTenantAddress
     */
    @DELETE
    @Path("/tenants/{guid}/addresses/{addrguid}")
    @Produces({"*/*"})
    @ApiOperation(value = "deleteTenantAddress", tags = {})
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK", response = ResponseEntity.class),
            @ApiResponse(code = 204, message = "No Content"),
            @ApiResponse(code = 401, message = "Unauthorized"),
            @ApiResponse(code = 403, message = "Forbidden")})
    void deleteTenantAddress(@PathParam("addrguid") String addrguid, @PathParam("guid") String guid);

    /**
     * deleteTenantProperty
     */
    @DELETE
    @Path("/tenants/{guid}/properties/{propguid}")
    @Produces({"*/*"})
    @ApiOperation(value = "deleteTenantProperty", tags = {})
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK", response = ResponseEntity.class),
            @ApiResponse(code = 204, message = "No Content"),
            @ApiResponse(code = 401, message = "Unauthorized"),
            @ApiResponse(code = 403, message = "Forbidden")})
    void deleteTenantProperty(@PathParam("guid") String guid, @PathParam("propguid") String propguid);

    /**
     * deleteTenant
     */
    @DELETE
    @Path("/tenants/{guid}")
    @Produces({"*/*"})
    @ApiOperation(value = "deleteTenant", tags = {})
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK", response = ResponseEntity.class),
            @ApiResponse(code = 204, message = "No Content"),
            @ApiResponse(code = 401, message = "Unauthorized"),
            @ApiResponse(code = 403, message = "Forbidden")})
    void deleteTenant(@PathParam("guid") String guid);

    /**
     * getTenantAddress
     */
    @GET
    @Path("/tenants/{guid}/addresses/{addrguid}")
    @Produces({"application/vnd.softserve.address+json"})
    @ApiOperation(value = "getTenantAddress", tags = {})
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK", response = Address.class),
            @ApiResponse(code = 401, message = "Unauthorized"),
            @ApiResponse(code = 403, message = "Forbidden"),
            @ApiResponse(code = 404, message = "Not Found")})
    Address getTenantAddress(@PathParam("addrguid") String addrguid, @PathParam("guid") String guid);

    /**
     * getTenantAddresses
     */
    @GET
    @Path("/tenants/{guid}/addresses")
    @Produces({"application/vnd.softserve.addressList+json"})
    @ApiOperation(value = "getTenantAddresses", tags = {})
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK", response = ListWrapperDto.class),
            @ApiResponse(code = 401, message = "Unauthorized"),
            @ApiResponse(code = 403, message = "Forbidden"),
            @ApiResponse(code = 404, message = "Not Found")})
    ListWrapperDto<Address> getTenantAddresses(@PathParam("guid") String guid);

    /**
     * getTenantList
     */
    @GET
    @Path("/tenants")
    @Produces({"application/vnd.softserve.tenantList+json"})
    @ApiOperation(value = "getTenantList", tags = {})
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK", response = ListWrapperDto.class),
            @ApiResponse(code = 401, message = "Unauthorized"),
            @ApiResponse(code = 403, message = "Forbidden"),
            @ApiResponse(code = 404, message = "Not Found")})
    ListWrapperDto<Tenant> getTenantList();

    /**
     * getTenantProperties
     */
    @GET
    @Path("/tenants/{guid}/properties")
    @Produces({"application/vnd.softserve.tenantproperty+json"})
    @ApiOperation(value = "getTenantProperties", tags = {})
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK", response = ListWrapperDto.class),
            @ApiResponse(code = 401, message = "Unauthorized"),
            @ApiResponse(code = 403, message = "Forbidden"),
            @ApiResponse(code = 404, message = "Not Found")})
    ListWrapperDto<TenantProperty> getTenantProperties(@PathParam("guid") String guid);

    /**
     * getTenantProperty
     */
    @GET
    @Path("/tenants/{guid}/properties/{propguid}")
    @Produces({"application/vnd.softserve.tenantproperty+json"})
    @ApiOperation(value = "getTenantProperty", tags = {})
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK", response = TenantProperty.class),
            @ApiResponse(code = 401, message = "Unauthorized"),
            @ApiResponse(code = 403, message = "Forbidden"),
            @ApiResponse(code = 404, message = "Not Found")})
    TenantProperty getTenantProperty(@PathParam("guid") String guid, @PathParam("propguid") String propguid);

    /**
     * getTenant
     */
    @GET
    @Path("/tenants/{guid}")
    @Produces({"application/vnd.softserve.tenant+json"})
    @ApiOperation(value = "getTenant", tags = {})
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK", response = Tenant.class),
            @ApiResponse(code = 401, message = "Unauthorized"),
            @ApiResponse(code = 403, message = "Forbidden"),
            @ApiResponse(code = 404, message = "Not Found")})
    Tenant getTenant(@PathParam("guid") String guid);

    /**
     * modifyTenantAddress
     */
    @PUT
    @Path("/tenants/{guid}/addresses/{addrguid}")
    @Consumes({"application/vnd.softserve.address+json"})
    @Produces({"application/vnd.softserve.address+json"})
    @ApiOperation(value = "modifyTenantAddress", tags = {})
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK", response = Address.class),
            @ApiResponse(code = 201, message = "Created"),
            @ApiResponse(code = 401, message = "Unauthorized"),
            @ApiResponse(code = 403, message = "Forbidden"),
            @ApiResponse(code = 404, message = "Not Found")})
    Address modifyTenantAddress(@PathParam("addrguid") String addrguid, @PathParam("guid") String guid, Address tenantAddress);

    /**
     * modifyTenantProperty
     */
    @PUT
    @Path("/tenants/{guid}/properties/{propguid}")
    @Consumes({"application/vnd.softserve.tenantproperty+json"})
    @Produces({"application/vnd.softserve.tenantproperty+json"})
    @ApiOperation(value = "modifyTenantProperty", tags = {})
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK", response = TenantProperty.class),
            @ApiResponse(code = 201, message = "Created"),
            @ApiResponse(code = 401, message = "Unauthorized"),
            @ApiResponse(code = 403, message = "Forbidden"),
            @ApiResponse(code = 404, message = "Not Found")})
    TenantProperty modifyTenantProperty(@PathParam("guid") String guid, @PathParam("propguid") String propguid, TenantProperty tenantProperties);

    /**
     * modifyTenant
     */
    @PUT
    @Path("/tenants/{guid}")
    @Consumes({"application/vnd.softserve.tenant+json"})
    @Produces({"application/vnd.softserve.tenant+json"})
    @ApiOperation(value = "modifyTenant", tags = {})
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK", response = Tenant.class),
            @ApiResponse(code = 201, message = "Created"),
            @ApiResponse(code = 401, message = "Unauthorized"),
            @ApiResponse(code = 403, message = "Forbidden"),
            @ApiResponse(code = 404, message = "Not Found")})
    Tenant modifyTenant(@PathParam("guid") String guid, Tenant tenant);
}

