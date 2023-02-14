package com.supermarke.ssm.controller;

import com.github.pagehelper.PageInfo;
import com.supermarke.ssm.pojo.StorageRecord;
import com.supermarke.ssm.pojo.Supplier;
import com.supermarke.ssm.pojo.SysUser;
import com.supermarke.ssm.service.StorageRecordService;
import com.supermarke.ssm.service.SupplierService;
import org.springframework.context.expression.MapAccessor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/sys/supplier")
public class SupplierController {

    @Resource(name = "storageRecordService")
    private StorageRecordService storageRecordService;

    @Resource(name = "supplierService")
    private SupplierService supplierService;

    // supplier/list.jsp：供货商全部信息 + 模糊查询
    @RequestMapping("/list/{pn}")
    public String supplier(@PathVariable("pn")Integer pn, Model model, String querySupCode, String querySupName){
        // 全部供货商信息
        PageInfo<Supplier> pageInfo = supplierService.selectByIdMap(pn, querySupCode, querySupName);
        List<Supplier> supplierList = pageInfo.getList();
        model.addAttribute("supplierList",supplierList);
        model.addAttribute("pageInfo",pageInfo);
        return "supplier/list";
    }

    // view.jsp：根据id查询供货商信息
    @RequestMapping("/view/{id}")
    public String view(@PathVariable("id")Integer id,Model model){
        Supplier supplier = supplierService.getById(id);
        model.addAttribute("supplier",supplier);
        return "supplier/view";
    }

    // update.jsp：修改
    @RequestMapping("/update")
    public String update(Supplier supplier, HttpSession session){
        // 修改时间 + 修改人id
        // update###执行更新时出错###原因：java.lang.IllegalArgumentException:比较无效：java.util.Date日期和java.lang.String
        Date date = new Date();
        supplier.setUpdatedTime(date);
        SysUser sys = (SysUser) session.getAttribute("userSession");
        supplier.setUpdatedUserId(sys.getId());
        supplierService.updateSupplier(supplier);
        return "redirect:/sys/supplier/list/1";
    }

    // 删除：主键id
    @RequestMapping("/del/{id}")
    @ResponseBody
    public Map<String,String> delete(@PathVariable("id") Integer id, Model model){
        List<StorageRecord> storageRecordList = storageRecordService.getSupplierId(id);
        if (storageRecordList.size() != 0){
            model.addAttribute("storageRecord",storageRecordList);
            return null;
        }
        boolean flag = supplierService.deleteSupplier(id);
        Map<String,String> map = new HashMap<>();
        if (flag){
            map.put("delResult","true");
            return map;
        }else {
            map.put("delResult","false");
            return map;
        }
//        return "redirect:/sys/supplier/list/1";
    }

    // 添加
    @RequestMapping("/add")
    public String add(Supplier supplier,HttpSession session){
        SysUser sys = (SysUser) session.getAttribute("userSession");
        supplier.setCreatedUserId(sys.getId());
//        supplier.setCreatedTime(new Date());
        supplierService.insertSupplier(supplier);
        return "redirect:/sys/supplier/list/1";
    }


}
