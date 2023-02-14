package com.supermarke.ssm.pojo;

import java.util.Date;
import java.util.List;
import com.alibaba.fastjson.annotation.JSONField;
import org.springframework.format.annotation.DateTimeFormat;

public class SysUser {

  private Long id;
  private String account;
  private String realName;
  private String password;
  private Integer sex;
  @DateTimeFormat(pattern = "yyyy-MM-dd")
  @JSONField(format = "yyyy-MM-dd")
  private Date birthday;
  private String phone;
  private String address;
  private Integer roleId;
  private Long createdUserId;
  @JSONField(format = "yyyy-MM-dd HH:mm:ss")
  private Date createdTime;
  private Long updatedUserId;
  private Date updatedTime;
  private String idPicPath;

  private SysRole sysRole;

  private List<Address> addressList;

  public SysUser() {
  }

  public SysUser(Long id, String account, String realName, String password, Integer sex, Date birthday, String phone, String address, Integer roleId, Long createdUserId, Date createdTime, Long updatedUserId, Date updatedTime, String idPicPath, SysRole sysRole, List<Address> addressList) {
    this.id = id;
    this.account = account;
    this.realName = realName;
    this.password = password;
    this.sex = sex;
    this.birthday = birthday;
    this.phone = phone;
    this.address = address;
    this.roleId = roleId;
    this.createdUserId = createdUserId;
    this.createdTime = createdTime;
    this.updatedUserId = updatedUserId;
    this.updatedTime = updatedTime;
    this.idPicPath = idPicPath;
    this.sysRole = sysRole;
    this.addressList = addressList;
  }

  public SysUser(Long id, String account, String realName, String password, Integer sex, Date birthday, String phone, String address, Integer roleId, Long createdUserId, Date createdTime, Long updatedUserId, Date updatedTime, String idPicPath) {
    this.id = id;
    this.account = account;
    this.realName = realName;
    this.password = password;
    this.sex = sex;
    this.birthday = birthday;
    this.phone = phone;
    this.address = address;
    this.roleId = roleId;
    this.createdUserId = createdUserId;
    this.createdTime = createdTime;
    this.updatedUserId = updatedUserId;
    this.updatedTime = updatedTime;
    this.idPicPath = idPicPath;
  }

  @Override
  public String toString() {
    return "SysUser{" +
            "id=" + id +
            ", account='" + account + '\'' +
            ", realName='" + realName + '\'' +
            ", password='" + password + '\'' +
            ", sex=" + sex +
            ", birthday=" + birthday +
            ", phone='" + phone + '\'' +
            ", address='" + address + '\'' +
            ", roleId=" + roleId +
            ", createdUserId=" + createdUserId +
            ", createdTime=" + createdTime +
            ", updatedUserId=" + updatedUserId +
            ", updatedTime=" + updatedTime +
            ", idPicPath='" + idPicPath + '\'' +
            ", sysRole=" + sysRole +
            ", addressList=" + addressList +
            '}';
  }

  public List<Address> getAddressList() {
    return addressList;
  }

  public void setAddressList(List<Address> addressList) {
    this.addressList = addressList;
  }

  public SysRole getSysRole() {
    return sysRole;
  }

  public void setSysRole(SysRole sysRole) {
    this.sysRole = sysRole;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getAccount() {
    return account;
  }

  public void setAccount(String account) {
    this.account = account;
  }

  public String getRealName() {
    return realName;
  }

  public void setRealName(String realName) {
    this.realName = realName;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public Integer getSex() {
    return sex;
  }

  public void setSex(Integer sex) {
    this.sex = sex;
  }

  public Date getBirthday() {
    return birthday;
  }

  public void setBirthday(Date birthday) {
    this.birthday = birthday;
  }

  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public Integer getRoleId() {
    return roleId;
  }

  public void setRoleId(Integer roleId) {
    this.roleId = roleId;
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

  public String getIdPicPath() {
    return idPicPath;
  }

  public void setIdPicPath(String idPicPath) {
    this.idPicPath = idPicPath;
  }
}
