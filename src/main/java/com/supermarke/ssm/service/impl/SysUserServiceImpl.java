package com.supermarke.ssm.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.supermarke.ssm.mapper.SysUserMapper;
import com.supermarke.ssm.pojo.SysUser;
import com.supermarke.ssm.service.SysUserService;
import com.supermarke.ssm.util.UpploadPhoto;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

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
    public String insert(SysUser sysUser, MultipartFile[] file, HttpServletRequest request) {

        Map<String, String> map = UpploadPhoto.uploadB(file, request);
        if (map.get("error") != null){
            if (map.get("error").equals("sysUser/add")) {
                return "sysUser/add";
            }
        }
        if (map.get("idPicPath") != null){
            sysUser.setIdPicPath(map.get("idPicPath"));
        }
        if (map.get("workPicPath") != null){
            sysUser.setWorkPicpath(map.get("workPicPath"));
        }
        int add = sysUserMapper.add(sysUser);
        if (add>0){
            return "true";
        }else {
            request.setAttribute("error","添加失败");
            return "sysUser/add";
        }
    }
}
