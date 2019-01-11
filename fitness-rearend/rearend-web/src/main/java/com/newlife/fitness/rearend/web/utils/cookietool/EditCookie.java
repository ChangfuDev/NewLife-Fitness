package com.newlife.fitness.rearend.web.utils.cookietool;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @ClassName: EditCookie  
 * @Description: 添加删除Cookie的工具类
 * @author Unruly  
 * @date 2018年12月28日
 */
public class EditCookie {
	
		private EditCookie() {}
	
		/**
		 * @param username cookie的key为用户名的账号
		 * @param password cookie的val为用户下的密码
		 * 添加Cookie的方法，通过 形式{key(用户名),value(密码)}，键值对。
		 */
		public static void add_Cookie(String username,String password,HttpServletRequest req,HttpServletResponse res) {
			Cookie c_user= new Cookie(username, password);	
			c_user.setMaxAge(60*60*24*3);					
			c_user.setPath(req.getContextPath()+"/");		
			res.addCookie(c_user);							
		}
		
		/**
		 * @param c_name 用户名
		 * 清除Cookie的方法，在程序中没有移除Cookie的方法。
		 * 只有通过覆盖key的值的形式去除原本的Cookie。路径必须设置。
		 */
		public static void del_Cookie(String c_name,HttpServletRequest req,HttpServletResponse res) {
			for (Cookie c : req.getCookies()) {
				if(c.getName().equals(c_name.trim())) {
					c.setMaxAge(-1);
					c.setValue("");
					c.setPath(req.getContextPath()+"/");
					res.addCookie(c);
				}
			}
		}
}

