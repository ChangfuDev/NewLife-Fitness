package com.newlife.fitness.rearend.web.controller.maincontroller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @ClassName: HomeController  
 * @Description: 主页的控制器
 * @author Unruly  
 * @date 2019年1月6日
 */
@Controller
@RequestMapping("/fitness-admin/")
public class HomeController {
	// ----------------------------------------- 设置真实视图 -------------------------------------
	/** 首页的主页真实视图 */
	private final String page_home 	   = "fitness-sys/home/home";	
	// ----------------------------------------- 设置真实视图 -------------------------------------
	
	
	// ----------------------------------------- 设置逻辑视图 -------------------------------------
	@RequestMapping("home/homepage2.html")
	public String goHome() {
		return page_home;
	}
	// ----------------------------------------- 设置逻辑视图 -------------------------------------
}
