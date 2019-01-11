package com.newlife.fitness.rearend.web.utils.regTool;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 全局的正则验证
 * @ClassName: GlobalRegTool  
 * @Description: TODO
 * @author Unruly  
 * @date 2018年12月29日
 */
public class GlobalRegTool {
	private GlobalRegTool() {}
	/**
	 * 验证手机号的正则表达式
	 * @param phoneNum 
	 * 				验证的手机号
	 * @return
	 */
	public static boolean phone_reg(String phoneNum) {
			String pattern = "0?(13|14|15|17|18)[0-9]{9}";
			Pattern r = Pattern.compile(pattern);
			Matcher m = r.matcher(phoneNum);
			return m.matches();
	}
	
}
