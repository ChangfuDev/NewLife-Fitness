package com.newlife.fitness.rearend.web.websocket;


import java.util.HashMap;
import java.util.Map;

import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.WebSocketMessage;
import org.springframework.web.socket.WebSocketSession;

import com.alibaba.fastjson.JSON;
import com.newlife.fitness.entity.MonitorInfoBean;
import com.newlife.fitness.rearend.biz.IMonitorBiz;
import com.newlife.fitness.rearend.biz.impl.MonitorBizImpl;

public class SystemInfoHandler implements WebSocketHandler {

	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
		while(true) {
			Map<String, Object> map = new HashMap<>();
			IMonitorBiz iMonitor = new MonitorBizImpl();
			MonitorInfoBean monitorInfo = iMonitor.MonitorInfoBean();
			map.put("cpu", monitorInfo.getCpuRatio()); // cpu使用率
			map.put("totalSize", monitorInfo.getTotalMemorySize());// 总的物理内存
			map.put("usedMemory", monitorInfo.getUsedMemory()); // 已经使用的物理内存
			session.sendMessage(new TextMessage(JSON.toJSONString(map)));
			Thread.sleep(500);
		}
	}

	@Override
	public void handleMessage(WebSocketSession session, WebSocketMessage<?> message) throws Exception {
		
	}

	@Override
	public void handleTransportError(WebSocketSession session, Throwable exception) throws Exception {
		
	}

	@Override
	public void afterConnectionClosed(WebSocketSession session, CloseStatus closeStatus) throws Exception {
		
	}

	@Override
	public boolean supportsPartialMessages() {
		return false;
	}

}
