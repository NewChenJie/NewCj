package com.cj.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@Data
@ConfigurationProperties(prefix = "dbconfig")
public class DBConfigInfo {
    private DBInfo oaMysql;
    private DBInfo oasqlserver;
    private DBInfo mysql;
    private DBInfo oapg;
}
