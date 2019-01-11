package com.newlife.fitness.rearend.web.utils.md5tool;
import org.apache.commons.codec.digest.*;
import org.apache.commons.lang3.StringUtils;
/**
 * @ClassName: MD5Util  
 * @Description: MD5加密工具类
 * @author Unruly  
 * @date 2018年12月28日
 */
public class MD5Util {
	
	private MD5Util() {}
	
	/**
	 * MD5五次加密，如果已经加密的则无需加密。
	 * @param value
	 * @return
	 */
	public static String md5Pass5(String value) {
		int mad5Length = 32;
		if(StringUtils.isBlank(value)) {
			return value;
		}
		if(value.trim().length() != mad5Length) {
			for (int i = 0; i < 5; i++) {
				value = DigestUtils.md5Hex(value);
			}
		}
		return value;
	}
}