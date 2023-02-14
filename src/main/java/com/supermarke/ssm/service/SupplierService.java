package com.supermarke.ssm.service;

import com.github.pagehelper.PageInfo;
import com.supermarke.ssm.pojo.Supplier;

import java.util.List;
import java.util.Map;

public interface SupplierService {

    /**
     * 更具id查询供货商信息
     * @param id
     * @return
     */
    Supplier getById(Integer id);

    /**
     * 查询全部供货商信息
     * @return
     */
    List<Supplier> getAllInfo();

    /**
     * 模糊查询
     * @param supCodes
     * @return
     */
    PageInfo<Supplier> selectByIdMap(Integer pn,String querySupCode,String querySupName);

    /**
     * 修改供货商信息
     * @param supplier
     */
    void updateSupplier(Supplier supplier);

    /**
     * 删除
     * @param id
     */
    boolean deleteSupplier(Integer id);

    /**
     * 添加
     * @param supplier
     */
    void insertSupplier(Supplier supplier);
}
