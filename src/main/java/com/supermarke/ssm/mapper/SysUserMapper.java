package com.supermarke.ssm.mapper;

import com.supermarke.ssm.pojo.SysUser;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface SysUserMapper {

    List<SysUser> getUserListWithRoleName(@Param("roleId")Integer roleId,@Param("realName")String realName);

    SysUser getAccount(@Param("account") String account);
    /**
     * 根据用户真实姓名模糊匹配查询用户
     * @param realName
     * @return
     */
    List<SysUser> getUsersByRealName(String realName);

    /**
     * 多条件查询，用户列表
     * @param sysUser
     * @return
     */
    List<SysUser> getUserListByPojo(SysUser sysUser);


    /**
     * 使用Map集合
     * @param map
     * @return
     */
    List<SysUser> getUserListByMap(Map<String, Object> map);

    /**
     * 使用注解
     * @param arg0
     * @param arg1
     * @return
     */
    List<SysUser> getUserListByParams(@Param("realName") String arg0,@Param("roleId") Integer arg1);

    /**
     * 查询用户列表，包括角色名称
     * @param sysUser
     * @return
     */
    List<SysUser> getUserListWithRoleName(SysUser sysUser);

    /**
     * 更具角色Id查询，包含系统角色实例
     * @param roleId
     * @return
     */
    List<SysUser> getUserListByRoleId(@Param("roleId")Integer roleId);

    /**
     * 根据用户ID查询用户及相关地址
     * @param userId
     * @return
     */
    SysUser getUserAddressesByUserId(@Param("userId") Integer userId);

    /**
     * 添加用户
     * @param user
     * @return
     */
    int add(SysUser user);

    /**
     * 修改用户
     * @param sysUser
     * @return
     */
    int modify(SysUser sysUser);

    /**
     * 删除用户
     * @param id
     * @return
     */
    int deleteUserById(Integer id);

    List<SysUser> selectListByChoose(SysUser sysUser);

    /**
     * 更具角色ID数组查询用户列表信息
     * @param roleIds
     * @return
     */
    List<SysUser> getUserByRoleIdArray(@Param("array") Map<Integer,Integer> roleIds);

    /**
     * 登录判断
     * @return
     */
    SysUser loginJudgment(@Param("username") String username, @Param("password")String password);
}
