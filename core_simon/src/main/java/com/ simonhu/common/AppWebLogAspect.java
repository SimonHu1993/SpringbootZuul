package com.simonhu.common;

import com.simonhu.util.DateUtil;
import com.simonhu.util.IpUtil;
import com.simonhu.util.JsonUtils;
import com.simonhu.web.logrecord.service.LogService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

@Aspect
@Configuration
public class AppWebLogAspect {
    private static final Logger log = LoggerFactory.getLogger(AppWebLogAspect.class);
    @Autowired
    private LogService logService;
    
    @Pointcut("execution(* com.simonhu.*.*.controller.*.*(..))")
    public void controllerAspect() {
    }
    
    /**
     * @param joinPoint
     * @return void
     * @Description:前置通知
     * @Author:SimonHu
     * @Date: 2019/8/22 8:57
     */
    @Before(value = "controllerAspect()")
    public void beforeMethod(JoinPoint joinPoint) {
    }
    
    /**
     * @param joinpoint
     * @param result
     * @return void
     * @Description:后置通知
     * @Author:SimonHu
     * @Date: 2019/8/22 8:56
     */
    @AfterReturning(value = "controllerAspect()", returning = "result")
    public void afterReturnning(JoinPoint joinpoint, Object result) throws Throwable {
        this.handleMethod(JsonUtils.toJsonNf(result),"10002","");
    }
    /**
      * @Description:获取请求参数
      * @Author:SimonHu
      * @Date: 2019/8/22 9:00
      * @param result
      * @param logType
      * @param requestPlaintext 请求明文
      * @return void
      */
    public void handleMethod(String result,String logType,String requestPlaintext) {
        RequestAttributes ra = RequestContextHolder.getRequestAttributes();
        ServletRequestAttributes sra = (ServletRequestAttributes) ra;
        HttpServletRequest request = sra.getRequest();
        Map ParameterMap = request.getParameterMap();
        Map reqMap = new HashMap();
        Set<Map.Entry<String, String[]>> entry = ParameterMap.entrySet();
        Iterator<Map.Entry<String, String[]>> it = entry.iterator();
        while (it.hasNext()) {
            Map.Entry<String, String[]> me = it.next();
            String key = me.getKey();
            String value = me.getValue()[0];
            reqMap.put(key, value);
        }
        String url = request.getRequestURL().toString();
        String method = request.getMethod();
        String queryString = JsonUtils.toJsonNf(reqMap);
        String resultStr = result;
        log.info("*********************请求开始**********************");
        log.info("请求url: {}", url);
        log.info("请求方法: {}", method);
        log.info("请求参数: {}", queryString);
        log.info("返回值: " + resultStr);
        log.info("*********************请求结束**********************");
        //记录appLog
        Map appLog = new HashMap();
        appLog.put("requestUrl", url);
        appLog.put("requestStr", queryString);
        appLog.put("requestTime", DateUtil.formatDate(new Date(), DateUtil.PATTERN_WHOLE));
        appLog.put("responstStr", resultStr);
        appLog.put("logType", logType);
        appLog.put("requestPlaintext", requestPlaintext);
        appLog.put("serverIp", IpUtil.getIpAddr(request));
        logService.insertLog(appLog);
    }
}
