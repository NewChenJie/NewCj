package com.cj.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.SetOperations;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

/**
 */
@Component
public class RedisServiceComponent {
    @Autowired
    RedisTemplate<String, String> redisTemplate;

    public RedisTemplate<String, String> getRedisTemplate() {
        return redisTemplate;
    }

    public void set(String key, String value) {
        getValueOperations().set(key, value);
    }

    //set(K key, V value, long seconds, TimeUnit unit);
    public void set(String key, String value, long seconds) {
        getValueOperations().set(key, value, seconds, TimeUnit.SECONDS);
    }

    public String get(String key) {
        return getValueOperations().get(key);
    }

    public void delete(String pattern) {
        redisTemplate.delete(redisTemplate.keys(pattern));
    }

    /**
     * 访问记录，已url+userId为键。放置3秒钟，如果3秒内重复提交。那么不相应。
     */
    public void setPostMark(String key, String value) {
        this.set(key, value, 2);
    }

    public Boolean has(String key) {
        return redisTemplate.hasKey(key);
    }

    public SetOperations<String, String> getSetOperations() {
        return redisTemplate.opsForSet();
    }

    public ListOperations<String, String> getListOperations() {
        return redisTemplate.opsForList();
    }

    private ValueOperations<String, String> getValueOperations() {
        return redisTemplate.opsForValue();
    }
}