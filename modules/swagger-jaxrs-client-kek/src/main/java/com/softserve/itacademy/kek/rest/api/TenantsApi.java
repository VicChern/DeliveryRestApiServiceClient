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

import com.softserve.itacademy.kek.rest.model.Address;
import com.softserve.itacademy.kek.rest.model.AddressList;
import com.softserve.itacademy.kek.rest.model.ErrorList;
import com.softserve.itacademy.kek.rest.model.Tenant;
import com.softserve.itacademy.kek.rest.model.TenantList;
import com.softserve.itacademy.kek.rest.model.TenantProperty;
import com.softserve.itacademy.kek.rest.model.TenantPropertyList;

/**
 * Kinda Express King
 *
 * <p>BaaS for delivery services like Glovo, Uber or even for regular mail. Also, a simple web front-end should be provided as an example of a typical consumer's app.
 *
 */
@Path("/")
@Api(value = "/", description = "")
public interface TenantsApi  {

    /**
     * Creates a new tenant
     *
     */
    @POST
    @Path("/tenants")
    @Consumes({ "application/vnd.softserve.tenant+json" })
    @Produces({ "application/vnd.softserve.tenant+json", "application/vnd.softserve.errorList+json" })
    @ApiOperation(value = "Creates a new tenant", tags={  })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "The newly created tenant object", response = Tenant.class),
        @ApiResponse(code = 400, message = "Fields validation failed", response = ErrorList.class) })
    public Tenant addTenant(Tenant tenant);

    /**
     * Adds a new addresses
     *
     */
    @POST
    @Path("/tenants/{guid}/addresses")
    @Consumes({ "application/vnd.softserve.addressList+json" })
    @Produces({ "application/vnd.softserve.addressList+json", "application/vnd.softserve.errorList+json" })
    @ApiOperation(value = "Adds a new addresses", tags={  })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "List of added tenant addresses", response = AddressList.class),
        @ApiResponse(code = 400, message = "Fields validation failed", response = ErrorList.class) })
    public AddressList addTenantAddresses(@PathParam("guid") String guid, AddressList addresses);

    /**
     * Adds tenant properties
     *
     */
    @POST
    @Path("/tenants/{guid}/properties")
    @Consumes({ "application/vnd.softserve.tenantPropertyList+json" })
    @Produces({ "application/vnd.softserve.tenantPropertyList+json", "application/vnd.softserve.errorList+json" })
    @ApiOperation(value = "Adds tenant properties", tags={  })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "List of added tenant properties", response = TenantPropertyList.class),
        @ApiResponse(code = 400, message = "Fields validation failed", response = ErrorList.class) })
    public TenantPropertyList addTenantProperties(@PathParam("guid") String guid, TenantPropertyList properties);

    /**
     * Deletes the specific tenant
     *
     */
    @DELETE
    @Path("/tenants/{guid}")
    @ApiOperation(value = "Deletes the specific tenant", tags={  })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Successful operation") })
    public void deleteTenant(@PathParam("guid") String guid);

    /**
     * Deletes the specific tenant address
     *
     */
    @DELETE
    @Path("/tenants/{guid}/addresses/{addrguid}")
    @ApiOperation(value = "Deletes the specific tenant address", tags={  })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Successful operation") })
    public void deleteTenantAddress(@PathParam("guid") String guid, @PathParam("addrguid") String addrguid);

    /**
     * Deletes the specific tenant property
     *
     */
    @DELETE
    @Path("/tenants/{guid}/properties/{propguid}")
    @ApiOperation(value = "Deletes the specific tenant property", tags={  })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Successful operation") })
    public void deleteTenantProperty(@PathParam("guid") String guid, @PathParam("propguid") String propguid);

    /**
     * Finds the specific tenant
     *
     */
    @GET
    @Path("/tenants/{guid}")
    @Produces({ "application/vnd.softserve.tenant+json" })
    @ApiOperation(value = "Finds the specific tenant", tags={  })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "The tenant object", response = Tenant.class) })
    public Tenant getTenant(@PathParam("guid") String guid);

    /**
     * Finds specific address of the specific tenant
     *
     */
    @GET
    @Path("/tenants/{guid}/addresses/{addrguid}")
    @Produces({ "application/vnd.softserve.address+json" })
    @ApiOperation(value = "Finds specific address of the specific tenant", tags={  })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Specific tenant address", response = Address.class) })
    public Address getTenantAddress(@PathParam("guid") String guid, @PathParam("addrguid") String addrguid);

    /**
     * Finds addressess of the specific tenant
     *
     */
    @GET
    @Path("/tenants/{guid}/addresses")
    @Produces({ "application/vnd.softserve.addressList+json" })
    @ApiOperation(value = "Finds addressess of the specific tenant", tags={  })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "List of tenant addresses", response = AddressList.class) })
    public AddressList getTenantAddresses(@PathParam("guid") String guid);

    /**
     * Searches for tenants
     *
     * Finds all tenants
     *
     */
    @GET
    @Path("/tenants")
    @Produces({ "application/vnd.softserve.tenantList+json" })
    @ApiOperation(value = "Searches for tenants", tags={  })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "List of tenants", response = TenantList.class) })
    public TenantList getTenantList();

    /**
     * Finds properties of the specific tenant
     *
     */
    @GET
    @Path("/tenants/{guid}/properties")
    @Produces({ "application/vnd.softserve.tenantPropertyList+json" })
    @ApiOperation(value = "Finds properties of the specific tenant", tags={  })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "List of tenant properties", response = TenantPropertyList.class) })
    public TenantPropertyList getTenantProperties(@PathParam("guid") String guid);

    /**
     * Finds specific property of the specific tenant
     *
     */
    @GET
    @Path("/tenants/{guid}/properties/{propguid}")
    @Produces({ "application/vnd.softserve.tenantProperty+json" })
    @ApiOperation(value = "Finds specific property of the specific tenant", tags={  })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Specific tenant tenant property", response = TenantProperty.class) })
    public TenantProperty getTenantProperty(@PathParam("guid") String guid, @PathParam("propguid") String propguid);

    /**
     * Modifies the specific tenant
     *
     */
    @PUT
    @Path("/tenants/{guid}")
    @Consumes({ "application/vnd.softserve.tenant+json" })
    @Produces({ "application/vnd.softserve.tenant+json", "application/vnd.softserve.errorList+json" })
    @ApiOperation(value = "Modifies the specific tenant", tags={  })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "The modified tenant object", response = Tenant.class),
        @ApiResponse(code = 400, message = "Fields validation failed", response = ErrorList.class) })
    public Tenant modifyTenant(@PathParam("guid") String guid, Tenant tenant);

    /**
     * Modifies the specific tenant address
     *
     */
    @PUT
    @Path("/tenants/{guid}/addresses/{addrguid}")
    @Consumes({ "application/vnd.softserve.address+json" })
    @Produces({ "application/vnd.softserve.address+json", "application/vnd.softserve.errorList+json" })
    @ApiOperation(value = "Modifies the specific tenant address", tags={  })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "The modified address object", response = Address.class),
        @ApiResponse(code = 400, message = "Fields validation failed", response = ErrorList.class) })
    public Address modifyTenantAddress(@PathParam("guid") String guid, @PathParam("addrguid") String addrguid, Address address);

    /**
     * Modifies the specific tenant property
     *
     */
    @PUT
    @Path("/tenants/{guid}/properties/{propguid}")
    @Consumes({ "application/vnd.softserve.tenantProperty+json" })
    @Produces({ "application/vnd.softserve.tenantProperty+json", "application/vnd.softserve.errorList+json" })
    @ApiOperation(value = "Modifies the specific tenant property", tags={  })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "The modified tenant property object", response = TenantProperty.class),
        @ApiResponse(code = 400, message = "Fields validation failed", response = ErrorList.class) })
    public TenantProperty modifyTenantProperty(@PathParam("guid") String guid, @PathParam("propguid") String propguid, TenantProperty property);
}

