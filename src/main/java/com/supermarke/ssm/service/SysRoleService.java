package com.supermarke.ssm.service;

import com.supermarke.ssm.pojo.SysRole;

import java.util.List;

public interface SysRoleService {

    /**
     * 查询全部角色
     */
    List<SysRole> selectAll();

    SysRole getById(Integer id);

    void sysRoleUpdate(SysRole sysRole);

    boolean delById(Integer id);

    void sysRoleInsert(SysRole sysRole);

    Integer checkCode(Integer code);
}
