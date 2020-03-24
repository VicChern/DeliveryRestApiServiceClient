package com.softserve.itacademy.kek.rest.old.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;

public class Tenant {

    @ApiModelProperty(value = "")
    private String guid = null;

    @ApiModelProperty(value = "tenant owner ID")
    /**
     * tenant owner ID
     **/
    private String owner = null;

    @ApiModelProperty(value = "")
    private String name = null;

    @ApiModelProperty(value = "")
    private TenantDetails details = null;

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

    public Tenant guid(String guid) {
        this.guid = guid;
        return this;
    }

    /**
     * tenant owner ID
     *
     * @return owner
     **/
    @JsonProperty("owner")
    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public Tenant owner(String owner) {
        this.owner = owner;
        return this;
    }

    /**
     * Get name
     *
     * @return name
     **/
    @JsonProperty("name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Tenant name(String name) {
        this.name = name;
        return this;
    }

    /**
     * Get details
     *
     * @return details
     **/
    @JsonProperty("details")
    public TenantDetails getDetails() {
        return details;
    }

    public void setDetails(TenantDetails details) {
        this.details = details;
    }

    public Tenant details(TenantDetails details) {
        this.details = details;
        return this;
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class Tenant {\n");

        sb.append("    guid: ").append(toIndentedString(guid)).append("\n");
        sb.append("    owner: ").append(toIndentedString(owner)).append("\n");
        sb.append("    name: ").append(toIndentedString(name)).append("\n");
        sb.append("    details: ").append(toIndentedString(details)).append("\n");
        sb.append("}");
        return sb.toString();
    }

    /**
     * Convert the given object to string with each line indented by 4 spaces
     * (except the first line).
     */
    private static String toIndentedString(Object o) {
        if (o == null) {
            return "null";
        }
        return o.toString().replace("\n", "\n    ");
    }
}

