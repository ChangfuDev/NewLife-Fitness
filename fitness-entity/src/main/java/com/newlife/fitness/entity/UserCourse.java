package com.newlife.fitness.entity;

import java.io.Serializable;

/**
 *	用户课程中间类
 *	一行记录 -- 对应 --> 一个课程，一个用户。
 *	多对多
 */
public class UserCourse implements Serializable {
	private static final long serialVersionUID = 1L;

	private int id;

	private Course course;

	private FUser FUser;

	public UserCourse() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Course getCourse() {
		return this.course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public FUser getFUser() {
		return this.FUser;
	}

	public void setFUser(FUser FUser) {
		this.FUser = FUser;
	}

}