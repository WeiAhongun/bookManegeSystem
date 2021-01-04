package com.sm.cn.pojo;


public class Admin {

  private String userId;
  private String username;
  private String avater;
  private String password;
  private String role;


  public String getUserId() {
    return userId;
  }

  public void setUserId(String userId) {
    this.userId = userId;
  }


  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }


  public String getAvater() {
    return avater;
  }

  public void setAvater(String avater) {
    this.avater = avater;
  }


  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }


  public String getRole() {
    return role;
  }

  public void setRole(String role) {
    this.role = role;
  }


  @Override
  public String toString() {
    return "Admin{" +
            "userId='" + userId + '\'' +
            ", username='" + username + '\'' +
            ", avater='" + avater + '\'' +
            ", password='" + password + '\'' +
            ", role='" + role + '\'' +
            '}';
  }
}
