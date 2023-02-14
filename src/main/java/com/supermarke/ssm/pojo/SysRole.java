package com.supermarke.ssm.pojo;


import java.util.Date;

public class SysRole {

  private Long id;
  private String code;
  private String roleName;
  private Long createdUserId;
  private Date createdTime;
  private Long updatedUserId;
  private Date updatedTime;

  public SysRole() {
  }

  public SysRole(Long id, String code, String roleName, Long createdUserId, Date createdTime, Long updatedUserId, Date updatedTime) {
    this.id = id;
    this.code = code;
    this.roleName = roleName;
    this.createdUserId = createdUserId;
    this.createdTime = createdTime;
    this.updatedUserId = updatedUserId;
    this.updatedTime = updatedTime;
  }

  @Override
  public String toString() {
    return "SysRole{" +
            "id=" + id +
            ", code='" + code + '\'' +
            ", roleName='" + roleName + '\'' +
            ", createdUserId=" + createdUserId +
            ", createdTime=" + createdTime +
            ", updatedUserId=" + updatedUserId +
            ", updatedTime=" + updatedTime +
            '}';
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }

  public String getRoleName() {
    return roleName;
  }

  public void setRoleName(String roleName) {
    this.roleName = roleName;
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
