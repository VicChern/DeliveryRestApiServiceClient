package com.softserve.itacademy.kek.rest.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;

public class TenantPropertyList  {
  
  @ApiModelProperty(value = "")
  private List<TenantProperty> tenantPropertyList = null;
 /**
   * Get tenantPropertyList
   * @return tenantPropertyList
  **/
  @JsonProperty("tenantPropertyList")
  public List<TenantProperty> getTenantPropertyList() {
    return tenantPropertyList;
  }

  public void setTenantPropertyList(List<TenantProperty> tenantPropertyList) {
    this.tenantPropertyList = tenantPropertyList;
  }

  public TenantPropertyList tenantPropertyList(List<TenantProperty> tenantPropertyList) {
    this.tenantPropertyList = tenantPropertyList;
    return this;
  }

  public TenantPropertyList addTenantPropertyListItem(TenantProperty tenantPropertyListItem) {
    this.tenantPropertyList.add(tenantPropertyListItem);
    return this;
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class TenantPropertyList {\n");
    
    sb.append("    tenantPropertyList: ").append(toIndentedString(tenantPropertyList)).append("\n");
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

