package com.zandooy.blog.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import javax.validation.ValidationException;

/**
 * 参数校验拦截器
 */
@Aspect
@Component
public class ValidationAspect extends BaseAspect {

//    private final static Logger logger = LoggerFactory.getLogger(ValidationAspect.class);

    @Pointcut("execution(public * com.zandooy.blog.controller..*(..))")
    public void validation() {
    }

    @Before("validation()")
    public void ValidationBefore(JoinPoint joinPoint) {
        Object[] args = joinPoint.getArgs();
        for (Object arg : args) {
            if (arg instanceof BindingResult) {
                // 强制转换
                BindingResult result = (BindingResult) arg;
                if (result.hasErrors()) {
                    FieldError fieldError = result.getFieldError();
                    throw new ValidationException(fieldError.getDefaultMessage()  + '1');
                }
            }
        }
    }
}
