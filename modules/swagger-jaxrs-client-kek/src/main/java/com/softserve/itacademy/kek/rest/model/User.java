package com.softserve.itacademy.kek.rest.model;

import io.swagger.annotations.ApiModelProperty;
import com.fasterxml.jackson.annotation.JsonProperty;

public class User  {
  
  @ApiModelProperty(value = "")
  private UserDetails userDetails = null;

  @ApiModelProperty(value = "")
  private String email = null;

  @ApiModelProperty(value = "")
  private String guid = null;

  @ApiModelProperty(value = "")
  private String name = null;

  @ApiModelProperty(value = "")
  private String nickname = null;

  @ApiModelProperty(value = "")
  private String phone = null;
 /**
   * Get details
   * @return details
  **/
  @JsonProperty("details")
  public UserDetails getUserDetails() {
    return userDetails;
  }

  public void setUserDetails(UserDetails userDetails) {
    this.userDetails = userDetails;
  }

  public User details(UserDetails userDetails) {
    this.userDetails = userDetails;
    return this;
  }

 /**
   * Get email
   * @return email
  **/
  @JsonProperty("email")
  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public User email(String email) {
    this.email = email;
    return this;
  }

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

  public User guid(String guid) {
    this.guid = guid;
    return this;
  }

 /**
   * Get name
   * @return name
  **/
  @JsonProperty("name")
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public User name(String name) {
    this.name = name;
    return this;
  }

 /**
   * Get nickname
   * @return nickname
  **/
  @JsonProperty("nickname")
  public String getNickname() {
    return nickname;
  }

  public void setNickname(String nickname) {
    this.nickname = nickname;
  }

  public User nickname(String nickname) {
    this.nickname = nickname;
    return this;
  }

 /**
   * Get phone
   * @return phone
  **/
  @JsonProperty("phone")
  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }

  public User phone(String phone) {
    this.phone = phone;
    return this;
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class User {\n");
    
    sb.append("    details: ").append(toIndentedString(userDetails)).append("\n");
    sb.append("    email: ").append(toIndentedString(email)).append("\n");
    sb.append("    guid: ").append(toIndentedString(guid)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    nickname: ").append(toIndentedString(nickname)).append("\n");
    sb.append("    phone: ").append(toIndentedString(phone)).append("\n");
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

