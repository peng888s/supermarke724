package com.ssm.test;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.supermarke.ssm.pojo.SysUser;
import com.supermarke.ssm.service.SysUserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Date;
import java.util.List;

public class Test {

    @org.junit.Test
    public void test1(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        SysUserService sysUserService = applicationContext.getBean("sysUserService", SysUserService.class);
        SysUser sysUser = new SysUser(null,"tom","tom","121212",1,new Date(),"13828100918","河南",1,1L,new Date(),1L,new Date(),null);
        sysUserService.insert(sysUser);
    }
}
