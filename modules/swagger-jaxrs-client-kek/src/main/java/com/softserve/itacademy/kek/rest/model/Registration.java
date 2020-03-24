package com.softserve.itacademy.kek.rest.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;

public class Registration {

    @ApiModelProperty(value = "")
    private String email = null;

    @ApiModelProperty(value = "")
    private String guid = null;

    @ApiModelProperty(value = "")
    private String name = null;

    @ApiModelProperty(value = "")
    private String nickname = null;

    @ApiModelProperty(value = "")
    private String password = null;

    @ApiModelProperty(value = "")
    private String phone = null;

    @ApiModelProperty(value = "")
    private IUserDetails userDetails = null;

    /**
     * Get email
     *
     * @return email
     **/
    @JsonProperty("email")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Registration email(String email) {
        this.email = email;
        return this;
    }

    /**
     * Get guid
     *
     * @return guid
     **/
    @JsonProperty("guid")
    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        this.guid = guid;
    }

    public Registration guid(String guid) {
        this.guid = guid;
        return this;
    }

    /**
     * Get name
     *
     * @return name
     **/
    @JsonProperty("name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Registration name(String name) {
        this.name = name;
        return this;
    }

    /**
     * Get nickname
     *
     * @return nickname
     **/
    @JsonProperty("nickname")
    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public Registration nickname(String nickname) {
        this.nickname = nickname;
        return this;
    }

    /**
     * Get password
     *
     * @return password
     **/
    @JsonProperty("password")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Registration password(String password) {
        this.password = password;
        return this;
    }

    /**
     * Get phone
     *
     * @return phone
     **/
    @JsonProperty("phone")
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Registration phone(String phone) {
        this.phone = phone;
        return this;
    }

    /**
     * Get userDetails
     *
     * @return userDetails
     **/
    @JsonProperty("userDetails")
    public IUserDetails getUserDetails() {
        return userDetails;
    }

    public void setUserDetails(IUserDetails userDetails) {
        this.userDetails = userDetails;
    }

    public Registration userDetails(IUserDetails userDetails) {
        this.userDetails = userDetails;
        return this;
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class Registration {\n");

        sb.append("    email: ").append(toIndentedString(email)).append("\n");
        sb.append("    guid: ").append(toIndentedString(guid)).append("\n");
        sb.append("    name: ").append(toIndentedString(name)).append("\n");
        sb.append("    nickname: ").append(toIndentedString(nickname)).append("\n");
        sb.append("    password: ").append(toIndentedString(password)).append("\n");
        sb.append("    phone: ").append(toIndentedString(phone)).append("\n");
        sb.append("    userDetails: ").append(toIndentedString(userDetails)).append("\n");
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

