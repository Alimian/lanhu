package com.lanhu.cn.utils;

import java.util.regex.Pattern;

public class CheckUtils {
	
	 /**
     * 正则表达式：验证手机号
     */
    public static final String REGEX_MOBILE = "^((17[0-9])|(14[0-9])|(13[0-9])|(15[^4,\\D])|(18[0,5-9]))\\d{8}$";

    /**
     * 正则表达式：验证密码
     */
    public static final String REGEX_PASSWORD = "^[a-zA-Z0-9]{6,20}$";
    /**
     * 正则表达式：邮箱
     */
    public static final String REGEX_EMAIL = "^\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*$";
    
	/**
	 * 
	 * @Title: checkTel 
	 * @author wangn 
	 * @Description: TODO 描述:校验手机号是否合法
	 * @param @return 
	 * @return boolean
	 * @throws
	 */
	public static boolean checkTel(String telPhone){
		return Pattern.matches(REGEX_MOBILE, telPhone);
		
	}
	 /**
     * 校验密码
     * 
     * @param password
     * @return 校验通过返回true，否则返回false
     */
    public static boolean isPassword(String password) {
        return Pattern.matches(REGEX_PASSWORD, password);
    }
    /**
     * 
     * @Title: checkEmail 
     * @author wangn 
     * @Description: TODO 描述:校验邮箱是否合法
     * @param @param email
     * @param @return 
     * @return boolean
     * @throws
     */
    public static boolean checkEmail(String email) {
    	return Pattern.matches(REGEX_EMAIL, email);
    }
}
