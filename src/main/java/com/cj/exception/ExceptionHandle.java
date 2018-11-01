package com.cj.exception;

import com.cj.utils.RD;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class ExceptionHandle {
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public RD exceptionGet(Exception e){
        if(e instanceof DemoException){
            DemoException MyException = (DemoException) e;
            return RD.exception(MyException.getMessage());
        }
        return RD.error(e.getMessage());
    }
}
