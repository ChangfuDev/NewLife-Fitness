package com.newlife.fitness.rearend.biz.impl;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.newlife.fitness.entity.FUser;
import com.newlife.fitness.rearend.biz.FUserService;
import com.newlife.fitness.rearend.dao.CommentsDAO;
import com.newlife.fitness.rearend.dao.FUserDAO;
import com.newlife.fitness.rearend.dao.ForumDAO;
import com.newlife.fitness.rearend.dao.UserCourseDAO;
import com.newlife.fitness.rearend.dao.UserTrainDAO;

@Service("fuserService")
public class FUserServiceImpl implements FUserService {

	@Autowired
	private FUserDAO fUserDao;
	
	@Autowired
	private CommentsDAO commentsDAO;
	
	@Autowired
	private ForumDAO forumDAO;

	@Autowired
	private UserTrainDAO userTrainDAO;
	
	@Autowired
	private UserCourseDAO userCourseDAO;
	
    @Override
    public int getCountByUserNameOrSex(String fUserName, String fSex, String fIsvip) {
        return fUserDao.selectCountByUserNameOrSex(fUserName, fSex, fIsvip);
    }

    @Override
    public List<FUser> getFUserByUserNameOrSex(String fUserName, String fSex, String fIsvip, Integer page,
            Integer limit) {
        return fUserDao.selectFUserByUserNameOrSex(fUserName, fSex, fIsvip, (page-1)*limit, limit);
    }

	@Override
	public int saveFUser(FUser user) {
		// TODO Auto-generated method stub
		return fUserDao.insertFUser(user);
	}

	@Override
	public FUser getFUser(int id) {
		// TODO Auto-generated method stub
		return fUserDao.selectFUserById(id);
	}

	@Override
	public int modifyUser(FUser user) {
		// TODO Auto-generated method stub
		return fUserDao.updateUser(user);
	}

	@Override
	public int delUser(int id) {
		int flag = 0;
		//获取要删除用户所创建的论坛
		List<Integer> forumIds = forumDAO.selectForumIdByUserId(id);
		//如果用户有发帖就删除
		if(forumIds.size()>0) {
			//删除用户创建的论坛回帖信息
			commentsDAO.delCommentsByForumId(forumIds);
		}
		//删除用户回帖
		commentsDAO.delCommentsByUserId(id);
		//删除用户所创建的论坛
		forumDAO.delForumByUserId(id);
		//删除用户的教练预约信息
		userTrainDAO.delUserTrainByUserId(id);
		//删除用户所选的相关课程
		userCourseDAO.delUserCourseByUserId(id);
		//删除用户基本信息
		flag = fUserDao.delUser(id);
		return flag;
	}

	@Override
	public int importUser(List<FUser> importCourses) {
		// TODO Auto-generated method stub
		return fUserDao.importUser(importCourses);
	}
	

}
