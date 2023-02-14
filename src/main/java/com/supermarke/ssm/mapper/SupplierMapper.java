package com.supermarke.ssm.mapper;

import com.supermarke.ssm.pojo.Supplier;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface SupplierMapper {
    /**
     * 全部供货商信息
     * @return
     */
    List<Supplier> selectAll();

    /**
     * 查询单条记录
     */
    Supplier selectById(@Param("id") Integer id);

    /**
     *
     * @return
     */
    List<Supplier> selectByIdSupplier(@Param("ids")Integer[] id);

    /**
     * 入库单码模糊匹配
     * @param supCodes
     * @return
     */
    List<Supplier> selectByIdMap(@Param("querySupCode") String querySupCode,@Param("querySupName") String querySupName);

    int update(Supplier supplier);

    int delete(Integer id);

    int insert(Supplier supplier);
}
