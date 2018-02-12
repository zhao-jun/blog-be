package com.zandooy.blog.common;

public interface ErrorCode {

    default String getCode() {
        return "SYSTEM_ERROR";
    }

    String getMsg ();

}
