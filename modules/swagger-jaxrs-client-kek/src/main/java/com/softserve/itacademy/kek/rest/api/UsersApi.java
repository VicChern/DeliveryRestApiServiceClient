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
import com.softserve.itacademy.kek.rest.model.ListWrapperDto;
import com.softserve.itacademy.kek.rest.model.ResponseEntity;
import com.softserve.itacademy.kek.rest.model.User;

/**
 * KEK
 *
 * <p>BaaS for delivery services like Glovo, Uber or even for regular mail.
 */
@Path("/")
@Api(value = "/", description = "")
public interface UsersApi {

    /**
     * addUserAddresses
     */
    @POST
    @Path("/users/{guid}/addresses")
    @Consumes({"application/vnd.softserve.addressList+json"})
    @Produces({"application/vnd.softserve.addressList+json"})
    @ApiOperation(value = "addUserAddresses", tags = {})
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK", response = ListWrapperDto.class),
            @ApiResponse(code = 201, message = "Created"),
            @ApiResponse(code = 401, message = "Unauthorized"),
            @ApiResponse(code = 403, message = "Forbidden"),
            @ApiResponse(code = 404, message = "Not Found")})
    ListWrapperDto<Address> addUserAddresses(@PathParam("guid") String guid, ListWrapperDto<Address> newAddresses);

    /**
     * addUser
     */
    @POST
    @Path("/users")
    @Consumes({"application/vnd.softserve.user+json"})
    @Produces({"application/vnd.softserve.user+json"})
    @ApiOperation(value = "addUser", tags = {})
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK", response = User.class),
            @ApiResponse(code = 201, message = "Created"),
            @ApiResponse(code = 401, message = "Unauthorized"),
            @ApiResponse(code = 403, message = "Forbidden"),
            @ApiResponse(code = 404, message = "Not Found")})
    User addUser(User newUser);

    /**
     * deleteUserAddress
     */
    @DELETE
    @Path("/users/{guid}/addresses/{addrguid}")
    @Produces({"*/*"})
    @ApiOperation(value = "deleteUserAddress", tags = {})
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK", response = ResponseEntity.class),
            @ApiResponse(code = 204, message = "No Content"),
            @ApiResponse(code = 401, message = "Unauthorized"),
            @ApiResponse(code = 403, message = "Forbidden")})
    void deleteUserAddress(@PathParam("addrguid") String addrguid, @PathParam("guid") String guid);

    /**
     * deleteUser
     */
    @DELETE
    @Path("/users/{guid}")
    @Produces({"*/*"})
    @ApiOperation(value = "deleteUser", tags = {})
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK", response = ResponseEntity.class),
            @ApiResponse(code = 204, message = "No Content"),
            @ApiResponse(code = 401, message = "Unauthorized"),
            @ApiResponse(code = 403, message = "Forbidden")})
    void deleteUser(@PathParam("guid") String guid);

    /**
     * getUserAddress
     */
    @GET
    @Path("/users/{guid}/addresses/{addrguid}")
    @Produces({"application/vnd.softserve.address+json"})
    @ApiOperation(value = "getUserAddress", tags = {})
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK", response = Address.class),
            @ApiResponse(code = 401, message = "Unauthorized"),
            @ApiResponse(code = 403, message = "Forbidden"),
            @ApiResponse(code = 404, message = "Not Found")})
    Address getUserAddress(@PathParam("addrguid") String addrguid, @PathParam("guid") String guid);

    /**
     * getUserAddresses
     */
    @GET
    @Path("/users/{guid}/addresses")
    @Produces({"application/vnd.softserve.addressList+json"})
    @ApiOperation(value = "getUserAddresses", tags = {})
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK", response = ListWrapperDto.class),
            @ApiResponse(code = 401, message = "Unauthorized"),
            @ApiResponse(code = 403, message = "Forbidden"),
            @ApiResponse(code = 404, message = "Not Found")})
    ListWrapperDto<Address> getUserAddresses(@PathParam("guid") String guid);

    /**
     * getUserList
     */
    @GET
    @Path("/users")
    @Produces({"application/vnd.softserve.userlist+json"})
    @ApiOperation(value = "getUserList", tags = {})
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK", response = ListWrapperDto.class),
            @ApiResponse(code = 401, message = "Unauthorized"),
            @ApiResponse(code = 403, message = "Forbidden"),
            @ApiResponse(code = 404, message = "Not Found")})
    ListWrapperDto<User> getUserList();

    /**
     * getUser
     */
    @GET
    @Path("/users/{guid}")
    @Produces({"application/vnd.softserve.user+json"})
    @ApiOperation(value = "getUser", tags = {})
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK", response = User.class),
            @ApiResponse(code = 401, message = "Unauthorized"),
            @ApiResponse(code = 403, message = "Forbidden"),
            @ApiResponse(code = 404, message = "Not Found")})
    User getUser(@PathParam("guid") String guid);

    /**
     * modifyUserAddress
     */
    @PUT
    @Path("/users/{guid}/addresses/{addrguid}")
    @Consumes({"application/vnd.softserve.address+json"})
    @Produces({"application/vnd.softserve.address+json"})
    @ApiOperation(value = "modifyUserAddress", tags = {})
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK", response = Address.class),
            @ApiResponse(code = 201, message = "Created"),
            @ApiResponse(code = 401, message = "Unauthorized"),
            @ApiResponse(code = 403, message = "Forbidden"),
            @ApiResponse(code = 404, message = "Not Found")})
    Address modifyUserAddress(Address address, @PathParam("addrguid") String addrguid, @PathParam("guid") String guid);

    /**
     * modifyUser
     */
    @PUT
    @Path("/users/{guid}")
    @Consumes({"application/vnd.softserve.user+json"})
    @Produces({"application/vnd.softserve.user+json"})
    @ApiOperation(value = "modifyUser", tags = {})
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK", response = User.class),
            @ApiResponse(code = 201, message = "Created"),
            @ApiResponse(code = 401, message = "Unauthorized"),
            @ApiResponse(code = 403, message = "Forbidden"),
            @ApiResponse(code = 404, message = "Not Found")})
    User modifyUser(@PathParam("guid") String guid, User user);
}

