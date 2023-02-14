package com.supermarke.ssm.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.supermarke.ssm.mapper.SysUserMapper;
import com.supermarke.ssm.pojo.SysUser;
import com.supermarke.ssm.service.SysUserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service("sysUserService")
public class SysUserServiceImpl implements SysUserService {

    @Resource
    private SysUserMapper sysUserMapper;

    /**
     * 用户登录
     * @param username 登录名
     * @param password 登陆密码
     * @return
     */
    @Override
    public SysUser login(String username, String password) {
        SysUser sysUser = sysUserMapper.loginJudgment(username, password);
        return sysUser;
    }

    @Override
    public PageInfo<SysUser> getUserByRoleIdRealName(Integer pn, Integer realId, String realName) {
        PageHelper.startPage(pn,5);
        List<SysUser> userListByRoleId = sysUserMapper.getUserListWithRoleName(realId, realName);
        return new PageInfo<>(userListByRoleId);
    }

    @Override
    public SysUser getSysUserId(Integer id) {
        return  sysUserMapper.getUserAddressesByUserId(id);
    }

    @Override
    @Transactional
    public boolean update(SysUser sysUser) {
        return sysUserMapper.modify(sysUser)>0;
    }

    @Override
    @Transactional
    public boolean delete(Integer id) {
        int flag = sysUserMapper.deleteUserById(id);
        return flag >0;
    }

    @Override
    public SysUser getAccountChecked(String account) {
        return sysUserMapper.getAccount(account);
    }


    @Override
    @Transactional
    public void insert(SysUser sysUser) {
        sysUserMapper.add(sysUser);
//        if (1==1){
//            throw new RuntimeException("事务回滚时：");
//        }
    }
}
