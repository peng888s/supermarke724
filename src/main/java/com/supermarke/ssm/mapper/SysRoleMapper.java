package com.supermarke.ssm.mapper;

import com.supermarke.ssm.pojo.SysRole;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SysRoleMapper {

    /**
     * 条件查询
     */
    SysRole selectByAllId(Integer roleId);

    List<SysRole> selectAll();

    int update(SysRole sysRole);

    int delete(Integer id);

    int insert(SysRole sysRole);

    SysRole selectCode(Integer selectCode);
}
