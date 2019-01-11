package com.newlife.fitness.rearend.dao;

import com.newlife.fitness.entity.Website;

public interface WebsiteDAO {
	
	/**
	 * 查询所有网站信息
	 */
	Website selectInfo();
	
	/**
	 * 修改网站信息
	 * @return
	 */
	int updateInfo(Website website);
	
}
