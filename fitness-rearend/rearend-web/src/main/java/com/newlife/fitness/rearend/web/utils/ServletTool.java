package com.newlife.fitness.rearend.web.utils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

public class ServletTool {
	private ServletTool() {}
	/**
	 * @return 
	 * 		Session对象
	 */
	public static HttpSession getSession() { 
	    HttpSession session = null; 
	    try { 
	        session = getRequest().getSession(); 
	    } catch (Exception e) {
	    	e.printStackTrace();
	    } 
	        return session; 
	} 
	
	/**
	 * @return
	 * 		Request对象
	 */
	public static HttpServletRequest getRequest() { 
	    ServletRequestAttributes attrs =(ServletRequestAttributes) RequestContextHolder.getRequestAttributes(); 
	    return attrs.getRequest(); 
	} 
	
	/**
	 * @return
	 * 		Response对象
	 */
	public static HttpServletResponse getResponse() { 
	    ServletRequestAttributes attrs =(ServletRequestAttributes) RequestContextHolder.getRequestAttributes(); 
	    return attrs.getResponse(); 
	} 
}
