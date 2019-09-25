package com.zhx.web.merchant.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.Map;

/**
 * @Author: SimonHu
 * @Date: 2019/8/20 10:01
 * @Description:
 */
@Mapper
@Repository
public interface MerchantMapper {
    /**
      * @Description:查询app会员商户信息
      * @Author:SimonHu
      * @Date: 2019/8/20 16:21
      * @param merchantId
      * @return java.util.Map<java.lang.String,java.lang.String>
      */
    Map<String,String> findAppCardMerchantById(@Param("MerchantID")String merchantId);
    
    Map sysConfig(@Param("configType")String configType);
    
    void insertRequestId(Map param);
}
