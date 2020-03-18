package com.softserve.itacademy.kek.rest.old.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;

public class UserList  {
  
  @ApiModelProperty(value = "")
  private List<User> userList = null;
 /**
   * Get userList
   * @return userList
  **/
  @JsonProperty("userList")
  public List<User> getUserList() {
    return userList;
  }

  public void setUserList(List<User> userList) {
    this.userList = userList;
  }

  public UserList userList(List<User> userList) {
    this.userList = userList;
    return this;
  }

  public UserList addUserListItem(User userListItem) {
    this.userList.add(userListItem);
    return this;
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class UserList {\n");
    
    sb.append("    userList: ").append(toIndentedString(userList)).append("\n");
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

