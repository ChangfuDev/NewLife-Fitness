package com.newlife.fitness.rearend.biz;

import com.newlife.fitness.entity.Website;

/**
 * 
 * @ClassName: WebSiteBiz  
 * @Description: TODO
 * @author Unruly  
 * @date 2019年1月12日
 */
public interface WebSiteBiz {
	/**
	 * 找到网站设置的服务
	 * @return Website
	 */
	Website findWebsiteInfo();
	
	/**
	 * 修改网站信息
	 * @return 是否成功
	 */
	boolean updateWebsiteInfo(Website website) throws Exception;
}
