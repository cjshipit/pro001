package com.li.returnJson;

/**
 * @Description:
 * @Auther: Li
 * @Version: 1.0
 */
//这个类很关键 是和前端进行交互的重要的类 我们向前端返回时
// 要把状态码返回过去 让前端知道


public class ReturnObject {
    private Integer code = 200;
    private String message = "";
    private Object result;
    public ReturnObject() {
    }

    public ReturnObject(Object result) {
        this.result = result;
    }

    public ReturnObject(String message, Object result) {
        this.message = message;
        this.result = result;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getResult() {
        return result;
    }

    public void setResult(Object result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return "ReturnObject{" +
                "code=" + code +
                ", message='" + message + '\'' +
                ", result=" + result +
                '}';
    }





}
