package com.newlife.fitness.rearend.biz;

import java.util.List;

import com.newlife.fitness.entity.Course;

public interface CourseService {

	/**
	 * 获取课程总数
	 * 
	 * @param cname
	 * @param cIsvip
	 * @return
	 */
	int getCourseCount(String cname, String cIsvip);

	/**
	 * 获取所有课程
	 * 
	 * @param cname
	 * @param cIsvip
	 * @return
	 */
	List<Course> getCourses(String cname, String cIsvip, Integer page, Integer limit);

	/***
	 * 添加课程
	 * @param course
	 * @return
	 */
	int saveCourse(Course course);

	/**
	 * 获取一门课程
	 * @param id
	 * @return
	 */
	Course getCourse(Integer id);

	/**
	 * 批量插入课程
	 * @param importCourses
	 * @return
	 */
	int importCourse(List<Course> importCourses);

	/**
	 * 删除课程
	 * @param id
	 * @return
	 */
	int delCourse(Integer id);

}
