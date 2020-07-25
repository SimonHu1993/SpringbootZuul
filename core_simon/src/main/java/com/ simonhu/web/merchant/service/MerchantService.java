package com.simonhu.web.merchant.service;

import com.simonhu.web.merchant.mapper.MerchantMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: SimonHu
 * @Date: 2019/8/20 10:01
 * @Description:
 */
@Service
public class MerchantService {
    private static final Logger logger = LoggerFactory.getLogger(MerchantService.class);
    @Autowired
    private MerchantMapper merchantMapper;
    
    /**
     * @param requestId
     * @return int
     * @Description:插入请求id
     * @Author:SimonHu
     * @Date: 2019/9/23 17:47
     */
    public long insertRequestId(String requestId) {
        Map param = new HashMap();
        param.put("requestId", requestId);
        long i = 0;
        try {
            merchantMapper.insertRequestId(param);
            i = (long) param.get("id");
        } catch (Exception e) {
            logger.error("----insertRequestId-------:", e);
            i = 0;
        }
        return i;
    }
    
    @Cacheable(value = "merchantDetail")
    public Map checkMerchantInfo(String merchantID) {
        Map<String, String> map = merchantMapper.findAppCardMerchantById(merchantID);
        logger.info("------商户详情从数据库中获取-----:{}", map);
        return map;
    }
    
    /**
     * @param configType
     * @return java.util.Map
     * @Description:查询配置信息
     * @Author:SimonHu
     * @Date: 2019/8/23 13:44
     */
    @Cacheable(value = "selConfig")
    public Map sysConfigInfo(String configType) {
        Map result = merchantMapper.sysConfig(configType);
        logger.info("------配置从数据库中获取-----:{}", result);
        return result;
    }
}
