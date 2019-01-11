package com.newlife.fitness.rearend.web.websocket;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.WebSocketMessage;
import org.springframework.web.socket.WebSocketSession;

import com.newlife.fitness.rearend.web.utils.GlobalConstant;

/**
 * @ClassName: MsgScoketHandle
 * @Description: 信息处理器；
 * @author Unruly
 * @date 2019年1月8日
 */
@Component
public class SendInfoHandler implements WebSocketHandler {
	// 在线用户列表
	private static final List<WebSocketSession> users;

	static {
		users = new ArrayList<WebSocketSession>();
	}


	/**
	 * 建立连接后
	 */
	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
		// 添加到List中
		users.add(session);
		System.out.println("连接成功！");
	}
	

	/**
	 * 接受到消息后
	 */
	@Override
	public void handleMessage(WebSocketSession session, WebSocketMessage<?> message) throws Exception {
		System.out.println(message.getPayload().toString());
	}

	/**
	 * 发生异常后
	 */
	@Override
	public void handleTransportError(WebSocketSession session, Throwable exception) throws Exception {
		// 判断进行关闭，移除WebSocketSession。
		if (session.isOpen()) {
			session.close();
		}
		users.remove(session.getAttributes().get(GlobalConstant.websocket_user));
	}

	/**
	 * 断开连接后
	 */
	@Override
	public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
		users.remove(session);
	}

	@Override
	public boolean supportsPartialMessages() {
		return false;
	}
	
	/**
     * 给所有在线用户发送消息
     * @param message
     */
    public boolean sendMessageToUsers(TextMessage message) {
    	boolean flag = true;
        try {
			for (WebSocketSession user : users) {
			    if (user.isOpen()) {
			        user.sendMessage(message);
			    }
			}
		} catch (IOException e) {
			e.printStackTrace();
			flag = false;
		}
        return flag;
    }
	
}