package com.entity;


public class User {

  private long userid;
  private String name;
  private long phone;
  public String password;
  private java.sql.Timestamp createTime;
  private String realName;
  private String userPhoto;


  public long getUserid() {
    return userid;
  }

  public void setUserid(long userid) {
    this.userid = userid;
  }


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }


  public long getPhone() {
    return phone;
  }

  public void setPhone(long phone) {
    this.phone = phone;
  }


  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }


  public java.sql.Timestamp getCreateTime() {
    return createTime;
  }

  public void setCreateTime(java.sql.Timestamp createTime) {
    this.createTime = createTime;
  }


  public String getRealName() {
    return realName;
  }

  public void setRealName(String realName) {
    this.realName = realName;
  }


  public String getUserPhoto() {
    return userPhoto;
  }

  public void setUserPhoto(String userPhoto) {
    this.userPhoto = userPhoto;
  }

  @Override
  public String toString() {
    return "User{" +
            "userid=" + userid +
            ", name='" + name + '\'' +
            ", phone=" + phone +
            ", password='" + password + '\'' +
            ", createTime=" + createTime +
            ", realName='" + realName + '\'' +
            ", userPhoto='" + userPhoto + '\'' +
            '}';
  }
}
