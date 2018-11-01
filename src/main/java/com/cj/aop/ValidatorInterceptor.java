package com.cj.aop;

import com.cj.utils.RD;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;

import java.lang.reflect.Method;

/**
 * 参数校验拦截器
 * @author Administrator
 */
@Component
@Aspect
@Slf4j
public class ValidatorInterceptor {

    @Around("within(com.cj..*)&&args(..,org.springframework.validation.BindingResult)")
    public Object validAop(ProceedingJoinPoint jp){
        //被拦截的方法
        MethodSignature methodSignature = (MethodSignature) jp.getSignature();
        //被拦截的对象
        Method method = methodSignature.getMethod();
        method.setAccessible(true);
        BindingResult bindingResult = null;
        //初始化校验结果
        for (Object o : jp.getArgs()) {
            if (o instanceof BindingResult){
                bindingResult = (BindingResult) o;
                break;
            }
        }
        if (bindingResult!=null&&bindingResult.hasErrors()){
            return RD.error(bindingResult.getAllErrors().get(0).getDefaultMessage());
        }
        try {
            return jp.proceed();
        } catch (Throwable e) {
            e.printStackTrace();
            return RD.exception("system error:" + e.getMessage());
        }

    }

}

