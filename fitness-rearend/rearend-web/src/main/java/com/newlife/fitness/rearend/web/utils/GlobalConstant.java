package com.newlife.fitness.rearend.web.utils;

/**
 * @ClassName: GlobalConstant
 * @Description: 保存一些系统常量方便后期维护修改。
 * @author Unruly
 * @date 2018年12月28日
 */
public class GlobalConstant {

	private GlobalConstant() {}
	/** 通过此key表示Session中的登录用户 */
	public final static String login_user = "login_user";
	public final static String websocket_user = "websocket_user";

	/** ajax状态 success 表示登录成功 */
	public final static String success = "success";
	/** ajax状态 success 表示验证失败 */
	public final static String fail = "fail";
	/** ajax状态 success 表示登录失败 */
	public final static String error = "error";
	/** 表示 返回的数据的值的key */
	public final static String myData = "myData";

	/** captcha用户储存验证码的key */
	public static final String captcha = "imgValidation";

	/** Session储存手机验证码的key */
	public static final String phone_code = "phone_code";

	/* 保存Cookie的key值 */
	public static final String cookie_name = "username";
	public static final String cookie_value = "password";

	/**
	 * 判断对象是否为空
	 * 
	 * @param obj
	 * @return
	 */
	public static boolean object_nullExits(Object obj) {
		boolean flag = true;
		if (obj == null) {
			flag = false;
		}
		return flag;
	}

	/* Layui返回的值的key code表示返回状态，msg表示返回信息，data表示返回数据 */
	public final static String code = "code";
	public final static String msg = "msg";
	public final static String data = "data";

	/**
	 * 保存信息验证的手机号和id
	 */
	public final static String session_phone = "SESSION_PHONE_REPASS";
	public final static String session_userid = "SESSION_USERID_REPASS";

}
