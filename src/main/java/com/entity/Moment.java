package com.entity;


public class Moment {

  private long id;
  private long userId;
  private String content;
  private String imgs;
  private java.sql.Timestamp createTime;


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


  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }


  public String getImgs() {
    return imgs;
  }

  public void setImgs(String imgs) {
    this.imgs = imgs;
  }


  public java.sql.Timestamp getCreateTime() {
    return createTime;
  }

  public void setCreateTime(java.sql.Timestamp createTime) {
    this.createTime = createTime;
  }

  @Override
  public String toString() {
    return "{" +
            "id:" + id +
            ", userId:" + userId +
            ", content:'" + content + '\'' +
            ", imgs:'" + imgs + '\'' +
            ", createTime:" + createTime +
            '}';
  }
}
