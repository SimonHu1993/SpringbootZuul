package com.zhx.common;

/**
 * Created by admin on 2017/2/16.
 */
public class Result<T> {
    //状态码
    private String result;
    //提示信息
    private String msg;
    private T data;
    
    public static Result success() {
        return success(null);
    }
    
    public static <S> Result success(S s) {
        Result<S> result = new Result();
        result.setResult("000");
        result.setMsg("success");
        result.setData(s);
        return result;
    }
    
    public static Result error() {
        return error("201", "fail");
    }
    
    public static Result error(String result, String msg) {
        Result res = new Result();
        res.setResult(result);
        res.setMsg(msg);
        res.setData(null);
        return res;
    }
    
    public String getResult() {
        return result;
    }
    
    public void setResult(String result) {
        this.result = result;
    }
    
    public String getMsg() {
        return msg;
    }
    
    public void setMsg(String msg) {
        this.msg = msg;
    }
    
    public T getData() {
        return data;
    }
    
    public void setData(T data) {
        this.data = data;
    }
    
    @Override
    public String toString() {
        return "Result{" +
                "result='" + result + '\'' +
                ", msg='" + msg + '\'' +
                ", data=" + data +
                '}';
    }
}
