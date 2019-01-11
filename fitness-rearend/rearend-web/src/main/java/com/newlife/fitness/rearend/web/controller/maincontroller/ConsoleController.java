package com.newlife.fitness.rearend.web.controller.maincontroller;


import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.socket.TextMessage;

import com.newlife.fitness.entity.Announce;
import com.newlife.fitness.entity.DUser;
import com.newlife.fitness.rearend.biz.AnnounceBiz;
import com.newlife.fitness.rearend.web.utils.GlobalConstant;
import com.newlife.fitness.rearend.web.utils.ServletTool;
import com.newlife.fitness.rearend.web.websocket.SendInfoHandler;

/**
 * @ClassName: ConsoleController  
 * @Description: 控制台的Controller层
 * @author Unruly  
 * @date 2019年1月6日
 */
@Controller
@RequestMapping("/fitness-admin/home/")
public class ConsoleController {
	
	@Bean//这个注解会从Spring容器拿出Bean
    public SendInfoHandler infoHandler() {
        return new SendInfoHandler();
    }
	
	@Resource
	private AnnounceBiz announceBiz;
	
	// ----------------------------------------- 设置真实视图 -------------------------------------
	/** 表示首页控制台真实视图 */
	private final String page_console = "fitness-sys/home/console";		
	// ----------------------------------------- 设置真实视图 -------------------------------------

	// ----------------------------------------- 设置逻辑视图 -------------------------------------
	@RequestMapping("console.html")
	public String goConsole(Model model) {
		model.addAttribute("announce", announceBiz.findByLimit3());
		return page_console;
	}
	// ----------------------------------------- 设置逻辑视图 -------------------------------------
	
	/**
	 * 发送通知的方法
	 * @param content 带有代码的文本
	 * @param text 纯文本
	 * @return 
	 */
	@ResponseBody
	@RequestMapping(value="sendMessage.do",produces="application/json;charset=utf-8")
	public Object sendMessage(@RequestParam String content,@RequestParam String text) {
		// 定义一个返回的map对象，包含状态，信息，数据
		Map<String, Object> map = new HashMap<>();
		map.put("status", GlobalConstant.fail);
		map.put("msg", "发送通知失败！无权限，或者请检查发送内容是否为空！");
		
		// 获取发送通知的后台用户。
		HttpSession session = ServletTool.getSession();
		DUser dUser = (DUser) session.getAttribute(GlobalConstant.login_user);
		
		// 进行业务判断。
		if(GlobalConstant.object_nullExits(dUser) && dUser.getUserRole() == 0 && !StringUtils.deleteWhitespace(content).equals("") && !StringUtils.deleteWhitespace(text).equals("")) {
				Announce announce = new Announce();
				announce.setCodeContent(content);
				announce.setContent(text);
				announce.setCreateDate(new Date());
				announce.setdUser(dUser);
				// 判断是否插入数据库，是否发送通知给其他用户。
				if(announceBiz.addOneInfo(announce) && infoHandler().sendMessageToUsers(new TextMessage(content))) {
					map.put("status", GlobalConstant.success);
					map.put("msg", "发送成功~");
				}else {
					map.put("msg", "发送失败，系统错误！请稍候重试。");
				}
		}
		return map;
	}
	
}
