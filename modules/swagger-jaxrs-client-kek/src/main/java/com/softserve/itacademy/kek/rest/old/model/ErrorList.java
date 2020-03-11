package com.softserve.itacademy.kek.rest.old.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;

public class ErrorList  {
  
  @ApiModelProperty(value = "")
  private List<java.lang.Error> errorlList = null;
 /**
   * Get errorlList
   * @return errorlList
  **/
  @JsonProperty("errorlList")
  public List<java.lang.Error> getErrorlList() {
    return errorlList;
  }

  public void setErrorlList(List<java.lang.Error> errorlList) {
    this.errorlList = errorlList;
  }

  public ErrorList errorlList(List<java.lang.Error> errorlList) {
    this.errorlList = errorlList;
    return this;
  }

  public ErrorList addErrorlListItem(java.lang.Error errorlListItem) {
    this.errorlList.add(errorlListItem);
    return this;
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ErrorList {\n");
    
    sb.append("    errorlList: ").append(toIndentedString(errorlList)).append("\n");
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

