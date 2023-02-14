package com.supermarke.ssm.pojo;


import java.util.Date;

public class Address {

  private Integer id;
  private String contact;
  private String addressDesc;
  private String postCode;
  private String tel;
  private Integer userId;
  private Integer createdUserId;
  private Date createdTime;
  private Integer updatedUserId;
  private Date updatedTime;

  public Address() {
  }

  public Address(Integer id, String contact, String addressDesc, String postCode, String tel, Integer userId, Integer createdUserId, Date createdTime, Integer updatedUserId, Date updatedTime) {
    this.id = id;
    this.contact = contact;
    this.addressDesc = addressDesc;
    this.postCode = postCode;
    this.tel = tel;
    this.userId = userId;
    this.createdUserId = createdUserId;
    this.createdTime = createdTime;
    this.updatedUserId = updatedUserId;
    this.updatedTime = updatedTime;
  }

  @Override
  public String toString() {
    return "Address{" +
            "id=" + id +
            ", contact='" + contact + '\'' +
            ", addressDesc='" + addressDesc + '\'' +
            ", postCode='" + postCode + '\'' +
            ", tel='" + tel + '\'' +
            ", userId=" + userId +
            ", createdUserId=" + createdUserId +
            ", createdTime=" + createdTime +
            ", updatedUserId=" + updatedUserId +
            ", updatedTime=" + updatedTime +
            '}';
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getContact() {
    return contact;
  }

  public void setContact(String contact) {
    this.contact = contact;
  }

  public String getAddressDesc() {
    return addressDesc;
  }

  public void setAddressDesc(String addressDesc) {
    this.addressDesc = addressDesc;
  }

  public String getPostCode() {
    return postCode;
  }

  public void setPostCode(String postCode) {
    this.postCode = postCode;
  }

  public String getTel() {
    return tel;
  }

  public void setTel(String tel) {
    this.tel = tel;
  }

  public Integer getUserId() {
    return userId;
  }

  public void setUserId(Integer userId) {
    this.userId = userId;
  }

  public Integer getCreatedUserId() {
    return createdUserId;
  }

  public void setCreatedUserId(Integer createdUserId) {
    this.createdUserId = createdUserId;
  }

  public Date getCreatedTime() {
    return createdTime;
  }

  public void setCreatedTime(Date createdTime) {
    this.createdTime = createdTime;
  }

  public Integer getUpdatedUserId() {
    return updatedUserId;
  }

  public void setUpdatedUserId(Integer updatedUserId) {
    this.updatedUserId = updatedUserId;
  }

  public Date getUpdatedTime() {
    return updatedTime;
  }

  public void setUpdatedTime(Date updatedTime) {
    this.updatedTime = updatedTime;
  }
}
