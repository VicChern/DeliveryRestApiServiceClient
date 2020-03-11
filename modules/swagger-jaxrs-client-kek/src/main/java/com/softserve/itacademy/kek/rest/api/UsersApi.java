package com.softserve.itacademy.kek.rest.api;

import com.softserve.itacademy.kek.rest.model.Address;
import com.softserve.itacademy.kek.rest.model.AddressList;
import com.softserve.itacademy.kek.rest.model.ResponseEntity;
import com.softserve.itacademy.kek.rest.model.User;
import com.softserve.itacademy.kek.rest.model.UserList;

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
public interface UsersApi {

    /**
     * addUserAddresses
     *
     */
    @POST
    @Path("/users/{guid}/addresses")
    @Consumes({ "application/vnd.softserve.addresslist+json" })
    @Produces({ "application/vnd.softserve.addresslist+json" })
    @ApiOperation(value = "addUserAddresses", tags={  })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "OK", response = AddressList.class),
        @ApiResponse(code = 201, message = "Created"),
        @ApiResponse(code = 401, message = "Unauthorized"),
        @ApiResponse(code = 403, message = "Forbidden"),
        @ApiResponse(code = 404, message = "Not Found") })
    public AddressList addUserAddresses(@PathParam("guid") String guid, AddressList newAddresses);

    /**
     * addUser
     *
     */
    @POST
    @Path("/users")
    @Consumes({ "application/vnd.softserve.user+json" })
    @Produces({ "application/vnd.softserve.user+json" })
    @ApiOperation(value = "addUser", tags={  })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "OK", response = User.class),
        @ApiResponse(code = 201, message = "Created"),
        @ApiResponse(code = 401, message = "Unauthorized"),
        @ApiResponse(code = 403, message = "Forbidden"),
        @ApiResponse(code = 404, message = "Not Found") })
    public User addUser(User newUser);

    /**
     * deleteUserAddress
     *
     */
    @DELETE
    @Path("/users/{guid}/addresses/{addrguid}")
    @Produces({ "*/*" })
    @ApiOperation(value = "deleteUserAddress", tags={  })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "OK", response = ResponseEntity.class),
        @ApiResponse(code = 204, message = "No Content"),
        @ApiResponse(code = 401, message = "Unauthorized"),
        @ApiResponse(code = 403, message = "Forbidden") })
    public ResponseEntity deleteUserAddress(@PathParam("addrguid") String addrguid, @PathParam("guid") String guid);

    /**
     * deleteUser
     *
     */
    @DELETE
    @Path("/users/{guid}")
    @Produces({ "*/*" })
    @ApiOperation(value = "deleteUser", tags={  })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "OK", response = ResponseEntity.class),
        @ApiResponse(code = 204, message = "No Content"),
        @ApiResponse(code = 401, message = "Unauthorized"),
        @ApiResponse(code = 403, message = "Forbidden") })
    public ResponseEntity deleteUser(@PathParam("guid") String guid);

    /**
     * getUserAddress
     *
     */
    @GET
    @Path("/users/{guid}/addresses/{addrguid}")
    @Produces({ "application/vnd.softserve.address+json" })
    @ApiOperation(value = "getUserAddress", tags={  })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "OK", response = Address.class),
        @ApiResponse(code = 401, message = "Unauthorized"),
        @ApiResponse(code = 403, message = "Forbidden"),
        @ApiResponse(code = 404, message = "Not Found") })
    public Address getUserAddress(@PathParam("addrguid") String addrguid, @PathParam("guid") String guid);

    /**
     * getUserAddresses
     *
     */
    @GET
    @Path("/users/{guid}/addresses")
    @Produces({ "application/vnd.softserve.addresslist+json" })
    @ApiOperation(value = "getUserAddresses", tags={  })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "OK", response = AddressList.class),
        @ApiResponse(code = 401, message = "Unauthorized"),
        @ApiResponse(code = 403, message = "Forbidden"),
        @ApiResponse(code = 404, message = "Not Found") })
    public AddressList getUserAddresses(@PathParam("guid") String guid);

    /**
     * getUserList
     *
     */
    @GET
    @Path("/users")
    @Produces({ "application/vnd.softserve.userlist+json" })
    @ApiOperation(value = "getUserList", tags={  })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "OK", response = UserList.class),
        @ApiResponse(code = 401, message = "Unauthorized"),
        @ApiResponse(code = 403, message = "Forbidden"),
        @ApiResponse(code = 404, message = "Not Found") })
    public UserList getUserList();

    /**
     * getUser
     *
     */
    @GET
    @Path("/users/{guid}")
    @Produces({ "application/vnd.softserve.user+json" })
    @ApiOperation(value = "getUser", tags={  })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "OK", response = User.class),
        @ApiResponse(code = 401, message = "Unauthorized"),
        @ApiResponse(code = 403, message = "Forbidden"),
        @ApiResponse(code = 404, message = "Not Found") })
    public User getUser(@PathParam("guid") String guid);

    /**
     * modifyUserAddress
     *
     */
    @PUT
    @Path("/users/{guid}/addresses/{addrguid}")
    @Consumes({ "application/vnd.softserve.address+json" })
    @Produces({ "application/vnd.softserve.address+json" })
    @ApiOperation(value = "modifyUserAddress", tags={  })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "OK", response = Address.class),
        @ApiResponse(code = 201, message = "Created"),
        @ApiResponse(code = 401, message = "Unauthorized"),
        @ApiResponse(code = 403, message = "Forbidden"),
        @ApiResponse(code = 404, message = "Not Found") })
    public Address modifyUserAddress(Address address, @PathParam("addrguid") String addrguid, @PathParam("guid") String guid);

    /**
     * modifyUser
     *
     */
    @PUT
    @Path("/users/{guid}")
    @Consumes({ "application/vnd.softserve.user+json" })
    @Produces({ "application/vnd.softserve.user+json" })
    @ApiOperation(value = "modifyUser", tags={  })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "OK", response = User.class),
        @ApiResponse(code = 201, message = "Created"),
        @ApiResponse(code = 401, message = "Unauthorized"),
        @ApiResponse(code = 403, message = "Forbidden"),
        @ApiResponse(code = 404, message = "Not Found") })
    public User modifyUser(@PathParam("guid") String guid, User user);
}

