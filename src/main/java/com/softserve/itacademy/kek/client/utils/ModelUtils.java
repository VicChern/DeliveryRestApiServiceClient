package com.softserve.itacademy.kek.client.utils;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.apache.commons.lang3.RandomStringUtils;

import com.softserve.itacademy.kek.rest.model.Address;
import com.softserve.itacademy.kek.rest.model.AddressList;
import com.softserve.itacademy.kek.rest.model.Order;
import com.softserve.itacademy.kek.rest.model.OrderDetails;
import com.softserve.itacademy.kek.rest.model.OrderEvent;
import com.softserve.itacademy.kek.rest.model.OrderEventTypes;
import com.softserve.itacademy.kek.rest.model.OrderList;
import com.softserve.itacademy.kek.rest.model.Tenant;
import com.softserve.itacademy.kek.rest.model.TenantDetails;
import com.softserve.itacademy.kek.rest.model.User;
import com.softserve.itacademy.kek.rest.model.UserDetails;


public class ModelUtils {
    public static User getUserWithName(String name) {
        User user = new User();
        user.setName(Optional.ofNullable(name).orElse(RandomStringUtils.randomAlphabetic(5)));
        user.setEmail(RandomStringUtils.randomAlphabetic(8)+ "@gmail.com");
        user.setNickname(RandomStringUtils.randomAlphabetic(7));
        user.setPhone(RandomStringUtils.randomNumeric(10));
        UserDetails userDetails = new UserDetails();
        userDetails.setImageURL("http://anyimage.com");
        userDetails.setPayload("avatar_image");
        user.setDetails(userDetails);
        return user;
    }

    public static AddressList getAddresses() {
        AddressList addressList = new AddressList();
        addressList.setAddressList(List.of(getAddress(), getAddress()));
        return addressList;
    }

    public static Address getAddress() {
        Address address = new Address();
        address.setAddress("New York, 1");
        address.setAlias(RandomStringUtils.randomAlphabetic(7));
        address.setNotes("just for bf");
        return address;
    }

    public static Tenant getTenantFor(User user) {
        Tenant tenant = new Tenant();
        tenant.setOwner(user.getGuid());
        tenant.setName("Deliver tenant" + RandomStringUtils.randomAlphabetic(3));
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
//        order.setGuid(customer.getGuid());
        order.setTenant(tenant.getGuid());
//        order.setUser(customer.getGuid());
        order.setSummary("Summary message");
        order.setDetails(getOrderDetails());
        order.setTenant(tenant.getGuid());
        return order;
    }

    public static OrderList getSingletonOrderList(Order order) {
        OrderList orderList = new OrderList();
        orderList.setOrderList(Collections.singletonList(order));
        return orderList;
    }

    public static OrderEvent getOrderEventFor(OrderEventTypes typeEnum) {
        OrderEvent orderEvent = new OrderEvent();
//        orderEvent.setGuid(String.valueOf(UUID.randomUUID()));
        orderEvent.setPayload("lat: 54.123, lng:52.456");
        orderEvent.setType(typeEnum);
        return orderEvent;
    }

    public static OrderEvent getOrderEventForOrder(Order order, OrderEventTypes typeEnum) {
        OrderEvent orderEvent = new OrderEvent();
        orderEvent.setOrder(order);
//        orderEvent.setGuid(String.valueOf(UUID.randomUUID()));
        orderEvent.setPayload("lat: 54.123, lng:52.456");
        orderEvent.setType(typeEnum);
        return orderEvent;
    }

    public static User getUser() {
        return getUserWithName(null);
    }
}
