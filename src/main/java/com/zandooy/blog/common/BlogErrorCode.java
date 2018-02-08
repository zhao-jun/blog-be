package com.zandooy.blog.common;

public enum BlogErrorCode {

    NO_BLOG_MESSAGE("NO_BLOG_MESSAGE", "未找到对应博客文章");

    private String code;
    private String msg;

    BlogErrorCode(String code, String msg) {
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
