package com.cj.config;

import com.cj.kits.BeanKit;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;
import org.springframework.core.convert.converter.GenericConverter;
import org.springframework.format.Formatter;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.util.List;

/**
 * @author MiaoWoo
 */
@Configuration
public class MvcConfigurer extends WebMvcConfigurerAdapter {

//    /**
//     * 自动扫描相关的拦截器并且注册
//     */
//    @Override
//    public void addInterceptors(InterceptorRegistry registry) {
//        BeanKit.getListOfType(HandlerInterceptor.class).forEach(handlerInterceptor -> {
//            val interceptor = registry.addInterceptor(handlerInterceptor);
//            val exclude = handlerInterceptor.getClass().getAnnotation(Excloud.class);
//            if (Objects.nonNull(exclude)) {
//                Arrays.stream(exclude.value()).forEach(interceptor::excludePathPatterns);
//            }
//        });
//    }

    /**
     * 自动扫描相关的参数解析器并且注册
     */
    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {
        argumentResolvers.addAll(BeanKit.getListOfType(HandlerMethodArgumentResolver.class));
    }

    /**
     * 自动扫描相关组件并且注册
     */
    @Override
    public void addFormatters(FormatterRegistry registry) {
        for (Converter<?, ?> converter : BeanKit.getListOfType(Converter.class)) {
            registry.addConverter(converter);
        }
        for (GenericConverter converter : BeanKit.getListOfType(GenericConverter.class)) {
            registry.addConverter(converter);
        }
        for (Formatter<?> formatter : BeanKit.getListOfType(Formatter.class)) {
            registry.addFormatter(formatter);
        }
    }

//    /**
//     * 消息类型转换
//     */
//    @Override
//    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
//        converters.add(new StringHttpMessageConverter(Charset.forName("UTF-8")));
//        FastJsonHttpMessageConverter fastJsonHttpMessageConverter = new FastJsonHttpMessageConverter();
//        FastJsonConfig fastJsonConfig = new FastJsonConfig();
//        fastJsonConfig.setSerializerFeatures(SerializerFeature.PrettyFormat,
//                                             SerializerFeature.WriteMapNullValue,
//                                             SerializerFeature.WriteNullStringAsEmpty,
//                                             SerializerFeature.WriteNullListAsEmpty,
//                                             SerializerFeature.DisableCircularReferenceDetect);
//        fastJsonHttpMessageConverter.setFastJsonConfig(fastJsonConfig);
//        converters.add(fastJsonHttpMessageConverter);
//    }
}

