package com.softserve.itacademy.kek.rest.model;

import com.softserve.itacademy.kek.rest.model.TenantDetails;
import java.util.UUID;

import io.swagger.annotations.ApiModelProperty;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Tenant  {
  
  @ApiModelProperty(value = "")
  private TenantDetails details = null;

  @ApiModelProperty(value = "")
  private String guid = null;

  @ApiModelProperty(value = "")
  private String name = null;

  @ApiModelProperty(value = "")
  private String owner = null;
 /**
   * Get details
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

  public Tenant guid(String guid) {
    this.guid = guid;
    return this;
  }

 /**
   * Get name
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
   * Get owner
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


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Tenant {\n");
    
    sb.append("    details: ").append(toIndentedString(details)).append("\n");
    sb.append("    guid: ").append(toIndentedString(guid)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    owner: ").append(toIndentedString(owner)).append("\n");
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

