package com.newlife.fitness.rearend.biz.impl;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;

import com.newlife.fitness.entity.DUser;
import com.newlife.fitness.rearend.biz.DUserBiz;
import com.newlife.fitness.rearend.dao.DUserDAO;

/**
 * @ClassName: DUserBizImpl  
 * @Description: 后台用户业务实现类
 * @author Unruly  
 * @date 2019年1月4日
 */
@Service
public class DUserBizImpl implements DUserBiz {
	
	@Resource
	private DUserDAO dUserDao;

	@Override
	public DUser getLoginDUser(DUser user) throws Exception {
		return dUserDao.selectByEntity(user);
	}

	@Override
	public int addDUser(DUser user) throws Exception {
		return dUserDao.insert(user);
	}

	@Override
	public boolean modifyDUser(DUser user) throws Exception {
		return dUserDao.update(user) == 1;
	}
	
}
