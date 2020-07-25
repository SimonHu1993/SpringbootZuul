package com.simonhu.interceptor;

import com.simonhu.common.IPWhiteUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Author: SimonHu
 * @Date: 2019/8/21 17:37
 * @Description:请求拦截器
 */
@Component
public class RequestInterceptor implements HandlerInterceptor {
    private static final Logger logger = LoggerFactory.getLogger(RequestInterceptor.class);
    @Autowired
    private IPWhiteUtil ipWhiteUtil;
    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        if(ipWhiteUtil.isAccess(httpServletRequest)){
            return true;
        };
        return false;
    }
    
    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {
    }
    
    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {
    }
    
}
