package com.softserve.itacademy.kek.rest.api;

import com.softserve.itacademy.kek.rest.model.Address;
import com.softserve.itacademy.kek.rest.model.Tenant;
import com.softserve.itacademy.kek.rest.model.TenantProperty;

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
public interface TenantsApi  {

    /**
     * Creates a new tenant
     *
     */
    @POST
    @Path("/tenants")
    @Consumes({ "application/vnd.softserve.tenant+json" })
    @Produces({ "application/vnd.softserve.tenant+json" })
    @ApiOperation(value = "Creates a new tenant", tags={  })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "The newly created tenant object", response = Tenant.class) })
    public Tenant addTenant(Tenant tenant);

    /**
     * Adds a new addresses
     *
     */
    @POST
    @Path("/tenants/{guid}/addresses")
    @Consumes({ "application/vnd.softserve.address+json" })
    @Produces({ "application/vnd.softserve.address+json" })
    @ApiOperation(value = "Adds a new addresses", tags={  })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "List of added tenant addresses", response = Address.class, responseContainer = "List") })
    public List<Address> addTenantAddresses(@PathParam("guid") String guid, List<Address> addresses);

    /**
     * Adds tenant properties
     *
     */
    @POST
    @Path("/tenants/{guid}/properties")
    @Consumes({ "application/vnd.softserve.tenantproperty+json" })
    @Produces({ "application/vnd.softserve.tenantproperty+json" })
    @ApiOperation(value = "Adds tenant properties", tags={  })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "List of added tenant properties", response = TenantProperty.class, responseContainer = "List") })
    public List<TenantProperty> addTenantProperties(@PathParam("guid") String guid, List<TenantProperty> properties);

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
    @Produces({ "application/vnd.softserve.address+json" })
    @ApiOperation(value = "Finds addressess of the specific tenant", tags={  })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "List of tenant addresses", response = Address.class, responseContainer = "List") })
    public List<Address> getTenantAddresses(@PathParam("guid") String guid);

    /**
     * Searches for tenants
     *
     * Finds all tenants
     *
     */
    @GET
    @Path("/tenants")
    @Produces({ "application/vnd.softserve.tenant+json" })
    @ApiOperation(value = "Searches for tenants", tags={  })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "List of tenants", response = Tenant.class, responseContainer = "List") })
    public List<Tenant> getTenantList();

    /**
     * Finds properties of the specific tenant
     *
     */
    @GET
    @Path("/tenants/{guid}/properties")
    @Produces({ "application/vnd.softserve.tenantproperty+json" })
    @ApiOperation(value = "Finds properties of the specific tenant", tags={  })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "List of tenant properties", response = TenantProperty.class, responseContainer = "List") })
    public List<TenantProperty> getTenantProperties(@PathParam("guid") String guid);

    /**
     * Finds specific property of the specific tenant
     *
     */
    @GET
    @Path("/tenants/{guid}/properties/{propguid}")
    @Produces({ "application/vnd.softserve.tenantproperty+json" })
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
    @Produces({ "application/vnd.softserve.tenant+json" })
    @ApiOperation(value = "Modifies the specific tenant", tags={  })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "The modified tenant object", response = Tenant.class) })
    public Tenant modifyTenant(@PathParam("guid") String guid, Tenant tenant);

    /**
     * Modifies the specific tenant address
     *
     */
    @PUT
    @Path("/tenants/{guid}/addresses/{addrguid}")
    @Consumes({ "application/vnd.softserve.address+json" })
    @Produces({ "application/vnd.softserve.address+json" })
    @ApiOperation(value = "Modifies the specific tenant address", tags={  })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "The modified address object", response = Address.class) })
    public Address modifyTenantAddress(@PathParam("guid") String guid, @PathParam("addrguid") String addrguid, Address address);

    /**
     * Modifies the specific tenant property
     *
     */
    @PUT
    @Path("/tenants/{guid}/properties/{propguid}")
    @Consumes({ "application/vnd.softserve.tenantproperty+json" })
    @Produces({ "application/vnd.softserve.tenantproperty+json" })
    @ApiOperation(value = "Modifies the specific tenant property", tags={  })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "The modified tenant property object", response = TenantProperty.class) })
    public TenantProperty modifyTenantProperty(@PathParam("guid") String guid, @PathParam("propguid") String propguid, TenantProperty property);
}

