package com.supermarke.ssm.controller;

import com.supermarke.ssm.pojo.SysRole;
import com.supermarke.ssm.pojo.SysUser;
import com.supermarke.ssm.service.SysRoleService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/sys/role")
public class SysRoleController {

    @Resource(name = "sysRoleService")
    private SysRoleService sysRoleService;

    @RequestMapping("/list")
    public String sysRoleList(Model model){
        List<SysRole> sysRoles = sysRoleService.selectAll();
        model.addAttribute("roleList",sysRoles);
        return "sysRole/list";
    }

    @RequestMapping("/toUpdate/{id}")
    public String goUpdate(@PathVariable("id")Integer id,Model model){
        SysRole byId = sysRoleService.getById(id);
        model.addAttribute("sysRole",byId);
        return "sysRole/update";
    }

    @RequestMapping("/update")
    public String sysRoleUpdate(SysRole sysRole, HttpSession session){
        SysUser userSession = (SysUser) session.getAttribute("userSession");
        sysRole.setUpdatedUserId(userSession.getId());
//        sysRole.setUpdatedTime(new Date());
        sysRoleService.sysRoleUpdate(sysRole);
        return "redirect:/sys/role/list";
    }

    @RequestMapping("/del/{id}")
    @ResponseBody
    public Map<String, String> sysRoleDel(@PathVariable("id")Integer id){
        boolean flag = sysRoleService.delById(id);
        Map<String,String> map = new HashMap<>();
        if (flag){
            map.put("delResult","true");
            return map;
        }else {
            map.put("delResult","false");
            return map;
        }
    }
    @RequestMapping("/toAdd")
    public String goAdd(){
        return "sysRole/add";
    }

    @RequestMapping("/codeExist")
    @ResponseBody
    public Map<String,Integer> codeExist(@RequestParam("code") Integer code){
        Map<String,Integer> map = new HashMap<>();
        try{
            Integer integer = sysRoleService.checkCode(code);
            if (integer>0){
                map.put("exist",1);
                return map;
            }else {
                map.put("exist",0);
                return map;
            }
        }catch (Exception e){
            map.put("exist",-1);
            return map;
        }
    }

    @RequestMapping("/add")
    public String sysRoleAdd(SysRole sysRole,HttpSession session){
        SysUser userSession = (SysUser) session.getAttribute("userSession");
        sysRole.setCreatedUserId(userSession.getId());
        sysRole.setCreatedTime(new Date());
        sysRoleService.sysRoleInsert(sysRole);
        return "redirect:/sys/role/list";
    }
}
