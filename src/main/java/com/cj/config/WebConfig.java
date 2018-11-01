package com.cj.config;

import com.cj.InterceptorAdapter.XssFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.web.context.request.RequestContextListener;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.MultipartConfigElement;
import java.util.EventListener;

@Configuration
public class WebConfig {


    /**
     * 30M上传大小限制
     */
    private int maxUploadSizeInMb = 30 * 1024 * 1024;

//    /**
//     * 修改内置tomcat对上传文件大小的限制
//     */
//    @Bean
//    public TomcatEmbeddedServletContainerFactory containerFactory() {
//        return new TomcatEmbeddedServletContainerFactory() {
//            @Override
//            protected void customizeConnector(Connector connector) {
//                super.customizeConnector(connector);
//                if (connector.getProtocolHandler() instanceof Http11NioProtocol) {
//                    // if maxUploadSizeInMb = -1, accept unlimited bytes
//                    Http11NioProtocol protocol = (Http11NioProtocol) connector.getProtocolHandler();
//                    protocol.setMaxSwallowSize(maxUploadSizeInMb);
//                }
//            }
//        };
//    }


    /**
     * 修改spring对上传文件大小的限制
     */
    @Bean
    public MultipartConfigElement multipartConfigElement() {
        MultipartConfigFactory factory = new MultipartConfigFactory();
        // 设置文件大小限制 ,超了，页面会抛出异常信息，这时候就需要进行异常信息的处理了;
        // KB,MB
        factory.setMaxFileSize("5MB");
        // 设置总上传数据总大小
        factory.setMaxRequestSize("30MB");
        return factory.createMultipartConfig();
    }

    /**
     * 配置过滤器 防止脚本注入 xss攻击
     */
    @Bean
    @Order
    public FilterRegistrationBean xssFilterRegistration() {
        FilterRegistrationBean registration = new FilterRegistrationBean();
        registration.setFilter(new XssFilter());
        registration.addUrlPatterns("/*");
        registration.setName("XssFilter");
        registration.setOrder(Integer.MAX_VALUE);
        return registration;
    }


    @Bean
    public ServletListenerRegistrationBean<EventListener> getDemoListener() {
        ServletListenerRegistrationBean<EventListener> registrationBean = new ServletListenerRegistrationBean<>();
        registrationBean.setListener(new RequestContextListener());
        return registrationBean;
    }

    @Bean
    public DispatcherServlet dispatcherServlet() {
        DispatcherServlet ds = new DispatcherServlet();
        ds.setThrowExceptionIfNoHandlerFound(true);
        return ds;
    }
}