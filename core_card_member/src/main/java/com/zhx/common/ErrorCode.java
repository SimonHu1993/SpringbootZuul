package com.zhx.common;

/**
 * @Author: SimonHu
 * @Date: 2019/8/21 15:47
 * @Description:
 */
public enum ErrorCode {
    ACCESS_ERROR("403", "访问被禁止"),
    DECIPHER_FAIL("208", "解密失败"),
    BUSSINESSTYPE_NULL("207", "bussinessType不能为空"),
    REQUEST_ID_NULL("206", "requestId不能为空"),
    REQUEST_DOUBLE("205", "提交请求重复"),
    REQUEST_FAIL("204", "查询信息失败"),
    SIGN_ERROR("203", "签名错误"),
    PARAM_NOT_FULL("202", "请求参数不全"),
    SYS_ERROR("201", "系统错误");
    
    ErrorCode(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }
    
    public static String getCodeInfo(String code) {
        for (ErrorCode info : ErrorCode.values()) {
            if (code.equals(info.getCode())) {
                return info.getMsg();
            }
        }
        return "其他错误";
    }
    
    private String code;
    private String msg;
    
    @Override
    public String toString() {
        return "ErrorCodeEnum{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                '}';
    }
    
    public String getCode() {
        return code;
    }
    
    public void setCode(String code) {
        this.code = code;
    }
    
    public String getMsg() {
        return msg;
    }
    
    public void setMsg(String msg) {
        this.msg = msg;
    }
    
    public static void main(String[] args) {
        System.out.println(ErrorCode.REQUEST_FAIL.getCode());
        System.out.println(ErrorCode.REQUEST_FAIL.getMsg());
    }
}

