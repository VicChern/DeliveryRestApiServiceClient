package dto;

import java.util.Objects;

public class User {

    private String guid;

    private String name;

    private String nickname;

    private String email;

    private String phone;

    private Details details;

    public User() {
    }

    public User(String guid, String name, String nickName, String email, String phone, Details detailsDto) {
        this.guid = guid;
        this.name = name;
        this.nickname = nickName;
        this.email = email;
        this.phone = phone;
        this.details = detailsDto;
    }

    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        this.guid = guid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Details getDetails() {
        return details;
    }

    public void setDetails(Details details) {
        this.details = details;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        User userDto = (User) o;
        return Objects.equals(guid, userDto.guid) &&
                Objects.equals(name, userDto.name) &&
                Objects.equals(nickname, userDto.nickname) &&
                Objects.equals(email, userDto.email) &&
                Objects.equals(phone, userDto.phone) &&
                Objects.equals(details, userDto.details);
    }

    @Override
    public int hashCode() {
        return Objects.hash(guid, name, nickname, email, phone, details);
    }

    @Override
    public String toString() {
        return "UserDto{" +
                "guid='" + guid + '\'' +
                ", name='" + name + '\'' +
                ", nickName='" + nickname + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", detailsDto=" + details +
                '}';
    }
}
