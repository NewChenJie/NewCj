package com.cj.resolver;

import com.cj.annotation.PageAttr;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.core.MethodParameter;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;


@Component
public class PageArgumentResolver implements HandlerMethodArgumentResolver {
    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        return Page.class.isAssignableFrom(parameter.getParameterType());
    }

    @Override
    public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer, NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {
        int num = 1;
        int size = 20;
        try {
            num = Integer.parseInt(webRequest.getParameter("pageNum"));
        } catch (Exception ignored) {
        }
        try {
            size = Integer.parseInt(webRequest.getParameter("pageSize"));
        } catch (Exception ignored) {
        }
        Page<Object> page = PageHelper.startPage(num, size);
        PageAttr attr = parameter.getParameterAnnotation(PageAttr.class);
        if (attr != null) {
            page.setOrderBy(attr.order());
        }
        return page;
    }

}
