package com.cj.exception;

import lombok.extern.slf4j.Slf4j;

/**
 * Created with IntelliJ IDEA
 * Created on 2017/6/13 19:45.
 */
@Slf4j
public class Redirect extends RuntimeException {
    private static final long serialVersionUID = -1861509208856597690L;

    public Redirect(String message) {
        super(message);
    }

    public Redirect() {

    }
}
