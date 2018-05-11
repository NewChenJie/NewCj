package com.cj.config;

import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;

@Configuration
public class DBInit_Mysql {
    private final String MapperPath = "classpath*:com.cj.mapper.mysql/*.xml";
    private final String DataSourceBean = "dataSource_mysql";
    private final String SQLSessionFactoryBean = "sqlSessionFactory_mysql";
    private final String PackageName = "com.cj.mapper.mysql";
    private final String txStr = "mysql";
    /**
     * 初始数据库
     *
     * @param dbinfo
     * @return
     */
    @Bean(DataSourceBean)
    public DataSource dataSource(DBConfigInfo dbinfo) {
        return DBConfigUtils.getDruid(dbinfo.getMysql());
    }
    /**
     * 指定 mybaties mapper 的xml配置
     *
     * @param driver
     * @return
     */
    @Bean(SQLSessionFactoryBean)
    public SqlSessionFactoryBean sqlSessionFactory(@Qualifier(DataSourceBean) DataSource driver) {
        return DBConfigUtils.getSQLSessionFactory(driver, MapperPath);
    }
    /**
     * 指定扫描 mybaties mapper 的包名
     *
     * @return
     * @throws Exception
     */
    @Bean("MapperScanner_" + SQLSessionFactoryBean)
    public MapperScannerConfigurer mapperScannerConfigurer() throws Exception {
        return DBConfigUtils.getMapperScannerConfigurer(SQLSessionFactoryBean, PackageName);
    }
    /**
     * 事物指定数据库
     *
     * @param dataSource
     * @return
     */
    @Bean(txStr)
    public PlatformTransactionManager txManager(@Qualifier(DataSourceBean) DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

}
