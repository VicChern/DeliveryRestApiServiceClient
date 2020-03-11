package com.softserve.itacademy.kek.rest.old.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;

public class OrderList  {
  
  @ApiModelProperty(value = "")
  private List<Order> orderList = null;
 /**
   * Get orderList
   * @return orderList
  **/
  @JsonProperty("orderList")
  public List<Order> getOrderList() {
    return orderList;
  }

  public void setOrderList(List<Order> orderList) {
    this.orderList = orderList;
  }

  public OrderList orderList(List<Order> orderList) {
    this.orderList = orderList;
    return this;
  }

  public OrderList addOrderListItem(Order orderListItem) {
    this.orderList.add(orderListItem);
    return this;
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class OrderList {\n");
    
    sb.append("    orderList: ").append(toIndentedString(orderList)).append("\n");
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

