package com.newlife.fitness.entity;

import java.io.Serializable;

/**
 * 课程视频类
 * courseVideo -- 多对一 -- course（课程）
 */
public class CourseVideo implements Serializable {
	private static final long serialVersionUID = 1L;

	private int id;

	private String title;

	private String videoUrl;
	
	private int courseId;

	private Course course;

	public CourseVideo() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getVideoUrl() {
		return this.videoUrl;
	}

	public void setVideoUrl(String videoUrl) {
		this.videoUrl = videoUrl;
	}
	
	

	public int getCourseId() {
		return courseId;
	}

	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}

	public Course getCourse() {
		return this.course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

}