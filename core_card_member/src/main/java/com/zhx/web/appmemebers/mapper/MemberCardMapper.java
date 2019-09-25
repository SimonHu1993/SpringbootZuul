package com.zhx.web.appmemebers.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.Map;

/**
 * @Author: SimonHu
 * @Date: 2019/8/20 9:18
 * @Description:
 */
@Mapper
@Repository
public interface MemberCardMapper {
    /**
     * @param param
     * @return void
     * @Description:查询卡信息
     * @Author:SimonHu
     * @Date: 2019/8/20 15:35
     */
    void checkCardInfo(Map param);
    
    /**
     * @param param
     * @return void
     * @Description:卡核销
     * @Author:SimonHu
     * @Date: 2019/8/20 15:35
     */
    void verificationCard(Map param);
    
    /**
     * @param param
     * @return void
     * @Description:卡核销查询
     * @Author:SimonHu
     * @Date: 2019/8/20 15:36
     */
    void verificationCardCheck(Map param);
}
