package com.cj.config;

import lombok.Data;

@Data
public class DBInfo {
    private String driver;
    private String url;
    private String databaseName;
    private String username;
    private String password;
}
