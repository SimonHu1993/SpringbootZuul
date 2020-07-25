package com.simonhu.common.exception;

import com.simonhu.common.ErrorCode;

/**
 * @Author: SimonHu
 * @Date: 2019/8/23 13:59
 * @Description:ip没有权限访问
 */
public class IpNoAccessException extends RuntimeException {
    private String code;
    
    /**
     * @return
     * @Description:无参构造函数
     * @Author:SimonHu
     * @Date: 2019/8/23 14:00
     */
    public IpNoAccessException() {
        super();
    }
    
    /**
     * @param message
     * @return
     * @Description:用详细信息指定一个异常
     * @Author:SimonHu
     * @Date: 2019/8/23 14:00
     */
    public IpNoAccessException(String message) {
        super(message);
        this.code = ErrorCode.ACCESS_ERROR.getCode();
    }
    
    public IpNoAccessException(String code, String message) {
        super(message);
        this.code = code;
    }
    
    /**
     * @param message
     * @param cause
     * @return
     * @Description:用指定的详细信息和原因构造一个新的异常
     * @Author:SimonHu
     * @Date: 2019/8/23 14:01
     */
    public IpNoAccessException(String message, Throwable cause) {
        super(message, cause);
    }
    
    /**
     * @param cause
     * @return
     * @Description:用指定原因构造一个新的异常
     * @Author:SimonHu
     * @Date: 2019/8/23 14:01
     */
    public IpNoAccessException(Throwable cause) {
        super(cause);
    }
    
    public String getCode() {
        return code;
    }
    
    public void setCode(String code) {
        this.code = code;
    }
}
