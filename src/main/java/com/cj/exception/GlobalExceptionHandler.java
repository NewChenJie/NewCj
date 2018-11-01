package com.cj.exception;

import com.alibaba.fastjson.JSON;
import com.cj.constant.Status;
import com.cj.kits.SessionKit;
import com.cj.kits.WebKit;
import com.cj.utils.KeyValue;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.TypeMismatchException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindException;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.multipart.MultipartException;
import org.springframework.web.servlet.NoHandlerFoundException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.servlet.http.HttpServletRequest;

/**
 * Create at 2017-06-02
 */
@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
//    @Value("${spring.profiles.active}")
//    private String profiles;

    @ExceptionHandler({ForbiddenException.class, AesException.class})
    @ResponseBody
    public KeyValue handleForbiddenException(Exception ex) {
        // 禁止访问不用打印异常
        log.error("拒绝访问: {}", WebKit.getRequestUrl());
        log.error("原因: {}", ex.getMessage());
        return KeyValue.forbidden(ex.getMessage());
    }

    @ExceptionHandler(Redirect.class)
    public String handleRedirect(Redirect ex) {
        // 记录当前访问的URL用于下次跳转回来
        String referer = WebKit.getRequestUrl();
        log.info("重定向记录Referer: {}", referer);
        SessionKit.setSessionAttr("Referer", referer);
        return "redirect:" + ex.getMessage();
    }

    @ExceptionHandler(MultipartException.class)
    @ResponseBody
    public KeyValue handleMultipartException(MultipartException ex) {
        doLogger(ex);
        return KeyValue.forbidden("文件大小超出系统限制!");
    }

    @ExceptionHandler(EntityValidException.class)
    @ResponseBody
    public KeyValue handleValidException(EntityValidException ex) {
        // 实体认证异常不需要打印
        return ex.getKeyValue();
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        return handleExceptionInternal(ex, KeyValue.checkInGlobal(ex.getBindingResult()), headers, HttpStatus.OK, request);
    }

    @Override
    protected ResponseEntity<Object> handleBindException(BindException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        return handleExceptionInternal(ex, KeyValue.checkInGlobal(ex.getBindingResult()), headers, HttpStatus.OK, request);
    }

    @Override
    protected ResponseEntity<Object> handleHttpMediaTypeNotSupported(HttpMediaTypeNotSupportedException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        return handleExceptionInternal(ex, KeyValue.bad_request("不支持的请求数据类型!", ex.getMessage()),
                headers, HttpStatus.OK, request);
    }

    @Override
    protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        return handleExceptionInternal(ex, KeyValue.bad_request("无法读取请求数据 请检查入参数据是否正确!", ex.getMessage()),
                headers, HttpStatus.OK, request);
    }

    @Override
    protected ResponseEntity<Object> handleTypeMismatch(TypeMismatchException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        return handleExceptionInternal(ex, KeyValue.bad_request(
                String.format("参数类型不匹配 值 %s 无法转换为 %s",
                        ex.getValue(),
                        ex.getRequiredType().getSimpleName()), ex.getMessage()),
                headers, HttpStatus.OK, request);
    }

    @Override
    protected ResponseEntity<Object> handleNoHandlerFoundException(NoHandlerFoundException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        HttpServletRequest req = ((ServletWebRequest) request).getNativeRequest(HttpServletRequest.class);
        return handleExceptionInternal(
                ex,
                KeyValue.rd(Status.HTTP.NOT_FOUND, "路径未找到!")
                        .add("path", req.getRequestURI())
                        .add("method", req.getMethod())
                        .add("time", System.currentTimeMillis()),
                headers, status, request);
    }

    @ExceptionHandler(Throwable.class)
    @ResponseBody
    public KeyValue handleControllerException(Throwable ex) {
        doLogger(ex);
        if ("online".equals("profiles")) {
            return KeyValue.rd(Status.HTTP.INTERNAL_SERVER_ERROR);
        }
        return KeyValue.rd(Status.HTTP.INTERNAL_SERVER_ERROR, ex.getClass().getName() + ": " + ex.getMessage());
    }

    private void doLogger(Throwable ex) {
        HttpServletRequest request = WebKit.getRequest();
        String realIp = request.getHeader("X-Real-IP");
        if (log.isErrorEnabled()) {
            log.info(String.format("\n%-15s %-6s %s %s",
                    StringUtils.isEmpty(realIp) ? request.getRemoteAddr() : realIp,
                    request.getMethod(),
                    request.getRequestURI(),
                    JSON.toJSONString(request.getParameterMap())));
            log.error("", ex);
        }
    }
}
