package com.zhx.web.logrecord.service;

import com.zhx.web.logrecord.mapper.LogMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @Author: SimonHu
 * @Date: 2019/8/21 17:43
 * @Description:
 */
@Service
public class LogService {
    private static final Logger logger = LoggerFactory.getLogger(LogService.class);
    @Autowired
    private LogMapper logMapper;
    
    /**
      * @Description:插入日志
      * @Author:SimonHu
      * @Date: 2019/8/21 17:52
      * @param param
      * @return void
      */
    @Async
    public void insertLog(Map param){
        logMapper.insertLog(param);
    }
}
