package com.entity;


public class MomentFavorite {

  private long id;
  private long momentId;
  private long favoriteUserId;


  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }


  public long getMomentId() {
    return momentId;
  }

  public void setMomentId(long momentId) {
    this.momentId = momentId;
  }


  public long getFavoriteUserId() {
    return favoriteUserId;
  }

  public void setFavoriteUserId(long favoriteUserId) {
    this.favoriteUserId = favoriteUserId;
  }

}
