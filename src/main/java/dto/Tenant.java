package dto;

import java.util.Objects;

public class Tenant {

    private String guid;
    private String owner;

    private String name;
    private TenantDetails details;

    public Tenant() {
    }

    public Tenant(String guid, String owner, String name, TenantDetails details) {
        this.guid = guid;
        this.owner = owner;
        this.name = name;
        this.details = details;
    }

    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        this.guid = guid;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public TenantDetails getDetails() {
        return details;
    }

    public void setDetails(TenantDetails details) {
        this.details = details;
    }

    @Override
    public String toString() {
        return "TenantDto{" +
                "guid='" + guid + '\'' +
                ", owner='" + owner + '\'' +
                ", name='" + name + '\'' +
                ", details=" + details +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Tenant)) return false;
        Tenant tenantDto = (Tenant) o;
        return guid.equals(tenantDto.guid) &&
                owner.equals(tenantDto.owner) &&
                name.equals(tenantDto.name) &&
                details.equals(tenantDto.details);
    }

    @Override
    public int hashCode() {
        return Objects.hash(guid, owner, name, details);
    }
}
