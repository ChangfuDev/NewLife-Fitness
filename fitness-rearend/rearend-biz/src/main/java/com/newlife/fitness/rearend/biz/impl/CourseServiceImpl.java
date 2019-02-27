package com.newlife.fitness.rearend.biz.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.newlife.fitness.entity.Course;
import com.newlife.fitness.rearend.biz.CourseService;
import com.newlife.fitness.rearend.dao.CourseDAO;
import com.newlife.fitness.rearend.dao.CourseVideoDAO;
import com.newlife.fitness.rearend.dao.UserCourseDAO;

@Service("courseService")
public class CourseServiceImpl implements CourseService {

	@Autowired
	private CourseDAO courseDao;
	
	@Autowired
	private CourseVideoDAO courseVideoDao;

	@Autowired
	private UserCourseDAO userCourse;
	
	@Override
	public int getCourseCount(String cname, String cIsvip) {
		// TODO Auto-generated method stub
		return courseDao.selectCount(cname, cIsvip);
	}

	@Override
	public List<Course> getCourses(String cname, String cIsvip, Integer page, Integer limit) {
		// TODO Auto-generated method stub
		return courseDao.selectCoursesBycNameOrcIsVip(cname, cIsvip, (page-1)*limit, limit);
	}

	@Override
	public int saveCourse(Course course) {
		// TODO Auto-generated method stub
		return courseDao.insertCourse(course);
	}

	@Override
	public Course getCourse(Integer id) {
		return courseDao.selectCourseById(id);
	}

	@Override
	public int importCourse(List<Course> importCourses) {
		// TODO Auto-generated method stub
		return courseDao.importCourse(importCourses);
	}

	@Override
	public int delCourse(Integer id) {
		//先删除课程下的所有视频
		courseVideoDao.delCourseVideoByCId(id);
		//删除用户所选的课程
		userCourse.delUserCourseByCId(id);
		return courseDao.delCourse(id);
	}

}
