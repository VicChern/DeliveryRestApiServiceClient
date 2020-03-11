package com.softserve.itacademy.kek.rest.model;

import java.util.List;

import io.swagger.annotations.ApiModelProperty;
import com.fasterxml.jackson.annotation.JsonProperty;

public class TenantPropertyList {
  
  @ApiModelProperty(value = "")
  private List<ITenantProperties> tenantPropertiesList = null;
 /**
   * Get tenantPropertiesList
   * @return tenantPropertiesList
  **/
  @JsonProperty("tenantPropertiesList")
  public List<ITenantProperties> getTenantPropertiesList() {
    return tenantPropertiesList;
  }

  public void setTenantPropertiesList(List<ITenantProperties> tenantPropertiesList) {
    this.tenantPropertiesList = tenantPropertiesList;
  }

  public TenantPropertyList tenantPropertiesList(List<ITenantProperties> tenantPropertiesList) {
    this.tenantPropertiesList = tenantPropertiesList;
    return this;
  }

  public TenantPropertyList addTenantPropertiesListItem(ITenantProperties tenantPropertiesListItem) {
    this.tenantPropertiesList.add(tenantPropertiesListItem);
    return this;
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class TenantPropertiesList {\n");
    
    sb.append("    tenantPropertiesList: ").append(toIndentedString(tenantPropertiesList)).append("\n");
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

