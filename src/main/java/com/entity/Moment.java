package com.entity;


public class Moment {

  private long id;
  private long userId;
  private java.sql.Timestamp createtime;
  private String content;
  private String userName;
  private String imgs;
  private long favorite;


  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }


  public long getUserId() {
    return userId;
  }

  public void setUserId(long userId) {
    this.userId = userId;
  }


  public java.sql.Timestamp getCreatetime() {
    return createtime;
  }

  public void setCreatetime(java.sql.Timestamp createtime) {
    this.createtime = createtime;
  }


  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }


  public String getUserName() {
    return userName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }


  public String getImgs() {
    return imgs;
  }

  public void setImgs(String imgs) {
    this.imgs = imgs;
  }


  public long getFavorite() {
    return favorite;
  }

  public void setFavorite(long favorite) {
    this.favorite = favorite;
  }

}
