package com.softserve.itacademy.kek.rest.model;

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

public class OrderEvent  {
  
  @ApiModelProperty(value = "")
  private String guid = null;

  @ApiModelProperty(value = "")
  private String orderId = null;

  @ApiModelProperty(value = "")
  private String payload = null;

    @ApiModelProperty(value = "order event type")
    /**
     * order event type
     **/
    private OrderEventTypes type = null;


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

  public OrderEvent guid(String guid) {
    this.guid = guid;
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

  public OrderEvent orderId(String orderId) {
    this.orderId = orderId;
    return this;
  }

 /**
   * Get payload
   * @return payload
  **/
  @JsonProperty("payload")
  public String getPayload() {
    return payload;
  }

  public void setPayload(String payload) {
    this.payload = payload;
  }

  public OrderEvent payload(String payload) {
    this.payload = payload;
    return this;
  }

    /**
     * order event type
     * @return type
     **/
    @JsonProperty("type")
    public String getType() {
        if (type == null) {
            return null;
        }
        return type.name();
    }

    public void setType(OrderEventTypes type) {
        this.type = type;
    }

    public OrderEvent type(OrderEventTypes type) {
        this.type = type;
        return this;
    }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class OrderEvent {\n");

    sb.append("    guid: ").append(toIndentedString(guid)).append("\n");
    sb.append("    orderId: ").append(toIndentedString(orderId)).append("\n");
    sb.append("    payload: ").append(toIndentedString(payload)).append("\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
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

