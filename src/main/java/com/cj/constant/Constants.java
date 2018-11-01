package com.cj.constant;

import com.google.common.collect.ImmutableMap;

import java.util.Map;

public class Constants {
    private Constants() {
    }

    public static final String CONTENT_TYPE = "application/json; charset=utf-8";
    public static final String CHARSET_UTF8 = "UTF-8";

    public static class Order {
        public static final Integer ACCEPT_TIME = 7;
        public static final Integer DELAY_ACCEPT_TIME = 13;
        public static final String PHONE_NULL = "未知";
        public static final String ADDRESS_NULL = "虚拟产品";
    }

    public static class Auth {
        private Auth() {
        }

        public static final String USER_NOT_LOGIN = "用户未登录!";
        public static final String LOGIN_SUCCESS = "登录成功!";
        public static final String LOGIN_FAIL = "用户名或密码错误!";
        public static final String EMPTY_USER_OR_PWD = "用户名或密码为空!";
        public static final String USER_EXIST = "用户名已存在!";
        public static final String USER_NOT_ADMIN = "当前非管理员用户!";
        public static final String USER_NOT_DESIGNER = "当前非注册设计师！";
        public static final String EXPERIENCE_PHONE = "18688889999";
    }

    /**
     * 微信退款有一定延时，用零钱支付的退款20分钟内到账，银行卡支付的退款3个工作日后重新查询退款状态。
     * 这里设置七次查询分别为申请退款1分钟,2分钟，20分钟，60分钟，1天，3天，7天
     */
    public static Map<Integer, Integer> WX_QUERY_MAP = new ImmutableMap.Builder<Integer, Integer>().
            put(1, 1).
            put(2, 2).
            put(3, 20).
            put(4, 60).
            put(5, 60 * 24).
            put(6, 60 * 24 * 3).
            put(7, 60 * 24 * 7)
            .build();

    public static class AliProduct {
        private AliProduct() {
        }

        public static String ALI_PRODUCT_URL = "https://detail.1688.com/offer/AAA.html";
        public static String ALI_PRODUCT_IMAGE_URL = "https://cbu01.alicdn.com/";
        public static String ALI_IMG_SIZE = ".280*280.jpg";
        public static Integer ALI_PRODUCT_NAME_NUM = 4;

    }

}
