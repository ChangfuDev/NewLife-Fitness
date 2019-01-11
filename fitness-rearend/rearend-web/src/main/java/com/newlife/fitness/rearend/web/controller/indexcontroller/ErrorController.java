package com.newlife.fitness.rearend.web.controller.indexcontroller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
/**
 * @ClassName: ErrorPageController  
 * @Description: 配置错误页面；404 、403、500（待完善）；已经修改用户信息的Controller
 * @author Unruly  
 * @date 2019年1月2日
 */
@Controller
public class ErrorController {
	// ----------------------------------------- 设置真实视图 -------------------------------------
	/** 403页面 */
	private final String go_403 = "/WEB-INF/403";	
	
	/** 404页面 */
	private final String go_404 = "/WEB-INF/404";	
	
	/** 500页面 */
	private final String go_500 = "/WEB-INF/500";		
	// ----------------------------------------- 设置真实视图 -------------------------------------
	
	
	// ----------------------------------------- 设置逻辑视图 -------------------------------------
	@RequestMapping("/403.html")
	public String go403() {
		return go_403;
	}
	@RequestMapping("/404.html")
	public String go404() {
		return go_404;
	}
	@RequestMapping("/500.html")
	public String go500() {
		return go_500;
	}
	// ----------------------------------------- 设置逻辑视图 -------------------------------------
	
}
