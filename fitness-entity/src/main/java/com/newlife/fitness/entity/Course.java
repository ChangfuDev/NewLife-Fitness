package com.newlife.fitness.entity;

import java.io.Serializable;
import java.util.List;

/**
 * 课程表 Course -- 一对多 -- courseVideos（课程视频） Course -- 一对多 -- userCourses（课程用户）
 */
public class Course implements Serializable {
	private static final long serialVersionUID = 1L;

	private int id;
	private String cName;
	private String cIsvip;
	private  String c_img;

	private List<CourseVideo> courseVideos;

	private List<UserCourse> userCourses;

	public Course() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getcName() {
		return cName;
	}

	public void setcName(String cName) {
		this.cName = cName;
	}

	public String getcIsvip() {
		return cIsvip;
	}

	public void setcIsvip(String cIsvip) {
		this.cIsvip = cIsvip;
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

	public String getC_img() {
		return c_img;
	}

	public void setC_img(String c_img) {
		this.c_img = c_img;
	}

}