package com.simonhu.web.appmemebers.controller;

import com.simonhu.common.AppWebLogAspect;
import com.simonhu.common.Result;
import com.simonhu.web.appmemebers.service.MemberCardService;
import com.simonhu.web.merchant.service.MerchantService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author: SimonHu
 * @Date: 2019/8/20 9:07
 * @Description:
 */
@Controller
@RequestMapping("/memberCard")
public class MemberCardController {
    private static final Logger logger = LoggerFactory.getLogger(MemberCardController.class);
    @Autowired
    private MerchantService merchantService;
    @Autowired
    private MemberCardService memberCardService;
    @Autowired
    private AppWebLogAspect appWebLogAspect;
    
    /**
     * @param merchantID
     * @param data
     * @param sign
     * @param keyPass
     * @param request
     * @return com.simonhu.common.Result
     * @Description:卡信息查询
     * @Author:SimonHu
     * @Date: 2019/8/20 9:17
     */
    @RequestMapping(value = "/call", produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public Result call(@RequestParam(value = "merchantID", required = true) String merchantID,
                       @RequestParam(value = "data", required = true) String data,
                       @RequestParam(value = "sign", required = true) String sign,
                       @RequestParam(value = "keyPass", required = true) String keyPass,
                       HttpServletRequest request) throws Exception {
        
        return Result.success();
    }
}
