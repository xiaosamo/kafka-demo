package com.yuanshijia.kafkademo.common;

import lombok.Getter;

import java.io.Serializable;

/**
 * @author yuan
 * @date 2019/5/19
 * @description
 */
@Getter
public class Response<T> implements Serializable {
    private Integer code;
    private String msg;
    private T data;


    private Response(){}


    private Response(Integer code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public static <T> Response<T> success(String msg, T data) {
        return new Response<>(200, msg, data);
    }

    public static <T> Response<T> error(String msg, T data) {
        return new Response<>(500, msg, data);
    }



}
