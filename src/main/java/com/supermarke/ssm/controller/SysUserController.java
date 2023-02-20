package com.supermarke.ssm.controller;


import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageInfo;
import com.sun.deploy.util.StringUtils;
import com.supermarke.ssm.mapper.SysUserMapper;
import com.supermarke.ssm.pojo.SysRole;
import com.supermarke.ssm.pojo.SysUser;
import com.supermarke.ssm.service.SysRoleService;
import com.supermarke.ssm.service.SysUserService;
import org.springframework.beans.BeanUtils;
import org.springframework.context.annotation.ImportResource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/sys/user")
public class SysUserController {

    @Resource(name = "sysUserService")
    private SysUserService sysUserService;
    @Resource
    private SysRoleService sysRoleService;

    // 跳转sysUser/list.jsp：全部用户信息+全部角色+pageInfo
    @RequestMapping("/list/{pn}")
    public String sysUserList(@PathVariable("pn")Integer pn,String queryRealName,Integer queryRoleId,Model model){
        // 全部用户信息
        PageInfo<SysUser> pageInfo = sysUserService.getUserByRoleIdRealName(pn, queryRoleId, queryRealName);
        List<SysUser> list = pageInfo.getList();
        list.forEach(sysUser ->{
            System.out.println(sysUser); System.out.println();
        });
        model.addAttribute("userList",list);
        model.addAttribute("pageInfo",pageInfo);

        // 全部角色
        List<SysRole> sysRoleList = sysRoleService.selectAll();
        model.addAttribute("sysRoleList",sysRoleList);
        return "sysUser/list";
    }

    // view.jsp：根据id查询用户信息
    @RequestMapping("/view/{id}")
    public String view(@PathVariable("id")Integer id,Model model){
        SysUser sysUserId = sysUserService.getSysUserId(id);
        model.addAttribute("sysUser",sysUserId);
        return "sysUser/view";
    }

    // update.jsp跳转
    @RequestMapping("/toUpdate")
    public String goUpdate(Integer uid,Model model){
        SysUser sysUserId = sysUserService.getSysUserId(uid);
        model.addAttribute("sysUser",sysUserId);

        // 全部角色
        List<SysRole> sysRoleList = sysRoleService.selectAll();
        model.addAttribute("sysRoleList",sysRoleList);
        return "sysUser/update";
    }

    // 修改
    @RequestMapping("/update")
    public String update(SysUser sysUser,HttpSession session,String birthdayUtil){
        // // update###执行更新时出错###原因：java.lang.IllegalArgumentException:比较无效：java.util.Date日期和java.lang.String
//        SimpleDateFormat simpleDateFormat = new SimpleDateFormat();
//        Date parse = null;
//        try {
//            parse = simpleDateFormat.parse(birthdayUtil);
//        } catch (ParseException e) {
//            throw new RuntimeException(e);
//        }
        SysUser userSession = (SysUser) session.getAttribute("userSession");
        sysUser.setUpdatedUserId(userSession.getId());
//        sysUser.setBirthday(parse);
        sysUser.setUpdatedTime(new Date());
        sysUserService.update(sysUser);
        return "redirect:/sys/user/list/1";
    }

    @RequestMapping("/del/{id}")
    @ResponseBody
    public Map<String, String> delete(@PathVariable("id") Integer id){
        boolean delete = sysUserService.delete(id);
        Map<String,String> map = new HashMap<>();
        if (delete){
            map.put("delResult","true");
            return map;
        }else {
            map.put("delResult","false");
            return map;
        }
    }

    @RequestMapping("/add")
    public String sysUserAdd(SysUser sysUser, HttpServletRequest request, HttpSession session, @RequestParam(value = "idPic",required = false) MultipartFile[] attachs){
        sysUser.setCreatedTime(new Date());
        SysUser userSession = (SysUser) session.getAttribute("userSession");
        userSession.setCreatedUserId(userSession.getId());
        String insert = sysUserService.insert(sysUser, attachs, request);
        if (insert.equals("true")){
            return "redirect:/sys/user/list/1";
        }
        return insert;
    }

    @ResponseBody
    @GetMapping("/userExist")
    public Map<String,Integer> userExist(@RequestParam("account") String accoount){
        Map<String,Integer> exist = new HashMap<>();
        try {
            SysUser accountChecked = sysUserService.getAccountChecked(accoount);
            if (accountChecked == null){
                exist.put("exist",0);
            }else {
                exist.put("exist",1);
            }
        }catch (Exception e){
            exist.put("exist",-1);
        }
        return exist;
    }

    @RequestMapping("/savePassword")
    public String savePassword(@RequestParam String reNewPassword, HttpSession session, HttpServletRequest request){
        if (session.getAttribute("userSession") != null){
            SysUser userSession = (SysUser) session.getAttribute("userSession");
            SysUser sysUser = new SysUser();
            sysUser.setId(userSession.getId());
            sysUser.setPassword(reNewPassword);
            boolean update = sysUserService.update(sysUser);
            if (update){
                session.removeAttribute("userSession");
                return "redirect:/login";
            }
        }else {
            request.setAttribute("userSession","修改密码失败");
        }
        return "redirect:/sys/user/list/1";
    }

    @RequestMapping("checkOldPwd")
    @ResponseBody
    public Map<String,String> checkOldPwd(@RequestParam("oldPassword")String oldPassword,HttpSession session){
        Map<String,String> map = new HashMap<>();
        SysUser userSession = (SysUser) session.getAttribute("userSession");
        if (session.getAttribute("userSession") != null){
            if (oldPassword.equals(userSession.getPassword())) {
                map.put("result","true");
                return map;
            }
            if (!oldPassword.equals(userSession.getPassword())) {
                map.put("result","false");
                return map;
            }
            if (oldPassword == ""){
                map.put("result","error");
                return map;
            }
        }else {
            map.put("result","sessionerror");
            return map;
        }
        map.put("result","500");
        return map;
    }

    @ResponseBody
    @GetMapping("/{id}/view")
    public String view(@PathVariable Integer id){
        SysUser sysUserId = sysUserService.getSysUserId(id);
        if (sysUserId != null){
            Map<String,SysUser> result = new HashMap<>();
            return JSON.toJSONString(sysUserId);
        }else {
            return "nodata";
        }
    }
}
