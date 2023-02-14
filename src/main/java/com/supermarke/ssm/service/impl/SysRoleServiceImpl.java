package com.supermarke.ssm.service.impl;

import com.supermarke.ssm.mapper.SysRoleMapper;
import com.supermarke.ssm.pojo.SysRole;
import com.supermarke.ssm.service.SysRoleService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service("sysRoleService")
public class SysRoleServiceImpl implements SysRoleService {

    @Resource
    private SysRoleMapper sysRoleMapper;

    @Override
    public List<SysRole> selectAll() {
        return sysRoleMapper.selectAll();
    }

    @Override
    public SysRole getById(Integer id) {
        return sysRoleMapper.selectByAllId(id);
    }

    @Override
    @Transactional
    public void sysRoleUpdate(SysRole sysRole) {
        sysRoleMapper.update(sysRole);
    }

    @Override
    @Transactional
    public boolean delById(Integer id) {
        int delete = sysRoleMapper.delete(id);
        return delete>0;
    }

    @Override
    @Transactional
    public void sysRoleInsert(SysRole sysRole) {
        sysRoleMapper.insert(sysRole);
    }

    @Override
    public Integer checkCode(Integer code) {
        SysRole sysRole = sysRoleMapper.selectCode(code);
        if (sysRole == null)
            return 0;
        if (sysRole != null)
            return 1;
        return null;
    }
}
