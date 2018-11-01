package com.cj.kits;

import com.cj.exception.EntityValidException;
import com.cj.utils.KeyValue;

import javax.servlet.http.HttpSession;

/**
 * Created with IntelliJ IDEA
 */
public class SessionKit {
    private SessionKit() {
    }

    /**
     * @return 获取手机验证码
     */
    public static String getPhoneCode() {
        return getSessionAttr("phone_captcha");
    }

    /**
     * 设置手机验证码
     *
     * @param code
     *         手机验证码
     */
    public static void setPhoneCode(String code) {
        getSession().setAttribute("phone_captcha", code);
    }

    /**
     * @return 获得图形验证码
     */
    public static String getCaptcha() {
        return getSessionAttr("captcha");
    }

    /**
     * 设置图形验证码
     *
     * @param code
     *         验证码
     */
    public static void setCaptcha(String code) {
        setSessionAttr("captcha", code);
    }

    public static void checkCaptcha(String code) {
        String captcha = getCaptcha();
        if (captcha == null) {
            throw new EntityValidException(KeyValue.forbidden("需要验证码!", "/auth/verifycode"));
        } else if (!captcha.equalsIgnoreCase(code)) {
            throw new EntityValidException(KeyValue.forbidden("验证码错误!", "/auth/verifycode"));
        } else {
            setCaptcha(null);
        }
    }

    /**
     * 获取Session属性
     *
     * @param key
     *         键
     * @param <T>
     *         泛型
     * @return 属性值
     */
    public static <T> T getSessionAttr(String key) {
        return (T) getSession().getAttribute(key);
    }

    /**
     * 获取Session属性
     *
     * @param key
     *         键
     * @param value
     *         值
     * @return 属性值
     */
    public static void setSessionAttr(String key, Object value) {
        getSession().setAttribute(key, value);
    }

    /**
     * 获取Session属性
     *
     * @param key
     *         键
     * @return 属性值
     */
    public static void clearSessionAttr(String key) {
        setSessionAttr(key, null);
    }

    public static HttpSession getSession() {
        return WebKit.getRequest().getSession();
    }
}
