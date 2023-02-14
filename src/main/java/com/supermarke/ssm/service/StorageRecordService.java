package com.supermarke.ssm.service;

import com.github.pagehelper.PageInfo;
import com.supermarke.ssm.pojo.StorageRecord;

import java.util.List;

public interface StorageRecordService {

    /**
     * 根据条件查询商品以及供货商信息
     *
     * @return
     */
    PageInfo conditionCommoditySupplier(Integer pn, String goodsName, Integer supplierId, Integer  payStatus);

    /**
     * 获取商品及对应供货商信息
     * @param id
     * @return
     */
    StorageRecord getJoinInfoId(Integer id);

    /**
     * 修改
     * @param id
     */
    void updateStorageRecord(StorageRecord storageRecord);

    /**
     * 添加
     * @param storageRecord
     */
    void insertStorageRecord(StorageRecord storageRecord);

    /**
     * 删除
     * @param id 主键id
     * @return
     */
    boolean deleteStorageRecord(Integer id);

    /**
     * 总记录数
     * @return
     */
    Long countStorageRecord();

    List<StorageRecord> getSupplierId(Integer id);
}