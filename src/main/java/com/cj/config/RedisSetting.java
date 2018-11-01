package com.cj.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 */
@ConfigurationProperties("redis")
@Data
public class RedisSetting {
    private Integer database;
    private String host;
    private Integer port;
    private Integer timeout;
    private Integer maxIdle;
    private Integer minIdle;
    private Integer maxActive;
    private Integer maxWait;
}
