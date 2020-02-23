package com.kddyzn.wenju.model;

import lombok.Data;

@Data
public class HttpResult {
    private int code;

    private String msg;

    private Object data;

    public HttpResult(int code, String msg, Object data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    HttpResult(String msg, Object data) {
        this.code = 0;
        this.msg = msg;
        this.data = data;
    }

    public HttpResult(Object data) {
        this.code = 0;
        this.msg = "success";
        this.data = data;
    }
}
