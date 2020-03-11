package com.softserve.itacademy.kek.rest.model;

import com.softserve.itacademy.kek.rest.model.Address;
import java.util.ArrayList;
import java.util.List;

import io.swagger.annotations.ApiModelProperty;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import com.fasterxml.jackson.annotation.JsonProperty;

public class AddressList  {
  
  @ApiModelProperty(value = "")
  private List<Address> addressList = null;
 /**
   * Get addressList
   * @return addressList
  **/
  @JsonProperty("addressList")
  public List<Address> getAddressList() {
    return addressList;
  }

  public void setAddressList(List<Address> addressList) {
    this.addressList = addressList;
  }

  public AddressList addressList(List<Address> addressList) {
    this.addressList = addressList;
    return this;
  }

  public AddressList addAddressListItem(Address addressListItem) {
    this.addressList.add(addressListItem);
    return this;
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AddressList {\n");
    
    sb.append("    addressList: ").append(toIndentedString(addressList)).append("\n");
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

