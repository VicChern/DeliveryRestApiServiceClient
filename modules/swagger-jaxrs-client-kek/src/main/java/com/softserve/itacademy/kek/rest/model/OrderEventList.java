package com.softserve.itacademy.kek.rest.model;

import com.softserve.itacademy.kek.rest.model.OrderEvent;
import java.util.ArrayList;
import java.util.List;
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

public class OrderEventList  {
  
  @ApiModelProperty(value = "")
  private List<OrderEvent> orderEventList = null;

  @ApiModelProperty(value = "")
  private String orderId = null;
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

 /**
   * Get orderId
   * @return orderId
  **/
  @JsonProperty("orderId")
  public String getOrderId() {
    return orderId;
  }

  public void setOrderId(String orderId) {
    this.orderId = orderId;
  }

  public OrderEventList orderId(String orderId) {
    this.orderId = orderId;
    return this;
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class OrderEventList {\n");
    
    sb.append("    orderEventList: ").append(toIndentedString(orderEventList)).append("\n");
    sb.append("    orderId: ").append(toIndentedString(orderId)).append("\n");
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

