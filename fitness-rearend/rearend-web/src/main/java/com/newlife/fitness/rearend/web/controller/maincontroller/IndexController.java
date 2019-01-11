package com.newlife.fitness.rearend.web.controller.maincontroller;



import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.newlife.fitness.entity.DUser;
import com.newlife.fitness.rearend.web.utils.GlobalConstant;
import com.newlife.fitness.rearend.web.utils.ServletTool;
import com.newlife.fitness.rearend.web.utils.cookietool.EditCookie;
/**
 * @ClassName: IndexController 
 * @Description: 用于登录后进入首页的Controller，用于进入各个页面的Controller
 * @author Unruly  
 * @date 2019年1月3日
 */
@Controller
@RequestMapping("/fitness-admin/")
public class IndexController {
	
	// -------------------------------------------------- 设置真实视图
	/** 如果Session失效重定向到登录页面 */
	private final String session_null = "redirect:/login.html";
	/** 首页真实视图 */
	private final String page_index = "fitness-sys/index";		
	
	// -------------------------------------------------- 设置真实视图
	
	
	// -------------------------------------------------- 设置逻辑视图
	@RequestMapping("index.html")
	public String goMain() {
		return page_index;
	}
	// -------------------------------------------------- 设置逻辑视图
	
	
	
	// -------------------------------------------------- 请求处理方法
	/**
	 * @return 进行锁屏的操作，清除Cookie、删除会话。
	 */
	@ResponseBody
	@RequestMapping(value="closeScreen")
	public String closeScreen() {
		DUser dUser= (DUser) ServletTool.getSession().getAttribute(GlobalConstant.login_user);
		if(dUser != null) {
			EditCookie.del_Cookie(dUser.getdLoginName(), ServletTool.getRequest(), ServletTool.getResponse());
			ServletTool.getSession().removeAttribute(GlobalConstant.login_user);
			ServletTool.getSession().invalidate();
			ServletTool.getSession().setAttribute("userLoginName", dUser.getdLoginName());
		}
		return GlobalConstant.success;
	}
	/**
	 * 退出页面的方法。移除Session属性，销毁Session；
	 * @return 返回登录页面
	 */
	@RequestMapping("loginOut.html")
	public String loginOut() {
		ServletTool.getSession().removeAttribute(GlobalConstant.login_user);
		ServletTool.getSession().invalidate();
		return session_null;
	}
	
	// -------------------------------------------------- 请求处理方法
	
	

}
