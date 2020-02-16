package dto;

import java.util.Objects;

public class Details {

    private String payload;

    private String imageUrl;

    public Details() {
    }

    public Details(String payload, String imageUrl) {
        this.payload = payload;
        this.imageUrl = imageUrl;
    }

    public String getPayload() {
        return payload;
    }

    public void setPayload(String payload) {
        this.payload = payload;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Details)) return false;
        Details that = (Details) o;
        return Objects.equals(payload, that.payload) &&
                Objects.equals(imageUrl, that.imageUrl);
    }

    @Override
    public int hashCode() {
        return Objects.hash(payload, imageUrl);
    }

    @Override
    public String toString() {
        return "DetailsDto{" +
                "payload='" + payload + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                '}';
    }
}
