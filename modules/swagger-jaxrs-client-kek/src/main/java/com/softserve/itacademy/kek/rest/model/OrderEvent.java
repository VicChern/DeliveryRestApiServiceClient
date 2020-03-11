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
  private UUID guid = null;

  @ApiModelProperty(value = "")
  private UUID orderId = null;

  @ApiModelProperty(value = "")
  private String payload = null;


@XmlType(name="TypeEnum")
@XmlEnum(String.class)
public enum TypeEnum {

@XmlEnumValue("CREATED") CREATED(String.valueOf("CREATED")), @XmlEnumValue("ASSIGNED") ASSIGNED(String.valueOf("ASSIGNED")), @XmlEnumValue("STARTED") STARTED(String.valueOf("STARTED")), @XmlEnumValue("DELIVERED") DELIVERED(String.valueOf("DELIVERED"));


    private String value;

    TypeEnum (String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }

    public static TypeEnum fromValue(String v) {
        for (TypeEnum b : TypeEnum.values()) {
            if (String.valueOf(b.value).equals(v)) {
                return b;
            }
        }
        return null;
    }
}

  @ApiModelProperty(value = "")
  private TypeEnum type = null;
 /**
   * Get guid
   * @return guid
  **/
  @JsonProperty("guid")
  public UUID getGuid() {
    return guid;
  }

  public void setGuid(UUID guid) {
    this.guid = guid;
  }

  public OrderEvent guid(UUID guid) {
    this.guid = guid;
    return this;
  }

 /**
   * Get orderId
   * @return orderId
  **/
  @JsonProperty("orderId")
  public UUID getOrderId() {
    return orderId;
  }

  public void setOrderId(UUID orderId) {
    this.orderId = orderId;
  }

  public OrderEvent orderId(UUID orderId) {
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
   * Get type
   * @return type
  **/
  @JsonProperty("type")
  public String getType() {
    if (type == null) {
      return null;
    }
    return type.value();
  }

  public void setType(TypeEnum type) {
    this.type = type;
  }

  public OrderEvent type(TypeEnum type) {
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

