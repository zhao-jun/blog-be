package com.zandooy.blog.utils;

import java.util.UUID;

public class GenerateCodeUtil {
    public GenerateCodeUtil() {
    }

    public static String generateCode () {
        return UUID.randomUUID().toString().replace("-", "");
    }
}
