package com.newlife.fitness.rearend.biz.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.newlife.fitness.entity.Website;
import com.newlife.fitness.rearend.biz.WebSiteBiz;
import com.newlife.fitness.rearend.dao.WebsiteDAO;

@Service
public class WebSiteBizImpl implements WebSiteBiz{
	
	@Resource
	private WebsiteDAO websiteDao;
	
	@Override
	public Website findWebsiteInfo() {
		return websiteDao.selectInfo();
	}

	@Override
	public boolean updateWebsiteInfo(Website website) {
		return websiteDao.updateInfo(website) == 1;
	}
	
}
