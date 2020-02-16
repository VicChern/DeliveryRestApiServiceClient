package dto;

import java.util.Objects;

public class Address {

    private String guid;

    private String alias;

    private String address;

    private String notes;

    public Address() {
    }

    public Address(String guid, String alias, String address, String notes) {
        this.guid = guid;
        this.alias = alias;
        this.address = address;
        this.notes = notes;
    }

    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        this.guid = guid;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Address)) return false;
        Address that = (Address) o;
        return Objects.equals(guid, that.guid) &&
                Objects.equals(alias, that.alias) &&
                Objects.equals(address, that.address) &&
                Objects.equals(notes, that.notes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(guid, alias, address, notes);
    }

    @Override
    public String toString() {
        return "AddressDto{" +
                "guid='" + guid + '\'' +
                ", alias='" + alias + '\'' +
                ", address='" + address + '\'' +
                ", notes='" + notes + '\'' +
                '}';
    }
}
