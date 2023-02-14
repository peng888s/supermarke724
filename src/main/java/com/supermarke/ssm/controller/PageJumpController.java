package com.supermarke.ssm.controller;

import com.supermarke.ssm.pojo.StorageRecord;
import com.supermarke.ssm.pojo.Supplier;
import com.supermarke.ssm.pojo.SysRole;
import com.supermarke.ssm.pojo.SysUser;
import com.supermarke.ssm.service.StorageRecordService;
import com.supermarke.ssm.service.SupplierService;
import com.supermarke.ssm.service.SysRoleService;
import com.supermarke.ssm.service.SysUserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * 页面跳转，controller
 */
@Controller
public class PageJumpController {
    @Resource(name = "sysUserService")
    private SysUserService sysUserService;
    @Resource(name = "supplierService")
    private SupplierService supplierService;
    @Resource(name = "storageRecordService")
    private StorageRecordService storageRecordService;
    @Resource(name = "sysRoleService")
    private SysRoleService sysRoleService;

    /**
     * 登录
     * @param account 登录名
     * @param password 密码
     * @param session 存入session会话
     * @param request 存入提示信息
     * @return
     */
    @RequestMapping("/loginJudgment")
    public String goLogin(String account, String password, HttpSession session, HttpServletRequest request){
        SysUser login = sysUserService.login(account, password);
        if (login != null) {
            if (login.getPassword().equals(password)){
                session.setAttribute("userSession",login);
                session.setMaxInactiveInterval(60*60*7*24);
                return "redirect:/frame";
            }else {
                throw new RuntimeException("密码输入错误❌");
            }
        }else {
            request.setAttribute("error","用户名或密码错误");
            return "login";
        }
    }

    /**
     * 跳转登录页面
     * @return
     */
    @RequestMapping("/sys/login")
    public String goLogin(){
        return "login";
    }

    @RequestMapping("/frame")
    public String frame(){
        return "frame";
    }

    // 跳转storageRecord/add.jsp + 查询全部供货商
    @RequestMapping("/sys/storageRecord/toAdd")
    public String storageRecordGoAdd(Model model){
        // 全部供货商
        List<Supplier> allInfo = supplierService.getAllInfo();
        model.addAttribute("suppLieList",allInfo);
        return "/storageRecord/add";
    }

    // 跳转storageRecord/update.jsp：查询商品信息 + 全部供货商
    @RequestMapping("/sys/storageRecord/toUpdate/{id}")
    public String storageRecordUpdate(@PathVariable("id") Integer id, Model model){
        // 商品信息
        StorageRecord joinInfoId = storageRecordService.getJoinInfoId(id);
        model.addAttribute("storageRecord",joinInfoId);
        // 全部供货商
        List<Supplier> allInfo = supplierService.getAllInfo();
        model.addAttribute("suppLieList",allInfo);
        return "storageRecord/update";
    }

    // 跳转supplier/update.jsp
    @RequestMapping("/sys/supplier/toUpdate/{id}")
    public String supplierUpdate(@PathVariable("id")Integer id,Model model){
        Supplier supplier = supplierService.getById(id);
        model.addAttribute("supplier",supplier);
        return "supplier/update";
    }

    // 跳转supplier/add.jsp
    @RequestMapping("/sys/supplier/toAdd")
    public String supplierAdd(){
        return "supplier/add";
    }

    // 跳转sysUser/add.jsp
    @RequestMapping("/sys/user/toAdd")
    public String sysUserAdd(Model model){
        // 全部角色
        List<SysRole> sysRoleList = sysRoleService.selectAll();
        model.addAttribute("sysRoleList",sysRoleList);
        return "sysUser/add";
    }

    // 修改密码
    @RequestMapping("/sys/user/toUpdatePwd")
    public String updatePassword(){
        return "sysUser/updatePassword";
    }

    // 退出
    @RequestMapping("/logout")
    public String index(HttpSession session){
        session.removeAttribute("userSession");
        session.invalidate();
        return "redirect:/";
    }
}
