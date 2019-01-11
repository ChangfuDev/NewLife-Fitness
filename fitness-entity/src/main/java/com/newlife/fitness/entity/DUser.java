package com.newlife.fitness.entity;

import java.io.Serializable;

/**
 * 后台管理员类
 * 没啥关联性
 */
public class DUser implements Serializable{
	private static final long serialVersionUID = 1L;

	private Integer id;

	private String dEmail;

	private String dImgUrl;

	private String dLoginName;

	private String dPassWord;

	private String dPhone;

	private String dSex;

	private String dUserName;
	
	private Integer userRole;
	
	private String dMark;
	

	public DUser(String dLoginName, String dPassWord) {
		this.dLoginName = dLoginName;
		this.dPassWord = dPassWord;
	}
	
	public DUser(Integer id, String dImgUrl) {
		this.id = id;
		this.dImgUrl = dImgUrl;
	}

	public DUser(Integer id, String dEmail, String dImgUrl, String dLoginName, String dPassWord, String dPhone, String dSex,
			String dUserName) {
		super();
		this.id = id;
		this.dEmail = dEmail;
		this.dImgUrl = dImgUrl;
		this.dLoginName = dLoginName;
		this.dPassWord = dPassWord;
		this.dPhone = dPhone;
		this.dSex = dSex;
		this.dUserName = dUserName;
	}

	public DUser() {
		super();
	}


	public DUser(Integer id, String dPassWord, String dPhone) {
		super();
		this.id = id;
		this.dPassWord = dPassWord;
		this.dPhone = dPhone;
	}
	

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getdEmail() {
		return dEmail;
	}

	public void setdEmail(String dEmail) {
		this.dEmail = dEmail;
	}

	public String getdImgUrl() {
		return dImgUrl;
	}

	public void setdImgUrl(String dImgUrl) {
		this.dImgUrl = dImgUrl;
	}

	public String getdLoginName() {
		return dLoginName;
	}

	public void setdLoginName(String dLoginName) {
		this.dLoginName = dLoginName;
	}

	public String getdPassWord() {
		return dPassWord;
	}

	public void setdPassWord(String dPassWord) {
		this.dPassWord = dPassWord;
	}

	public String getdPhone() {
		return dPhone;
	}

	public void setdPhone(String dPhone) {
		this.dPhone = dPhone;
	}

	public String getdSex() {
		return dSex;
	}

	public void setdSex(String dSex) {
		this.dSex = dSex;
	}

	public String getdUserName() {
		return dUserName;
	}

	public void setdUserName(String dUserName) {
		this.dUserName = dUserName;
	}

	public DUser(String dPhone) {
		super();
		this.dPhone = dPhone;
	}

	public Integer getUserRole() {
		return userRole;
	}

	public void setUserRole(Integer userRole) {
		this.userRole = userRole;
	}

	public String getdMark() {
		return dMark;
	}

	public void setdMark(String dMark) {
		this.dMark = dMark;
	}

	@Override
	public String toString() {
		return "DUser [id=" + id + ", dEmail=" + dEmail + ", dImgUrl=" + dImgUrl + ", dLoginName=" + dLoginName
				+ ", dPassWord=" + dPassWord + ", dPhone=" + dPhone + ", dSex=" + dSex + ", dUserName=" + dUserName
				+ ", userRole=" + userRole + ", dMark=" + dMark + "]";
	}

}