package com.softserve.itacademy.kek.rest.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;

public class TenantList  {
  
  @ApiModelProperty(value = "")
  private List<Tenant> tenantList = null;
 /**
   * Get tenantList
   * @return tenantList
  **/
  @JsonProperty("tenantList")
  public List<Tenant> getTenantList() {
    return tenantList;
  }

  public void setTenantList(List<Tenant> tenantList) {
    this.tenantList = tenantList;
  }

  public TenantList tenantList(List<Tenant> tenantList) {
    this.tenantList = tenantList;
    return this;
  }

  public TenantList addTenantListItem(Tenant tenantListItem) {
    this.tenantList.add(tenantListItem);
    return this;
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class TenantList {\n");
    
    sb.append("    tenantList: ").append(toIndentedString(tenantList)).append("\n");
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

