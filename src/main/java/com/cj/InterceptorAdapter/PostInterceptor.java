package com.cj.InterceptorAdapter;

import com.cj.component.RedisServiceComponent;
import com.cj.kits.UserKit;
import com.cj.kits.WebKit;
import com.cj.utils.KeyValue;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Optional;

/**
 * Created by Administrator on 2017/6/28.
 */
@Component
public class PostInterceptor extends HandlerInterceptorAdapter {

    private static final String MARK = "1";

    private RedisServiceComponent redisServiceComponent;

    public PostInterceptor(RedisServiceComponent redisServiceComponent) {this.redisServiceComponent = redisServiceComponent;}

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if ("GET".equalsIgnoreCase(request.getMethod())) {
            return true;
        }
        String key = "PostInterceptor:" +
                     request.getRequestURI() + ":" +
                     Optional.ofNullable(UserKit.getOpenId()).orElseGet(WebKit::getClientIP) + ":" +
                     WebKit.getClientIP();
        String value = redisServiceComponent.get(key);
        if (StringUtils.isNotEmpty(value)) {
            KeyValue.forbidden("请勿重复提交").write(response);
            return false;
        } else {
            redisServiceComponent.setPostMark(key, MARK);
            return true;
        }
    }
}
