package com.newlife.fitness.rearend.dao;


import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.newlife.fitness.entity.CourseVideo;

public interface CourseVideoDAO {

	/**
	 * 根据课程id查询相应数据
	 * @param cid
	 * @return
	 */
	List<CourseVideo> selectCCourseVideoByCourseId(@Param("cid")Integer cid,@Param("page") Integer page,@Param ("limit") Integer limit);

	/**
	 * 根据课程id查询相应课程视频的总数
	 * @param cid
	 * @return
	 */
	int selectCourseVideoCountByCourseId(@Param("cid") Integer cid);
	
	/**
	 * 保存课程视频
	 * @param courseVideo
	 * @return
	 */
	int insertCourseVideo(CourseVideo courseVideo);
	
	/**
	 * 删除单条课程视频
	 * @param courseVideo
	 * @return
	 */
	int delCourseVideo(@Param("id") Integer id);
	
	/**
	 * 根据课程id删除课程视频
	 * @param cid
	 * @return
	 */
	int delCourseVideoByCId(@Param("cid") Integer id);
	
	
	
}