package com.newlife.fitness.rearend.web.websocket;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.http.server.ServletServerHttpRequest;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.server.HandshakeInterceptor;

import com.newlife.fitness.entity.DUser;
import com.newlife.fitness.rearend.web.utils.GlobalConstant;

/**
 * @ClassName: WebSocketFilter  
 * @Description: websocket过滤器
 * @author Unruly  
 * @date 2019年1月8日
 */
public class WebSocketInterceptor implements HandshakeInterceptor {

	    /**
	     * 建立管道，握手前；
	     */
	    @Override
	    public boolean beforeHandshake(ServerHttpRequest request, ServerHttpResponse response, WebSocketHandler webSocketHandler, Map<String, Object> map) throws Exception {
	    	if (request instanceof ServletServerHttpRequest) {
	            ServletServerHttpRequest serverHttpRequest = (ServletServerHttpRequest) request;
	            HttpSession session = serverHttpRequest.getServletRequest().getSession();
	            if (session != null) {
	            	DUser obj = (DUser) session.getAttribute(GlobalConstant.login_user);
	                map.put(obj.getdLoginName(),obj);
	            }
	        }
	        return true;
	    }

	    /**
	     * 建立管道，握手后；
	     */
	    @Override
	    public void afterHandshake(ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse, WebSocketHandler webSocketHandler, Exception e) {
	    	afterHandshake(serverHttpRequest, serverHttpResponse, webSocketHandler, e);
	    }
}