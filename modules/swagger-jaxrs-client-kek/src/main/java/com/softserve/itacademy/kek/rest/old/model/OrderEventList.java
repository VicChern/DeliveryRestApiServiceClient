package com.softserve.itacademy.kek.rest.old.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;

public class OrderEventList  {
  
  @ApiModelProperty(value = "")
  private List<OrderEvent> orderEventList = null;
 /**
   * Get orderEventList
   * @return orderEventList
  **/
  @JsonProperty("orderEventList")
  public List<OrderEvent> getOrderEventList() {
    return orderEventList;
  }

  public void setOrderEventList(List<OrderEvent> orderEventList) {
    this.orderEventList = orderEventList;
  }

  public OrderEventList orderEventList(List<OrderEvent> orderEventList) {
    this.orderEventList = orderEventList;
    return this;
  }

  public OrderEventList addOrderEventListItem(OrderEvent orderEventListItem) {
    this.orderEventList.add(orderEventListItem);
    return this;
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class OrderEventList {\n");
    
    sb.append("    orderEventList: ").append(toIndentedString(orderEventList)).append("\n");
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

