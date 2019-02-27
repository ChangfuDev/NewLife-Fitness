package com.newlife.fitness.rearend.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.newlife.fitness.entity.Course;

public interface CourseDAO {

	/**
	 * 查询数据总条数
	 * 
	 * @param cname
	 * @param cIsvip
	 * @return
	 */
	int selectCount(@Param("cName")String cname, @Param("cIsvip")String cIsvip);
	
	/**
	 * 根据课程名称或者课程是否vip可看查询分页相应数据
	 * 
	 * @param cname
	 * @param cIsvip
	 * @param limit
	 * @param page
	 * @return
	 */
	List<Course> selectCoursesBycNameOrcIsVip(@Param("cname") String cname, @Param("cIsvip") String cIsvip,
			@Param("page") Integer page, @Param("limit") Integer limit);

	/**
	 * 新增课程
	 * @param course
	 * @return
	 */
	int insertCourse(Course course);

	/**
	 * 查詢一個课程
	 * @param id
	 * @return
	 */
	Course selectCourseById(@Param("id") Integer id);

	/**
	 * 批量插入数据
	 * @param importCourses
	 * @return
	 */
	int importCourse(List<Course> importCourses);

	/**
	 * 删除数据
	 * @param id
	 * @return
	 */
	int delCourse(@Param("id") Integer id);

	
}