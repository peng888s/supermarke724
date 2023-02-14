package com.supermarke.ssm.mapper;

import com.supermarke.ssm.pojo.Address;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AddressMapper {

    /**
     * 根据用户id查询地址
     * @param userId
     * @return
     */
    List<Address> selectByUserId(@Param("userId") Integer userId);
}
