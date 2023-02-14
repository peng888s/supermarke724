package com.supermarke.ssm.service;

import com.github.pagehelper.PageInfo;
import com.supermarke.ssm.pojo.SysUser;

import java.util.List;

public interface SysUserService {
    /**
     * 登录
     * @param username 登录名
     * @param password 登陆密码
     * @return
     */
    SysUser login(String username,String password);



    /**
     * 全部用户信息 || 根据角色ID以及角色名字模糊查询
     * @param pn
     * @param realId
     * @param realName
     * @return
     */
    PageInfo<SysUser> getUserByRoleIdRealName(Integer pn, Integer realId, String realName);

    SysUser getSysUserId(Integer id);

    boolean update(SysUser sysUser);

    boolean delete(Integer id);
    SysUser getAccountChecked(String account);
    void insert(SysUser sysUser);
}
