package utils;

import java.util.List;

import dto.Address;
import dto.AddressesList;
import dto.Details;
import dto.Order;
import dto.OrderDetails;
import dto.Tenant;
import dto.TenantDetails;
import dto.User;
//TODO::Refactor to generic
//TODO::Builder

public class DtoUtils {
    //TODO:: Make unique fields Random creation
    public static User getUser() {
        User user = new User();
        user.setName("Julia");
        user.setGuid("a8660eff-14d0-4ac0-86f4-12544c5b8a75");
        user.setEmail("julia@gmail.com");
        user.setNickname("julia1");
        user.setPhone("982-223-42-44");
        Details userDetails = new Details();
        userDetails.setImageUrl("image.com");
        userDetails.setPayload("avatar_image");
        user.setDetails(userDetails);
        return user;
    }

    public static AddressesList getAddresses() {
        List<Address> addresses = List.of(getAddress(), getAddress());
        AddressesList addressesList = new AddressesList();
        addressesList.setAddresses(addresses);
        return addressesList;
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
        order.setGuid("a8660eff-14d0-4ac0-86f4-1254any");
        order.setSummary("Summary message");
        order.setDetails(getOrderDetails());
        order.setTenant(tenant.getGuid());
        order.setUser(customer.getGuid());
        return order;
    }
}
