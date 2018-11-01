package com.cj.thread;

import lombok.SneakyThrows;
import org.junit.Test;

import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
//三种实现线程的方式

public class ThreadDemo1 {
  public static class MyThread extends Thread{
        @Override
        public void run(){
            System.out.println("mythread");
        }
    }
    @Test
    @SneakyThrows
    public void threadCreateOne(){
        MyThread thread = new MyThread();
        thread.start();
        System.out.println("mian结束");
        Thread.sleep(1000);
    }

    @Test
    @SneakyThrows
    public void threadCreateTwo(){
        Thread thread = new Thread(() -> System.out.println("mythread2"));
        thread.start();
        System.out.println("mian结束");
        Thread.sleep(1000);
    }


    @Test
    @SneakyThrows
    public void threadCreateThree(){
        FutureTask<String> task = new FutureTask<>(() -> {
            Thread.sleep(1000);
            System.out.println("callable start");
            return "callable over";
        });
        new Thread(task).start();
        try {
            String str = task.get(500, TimeUnit.NANOSECONDS);
        }catch (TimeoutException e){
            System.out.println(e.getMessage());
            task.cancel(true);
        }
        System.out.println("mian结束");
        Thread.sleep(1000);
    }

}
