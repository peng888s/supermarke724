package com.supermarke.ssm.pojo;


import java.util.Date;
import java.util.List;

public class Supplier {

  private Long id;
  private String supCode;
  private String supName;
  private String supDesc;
  private String supContact;
  private String supPhone;
  private String supAddress;
  private String supFax;
  private Long createdUserId;
  private Date createdTime;
  private Long updatedUserId;
  private Date updatedTime;
  private String companyLicPicPath;

  private String orgCodePicPath;

  public String getOrgCodePicPath() {
    return orgCodePicPath;
  }

  public void setOrgCodePicPath(String orgCodePicPath) {
    this.orgCodePicPath = orgCodePicPath;
  }

  public String getCompanyLicPicPath() {
    return companyLicPicPath;
  }

  public void setCompanyLicPicPath(String companyLicPicPath) {
    this.companyLicPicPath = companyLicPicPath;
  }

  private List<StorageRecord> storageRecords;

  @Override
  public String toString() {
    return "Supplier{" +
            "id=" + id +
            ", supCode='" + supCode + '\'' +
            ", supName='" + supName + '\'' +
            ", supDesc='" + supDesc + '\'' +
            ", supContact='" + supContact + '\'' +
            ", supPhone='" + supPhone + '\'' +
            ", supAddress='" + supAddress + '\'' +
            ", supFax='" + supFax + '\'' +
            ", createdUserId=" + createdUserId +
            ", createdTime=" + createdTime +
            ", updatedUserId=" + updatedUserId +
            ", updatedTime=" + updatedTime +
            ", storageRecords=" + storageRecords +
            '}';
  }

  public List<StorageRecord> getStorageRecords() {
    return storageRecords;
  }

  public void setStorageRecords(List<StorageRecord> storageRecords) {
    this.storageRecords = storageRecords;
  }

  public Supplier() {
  }

  public Supplier(Long id, String supCode, String supName, String supDesc, String supContact, String supPhone, String supAddress, String supFax, Long createdUserId, Date createdTime, Long updatedUserId, Date updatedTime, List<StorageRecord> storageRecords) {
    this.id = id;
    this.supCode = supCode;
    this.supName = supName;
    this.supDesc = supDesc;
    this.supContact = supContact;
    this.supPhone = supPhone;
    this.supAddress = supAddress;
    this.supFax = supFax;
    this.createdUserId = createdUserId;
    this.createdTime = createdTime;
    this.updatedUserId = updatedUserId;
    this.updatedTime = updatedTime;
    this.storageRecords = storageRecords;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getSupCode() {
    return supCode;
  }

  public void setSupCode(String supCode) {
    this.supCode = supCode;
  }

  public String getSupName() {
    return supName;
  }

  public void setSupName(String supName) {
    this.supName = supName;
  }

  public String getSupDesc() {
    return supDesc;
  }

  public void setSupDesc(String supDesc) {
    this.supDesc = supDesc;
  }

  public String getSupContact() {
    return supContact;
  }

  public void setSupContact(String supContact) {
    this.supContact = supContact;
  }

  public String getSupPhone() {
    return supPhone;
  }

  public void setSupPhone(String supPhone) {
    this.supPhone = supPhone;
  }

  public String getSupAddress() {
    return supAddress;
  }

  public void setSupAddress(String supAddress) {
    this.supAddress = supAddress;
  }

  public String getSupFax() {
    return supFax;
  }

  public void setSupFax(String supFax) {
    this.supFax = supFax;
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
}
