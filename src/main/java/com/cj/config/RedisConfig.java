package com.cj.config;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import redis.clients.jedis.JedisPoolConfig;

@Configuration
@EnableConfigurationProperties({RedisSetting.class})
public class RedisConfig{
    private RedisSetting redisSetting;

    public RedisConfig(RedisSetting redisSetting){
        this.redisSetting = redisSetting;
    }

    @Bean
    public JedisPoolConfig jedisPoolConfig(){
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        jedisPoolConfig.setMaxIdle(redisSetting.getMaxIdle());
        jedisPoolConfig.setMinIdle(redisSetting.getMinIdle());
        jedisPoolConfig.setMaxTotal(redisSetting.getMaxActive());
        jedisPoolConfig.setMaxWaitMillis(redisSetting.getMaxWait());
        return jedisPoolConfig;
    }

    @Bean(value = "redisTemplate")
    public RedisTemplate<String, Object> redisTemplate() {
        RedisTemplate<String, Object> redisTemplate = new RedisTemplate<>();
        redisTemplate.setConnectionFactory(connectionFactory());
        // 开启事务支持
        redisTemplate.setEnableTransactionSupport(true);
        // 使用String格式序列化缓存键
        StringRedisSerializer stringRedisSerializer = new StringRedisSerializer();
        redisTemplate.setKeySerializer(stringRedisSerializer);
        redisTemplate.setHashKeySerializer(stringRedisSerializer);
        redisTemplate.setValueSerializer(new GenericJackson2JsonRedisSerializer());
        return redisTemplate;
    }
    @Bean
    public  RedisConnectionFactory connectionFactory() {
            JedisConnectionFactory factory = new JedisConnectionFactory();
            factory.setHostName(redisSetting.getHost());
            factory.setPort(redisSetting.getPort());
            //设置连接超时时间
            factory.setTimeout(redisSetting.getTimeout());
            factory.setDatabase(redisSetting.getDatabase());
            factory.setPoolConfig(jedisPoolConfig());
            return factory;
        }
    }


