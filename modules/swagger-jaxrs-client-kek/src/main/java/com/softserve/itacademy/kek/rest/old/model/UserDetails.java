package com.softserve.itacademy.kek.rest.old.model;


import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;

public class UserDetails  {
  
  @ApiModelProperty(value = "")
  private String payload = null;

  @ApiModelProperty(value = "")
  private String imageURL = null;
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

  public UserDetails payload(String payload) {
    this.payload = payload;
    return this;
  }

 /**
   * Get imageURL
   * @return imageURL
  **/
  @JsonProperty("imageURL")
  public String getImageURL() {
    return imageURL;
  }

  public void setImageURL(String imageURL) {
    this.imageURL = imageURL;
  }

  public UserDetails imageURL(String imageURL) {
    this.imageURL = imageURL;
    return this;
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class UserDetails {\n");
    
    sb.append("    payload: ").append(toIndentedString(payload)).append("\n");
    sb.append("    imageURL: ").append(toIndentedString(imageURL)).append("\n");
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

