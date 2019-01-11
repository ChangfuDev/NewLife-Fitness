package com.newlife.fitness.rearend.web.filter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.newlife.fitness.entity.DUser;
import com.newlife.fitness.rearend.web.utils.GlobalConstant;

/**
 * 
 * @ClassName: UserLoginIntercepter  
 * @Description: 后台过滤器，进入控制页面先进行判断。
 * @author Unruly  
 * @date 2018年12月28日  
 *
 */
public class UserLoginIntercepter extends HandlerInterceptorAdapter{

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
			HttpSession session = request.getSession();
			try {
				DUser user = (DUser) session.getAttribute(GlobalConstant.login_user);
				if(user != null) {
					return true;
				}else {
					response.sendRedirect(request.getContextPath()+"/403.html");
					return false;
				}
			} catch (RuntimeException e) {
				response.sendRedirect(request.getContextPath()+"/500.html");
				return false;
			}
			
	}

}
