package com.cj.TestDemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/redis")
public class RedisOne {
    @Autowired
    RedisTemplate redisTemplate;
    @GetMapping("/one")
    public void TestRedis(){
     redisTemplate.opsForHash().put("one","age",26);
     redisTemplate.opsForHash().put("one","age",27);
        System.out.println(redisTemplate.opsForHash().size("one"));
        System.out.println(redisTemplate.opsForHash().get("one","age"));
    }

    }


