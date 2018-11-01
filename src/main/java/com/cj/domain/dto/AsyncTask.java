package com.cj.domain.dto;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
public class AsyncTask {
    @Async //异步标签
    public void testAsyn(){
        long time = System.currentTimeMillis();
        System.err.println(Thread.currentThread().getId());
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.err.println("async total time:"+(System.currentTimeMillis()-time));
    }
}
