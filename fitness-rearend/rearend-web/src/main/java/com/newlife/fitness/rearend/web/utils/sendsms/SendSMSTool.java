package com.newlife.fitness.rearend.web.utils.sendsms;

import org.apache.commons.lang3.StringUtils;
import com.alibaba.fastjson.JSONObject;
import com.newlife.fitness.rearend.web.utils.sendsms.depend.client.AbsRestClient;
import com.newlife.fitness.rearend.web.utils.sendsms.depend.client.JsonReqClient;
/**
 * @ClassName: SendSMSTool  
 * @Description: 主要调用 云之讯 接口发送短信工具类
 * @author Unruly  
 * @date 2018年12月28日
 */
public class SendSMSTool {
	
	static AbsRestClient InstantiationRestAPI() {
		return new JsonReqClient();
	}
	
	/**
	 * 发送短信的方法
	 * @param randNum 
	 * 			随机验证码
	 * @param mobile 
	 * 			验证电话号码
	 * @return 
	 * 			发送状态 比如：OK、发送不成功等等
	 * 			返回状态：http://docs.ucpaas.com/doku.php?id=error_code
	 */ 
	public static String SendMessage(String randNum, String mobile){
		if(StringUtils.isBlank(mobile)) {
			return "手机号：Is a blank";
		}
		String sid  = "36c9b63fecd1952123c1d21f53ca42a7";	
		String token = "6c3000d9c241cc0dc32d6f279699b8c2";	
		String appid ="006bb2f7d21a4f288ff550d0e4d33c20";
		String templateid ="415648";					//模板
		String result=InstantiationRestAPI().sendSms(sid, token, appid, templateid, randNum, mobile, appid);
		JSONObject json = JSONObject.parseObject(result);
		return json.getString("msg");
	}
	
	public static String SendMessageAsAdvisor(String mobile){
		if(StringUtils.isBlank(mobile)) {
			return "手机号：Is a blank";
		}
		String sid  = "36c9b63fecd1952123c1d21f53ca42a7";	
		String token = "6c3000d9c241cc0dc32d6f279699b8c2";	
		String appid ="006bb2f7d21a4f288ff550d0e4d33c20";
		String templateid ="418850";					//模板
		String result=InstantiationRestAPI().sendSms(sid, token, appid, templateid, null, mobile, appid);
		JSONObject json = JSONObject.parseObject(result);
		return json.getString("msg");
	}
}
