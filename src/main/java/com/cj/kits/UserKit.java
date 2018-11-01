package com.cj.kits;

import org.apache.commons.lang3.StringUtils;

/**
 * Created with IntelliJ IDEA
 *
 * Created on 2017/6/28 20:35.
 */
public class UserKit {
    private static final String OPEN_ID = "openId";
    private static final String ALI_ACCOUNT_ID = "aliAccountId";
    private static final String GUEST = "guest";

    private UserKit() {
    }

    /**
     * 用户登录
     *
     * @param openid
     *         用户信息
     */
    public static void login(String openid) {
        SessionKit.setSessionAttr(OPEN_ID, openid);
        SessionKit.clearSessionAttr(ALI_ACCOUNT_ID);
    }

    /**
     * 根据openid判断是否登录
     */
    public static boolean isLogin() {
        return StringUtils.isNotBlank(getOpenId());
    }

    /**
     * 设置当前用用户的AliAccountId
     *
     * @param aliAccountId
     *         阿里账户ID
     */
    public static void setAliAccountId(Integer aliAccountId) {
        SessionKit.setSessionAttr(ALI_ACCOUNT_ID, aliAccountId);
    }

    /**
     * 获得AliAccountId
     *
     * @return aliAccountId
     */
    public static Integer getAliAccountId() {
        return SessionKit.getSessionAttr(ALI_ACCOUNT_ID);
    }


    /**
     * 获得openId
     *
     * @return openId
     */
    public static String getOpenId() {
        return SessionKit.getSessionAttr(OPEN_ID);
    }

    /**
     * 根据是否为访客
     */
    public static boolean isGuest() {
        return StringUtils.isNotBlank(SessionKit.getSessionAttr(GUEST));
    }

    /**
     * 设置为访客登录
     */
    public static void setGuest() {
        SessionKit.setSessionAttr(GUEST, "1");
    }

    /**
     * 用户登出
     */
    public static void logout() {
        SessionKit.clearSessionAttr(OPEN_ID);
        SessionKit.clearSessionAttr(ALI_ACCOUNT_ID);
        SessionKit.clearSessionAttr(GUEST);
    }

}
