package com.newlife.fitness.rearend.dao;

import org.apache.ibatis.annotations.Param;


public interface UserCourseDAO {

	/**
	 * 根据用户id删除所选课程
	 * @param userId
	 * @return
	 */
	public int delUserCourseByUserId(@Param("userId") int userId);
	
	
	/**
	 * 根据课程id删除所选课程
	 * @param cid
	 * @return
	 */
	public int delUserCourseByCId(@Param("cid") int cid);
	
	
	
}