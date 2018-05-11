package com.cj.config;

import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;

@Configuration
public class DBInit_OAMysql {
    private final String MapperPath="classpath*:com.cj.mapper.oamysql/*.xml";
    private final String DataSourceBean="dataSource_oamysql";
    private final String SQLSessionFactoryBean="sqlSessionFactory_oamysql";
    private final String PackageName="com.cj.mapper.oamysql";
    private final String txStr = "oaMySql";
    /**
     * 初始数据库
     * @param dbinfo
     * @return
     */
    @Bean(DataSourceBean)
    @Primary
    //@Profile("dev")
    public DataSource dataSource(DBConfigInfo dbinfo){
        return DBConfigUtils.getDruid(dbinfo.getOaMysql());
    }

    /**
     * 指定 mybaties mapper 的sql配置
     * @param driver
     * @return
     */
    @Bean(SQLSessionFactoryBean)
    @Primary
    public SqlSessionFactoryBean sqlSessionFactory(@Qualifier(DataSourceBean) DataSource driver){
        return DBConfigUtils.getSQLSessionFactory(driver, MapperPath);
    }

    /**
     * 指定扫描 mybaties mapper 的包名
     * @return
     * @throws Exception
     */
    @Bean("MapperScanner_"+SQLSessionFactoryBean)
    public MapperScannerConfigurer mapperScannerConfigurer() throws Exception{
        return DBConfigUtils.getMapperScannerConfigurer(SQLSessionFactoryBean, PackageName);
    }

    /**
     *事物指定数据库
     * @param dataSource
     * @return
     */
    @Bean(txStr)
    public PlatformTransactionManager txManager(@Qualifier(DataSourceBean) DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }
}
