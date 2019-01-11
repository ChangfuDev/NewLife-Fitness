package com.newlife.fitness.entity;

import java.io.Serializable;
import java.util.List;

/**
 *	教练类
 *	可以通过 --中间键（UserTrain）的教练id--  查询所对应的学生。
 */
public class Train implements Serializable {
	private static final long serialVersionUID = 1L;

	private int id;

	private String tAddress;

	private int tAge;

	private String tEmail;

	private String t_imgUrl;

	private String t_isVip;

	private String t_loginName;

	private String tPassword;

	private String tPhone;

	private String tSex;

	private String t_userName;

	private List<UserTrain> userTrains;

	public Train() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTAddress() {
		return this.tAddress;
	}

	public void setTAddress(String tAddress) {
		this.tAddress = tAddress;
	}

	public int getTAge() {
		return this.tAge;
	}

	public void setTAge(int tAge) {
		this.tAge = tAge;
	}

	public String getTEmail() {
		return this.tEmail;
	}

	public void setTEmail(String tEmail) {
		this.tEmail = tEmail;
	}

	public String getT_imgUrl() {
		return this.t_imgUrl;
	}

	public void setT_imgUrl(String t_imgUrl) {
		this.t_imgUrl = t_imgUrl;
	}

	public String getT_isVip() {
		return this.t_isVip;
	}

	public void setT_isVip(String t_isVip) {
		this.t_isVip = t_isVip;
	}

	public String getT_loginName() {
		return this.t_loginName;
	}

	public void setT_loginName(String t_loginName) {
		this.t_loginName = t_loginName;
	}

	public String getTPassword() {
		return this.tPassword;
	}

	public void setTPassword(String tPassword) {
		this.tPassword = tPassword;
	}

	public String getTPhone() {
		return this.tPhone;
	}

	public void setTPhone(String tPhone) {
		this.tPhone = tPhone;
	}

	public String getTSex() {
		return this.tSex;
	}

	public void setTSex(String tSex) {
		this.tSex = tSex;
	}

	public String getT_userName() {
		return this.t_userName;
	}

	public void setT_userName(String t_userName) {
		this.t_userName = t_userName;
	}

	public List<UserTrain> getUserTrains() {
		return this.userTrains;
	}

	public void setUserTrains(List<UserTrain> userTrains) {
		this.userTrains = userTrains;
	}

	public UserTrain addUserTrain(UserTrain userTrain) {
		getUserTrains().add(userTrain);
		userTrain.setTrain(this);

		return userTrain;
	}

	public UserTrain removeUserTrain(UserTrain userTrain) {
		getUserTrains().remove(userTrain);
		userTrain.setTrain(null);

		return userTrain;
	}

}