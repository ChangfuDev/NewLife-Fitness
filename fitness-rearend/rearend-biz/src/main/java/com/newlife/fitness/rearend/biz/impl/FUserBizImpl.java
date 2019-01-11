package com.newlife.fitness.rearend.biz.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.newlife.fitness.entity.FUser;
import com.newlife.fitness.rearend.biz.FUserBiz;
import com.newlife.fitness.rearend.dao.FUserDAO;

/**
 * @ClassName: FUserBizImpl  
 * @Description: 前台用于业务实现类
 * @author Unruly  
 * @date 2019年1月4日
 */
@Service
public class FUserBizImpl implements FUserBiz {
	
	@Resource
	private FUserDAO fUser;

	@Override
	public boolean addFUser(FUser user) {
		return fUser.insert(user) == 1;
	}

}
