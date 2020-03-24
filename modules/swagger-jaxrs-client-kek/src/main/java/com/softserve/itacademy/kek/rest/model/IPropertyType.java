package com.softserve.itacademy.kek.rest.model;


import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;

public class IPropertyType {

    @ApiModelProperty(value = "")
    private String name = null;

    @ApiModelProperty(value = "")
    private String schema = null;

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

    public IPropertyType name(String name) {
        this.name = name;
        return this;
    }

    /**
     * Get schema
     *
     * @return schema
     **/
    @JsonProperty("schema")
    public String getSchema() {
        return schema;
    }

    public void setSchema(String schema) {
        this.schema = schema;
    }

    public IPropertyType schema(String schema) {
        this.schema = schema;
        return this;
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class IPropertyType {\n");

        sb.append("    name: ").append(toIndentedString(name)).append("\n");
        sb.append("    schema: ").append(toIndentedString(schema)).append("\n");
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

