package com.cj.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created with IntelliJ IDEA
 * 正则匹配工具类
 * @Description
 */
public class PatternUtils {

    /**
     * 身份证正则匹配
     */
    public static final String IDCARD = "\\d{17}[0-9Xx]|\\d{15}";

    /**
     * 手机号正则匹配
     */
    public static final String PHONE = "(13\\d|14[57]|15[^4,\\D]|17[13678]|18\\d)\\d{8}|170[0589]\\d{7}";



    /**
     * 校验身份证
     *
     * @param idCard
     * @return
     */
    public static Boolean isIdCard(String idCard) {
        Pattern p = Pattern.compile(IDCARD);
        Matcher m = p.matcher(idCard);
        if (m.matches()) {
            return true;
        }
        return false;
    }

    /**
     * 校验手机号码
     *
     * @param phone
     * @return
     */
    public static Boolean isPhone(String phone) {
        Pattern p = Pattern.compile(PHONE);
        Matcher m = p.matcher(phone);
        if (m.matches()) {
            return true;
        }
        return false;
    }



}
