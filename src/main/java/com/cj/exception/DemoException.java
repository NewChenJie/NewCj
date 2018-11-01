package com.cj.exception;

import lombok.Getter;

public class DemoException extends RuntimeException {
    @Getter
    private Integer code=0;

    private DemoException(){};
    public DemoException(Integer code) {
        this.code = code;
    }

    public DemoException(String message, Integer code) {
        super(message);
        this.code = code;
    }

    public DemoException(String message, Throwable cause, Integer code) {
        super(message, cause);
        this.code = code;
    }

    public DemoException(Throwable cause, Integer code) {
        super(cause);
        this.code = code;
    }

    public DemoException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace, Integer code) {
        super(message, cause, enableSuppression, writableStackTrace);
        this.code = code;
    }
}
