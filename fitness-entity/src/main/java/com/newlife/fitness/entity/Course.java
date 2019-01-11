package com.newlife.fitness.entity;

import java.io.Serializable;
import java.util.List;

/**
 *	课程表
 *  Course -- 一对多 -- courseVideos（课程视频）
 *  Course -- 一对多 -- userCourses（课程用户）
 */
public class Course implements Serializable {
	private static final long serialVersionUID = 1L;

	private int id;

	private String c_isVip;

	private String cName;

	private List<CourseVideo> courseVideos;

	private List<UserCourse> userCourses;

	public Course() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getC_isVip() {
		return this.c_isVip;
	}

	public void setC_isVip(String c_isVip) {
		this.c_isVip = c_isVip;
	}

	public String getCName() {
		return this.cName;
	}

	public void setCName(String cName) {
		this.cName = cName;
	}

	public List<CourseVideo> getCourseVideos() {
		return this.courseVideos;
	}

	public void setCourseVideos(List<CourseVideo> courseVideos) {
		this.courseVideos = courseVideos;
	}

	public CourseVideo addCourseVideo(CourseVideo courseVideo) {
		getCourseVideos().add(courseVideo);
		courseVideo.setCourse(this);

		return courseVideo;
	}

	public CourseVideo removeCourseVideo(CourseVideo courseVideo) {
		getCourseVideos().remove(courseVideo);
		courseVideo.setCourse(null);

		return courseVideo;
	}

	public List<UserCourse> getUserCourses() {
		return this.userCourses;
	}

	public void setUserCourses(List<UserCourse> userCourses) {
		this.userCourses = userCourses;
	}

	public UserCourse addUserCours(UserCourse userCours) {
		getUserCourses().add(userCours);
		userCours.setCourse(this);

		return userCours;
	}

	public UserCourse removeUserCours(UserCourse userCours) {
		getUserCourses().remove(userCours);
		userCours.setCourse(null);

		return userCours;
	}

}