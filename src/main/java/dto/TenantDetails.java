package dto;

import java.util.Objects;

public class TenantDetails {

    private String payload;

    private String imageUrl;

    public TenantDetails() {
    }

    public TenantDetails(String payload, String imageUrl) {
        this.payload = payload;
        this.imageUrl = imageUrl;
    }

    public String getPayload() {
        return payload;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    @Override
    public String toString() {
        return "TenantDetailsDto{" +
                "payload='" + payload + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TenantDetails)) return false;
        TenantDetails that = (TenantDetails) o;
        return payload.equals(that.payload) &&
                imageUrl.equals(that.imageUrl);
    }

    @Override
    public int hashCode() {
        return Objects.hash(payload, imageUrl);
    }
}
