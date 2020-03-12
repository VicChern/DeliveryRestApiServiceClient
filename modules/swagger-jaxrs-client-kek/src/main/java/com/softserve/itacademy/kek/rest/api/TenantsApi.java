package com.softserve.itacademy.kek.rest.api;

import com.softserve.itacademy.kek.rest.model.Address;
import com.softserve.itacademy.kek.rest.model.AddressList;
import com.softserve.itacademy.kek.rest.model.ResponseEntity;
import com.softserve.itacademy.kek.rest.model.Tenant;
import com.softserve.itacademy.kek.rest.model.TenantList;
import com.softserve.itacademy.kek.rest.model.TenantProperty;
import com.softserve.itacademy.kek.rest.model.TenantPropertyList;

import java.util.Map;
import javax.ws.rs.*;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.ApiResponse;

/**
 * KEK
 *
 * <p>BaaS for delivery services like Glovo, Uber or even for regular mail.
 *
 */
@Path("/")
@Api(value = "/", description = "")
public interface TenantsApi {

    /**
     * addTenantAddresses
     *
     */
    @POST
    @Path("/tenants/{guid}/addresses")
    @Consumes({ "application/vnd.softserve.address+json" })
    @Produces({ "application/vnd.softserve.address+json" })
    @ApiOperation(value = "addTenantAddresses", tags={  })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "OK", response = AddressList.class),
        @ApiResponse(code = 201, message = "Created"),
        @ApiResponse(code = 401, message = "Unauthorized"),
        @ApiResponse(code = 403, message = "Forbidden"),
        @ApiResponse(code = 404, message = "Not Found") })
    public AddressList addTenantAddresses(@PathParam("guid") String guid, AddressList newAddresses);

    /**
     * addTenantProperties
     *
     */
    @POST
    @Path("/tenants/{guid}/properties")
    @Consumes({ "application/vnd.softserve.tenantproperty+json" })
    @Produces({ "application/vnd.softserve.tenantproperty+json" })
    @ApiOperation(value = "addTenantProperties", tags={  })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "OK", response = TenantPropertyList.class),
        @ApiResponse(code = 201, message = "Created"),
        @ApiResponse(code = 401, message = "Unauthorized"),
        @ApiResponse(code = 403, message = "Forbidden"),
        @ApiResponse(code = 404, message = "Not Found") })
    public TenantPropertyList addTenantProperties(@PathParam("guid") String guid, TenantPropertyList tenantPropertiesList);

    /**
     * addTenant
     *
     */
    @POST
    @Path("/tenants")
    @Consumes({ "application/vnd.softserve.tenant+json" })
    @Produces({ "application/vnd.softserve.tenant+json" })
    @ApiOperation(value = "addTenant", tags={  })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "OK", response = Tenant.class),
        @ApiResponse(code = 201, message = "Created"),
        @ApiResponse(code = 401, message = "Unauthorized"),
        @ApiResponse(code = 403, message = "Forbidden"),
        @ApiResponse(code = 404, message = "Not Found") })
    public Tenant addTenant(Tenant tenant);

    /**
     * deleteTenantAddress
     *
     */
    @DELETE
    @Path("/tenants/{guid}/addresses/{addrguid}")
    @Produces({ "*/*" })
    @ApiOperation(value = "deleteTenantAddress", tags={  })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "OK", response = ResponseEntity.class),
        @ApiResponse(code = 204, message = "No Content"),
        @ApiResponse(code = 401, message = "Unauthorized"),
        @ApiResponse(code = 403, message = "Forbidden") })
    public void deleteTenantAddress(@PathParam("addrguid") String addrguid, @PathParam("guid") String guid);

    /**
     * deleteTenantProperty
     *
     */
    @DELETE
    @Path("/tenants/{guid}/properties/{propguid}")
    @Produces({ "*/*" })
    @ApiOperation(value = "deleteTenantProperty", tags={  })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "OK", response = ResponseEntity.class),
        @ApiResponse(code = 204, message = "No Content"),
        @ApiResponse(code = 401, message = "Unauthorized"),
        @ApiResponse(code = 403, message = "Forbidden") })
    public void deleteTenantProperty(@PathParam("guid") String guid, @PathParam("propguid") String propguid);

    /**
     * deleteTenant
     *
     */
    @DELETE
    @Path("/tenants/{guid}")
    @Produces({ "*/*" })
    @ApiOperation(value = "deleteTenant", tags={  })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "OK", response = ResponseEntity.class),
        @ApiResponse(code = 204, message = "No Content"),
        @ApiResponse(code = 401, message = "Unauthorized"),
        @ApiResponse(code = 403, message = "Forbidden") })
    public void deleteTenant(@PathParam("guid") String guid);

    /**
     * getTenantAddress
     *
     */
    @GET
    @Path("/tenants/{guid}/addresses/{addrguid}")
    @Produces({ "application/vnd.softserve.address+json" })
    @ApiOperation(value = "getTenantAddress", tags={  })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "OK", response = Address.class),
        @ApiResponse(code = 401, message = "Unauthorized"),
        @ApiResponse(code = 403, message = "Forbidden"),
        @ApiResponse(code = 404, message = "Not Found") })
    public Address getTenantAddress(@PathParam("addrguid") String addrguid, @PathParam("guid") String guid);

    /**
     * getTenantAddresses
     *
     */
    @GET
    @Path("/tenants/{guid}/addresses")
    @Produces({ "application/vnd.softserve.addresslist+json" })
    @ApiOperation(value = "getTenantAddresses", tags={  })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "OK", response = AddressList.class),
        @ApiResponse(code = 401, message = "Unauthorized"),
        @ApiResponse(code = 403, message = "Forbidden"),
        @ApiResponse(code = 404, message = "Not Found") })
    public AddressList getTenantAddresses(@PathParam("guid") String guid);

    /**
     * getTenantList
     *
     */
    @GET
    @Path("/tenants")
    @Produces({ "application/vnd.softserve.tenantlist+json" })
    @ApiOperation(value = "getTenantList", tags={  })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "OK", response = TenantList.class),
        @ApiResponse(code = 401, message = "Unauthorized"),
        @ApiResponse(code = 403, message = "Forbidden"),
        @ApiResponse(code = 404, message = "Not Found") })
    public TenantList getTenantList();

    /**
     * getTenantProperties
     *
     */
    @GET
    @Path("/tenants/{guid}/properties")
    @Produces({ "application/vnd.softserve.tenantproperty+json" })
    @ApiOperation(value = "getTenantProperties", tags={  })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "OK", response = TenantPropertyList.class),
        @ApiResponse(code = 401, message = "Unauthorized"),
        @ApiResponse(code = 403, message = "Forbidden"),
        @ApiResponse(code = 404, message = "Not Found") })
    public TenantPropertyList getTenantProperties(@PathParam("guid") String guid);

    /**
     * getTenantProperty
     *
     */
    @GET
    @Path("/tenants/{guid}/properties/{propguid}")
    @Produces({ "application/vnd.softserve.tenantproperty+json" })
    @ApiOperation(value = "getTenantProperty", tags={  })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "OK", response = TenantProperty.class),
        @ApiResponse(code = 401, message = "Unauthorized"),
        @ApiResponse(code = 403, message = "Forbidden"),
        @ApiResponse(code = 404, message = "Not Found") })
    public TenantProperty getTenantProperty(@PathParam("guid") String guid, @PathParam("propguid") String propguid);

    /**
     * getTenant
     *
     */
    @GET
    @Path("/tenants/{guid}")
    @Produces({ "application/vnd.softserve.tenant+json" })
    @ApiOperation(value = "getTenant", tags={  })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "OK", response = Tenant.class),
        @ApiResponse(code = 401, message = "Unauthorized"),
        @ApiResponse(code = 403, message = "Forbidden"),
        @ApiResponse(code = 404, message = "Not Found") })
    public Tenant getTenant(@PathParam("guid") String guid);

    /**
     * modifyTenantAddress
     *
     */
    @PUT
    @Path("/tenants/{guid}/addresses/{addrguid}")
    @Consumes({ "application/vnd.softserve.address+json" })
    @Produces({ "application/vnd.softserve.address+json" })
    @ApiOperation(value = "modifyTenantAddress", tags={  })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "OK", response = Address.class),
        @ApiResponse(code = 201, message = "Created"),
        @ApiResponse(code = 401, message = "Unauthorized"),
        @ApiResponse(code = 403, message = "Forbidden"),
        @ApiResponse(code = 404, message = "Not Found") })
    public Address modifyTenantAddress(@PathParam("addrguid") String addrguid, @PathParam("guid") String guid, Address tenantAddress);

    /**
     * modifyTenantProperty
     *
     */
    @PUT
    @Path("/tenants/{guid}/properties/{propguid}")
    @Consumes({ "application/vnd.softserve.tenantproperty+json" })
    @Produces({ "application/vnd.softserve.tenantproperty+json" })
    @ApiOperation(value = "modifyTenantProperty", tags={  })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "OK", response = TenantProperty.class),
        @ApiResponse(code = 201, message = "Created"),
        @ApiResponse(code = 401, message = "Unauthorized"),
        @ApiResponse(code = 403, message = "Forbidden"),
        @ApiResponse(code = 404, message = "Not Found") })
    public TenantProperty modifyTenantProperty(@PathParam("guid") String guid, @PathParam("propguid") String propguid, TenantProperty tenantProperties);

    /**
     * modifyTenant
     *
     */
    @PUT
    @Path("/tenants/{guid}")
    @Consumes({ "application/vnd.softserve.tenant+json" })
    @Produces({ "application/vnd.softserve.tenant+json" })
    @ApiOperation(value = "modifyTenant", tags={  })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "OK", response = Tenant.class),
        @ApiResponse(code = 201, message = "Created"),
        @ApiResponse(code = 401, message = "Unauthorized"),
        @ApiResponse(code = 403, message = "Forbidden"),
        @ApiResponse(code = 404, message = "Not Found") })
    public Tenant modifyTenant(@PathParam("guid") String guid, Tenant tenant);
}

