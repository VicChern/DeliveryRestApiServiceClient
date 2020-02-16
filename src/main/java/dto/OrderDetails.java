package dto;

import java.util.Objects;

public class OrderDetails {

    private String payload;

    private String imageURL;

    public OrderDetails() {
    }

    public OrderDetails(String payload, String imageUrl) {
        this.payload = payload;
        this.imageURL = imageUrl;
    }

    public String getPayload() {
        return payload;
    }

    public String getImageUrl() {
        return imageURL;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderDetails that = (OrderDetails) o;
        return Objects.equals(payload, that.payload) &&
                Objects.equals(imageURL, that.imageURL);
    }

    @Override
    public int hashCode() {
        return Objects.hash(payload, imageURL);
    }

    @Override
    public String toString() {
        return "OrderDetailsDto{" +
                "payload='" + payload + '\'' +
                ", imageURL='" + imageURL + '\'' +
                '}';
    }
}
