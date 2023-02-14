package com.supermarke.ssm.pojo;


import java.util.Date;

public class StorageRecord {

  private long id;
  private String srCode;
  private String goodsName;
  private String goodsDesc;
  private String goodsUnit;
  private Double goodsCount;
  private Double totalAmount;
  private Integer payStatus;
  private Long createdUserId;
  private Date createdTime;
  private Long updatedUserId;
  private Date updatedTime;
  private Integer supplierId;
  private Supplier supplier;

  public StorageRecord(long id, String srCode, String goodsName, String goodsDesc, String goodsUnit, Double goodsCount, Double totalAmount, Integer payStatus, Long createdUserId, Date createdTime, Long updatedUserId, Date updatedTime, Integer supplierId, Supplier supplier) {
    this.id = id;
    this.srCode = srCode;
    this.goodsName = goodsName;
    this.goodsDesc = goodsDesc;
    this.goodsUnit = goodsUnit;
    this.goodsCount = goodsCount;
    this.totalAmount = totalAmount;
    this.payStatus = payStatus;
    this.createdUserId = createdUserId;
    this.createdTime = createdTime;
    this.updatedUserId = updatedUserId;
    this.updatedTime = updatedTime;
    this.supplierId = supplierId;
    this.supplier = supplier;
  }

  @Override
  public String toString() {
    return "StorageRecord{" +
            "id=" + id +
            ", srCode='" + srCode + '\'' +
            ", goodsName='" + goodsName + '\'' +
            ", goodsDesc='" + goodsDesc + '\'' +
            ", goodsUnit='" + goodsUnit + '\'' +
            ", goodsCount=" + goodsCount +
            ", totalAmount=" + totalAmount +
            ", payStatus=" + payStatus +
            ", createdUserId=" + createdUserId +
            ", createdTime=" + createdTime +
            ", updatedUserId=" + updatedUserId +
            ", updatedTime=" + updatedTime +
            ", supplierId=" + supplierId +
            ", supplier=" + supplier +
            '}';
  }

  public StorageRecord() {
  }

  public Supplier getSupplier() {
    return supplier;
  }

  public void setSupplier(Supplier supplier) {
    this.supplier = supplier;
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getSrCode() {
    return srCode;
  }

  public void setSrCode(String srCode) {
    this.srCode = srCode;
  }

  public String getGoodsName() {
    return goodsName;
  }

  public void setGoodsName(String goodsName) {
    this.goodsName = goodsName;
  }

  public String getGoodsDesc() {
    return goodsDesc;
  }

  public void setGoodsDesc(String goodsDesc) {
    this.goodsDesc = goodsDesc;
  }

  public String getGoodsUnit() {
    return goodsUnit;
  }

  public void setGoodsUnit(String goodsUnit) {
    this.goodsUnit = goodsUnit;
  }

  public Double getGoodsCount() {
    return goodsCount;
  }

  public void setGoodsCount(Double goodsCount) {
    this.goodsCount = goodsCount;
  }

  public Double getTotalAmount() {
    return totalAmount;
  }

  public void setTotalAmount(Double totalAmount) {
    this.totalAmount = totalAmount;
  }

  public Integer getPayStatus() {
    return payStatus;
  }

  public void setPayStatus(Integer payStatus) {
    this.payStatus = payStatus;
  }

  public Long getCreatedUserId() {
    return createdUserId;
  }

  public void setCreatedUserId(Long createdUserId) {
    this.createdUserId = createdUserId;
  }

  public Date getCreatedTime() {
    return createdTime;
  }

  public void setCreatedTime(Date createdTime) {
    this.createdTime = createdTime;
  }

  public Long getUpdatedUserId() {
    return updatedUserId;
  }

  public void setUpdatedUserId(Long updatedUserId) {
    this.updatedUserId = updatedUserId;
  }

  public Date getUpdatedTime() {
    return updatedTime;
  }

  public void setUpdatedTime(Date updatedTime) {
    this.updatedTime = updatedTime;
  }

  public Integer getSupplierId() {
    return supplierId;
  }

  public void setSupplierId(Integer supplierId) {
    this.supplierId = supplierId;
  }
}
