package com.zqh.test.myfirstspringboot.error;


import lombok.Data;

/**
 * @Author：zhengqh
 * @date 2020/4/14 20:10
 **/
@Data
public class ErrorInfo<T> {
    public static final Integer SUCCESS = 200;
    public static final Integer ERROR = 100;
    // 错误码
    private Integer code;
    // 错误信息
    private String message;
    private String url;
    private T data;
}
