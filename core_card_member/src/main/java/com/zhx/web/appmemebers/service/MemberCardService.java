package com.zhx.web.appmemebers.service;

import com.zhx.util.JsonUtils;
import com.zhx.web.appmemebers.mapper.MemberCardMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: SimonHu
 * @Date: 2019/8/20 9:18
 * @Description:
 */
@Service
public class MemberCardService {
    private static final Logger logger = LoggerFactory.getLogger(MemberCardService.class);
    @Autowired
    private MemberCardMapper memberCardMapper;
    
    /**
     * @param cardCode
     * @param requestId
     * @return com.zhx.common.Result
     * @Description:查询卡信息
     * @Author:SimonHu
     * @Date: 2019/8/20 10:46
     */
    public Map checkCardInfo(String cardCode, String requestId) {
        try {
            Map param = new HashMap(16);
            param.put("cardCode", cardCode);
            param.put("requestId", requestId);
            Map procedureMap = new HashMap();
            procedureMap.put("p_in_str", JsonUtils.toJson(param));
            procedureMap.put("p_out_str", "");
            memberCardMapper.checkCardInfo(procedureMap);
            Map resMap = JsonUtils.toObject(String.valueOf(procedureMap.get("p_out_str")), HashMap.class);
            return resMap;
        } catch (Exception e) {
            logger.error("========查询卡信息错误===========",e);
            return null;
        }
    }
    
    /**
     * @param requestId
     * @param cardCode
     * @param activeOrderNo
     * @return java.util.Map
     * @Description:卡核销
     * @Author:SimonHu
     * @Date: 2019/8/20 11:21
     */
    public Map verificationCard(String cardCode, String activeOrderNo, String requestId) {
        try {
            Map param = new HashMap(16);
            param.put("requestId", requestId);
            param.put("cardCode", cardCode);
            param.put("activeOrderNo", activeOrderNo);
            Map procedureMap = new HashMap();
            procedureMap.put("p_in_str", JsonUtils.toJson(param));
            procedureMap.put("p_out_str", "");
            memberCardMapper.verificationCard(procedureMap);
            Map resMap = JsonUtils.toObject(String.valueOf(procedureMap.get("p_out_str")), HashMap.class);
            return resMap;
        } catch (Exception e) {
            logger.error("========卡核销错误===========",e);
            return null;
        }
    }
    
    /**
     * @param requestId
     * @param activeOrderNo
     * @return java.util.Map
     * @Description:卡核销查询
     * @Author:SimonHu
     * @Date: 2019/8/20 15:38
     */
    public Map verificationCardCheck(String requestId, String activeOrderNo) {
        try {
            Map param = new HashMap(16);
            param.put("requestId", requestId);
            param.put("activeOrderNo", activeOrderNo);
            Map procedureMap = new HashMap();
            procedureMap.put("p_in_str", JsonUtils.toJson(param));
            procedureMap.put("p_out_str", "");
            memberCardMapper.verificationCardCheck(procedureMap);
            Map resMap = JsonUtils.toObject(String.valueOf(procedureMap.get("p_out_str")), HashMap.class);
            return resMap;
        } catch (Exception e) {
            logger.error("========卡核销查询错误===========",e);
            return null;
        }
    }
}
