package com.zhx.common;

import com.zhx.common.exception.IpNoAccessException;
import com.zhx.util.IpUtil;
import com.zhx.web.merchant.service.MerchantService;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * @Author: SimonHu
 * @Date: 2019/8/23 13:55
 * @Description:
 */
@Service
public class IPWhiteUtil {
    private static final Logger logger = LoggerFactory.getLogger(IPWhiteUtil.class);
    @Autowired
    private MerchantService merchantService;
    
    public boolean isAccess(HttpServletRequest request) {
        String ip = IpUtil.getIpAddr(request);
        logger.info("------------您的ip地址：{}----------------------------" ,ip);
        if (StringUtils.isEmpty(ip)) {
            throw new IpNoAccessException("获取不到ip");
        } else {
            Map result = merchantService.sysConfigInfo(Constants.CONFIG_IP);
            if(result == null || result.isEmpty() || "0".equals(String.valueOf(result.get("value1")))){
                return true;
            }
            String ipString = String.valueOf(result.get("value4"));
            String[] ipList = ipString.split(",");
            List<String> list = Arrays.asList(ipList);
            if (list.contains(ip)) {
                return true;
            }
            throw new IpNoAccessException("ip不在白名单内:::" + ip);
        }
    }
}
