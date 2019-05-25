package com.entity;

import java.util.List;
import java.util.Map;

public class ResponseResult {
    private Integer code;

    private String message;

    private String result[];

    public Integer getCode() {
        return this.code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String[] getResult() {
        return this.result;
    }

    public void setResult( String result[]) {
        this.result = result;
    }

}
