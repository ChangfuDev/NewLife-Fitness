package com.newlife.fitness.rearend.web.controller.indexcontroller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.newlife.fitness.entity.DUser;
import com.newlife.fitness.rearend.biz.DUserBiz;
import com.newlife.fitness.rearend.web.utils.GlobalConstant;
import com.newlife.fitness.rearend.web.utils.ServletTool;
import com.newlife.fitness.rearend.web.utils.captchatool.GifCaptcha;
import com.newlife.fitness.rearend.web.utils.captchatool.parent.Captcha;
import com.newlife.fitness.rearend.web.utils.cookietool.EditCookie;
import com.newlife.fitness.rearend.web.utils.md5tool.MD5Util;

/**
 * @ClassName: LoginController  
 * @Description: 登录板块，进入登录页面，主要实现登录，验证码生成返回，Cookie清除、记住密码。
 * @author Unruly  
 * @date 2018年12月28日  
 */
@Controller
public class LoginController {
	/**
	 *  使用用户的登录名作为Cookie的key；
	 *  用于记住密码的重要变量；用于判断具体之前是否有用于登录，并且进行后记住密码的操作；
	 */
	private String cookie_name = null;
	// 登录页面
	private final String go_login = "login";	
	
	
	@Resource
	private DUserBiz dUserBiz;
	/**
	 * 进入登录页面
	 * @return
	 */
	@RequestMapping("/login.html")
	public String goLogin() {
		return go_login;
	}
	
	
	/**
	 * 获取Cookie的方法，每次进入主页都进行通过ajax查询，并返回响应状态。
	 * 1.返回json的时候，映射路径不能为getCookie.html、.htm等；
	 * 2.produces="application/json;charset=utf-8" 设置返回的；
	 * 3.页面打开 获取Cookie中的密码方法
	 */
	@ResponseBody
	@RequestMapping(value = "/getCookie", method = RequestMethod.POST,produces="application/json;charset=utf-8")
	public Object getCookie() throws Exception{
		Map<String,String> map = new HashMap<>(16);			
		Cookie[] cookies = ServletTool.getRequest().getCookies();
		// 创建默认值，减少分支代码。
		map.put("msg", "not find");	
		if(cookies != null) {
			for (Cookie c : cookies) {	
				if(!c.getValue().trim().equals("") && cookie_name != null && c.getName().equals(cookie_name)){
					map.put(GlobalConstant.cookie_name, c.getName());
					map.put(GlobalConstant.cookie_value, c.getValue());
					map.put("msg", "success");
				}
			}
		}
		return map;
	}
	

	/**
	 * @param user 用户实体
	 * @param request 请求
	 * @return 验证码验证、成功、失败状态
	 * 
	 * 用户登录进行验证的方法
	 * 将正确的用户存入session中。
	 * 整体流程：
	 * 1. 判断验证码是否通过，减轻直接连接数据源验证的负担；防止恶意破坏系统。
	 * 2. 上述通过 -- 判断传入的账号密码是否通过，验证非法数据，防止恶意破坏。
	 * 3. 上述通过 -- 连接数据源，判断用户是否存在。
	 * 4. 上述通过 -- 对象存入会话，并且通过全局变量保存CookieKey，以便于实现记住密码。
	 * 5. 上述通过 -- 通过传入参数判断是否需要保存
	 * 					--	- 如果条件成立 即执行添加Cookie操作。
	 * 					--  - 如果条件不成立 不管是否存在都进行清理一遍。
	 * 
	 * 6.不管是否保存Cookie最后条件通过验证，成功登陆。
	 */
	@ResponseBody
	@RequestMapping(value="/dologin",method=RequestMethod.POST)
	public String loginInto(String username,String password,String keep_pass,
			@RequestParam(required=true) String vercode,HttpServletResponse res) throws Exception {
		// 通过默认状态，减少判断分支代码。
		String status = GlobalConstant.error;	
		HttpSession session = ServletTool.getSession();
		String captchaStr = (String) session.getAttribute(GlobalConstant.captcha);
		if(!StringUtils.isBlank(vercode) && StringUtils.deleteWhitespace(vercode).equals(captchaStr)){
			if(!StringUtils.isBlank(username) && !StringUtils.isBlank(password)) {
				DUser user = dUserBiz.getLoginDUser(new DUser(username,MD5Util.md5Pass5(password)));
				if(user != null) {
					// 防止拦截		
					session.setAttribute(GlobalConstant.login_user, user); 
					// 使用全局变量保存key，以便于清除Cookie。
					cookie_name = user.getdLoginName();		
					if(keep_pass != null) {		
						EditCookie.add_Cookie(cookie_name,user.getdPassWord(),ServletTool.getRequest(),res);
					}else {
						EditCookie.del_Cookie(user.getdLoginName(),ServletTool.getRequest(),res);
					}
					status = GlobalConstant.success;
				}
			}
		}else {
			status = GlobalConstant.fail;
		}
		return status;
	}
	

	/**
	 * @param time 回调多次请求的时候根据系统当前时间来进行。
	 * 
	 * 获取验证码（Gif版本）的方法
	 * 注意：将值存入session中，以便获取验证码的值，通过覆盖进行值更新。
	 * 1.只要登录不成功即需要每次进行请求新的验证码。
	 * 2.需要设置响应头，告诉浏览器，并且不进行缓存。
	 * 3.session为true的时候当request不存在session，则创建一个；一般用于存、取数据。
	 * 4.session默认为true，session为false一般用于查询数据的时候，没有session不会创建新的；
	 */
	@RequestMapping(value = "/getGifCode.html", method = RequestMethod.GET)
	public void getGifCode(@RequestParam(required=false) String time,HttpServletResponse response,HttpServletRequest res) throws IOException {
			// 设置浏览器不缓存
			response.setHeader("Pragma", "No-cache");		
			// 设置响应头信息，不缓存
			response.setHeader("Cache-Control", "no-cache");
			// 在代理服务器端防止缓冲
			response.setDateHeader("Expires", 0);		
			// 设置图片格式
			response.setContentType("image/gif");			
			/*
			 *  1.创建gif格式动画验证码 宽，高，位数。
			 *  2.向客户端响应输出gif动态验证信息。
			 */
			Captcha captcha = new GifCaptcha(120, 40, 5);
			captcha.out(response.getOutputStream());
			HttpSession session = res.getSession(true);		
			session.setAttribute(GlobalConstant.captcha, captcha.text());
			System.out.println("生成的验证码："+captcha.text());
	}
	
	/**
	 * 解锁方法，解锁实际上也是相当于一次退出、登录操作。
	 * 因为解锁后，不能访问权限内的文件。
	 * 解锁有次数限制操作，当大于3次之后解锁注销退出登录；
	 * @param pass
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/openScreen")
	public String openScreen(@RequestParam String pass,@RequestParam Integer number) throws Exception {
		// 通过锁屏传入的登录的UserLoginName
		String userLoginName = (String) ServletTool.getSession().getAttribute("userLoginName");
		// 当密码不是空串或者null，并且数字不为空，<=3的时候才能进行解锁
		if(!StringUtils.isBlank(pass)) {
			// 判断解锁的次数，如果超过清空Cookie；
			if(number!=null && number<3) {
				DUser user = dUserBiz.getLoginDUser(new DUser(userLoginName, MD5Util.md5Pass5(pass)));
				cookie_name = user.getdLoginName();	// 标识
				if(user != null && user.getId() != null) {
					EditCookie.add_Cookie(user.getdLoginName(),user.getdPassWord(),ServletTool.getRequest(),ServletTool.getResponse());
					ServletTool.getSession().setAttribute(GlobalConstant.login_user, user);
					return GlobalConstant.success;
				}
			}else {
				EditCookie.del_Cookie(userLoginName, ServletTool.getRequest(), ServletTool.getResponse());
				return GlobalConstant.fail;
			}
		}
		return GlobalConstant.error;
	}
	
}
