package com.softserve.itacademy.kek.client.utils;

import java.util.List;
import java.util.Optional;

import com.softserve.itacademy.kek.rest.model.Address;
import com.softserve.itacademy.kek.rest.model.Order;
import com.softserve.itacademy.kek.rest.model.OrderDetails;
import com.softserve.itacademy.kek.rest.model.OrderEvent;
import com.softserve.itacademy.kek.rest.model.OrderEventTypes;
import com.softserve.itacademy.kek.rest.model.Tenant;
import com.softserve.itacademy.kek.rest.model.TenantDetails;
import com.softserve.itacademy.kek.rest.model.User;
import com.softserve.itacademy.kek.rest.model.UserDetails;

public class ModelUtils {
    public static User getUserWithName(String name) {
        User user = new User();
        user.setName(Optional.ofNullable(name).orElse("John"));
        user.setGuid("a8660eff-14d0-4ac0-86f4-12544c5b8a75");
        user.setEmail("julia@gmail.com");
        user.setNickname("julia1");
        user.setPhone("982-223-42-44");
        UserDetails userDetails = new UserDetails();
        userDetails.setImageURL("http://anyimage.com");
        userDetails.setPayload("avatar_image");
        user.setDetails(userDetails);
        return user;
    }

    public static List<Address> getAddresses() {
        return List.of(getAddress(), getAddress());
    }

    public static Address getAddress() {
        Address address = new Address();
        address.setGuid("a8660eff-14d0-4ac0-86f4-12544c5b8a75");
        address.setAddress("New York, 1");
        address.setAlias("NY");
        address.setNotes("just for bf");
        return address;
    }

    public static Tenant getTenantFor(User user) {
        Tenant tenant = new Tenant();
        tenant.setOwner(user.getGuid());
        tenant.setGuid("a8660eff-14d0-4ac0-86f4-1254unique");
        tenant.setName("Deliver tenant");
        tenant.setDetails(getTenantDetails());
        return tenant;
    }

    public static TenantDetails getTenantDetails() {
        return new TenantDetails();
    }

    public static OrderDetails getOrderDetails() {
        return new OrderDetails();
    }


    public static Order getOrderFor(User customer, Tenant tenant) {
        Order order = new Order();
        order.setGuid(customer.getGuid());
        order.setSummary("Summary message");
        order.setDetails(getOrderDetails());
        order.setTenant(tenant.getGuid());
        order.setUser(customer.getGuid());
        return order;
    }

    public static OrderEvent getOrderEventFor(OrderEventTypes type) {
        OrderEvent orderEvent = new OrderEvent();
        orderEvent.setPayload("some msg");
        orderEvent.setType(type);
        return orderEvent;
    }

    public static User getUser() {
        return getUserWithName(null);
    }
}
