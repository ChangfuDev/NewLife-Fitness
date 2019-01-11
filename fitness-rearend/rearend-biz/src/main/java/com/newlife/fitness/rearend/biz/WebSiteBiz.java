package com.newlife.fitness.rearend.biz;

import com.newlife.fitness.entity.Website;

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
