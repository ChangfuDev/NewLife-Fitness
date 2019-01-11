package com.newlife.fitness.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 *	前端用户表
 *	FUser -- 一对多 -- Comment		（评论类）
 *	FUser -- 一对多 -- Forum		（帖子类）
 *	FUser -- 一对多 -- UserCourse	（用户课程类）
 *	FUser -- 一对多 -- UserTrain	（用户教练中间类）
 *	用户可能有多个评论，多个贴，多个课程，多个教练。
 */
public class FUser implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer id;

	private String fAddress;

	private Integer fAge;

	private String fEmail;

	private String fImgUrl;

	private String fIsVip;

	private String fLoginName;

	private String fPassword;

	private String fPhone;

	private String fSex;

	private String fUserName;

	private Date fVipBegiTtime;

	private Date fVipEndTime;

	private List<Comments> comments;

	private List<Forum> forums;

	private List<UserCourse> userCourses;

	private List<UserTrain> userTrains;
	

	public FUser() {
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getfAddress() {
		return fAddress;
	}


	public void setfAddress(String fAddress) {
		this.fAddress = fAddress;
	}


	public Integer getfAge() {
		return fAge;
	}


	public void setfAge(Integer fAge) {
		this.fAge = fAge;
	}


	public String getfEmail() {
		return fEmail;
	}


	public void setfEmail(String fEmail) {
		this.fEmail = fEmail;
	}


	public String getfImgUrl() {
		return fImgUrl;
	}


	public void setfImgUrl(String fImgUrl) {
		this.fImgUrl = fImgUrl;
	}


	public String getfIsVip() {
		return fIsVip;
	}


	public void setfIsVip(String fIsVip) {
		this.fIsVip = fIsVip;
	}


	public String getfLoginName() {
		return fLoginName;
	}


	public void setfLoginName(String fLoginName) {
		this.fLoginName = fLoginName;
	}


	public String getfPassword() {
		return fPassword;
	}


	public void setfPassword(String fPassword) {
		this.fPassword = fPassword;
	}


	public String getfPhone() {
		return fPhone;
	}


	public void setfPhone(String fPhone) {
		this.fPhone = fPhone;
	}


	public String getfSex() {
		return fSex;
	}


	public void setfSex(String fSex) {
		this.fSex = fSex;
	}


	public String getfUserName() {
		return fUserName;
	}


	public void setfUserName(String fUserName) {
		this.fUserName = fUserName;
	}


	public Date getfVipBegiTtime() {
		return fVipBegiTtime;
	}


	public void setfVipBegiTtime(Date fVipBegiTtime) {
		this.fVipBegiTtime = fVipBegiTtime;
	}


	public Date getfVipEndTime() {
		return fVipEndTime;
	}


	public void setfVipEndTime(Date fVipEndTime) {
		this.fVipEndTime = fVipEndTime;
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
		return "FUser [id=" + id + ", fAddress=" + fAddress + ", fAge=" + fAge + ", fEmail=" + fEmail + ", fImgUrl="
				+ fImgUrl + ", fIsVip=" + fIsVip + ", fLoginName=" + fLoginName + ", fPassword=" + fPassword
				+ ", fPhone=" + fPhone + ", fSex=" + fSex + ", fUserName=" + fUserName + ", fVipBegiTtime="
				+ fVipBegiTtime + ", fVipEndTime=" + fVipEndTime + "]";
	}

}