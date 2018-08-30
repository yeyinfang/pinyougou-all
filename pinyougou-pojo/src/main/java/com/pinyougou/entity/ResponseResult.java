package com.pinyougou.entity;

import java.io.Serializable;

/**
 * @program: pinyougou-all
 * @description: 就是返回结果的
 * @author: YF
 * @create: 2018-08-29 19:42
 **/
public class ResponseResult<T> implements Serializable {
    private int status;//状态
    private String message;//返回的信息
    private T data;//要返回的数据
    //构造函数
    public ResponseResult(int status, String message, T data) {
        this.status = status;
        this.message = message;
        this.data = data;
    }
    //接下来就是如果只有其中一个有值
    //返回的是信息
    public static ResponseResult success(String message){
        return new ResponseResult(0,message,null);
    }
    public static<T> ResponseResult success(T data){
        return new ResponseResult(0,null,data);
    }
    public static ResponseResult error(String message){
        return new ResponseResult(-1,message,null);
    }

    public int getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }

    public T getData() {
        return data;
    }
}
