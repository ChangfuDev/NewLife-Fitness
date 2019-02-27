package com.newlife.fitness.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * 前端用户表 FUser -- 一对多 -- Comment （评论类） FUser -- 一对多 -- Forum （帖子类） FUser -- 一对多
 * -- UserCourse （用户课程类） FUser -- 一对多 -- UserTrain （用户教练中间类）
 * 用户可能有多个评论，多个贴，多个课程，多个教练。
 */
public class FUser implements Serializable {
	private static final long serialVersionUID = 1L;

	private int id;
	private String fUserName;
	private String fLoginname;
	private String fPassword;
	private String fSex;
	private int fAge;
	private String fAddress;
	private String fEmail;
	private String fPhone;
	private String fIsvip;
	private String fImgurl;
	private Date fVipbegittime;
	private Date fVipendtime;
	private List<Comments> comments;
	private List<Forum> forums;
	private List<UserCourse> userCourses;
	private List<UserTrain> userTrains;

	public FUser() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getfUserName() {
		return fUserName;
	}

	public void setfUserName(String fUserName) {
		this.fUserName = fUserName;
	}

	public String getfLoginname() {
		return fLoginname;
	}

	public void setfLoginname(String fLoginname) {
		this.fLoginname = fLoginname;
	}

	public String getfPassword() {
		return fPassword;
	}

	public void setfPassword(String fPassword) {
		this.fPassword = fPassword;
	}

	public String getfSex() {
		return fSex;
	}

	public void setfSex(String fSex) {
		this.fSex = fSex;
	}

	public int getfAge() {
		return fAge;
	}

	public void setfAge(int fAge) {
		this.fAge = fAge;
	}

	public String getfAddress() {
		return fAddress;
	}

	public void setfAddress(String fAddress) {
		this.fAddress = fAddress;
	}

	public String getfEmail() {
		return fEmail;
	}

	public void setfEmail(String fEmail) {
		this.fEmail = fEmail;
	}

	public String getfPhone() {
		return fPhone;
	}

	public void setfPhone(String fPhone) {
		this.fPhone = fPhone;
	}

	public String getfIsvip() {
		return fIsvip;
	}

	public void setfIsvip(String fIsvip) {
		this.fIsvip = fIsvip;
	}

	public String getfImgurl() {
		return fImgurl;
	}

	public void setfImgurl(String fImgurl) {
		this.fImgurl = fImgurl;
	}

	public Date getfVipbegittime() {
		return fVipbegittime;
	}

	public void setfVipbegittime(Date fVipbegittime) {
		this.fVipbegittime = fVipbegittime;
	}

	public Date getfVipendtime() {
		return fVipendtime;
	}

	public void setfVipendtime(Date fVipendtime) {
		this.fVipendtime = fVipendtime;
	}

	public List<Comments> getComments() {
		return comments;
	}

	public void setComments(List<Comments> comments) {
		this.comments = comments;
	}

	public List<Forum> getForums() {
		return forums;
	}

	public void setForums(List<Forum> forums) {
		this.forums = forums;
	}

	public List<UserCourse> getUserCourses() {
		return userCourses;
	}

	public void setUserCourses(List<UserCourse> userCourses) {
		this.userCourses = userCourses;
	}

	public List<UserTrain> getUserTrains() {
		return userTrains;
	}

	public void setUserTrains(List<UserTrain> userTrains) {
		this.userTrains = userTrains;
	}

	@Override
	public String toString() {
		return "FUser [id=" + id + ", fUserName=" + fUserName + ", fLoginname=" + fLoginname + ", fPassword="
				+ fPassword + ", fSex=" + fSex + ", fAge=" + fAge + ", fAddress=" + fAddress + ", fEmail=" + fEmail
				+ ", fPhone=" + fPhone + ", fIsvip=" + fIsvip + ", fImgurl=" + fImgurl + ", fVipbegittime="
				+ fVipbegittime + ", fVipendtime=" + fVipendtime + ", comments=" + comments + ", forums=" + forums
				+ ", userCourses=" + userCourses + ", userTrains=" + userTrains + "]";
	}

	
	
}