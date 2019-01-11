package com.newlife.fitness.rearend.web.controller.indexcontroller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang3.RandomUtils;
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
import com.newlife.fitness.rearend.web.utils.md5tool.MD5Util;
import com.newlife.fitness.rearend.web.utils.regTool.GlobalRegTool;
import com.newlife.fitness.rearend.web.utils.sendsms.SendSMSTool;

/**
 * 
 * @ClassName: ForgetController
 * @Description: 忘记密码板块：手机验证，验证码验证，短信验证，个人密码重置。
 * @author Unruly
 * @date 2018年12月28日
 */
@Controller
public class ForgetController {

	@Resource
	private DUserBiz dUserBiz;

	/** 忘记密码逻辑视图名 */
	private final String page_forget = "forget"; 

	/**
	 * 进入忘记密码界面
	 * 
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/forget.html")
	public String intoForget() throws Exception {
		return page_forget;
	}

	/**
	 * 先验证手机号是否合法，验证数据库是否存在手机号； 如果手机不合法直接返回； 防止同一手机号重复验证因此将通过的手机号，返回放至隐藏域。
	 * @return Map<String,Object> msg：返回信息 status：返回状态 phone：隐藏的手机号保存
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping(value = "/validation", produces = "application/json;charset=utf-8")
	public Object validationPhone(@RequestParam(name = "phoneNum", required = true) String num) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>(16);
		// 默认状态 减少分支代码
		map.put("status", GlobalConstant.fail);
		map.put("msg", "输入的手机号不合法");
		map.put("phone", ""); 
		if (!StringUtils.isBlank(num) && GlobalRegTool.phone_reg(num)) {
			// 如果手机有数据才查询
			DUser dUser = dUserBiz.getLoginDUser(new DUser(num));
			// 判断用户是否存在
			if (GlobalConstant.object_nullExits(dUser)) { 			
				map.put("status", GlobalConstant.success);
				map.put("phone", dUser.getdPhone());
				//	用来最后修改用户
				ServletTool.getSession().setAttribute(GlobalConstant.session_phone, dUser.getdPhone());	
				//	用来最后修改用户
				ServletTool.getSession().setAttribute(GlobalConstant.session_userid, dUser.getId());		
			} else {
				map.put("msg", "用户手机号并不存在");
			}
		}
		return map;
	}

	/**
	 * 发送短信的方法
	 * @param num 手机号
	 * @param res 
	 * @return 发送的状态
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping(value = "/sendMessage")
	public Object getSMS(@RequestParam(name = "phone", required = true) String phone) throws Exception {
		HashMap<String, Object> map = new HashMap<>(16);
		map.put(GlobalConstant.code, 1001);
		map.put(GlobalConstant.msg, "发送信息失败：请输入合法的手机号！");
		if (!StringUtils.isBlank(phone) && GlobalRegTool.phone_reg(phone)) {
			/* 随机的生成的手机验证码 */
			String phoneVercode = String.valueOf(RandomUtils.nextInt(10000, 100000));
			String sendMessage = SendSMSTool.SendMessage(phoneVercode, phone);
			map.put(GlobalConstant.code,0);
			map.put(GlobalConstant.msg, sendMessage);
			ServletTool.getSession().setAttribute(GlobalConstant.session_phone, phone);    
			// 将验证信息存入Session
			ServletTool.getSession().setAttribute(GlobalConstant.phone_code, phoneVercode);
		}
		return map;
	}
	
	/**
	 * 身份验证完毕的信息
	 * 先验证验证码是否正确，再验证手机验证码是否正确。
	 * @return 
	 */
	@ResponseBody
	@RequestMapping(value="/validation_forget")
	public String validation(@RequestParam(name = "imgVercode",required=true)String imgVercode,
							  @RequestParam(name = "vercode",required=true)String vercode) {
		// 获取Session中的图形验证码和手机验证码
		String img = (String) ServletTool.getSession().getAttribute(GlobalConstant.captcha);			
		String phone = (String) ServletTool.getSession().getAttribute(GlobalConstant.phone_code);		
		// 默认验证码验证失败
		String status = GlobalConstant.fail;		
		if(imgVercode.trim().equals(img)) {			
			// 如果图形验证正确，那么进行手机号验证；最后返回状态。
			if(!StringUtils.isBlank(phone)&&vercode.trim().equals(phone)) {
				status = GlobalConstant.success;	
				ServletTool.getSession().removeAttribute(GlobalConstant.phone_code);
			}else {
				status = GlobalConstant.error;		
			}
		}
		return status;
	}
	
	/**
	 * 重置密码的方法
	 * @param oldPass 
	 * 				旧密码
	 * @param newPass
	 * 				新密码
	 * @return		状态结果
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping(value="/resetpassword",method=RequestMethod.POST)
	public String restPassWord(@RequestParam(value="password")String password,@RequestParam(value="repass")String repass) throws Exception {
		// 设置默认的失败状态为失败；并且获取通过验证后储存在Session中的手机号和用户id；
		String status = GlobalConstant.error;		
		String  userPhone= (String) ServletTool.getSession().getAttribute(GlobalConstant.session_phone);
		Integer userID = (Integer) ServletTool.getSession().getAttribute(GlobalConstant.session_userid);
		int length = 6;
		// 在密码相等的情况下进入密码重置；
		if(!StringUtils.isBlank(password)&& password.length()>= length && password.equals(repass)) {
			/*
			 * 1.&&具有短路功能，如果为空不进行判断。
			 * 2.如果userID通过某些情况没有获取到，那么通过最后传递上的手机号进行查询。
			 * 3.查询到后，再进行修改返回状态。
			 */
			if(userID != null && dUserBiz.modifyDUser(new DUser(userID,MD5Util.md5Pass5(repass),null))) {
				status = GlobalConstant.success;
			}else if(userPhone != null && !StringUtils.isBlank(userPhone)) {
				DUser dUser = new DUser(null,null,userPhone);		
				DUser findDUser= dUserBiz.getLoginDUser(dUser);		
				findDUser.setdPassWord(MD5Util.md5Pass5(repass));	
				if(findDUser != null && dUserBiz.modifyDUser(findDUser)) {
					status = GlobalConstant.success;
				}
			}
		}
		return status;
	}
	
	

}
