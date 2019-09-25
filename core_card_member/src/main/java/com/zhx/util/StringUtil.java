package com.zhx.util;

import java.util.ArrayList;
import java.util.Map;
import java.util.Set;

/**
 * 用于校验字符串工具类
 * Created by admin on 2017/3/16.
 */
public class StringUtil {

    /**
     * 字符串不为null且非空串
     */
    public static boolean isBlank(Object obj){
        if(obj == null || "".equals(obj)){
            return true;
        }
        return false;
    }
    /**
     * 多个参数中存在空值
     */
    public static boolean hasBlankParam(Object ...objects){
        for (Object obj : objects){
            if(obj == null || "".equals(obj)){
                return true;
            }
        }
        return false;
    }

    /**
     * map中参数中存在空值,并且返回空值的引用名
     */
    public static ArrayList hasBlankAndReturnName(Map param){
        ArrayList<String> keys = new ArrayList<>();
        Set<Object> keySet = param.keySet();
        for (Object obj : keySet){
            String keyValue = obj.toString();
            if(isBlank(param.get(keyValue))){
               keys.add(keyValue);
            }
        }
        return keys;
    }

    public static boolean isNotEmpty(String str) {
        return ((str != null) && (str.length() > 0));
    }

    /**
     * 从中间掩码 (目前掩码只支持偶数)
     *
     * @param obj
     * @return
     */
    public static String hiddeMiddleString(String obj, int hiddenNum) {
        int objLength = obj.length();
        int startCut = (objLength / 2) - hiddenNum / 2;
        int endCut = (objLength / 2) + hiddenNum / 2;
        String star = "";
        for (int i = 0; i < hiddenNum; i++) {
            star = star + "*";
        }
        String result = obj.substring(0, startCut) + star + obj.substring(endCut, obj.length());
        return result;
    }

    /**
     * 截取卡号前四位和后四位、中间用*代替
     * @param cardNo
     * @return
     */
    public static String hiddenMiddleCardString(String cardNo){
        StringBuilder builder = new StringBuilder();
        if(isBlank(cardNo)){
            return "";
        }else{
            int length = cardNo.length();
            String part1 = cardNo.substring(0,4);
            String part2 = cardNo.substring(cardNo.length() - 4, cardNo.length());
            if(length==16){
                builder.append(part1).append("********").append(part2);
            }else if(length==18){
                builder.append(part1).append("**********").append(part2);
            }
        }
        return builder.toString();
    }
    /**
     * 隐藏手机号中间6位
     */
    public static String nickPhoneNo(String phoneNo){
        if(phoneNo == null || "".equals(phoneNo)){
            return null;
        }
        StringBuilder sb = new StringBuilder();
        String part1 = phoneNo.substring(0,3);
        String part2 = phoneNo.substring(phoneNo.length() - 4, phoneNo.length());
        return sb.append(part1).append("******").append(part2).toString();
    }
    /**
     * 校验位数是否为x位
     */
    public static boolean checkStrNum(String str,int num){
        if(isBlank(str)){
            return false;
        }
        return str.length() == num;
    }
    public static boolean illegalParam(String str,int num){
        if(isBlank(str)){
            return true;
        }
        return !(str.length() == num);
    }

    /**
     * 非法手机号验证
     * @param phoneNo
     * @return true 非法
     */
    public static boolean illagelPhoneNo(String phoneNo) {
        if (null == phoneNo) {
            return true;
        }
        return !phoneNo.matches("^((13[0-9])|(14[4,7])|(15[^4,\\D])|(17[6-8])|(18[0-9]))(\\d{8})$");
    }
    /**每隔多少位增加空格*/
    public static String splitStrwithEmpty(String string,int num){
        if (isBlank(string)){
            return "";
        }
        if (num <= 0){
            return string;
        }
        StringBuilder str = new StringBuilder(string.replace(" ",""));

        int i = str.length() / num;
        int j = str.length() % num;

        for (int x = (j == 0 ? i - 1 : i); x > 0; x--) {
            str = str.insert(x * 4," ");
        }

        return str.toString();
    }


}
