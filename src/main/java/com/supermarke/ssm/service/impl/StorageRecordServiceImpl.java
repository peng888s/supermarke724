package com.supermarke.ssm.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.supermarke.ssm.mapper.StorageRecordMapper;
import com.supermarke.ssm.pojo.StorageRecord;
import com.supermarke.ssm.service.StorageRecordService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service("storageRecordService")
public class StorageRecordServiceImpl implements StorageRecordService {

    @Resource
    private StorageRecordMapper storageRecordMapper;
    /**
     * 根据条件查询商品以及供货商信息
     *
     * @return
     */
    @Override
    public PageInfo conditionCommoditySupplier(Integer pn, String goodsName, Integer supplierId, Integer  payStatus) {
        PageHelper.startPage(pn,5);
        List<StorageRecord> storageRecords = storageRecordMapper.selectByNameOrIdOrType(goodsName, supplierId, payStatus);
        return new PageInfo<>(storageRecords);
    }

    /**
     * 获取商品及对应供货商信息
     * @param id
     * @return
     */
    @Override
    public StorageRecord getJoinInfoId(Integer id) {
        return storageRecordMapper.selectBySupplierId(id);
    }

    /**
     * 修改
     * @param storageRecord
     */
    @Override
    @Transactional
    public void updateStorageRecord(StorageRecord storageRecord) {
        storageRecordMapper.updateById(storageRecord);
    }

    /**
     * 添加
     * @param storageRecord
     */
    @Override
    @Transactional
    public void insertStorageRecord(StorageRecord storageRecord) {
        storageRecordMapper.insert(storageRecord);
    }

    /**
     * 删除
     * @param id 主键id
     * @return
     */
    @Override
    @Transactional
    public boolean deleteStorageRecord(Integer id) {
        int delete = storageRecordMapper.deleteBySrCode(id);
        return delete>0;
    }

    /**
     * 总记录数
     * @return
     */
    @Override
    public Long countStorageRecord() {
        return storageRecordMapper.count();
    }

    @Override
    public List<StorageRecord> getSupplierId(Integer id) {
        return storageRecordMapper.selectGetBySupplierId(id);
    }
}
