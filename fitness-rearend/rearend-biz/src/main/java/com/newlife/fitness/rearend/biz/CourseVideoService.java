package com.newlife.fitness.rearend.biz;

import java.util.List;

import com.newlife.fitness.entity.CourseVideo;

public interface CourseVideoService {


	/**
	 * 根据课程id获取课程的详细视频
	 * @param cid
	 * @return
	 */
	public List<CourseVideo> getCourseVideoByCourseId(Integer cid,Integer page,Integer limit);
	
	/**
	 * 根据课程id获取相应课程的总数
	 * @param cid
	 * @return
	 */
	public int getCourseVideoCountByCourseId(Integer cid);

	/**
	 * 保存課程視頻
	 * @param courseVideo
	 * @return
	 */
	public int saveCourseVideo(CourseVideo courseVideo);

	/**
	 * 删除课程视频
	 * @param id
	 * @return
	 */
	public int delCourseVideo(Integer id);

}
