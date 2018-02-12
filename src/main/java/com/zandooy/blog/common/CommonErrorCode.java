package com.zandooy.blog.common;

public enum CommonErrorCode implements ErrorCode {

    SUCCESS("0", "成功");

    private String code;
    private String msg;

    CommonErrorCode(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
