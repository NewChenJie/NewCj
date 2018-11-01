package com.cj.SomeDemo;

import com.alibaba.ttl.TransmittableThreadLocal;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Slf4j
public class ThreadLocalDemo {

    static ExecutorService executorService = Executors.newFixedThreadPool(1);

    @Test
    public void TestDemo1() {
        mainThread();
    }

        /**
         * 创建一个线程,在线程内有去运行另一个线程的时候，作为子线程，如何去拿到父线程的私有属性呢?
         */
     public static void mainThread(){
            /**
             *    相当于一个Map集合,只不过这个Map 的Key是固定的,都是当前线程
             */
//            ThreadLocal t1=new ThreadLocal<String>();
         /**
          * 可以继承的threadlocal
          */
         ThreadLocal t1=new InheritableThreadLocal<String>();
            t1.set("main");
            log.info("当前线程名{}：{}", Thread.currentThread().getName(),t1.get());
            new Thread(new Runnable() {
                @Override
                public void run() {
                    log.info("当前线程名{}：{}", Thread.currentThread().getName(),t1.get());
                }
            }).start();
     }

     public void testTrancmittable(){
         ThreadLocal<String> t1 = new TransmittableThreadLocal<>();
         t1.set("one");
         ThreadLocal<String> t2 = new TransmittableThreadLocal<>();
         t2.set("two");
         //拷贝出一份副本


     }



}
