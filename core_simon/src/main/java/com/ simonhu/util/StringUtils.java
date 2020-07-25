package com.simonhu.util;

import java.util.Map;

/**
 * Created by admin on 2016/11/25.
 */
public class StringUtils {


    /**
     * 从中间掩码 (目前掩码只支持偶数)
     * @param obj
     * @return
     */
    public static String hiddeMiddleString(String obj, int hiddenNum){
        int objLength = obj.length();
        int startCut = (objLength/2)-hiddenNum/2;
        int endCut = (objLength/2)+hiddenNum/2;
        String star="";
        for(int i=0;i<hiddenNum;i++){
            star = star + "*";
        }
        String result = obj.substring(0,startCut) + star + obj.substring(endCut, obj.length());
        return result;
    }

    /**
     * 取字符串最后x位
     * @param obj
     * @param lastNum
     * @return
     */
    public static String showlastNums(String obj, int lastNum){
        int objLength = obj.length();
        int startCut = objLength - lastNum;
        int endCut = obj.length();
        String result = obj.substring(startCut,endCut);
        return result;
    }


    /**
     * 隐藏银行卡号中间数位
     * @param string
     * @return
     */
    public static String hideBankAccountNo(String string){
        StringBuilder sb = new StringBuilder();
        return sb.append(string.substring(0,3))
                .append("********")
                .append(string.substring(string.length()-4,string.length()))
                .toString();
    }


    /**
     * 有效手机号码验证
     * @param phoneNo
     * @return
     */
    public static boolean isMobileNum(String phoneNo) {
        if (null == phoneNo) {
            return false;
        }
        return phoneNo.matches("^((13[0-9])|(14[4,7])|(15[^4,\\D])|(17[6-8])|(18[0-9]))(\\d{8})$");
    }

    /**
     * 银行账号验证16-22位
     * @param bankCardNo
     * @return
     */
    public static boolean isBankCardNo(String bankCardNo){
        if (null == bankCardNo) {
            return false;
        }
        return bankCardNo.matches("^\\d{16,22}$");
    }

    /**
     * 空值校验
     * @param string
     * @return
     */
    public static boolean isBlank(String string){
        if(string == null || "".equals(string)){
            return true;
        }
        return false;
    }

    /**
     * 多个参数中是否有空值
     * @param args
     * @return
     */
    public static boolean hasBlank(String... args){
        for (String str : args){
            if (isBlank(str)) return true;
        }
        return false;
    }

    /**
     * 多个参数中是否有空值并且返回具体哪个参数为空
     * @param params
     * @return
     */
    public static String hasBlankAndReport(Map params, String[] necessaryParams){
        for(int i=0;i<necessaryParams.length;i++){
            if (isBlank((String) params.get(necessaryParams[i])))
                return necessaryParams[i];
        }
        return "success";
    }

    /**
     * 保留手机号前三和后四位
     * @param phoneNo
     * @return
     */
    public static String nickPhoneNo(String phoneNo){
        return phoneNo.substring(0, 3) + "****" + phoneNo.substring(phoneNo.length() - 4, phoneNo.length());
    }


    /**
     * 将null转换为空值
     * @param data
     * @return
     */
    public static String putNulltoEmpty(String data){
        if(data==null){
            return "";
        }
        else{
            return data;
        }
    }

}
