package com.softserve.itacademy.kek.rest.model;

import io.swagger.annotations.ApiModelProperty;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Order  {

    @ApiModelProperty(value = "tenant id")
    /**
     * tenant id
     **/
    private String tenant = null;

    @ApiModelProperty(value = "")
    private String guid = null;

    @ApiModelProperty(value = "")
    private String summary = null;

    @ApiModelProperty(value = "")
    private OrderDetails details = null;
    /**
     * tenant id
     * @return tenant
     **/
    @JsonProperty("tenant")
    public String getTenant() {
        return tenant;
    }

    public void setTenant(String tenant) {
        this.tenant = tenant;
    }

    public Order tenant(String tenant) {
        this.tenant = tenant;
        return this;
    }

    /**
     * Get guid
     * @return guid
     **/
    @JsonProperty("guid")
    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        this.guid = guid;
    }

    public Order guid(String guid) {
        this.guid = guid;
        return this;
    }

    /**
     * Get summary
     * @return summary
     **/
    @JsonProperty("summary")
    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public Order summary(String summary) {
        this.summary = summary;
        return this;
    }

    /**
     * Get details
     * @return details
     **/
    @JsonProperty("details")
    public OrderDetails getDetails() {
        return details;
    }

    public void setDetails(OrderDetails details) {
        this.details = details;
    }

    public Order details(OrderDetails details) {
        this.details = details;
        return this;
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class Order {\n");

        sb.append("    tenant: ").append(toIndentedString(tenant)).append("\n");
        sb.append("    guid: ").append(toIndentedString(guid)).append("\n");
        sb.append("    summary: ").append(toIndentedString(summary)).append("\n");
        sb.append("    details: ").append(toIndentedString(details)).append("\n");
        sb.append("}");
        return sb.toString();
    }

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
}

