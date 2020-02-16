package dto;


import java.util.Objects;

public class Order {

    private String tenant;

    private String user;

    private String guid;

    private String summary;

    private OrderDetails details;

    public Order() {
    }

    public Order(String tenant, String user, String guid, String summary, OrderDetails details) {
        this.tenant = tenant;
        this.user = user;
        this.guid = guid;
        this.summary = summary;
        this.details = details;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getTenant() {
        return tenant;
    }

    public void setTenant(String tenant) {
        this.tenant = tenant;
    }

    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        this.guid = guid;
    }

    public OrderDetails getDetails() {
        return details;
    }

    public void setDetails(OrderDetails details) {
        this.details = details;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order orderDto = (Order) o;
        return Objects.equals(tenant, orderDto.tenant) &&
                Objects.equals(guid, orderDto.guid) &&
                Objects.equals(details, orderDto.details);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tenant, guid, details);
    }

    @Override
    public String toString() {
        return "OrderDto{" +
                "tenant='" + tenant + '\'' +
                ", guid='" + guid + '\'' +
                ", details=" + details +
                '}';
    }
}
