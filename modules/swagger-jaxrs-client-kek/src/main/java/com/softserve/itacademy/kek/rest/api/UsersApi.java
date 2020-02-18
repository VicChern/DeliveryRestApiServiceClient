package com.softserve.itacademy.kek.rest.api;

import com.softserve.itacademy.kek.rest.model.Address;
import com.softserve.itacademy.kek.rest.model.User;

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
public interface UsersApi  {

    /**
     * Creates a new user
     *
     */
    @POST
    @Path("/users")
    @Consumes({ "application/vnd.softserve.user+json" })
    @Produces({ "application/vnd.softserve.user+json" })
    @ApiOperation(value = "Creates a new user", tags={  })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "The newly created user object", response = User.class) })
    public User addUser(User user);

    /**
     * Adds a new addresses
     *
     */
    @POST
    @Path("/users/{guid}/addresses")
    @Consumes({ "application/vnd.softserve.address+json" })
    @Produces({ "application/vnd.softserve.address+json" })
    @ApiOperation(value = "Adds a new addresses", tags={  })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "List of added user addresses", response = Address.class, responseContainer = "List") })
    public List<Address> addUserAddresses(@PathParam("guid") String guid, List<Address> addresses);

    /**
     * Deletes the specific user
     *
     */
    @DELETE
    @Path("/users/{guid}")
    @ApiOperation(value = "Deletes the specific user", tags={  })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Successful operation") })
    public void deleteUser(@PathParam("guid") String guid);

    /**
     * Deletes the specific user address
     *
     */
    @DELETE
    @Path("/users/{guid}/addresses/{addrguid}")
    @ApiOperation(value = "Deletes the specific user address", tags={  })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Successful operation") })
    public void deleteUserAddress(@PathParam("guid") String guid, @PathParam("addrguid") String addrguid);

    /**
     * Finds the specific user
     *
     */
    @GET
    @Path("/users/{guid}")
    @Produces({ "application/vnd.softserve.user+json" })
    @ApiOperation(value = "Finds the specific user", tags={  })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "The user object", response = User.class) })
    public User getUser(@PathParam("guid") String guid);

    /**
     * Finds addressess of the specific user
     *
     */
    @GET
    @Path("/users/{guid}/addresses/{addrguid}")
    @Produces({ "application/vnd.softserve.address+json" })
    @ApiOperation(value = "Finds addressess of the specific user", tags={  })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Specific user address", response = Address.class) })
    public Address getUserAddress(@PathParam("guid") String guid, @PathParam("addrguid") String addrguid);

    /**
     * Finds addressess of the specific user
     *
     */
    @GET
    @Path("/users/{guid}/addresses")
    @Produces({ "application/vnd.softserve.address+json" })
    @ApiOperation(value = "Finds addressess of the specific user", tags={  })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "List of user addresses", response = Address.class, responseContainer = "List") })
    public List<Address> getUserAddresses(@PathParam("guid") String guid);

    /**
     * Searches for users
     *
     * Finds all users
     *
     */
    @GET
    @Path("/users")
    @Produces({ "application/vnd.softserve.user+json" })
    @ApiOperation(value = "Searches for users", tags={  })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "List of users", response = User.class, responseContainer = "List") })
    public List<User> getUserList();

    /**
     * Modifies the specific user
     *
     */
    @PUT
    @Path("/users/{guid}")
    @Consumes({ "application/vnd.softserve.user+json" })
    @Produces({ "application/vnd.softserve.user+json" })
    @ApiOperation(value = "Modifies the specific user", tags={  })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "The modified user object", response = User.class) })
    public User modifyUser(@PathParam("guid") String guid, User user);

    /**
     * Modifies the specific user address
     *
     */
    @PUT
    @Path("/users/{guid}/addresses/{addrguid}")
    @Consumes({ "application/vnd.softserve.address+json" })
    @Produces({ "application/vnd.softserve.address+json" })
    @ApiOperation(value = "Modifies the specific user address", tags={  })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "The modified address object", response = Address.class) })
    public Address modifyUserAddress(@PathParam("guid") String guid, @PathParam("addrguid") String addrguid, Address address);
}

