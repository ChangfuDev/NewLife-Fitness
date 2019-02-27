package com.newlife.fitness.rearend.biz.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.newlife.fitness.entity.CourseVideo;
import com.newlife.fitness.rearend.biz.CourseVideoService;
import com.newlife.fitness.rearend.dao.CourseVideoDAO;

@Service("courseVideoService")
public class CourseVideoServiceImpl implements CourseVideoService {

	@Autowired
	private CourseVideoDAO courseVideoDao;
	
	@Override
	public List<CourseVideo> getCourseVideoByCourseId(Integer cid,Integer page,Integer limit) {
		// TODO Auto-generated method stub
		return courseVideoDao.selectCCourseVideoByCourseId(cid,(page-1)*limit,limit);
	}
	

	@Override
	public int getCourseVideoCountByCourseId(Integer cid) {
		// TODO Auto-generated method stub
		return courseVideoDao.selectCourseVideoCountByCourseId(cid);
	}
	

	@Override
	public int saveCourseVideo(CourseVideo courseVideo) {
		// TODO Auto-generated method stub
		return courseVideoDao.insertCourseVideo(courseVideo);
	}


	@Override
	public int delCourseVideo(Integer id) {
		// TODO Auto-generated method stub
		return courseVideoDao.delCourseVideo(id);
	}
	

}
