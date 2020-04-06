package com.softserve.itacademy.kek.rest.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;

public class ITenantProperties {

    @ApiModelProperty(value = "")
    private String guid = null;

    @ApiModelProperty(value = "")
    private String key = null;

    @ApiModelProperty(value = "")
    private IPropertyType propertyType = null;

    @ApiModelProperty(value = "")
    private String value = null;

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

    public ITenantProperties guid(String guid) {
        this.guid = guid;
        return this;
    }

    /**
     * Get key
     *
     * @return key
     **/
    @JsonProperty("key")
    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public ITenantProperties key(String key) {
        this.key = key;
        return this;
    }

    /**
     * Get propertyType
     *
     * @return propertyType
     **/
    @JsonProperty("propertyType")
    public IPropertyType getPropertyType() {
        return propertyType;
    }

    public void setPropertyType(IPropertyType propertyType) {
        this.propertyType = propertyType;
    }

    public ITenantProperties propertyType(IPropertyType propertyType) {
        this.propertyType = propertyType;
        return this;
    }

    /**
     * Get value
     *
     * @return value
     **/
    @JsonProperty("value")
    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public ITenantProperties value(String value) {
        this.value = value;
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class ITenantProperties {\n");

        sb.append("    guid: ").append(toIndentedString(guid)).append("\n");
        sb.append("    key: ").append(toIndentedString(key)).append("\n");
        sb.append("    propertyType: ").append(toIndentedString(propertyType)).append("\n");
        sb.append("    value: ").append(toIndentedString(value)).append("\n");
        sb.append("}");
        return sb.toString();
    }
}

