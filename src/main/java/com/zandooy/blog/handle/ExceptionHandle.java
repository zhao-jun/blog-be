package com.zandooy.blog.handle;

import com.zandooy.blog.dto.Result;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.ValidationException;

/**
 * 全局异常处理
 */
@ControllerAdvice
public class ExceptionHandle {

    @ExceptionHandler
    @ResponseBody
    public Result handle (ValidationException e) {
        // 不符合验证项
        return new Result("-1", e.getMessage(), null);
    }

    @ExceptionHandler
    @ResponseBody
    public Result handle (Exception e) {
        return new Result("0", e.getMessage(), null);
    }
}
