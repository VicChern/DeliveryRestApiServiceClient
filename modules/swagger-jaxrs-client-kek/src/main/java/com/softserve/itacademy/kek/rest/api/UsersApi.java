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
import com.softserve.itacademy.kek.rest.model.User;
import com.softserve.itacademy.kek.rest.model.UserList;

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
    @Produces({ "application/vnd.softserve.user+json", "application/vnd.softserve.errorList+json" })
    @ApiOperation(value = "Creates a new user", tags={  })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "The newly created user object", response = User.class),
        @ApiResponse(code = 400, message = "Fields validation failed", response = ErrorList.class) })
    public User addUser(User user);

    /**
     * Adds a new addresses
     *
     */
    @POST
    @Path("/users/{guid}/addresses")
    @Consumes({ "application/vnd.softserve.addressList+json" })
    @Produces({ "application/vnd.softserve.addressList+json", "application/vnd.softserve.errorList+json" })
    @ApiOperation(value = "Adds a new addresses", tags={  })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "List of added user addresses", response = AddressList.class),
        @ApiResponse(code = 400, message = "Fields validation failed", response = ErrorList.class) })
    public AddressList addUserAddresses(@PathParam("guid") String guid, AddressList addresses);

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
    @Produces({ "application/vnd.softserve.addressList+json" })
    @ApiOperation(value = "Finds addressess of the specific user", tags={  })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "List of user addresses", response = AddressList.class) })
    public AddressList getUserAddresses(@PathParam("guid") String guid);

    /**
     * Searches for users
     *
     * Finds all users
     *
     */
    @GET
    @Path("/users")
    @Produces({ "application/vnd.softserve.userList+json" })
    @ApiOperation(value = "Searches for users", tags={  })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "List of users", response = UserList.class) })
    public UserList getUserList();

    /**
     * Modifies the specific user
     *
     */
    @PUT
    @Path("/users/{guid}")
    @Consumes({ "application/vnd.softserve.user+json" })
    @Produces({ "application/vnd.softserve.user+json", "application/vnd.softserve.errorList+json" })
    @ApiOperation(value = "Modifies the specific user", tags={  })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "The modified user object", response = User.class),
        @ApiResponse(code = 400, message = "Fields validation failed", response = ErrorList.class) })
    public User modifyUser(@PathParam("guid") String guid, User user);

    /**
     * Modifies the specific user address
     *
     */
    @PUT
    @Path("/users/{guid}/addresses/{addrguid}")
    @Consumes({ "application/vnd.softserve.address+json" })
    @Produces({ "application/vnd.softserve.address+json", "application/vnd.softserve.errorList+json" })
    @ApiOperation(value = "Modifies the specific user address", tags={  })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "The modified address object", response = Address.class),
        @ApiResponse(code = 400, message = "Fields validation failed", response = ErrorList.class) })
    public Address modifyUserAddress(@PathParam("guid") String guid, @PathParam("addrguid") String addrguid, Address address);
}

