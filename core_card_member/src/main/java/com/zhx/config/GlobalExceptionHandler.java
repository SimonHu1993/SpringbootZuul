package com.zhx.config;

import com.zhx.common.AppWebLogAspect;
import com.zhx.common.ErrorCode;
import com.zhx.common.Result;
import com.zhx.common.exception.DecipherException;
import com.zhx.common.exception.IpNoAccessException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author: SimonHu
 * @Date: 2019/8/21 10:17
 * @Description:
 */
@ControllerAdvice
public class GlobalExceptionHandler {
    private Logger logger = LoggerFactory.getLogger(getClass().getName());
    @Autowired
    private AppWebLogAspect appWebLogAspect;
    
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Result jsonHandler(HttpServletRequest request, Exception e) throws Exception {
        if ("org.apache.catalina.connector.ClientAbortException".equals(e.getClass().getName())) {
            logger.error("发生clientAbortException");
            return null;
        }
        logger.error("--------------错误信息----------：", e);
        this.getErrrorInfo(e,ErrorCode.SYS_ERROR.getCode(), ErrorCode.SYS_ERROR.getMsg());
        return Result.error(ErrorCode.SYS_ERROR.getCode(), ErrorCode.SYS_ERROR.getMsg());
    }
    
    /**
     * @param request
     * @param e
     * @return com.zhx.common.Result
     * @Description:ip拦截访问
     * @Author:SimonHu
     * @Date: 2019/8/23 14:26
     */
    @ExceptionHandler(value = IpNoAccessException.class)
    @ResponseBody
    public Result accessException(HttpServletRequest request, IpNoAccessException e) {
        logger.error("--------------错误信息----------：", e);
        this.getErrrorInfo(e,e.getCode(), e.getMessage());
        return Result.error(e.getCode(), e.getMessage());
    }
    
    /**
     * @param request
     * @param e
     * @return com.zhx.common.Result
     * @Description:解密失败
     * @Author:SimonHu
     * @Date: 2019/8/23 15:02
     */
    @ExceptionHandler(value = DecipherException.class)
    @ResponseBody
    public Result decipherException(HttpServletRequest request, DecipherException e) {
        logger.error("--------------错误信息----------：", e);
        this.getErrrorInfo(e,e.getCode(), e.getMessage());
        return Result.error(e.getCode(), e.getMessage());
    }
    
    /**
     * @param ex
     * @return java.lang.String
     * @Description:获取错误信息并记录日志
     * @Author:SimonHu
     * @Date: 2019/8/26 16:04
     */
    private String getErrrorInfo(Exception ex,String code,String msg) {
        StringBuilder sb = new StringBuilder();
        logger.error("************************异常开始*******************************");
        StackTraceElement[] error = ex.getStackTrace();
        int i = 0;
        for (StackTraceElement stackTraceElement : error) {
            logger.error(String.valueOf(stackTraceElement));
            sb.append(stackTraceElement);
            i++;
            if (i >= 10) {
                break;
            }
        }
        logger.error("************************异常结束*******************************");
        String result = sb.toString() + "\r\n" + Result.error(code, msg).toString();
        appWebLogAspect.handleMethod(result, "10003", "");
        return sb.toString();
    }
}
