package com.softserve.itacademy.kek.rest.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;

public class Address {

    @ApiModelProperty(value = "")
    private String address = null;

    @ApiModelProperty(value = "")
    private String alias = null;

    @ApiModelProperty(value = "")
    private String guid = null;

    @ApiModelProperty(value = "")
    private String notes = null;

    /**
     * Convert the given object to string with each line indented by 4 spaces
     * (except the first line).
     */
    private static String toIndentedString(java.lang.Object o) {
        if (o == null) {
            return "null";
        }
        return o.toString().replace("\n", "\n    ");
    }

    /**
     * Get address
     *
     * @return address
     **/
    @JsonProperty("address")
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Address address(String address) {
        this.address = address;
        return this;
    }

    /**
     * Get alias
     *
     * @return alias
     **/
    @JsonProperty("alias")
    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public Address alias(String alias) {
        this.alias = alias;
        return this;
    }

    /**
     * Get guid
     *
     * @return guid
     **/
    @JsonProperty("guid")
    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        this.guid = guid;
    }

    public Address guid(String guid) {
        this.guid = guid;
        return this;
    }

    /**
     * Get notes
     *
     * @return notes
     **/
    @JsonProperty("notes")
    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public Address notes(String notes) {
        this.notes = notes;
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class Address {\n");

        sb.append("    address: ").append(toIndentedString(address)).append("\n");
        sb.append("    alias: ").append(toIndentedString(alias)).append("\n");
        sb.append("    guid: ").append(toIndentedString(guid)).append("\n");
        sb.append("    notes: ").append(toIndentedString(notes)).append("\n");
        sb.append("}");
        return sb.toString();
    }
}

