package com.supermarke.ssm.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.supermarke.ssm.mapper.SupplierMapper;
import com.supermarke.ssm.pojo.Supplier;
import com.supermarke.ssm.service.SupplierService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service("supplierService")
public class SupplierServiceImpl implements SupplierService {

    @Resource
    private SupplierMapper supplierMapper;

    @Override
    public Supplier getById(Integer id){
        return supplierMapper.selectById(id);
    }

    /**
     * 查询全部供货商信息
     * @return
     */
    @Override
    public List<Supplier> getAllInfo() {
        return supplierMapper.selectAll();
    }

    /**
     * 模糊查询
     * @param pn
     * @param querySupCode
     * @param querySupName
     * @return
     */
    @Override
    public PageInfo<Supplier> selectByIdMap(Integer pn,String querySupCode,String querySupName) {
        PageHelper.startPage(pn,5);
        List<Supplier> suppliers = supplierMapper.selectByIdMap(querySupCode, querySupName);
        return new PageInfo<>(suppliers);
    }

    @Override
    @Transactional
    public void updateSupplier(Supplier supplier) {
        supplierMapper.update(supplier);
    }

    @Override
    @Transactional
    public boolean deleteSupplier(Integer id) {
        int delete = supplierMapper.delete(id);
        return delete>0;
    }

    @Override
    @Transactional
    public void insertSupplier(Supplier supplier) {
        supplierMapper.insert(supplier);
    }
}
