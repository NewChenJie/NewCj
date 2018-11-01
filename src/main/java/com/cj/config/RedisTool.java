package com.cj.config;

import redis.clients.jedis.Jedis;

import java.util.Collections;

/**
 * 分段式锁的相关实现
 * @author Administrator
 */
public class RedisTool {
    public static final String LOCK_SUCCESS="OK";
    /**
     * 尝试获取分布式锁
     * @param jedis Redis客户端
     * @param lockKey 锁
     * @param requestId 请求标识
     * @param expireTime 超期时间
     * @return 是否获取成功
     */
    public static boolean tryGetDistributedLock(Jedis jedis, String lockKey, String requestId, int expireTime) {
          //NX :即当key不存在时，我们进行set操作；若key已经存在，则不做任何操作
          //px:意思是我们要给这个key加一个过期的设置
        String result = jedis.set(lockKey, requestId, "NX", "PX", expireTime);
        if (LOCK_SUCCESS.equals(result)) {

            return true;
        }
        return false;
    }

    private static final Long RELEASE_SUCCESS = 1L;

    /**
     * 释放分布式锁
     * @param jedis Redis客户端
     * @param lockKey 锁
     * @param requestId 请求标识
     * @return 是否释放成功
     */
    public static boolean releaseDistributedLock(Jedis jedis, String lockKey, String requestId) {
        //首先获取锁对应的value值，检查是否与requestId相等，如果相等则删除锁（解锁）
        String script = "if redis.call('get', KEYS[1]) == ARGV[1] then return redis.call('del', KEYS[1]) else return 0 end";
        Object result = jedis.eval(script, Collections.singletonList(lockKey), Collections.singletonList(requestId));
        if (RELEASE_SUCCESS.equals(result)) {
            return true;
        }
        return false;
    }
//建立个守护线程来实现当锁将过期而任务还未完成时，进行增加时间的设置
    public void daemonThreadAddTime(Jedis jedis, String lockKey, String requestId, int expireTime){
        Thread thread=new Thread( new Runnable() {
            @Override
            public void run() {

                while (true) {
                    try {
                        Thread.sleep(10000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    jedis.expire(lockKey,expireTime);
                }
            }
        });
        thread.setDaemon(true);
        thread.start();
    }

}
