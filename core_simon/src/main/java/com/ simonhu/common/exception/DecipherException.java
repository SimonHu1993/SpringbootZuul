package com.simonhu.common.exception;

/**
 * @Author: SimonHu
 * @Date: 2019/8/23 14:57
 * @Description:
 */
public class DecipherException extends RuntimeException {
    private String code;
    
    /**
     * @return
     * @Description:无参构造函数
     * @Author:SimonHu
     * @Date: 2019/8/23 14:00
     */
    public DecipherException() {
        super();
    }
    
    /**
     * @param message
     * @return
     * @Description:用详细信息指定一个异常
     * @Author:SimonHu
     * @Date: 2019/8/23 14:00
     */
    public DecipherException(String message) {
        super(message);
    }
    
    public DecipherException(String code, String message) {
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
    public DecipherException(String message, Throwable cause) {
        super(message, cause);
    }
    
    /**
     * @param cause
     * @return
     * @Description:用指定原因构造一个新的异常
     * @Author:SimonHu
     * @Date: 2019/8/23 14:01
     */
    public DecipherException(Throwable cause) {
        super(cause);
    }
    
    public String getCode() {
        return code;
    }
    
    public void setCode(String code) {
        this.code = code;
    }
}
