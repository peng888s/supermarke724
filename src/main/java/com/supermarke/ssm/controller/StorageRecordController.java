package com.supermarke.ssm.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.supermarke.ssm.pojo.StorageRecord;
import com.supermarke.ssm.pojo.Supplier;
import com.supermarke.ssm.pojo.SysUser;
import com.supermarke.ssm.service.StorageRecordService;
import com.supermarke.ssm.service.SupplierService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.thymeleaf.expression.Lists;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/sys/storageRecord")
public class StorageRecordController {

    @Resource(name = "storageRecordService")
    private StorageRecordService storageRecordService;
    @Resource(name = "supplierService")
    private SupplierService supplierService;

    // 所有入库记录信息，list.jsp
    @RequestMapping("/list/{pn}")
    public String allStorageRecord(@PathVariable("pn") Integer pn, String queryGoodsName, Integer querySupplierId, Integer queryPayStatus, Model model){
        // 全部商品以及对应供货商信息
        PageInfo pageInfo = storageRecordService.conditionCommoditySupplier(pn, queryGoodsName, querySupplierId, queryPayStatus);
        List storageRecords = pageInfo.getList();
        model.addAttribute("storageRecordList",storageRecords);
        model.addAttribute("pageInfo",pageInfo);

        // 全部供货商信息
        List<Supplier> allInfo = supplierService.getAllInfo();
        model.addAttribute("supplierList",allInfo);
        return "/storageRecord/list";
    }

    // 查询view.jsp：商品信息 + 商品对应供货商
    @RequestMapping(value = {"/view/{id}"})
    public String showInfo(@PathVariable("id") Integer id, Model model){
        StorageRecord joinInfoId = storageRecordService.getJoinInfoId(id);
        model.addAttribute("storageRecord",joinInfoId);
        return "storageRecord/view";
    }

    // 添加add.jsp
    @RequestMapping("/add")
    public String storageRecordAdd(StorageRecord storageRecord, HttpSession session){
        Date queueDate = new Date();
        storageRecord.setCreatedTime(queueDate);

        SysUser userSession = (SysUser) session.getAttribute("userSession");
        storageRecord.setCreatedUserId(userSession.getId());

        storageRecordService.insertStorageRecord(storageRecord);
        return "redirect:/sys/storageRecord/list/1";
    }

    // 修改
    @RequestMapping(
            value = "/update",
            method = RequestMethod.POST
    )
    public String updateStorageRecord(StorageRecord storageRecord){
        storageRecordService.updateStorageRecord(storageRecord);
        return "redirect:/sys/storageRecord/list/1";
    }

    // 删除
    @RequestMapping(value = {"/del/{id}"})
    @ResponseBody
    public Map<String,String> deleteStorageRecord(@PathVariable("id") Integer id){
        boolean record = storageRecordService.deleteStorageRecord(id);
        Map<String,String> map = new HashMap<>();
        if (record){
            map.put("delResult","true");
            return map;
        }else {
            map.put("delResult","false");
            return map;
        }
    }

    ///sys/storageRecord/del/
}
