package com.zhx.util;

import org.apache.commons.lang3.StringUtils;

public class CheckUtils {


    /**
     * 检查请求参数是否为空或null字符串
     * @param strings
     * @return
     */
    public static boolean checkParam(String... strings){
        for (String str:strings) {
            if(StringUtils.isEmpty(str) || "null".equals(str)){
                return false;
            }
        }
        return true;
    }


}
