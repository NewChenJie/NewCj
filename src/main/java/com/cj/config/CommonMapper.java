package com.cj.config;


import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CommonMapper {
    @Bean
    public MapperScannerConfigurer getConfig(){
        MapperScannerConfigurer config = new MapperScannerConfigurer();
        config.setBasePackage("com.cj.mapper");
        return  config;
    }
}
