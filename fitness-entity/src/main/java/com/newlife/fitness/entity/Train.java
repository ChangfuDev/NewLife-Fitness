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
	private String tUsername;
	private String tLoginname;
	private String tPassword;
	private String tSex;
	private int tAge;
	private String tAddress;
	private String tEmail;
	private String tPhone;
	private String tIsvip;
	private String tImgurl;
	
	private List<UserTrain> userTrains;

	public Train() {
		
	}
	
	public Train(int id, String tUsername, String tLoginname, String tPassword, String tSex, int tAge, String tAddress,
			String tEmail, String tPhone, String tIsvip, String tImgurl, List<UserTrain> userTrains) {
		super();
		this.id = id;
		this.tUsername = tUsername;
		this.tLoginname = tLoginname;
		this.tPassword = tPassword;
		this.tSex = tSex;
		this.tAge = tAge;
		this.tAddress = tAddress;
		this.tEmail = tEmail;
		this.tPhone = tPhone;
		this.tIsvip = tIsvip;
		this.tImgurl = tImgurl;
		this.userTrains = userTrains;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String gettUsername() {
		return tUsername;
	}

	public void settUsername(String tUsername) {
		this.tUsername = tUsername;
	}

	public String gettLoginname() {
		return tLoginname;
	}

	public void settLoginname(String tLoginname) {
		this.tLoginname = tLoginname;
	}

	public String gettPassword() {
		return tPassword;
	}

	public void settPassword(String tPassword) {
		this.tPassword = tPassword;
	}

	public String gettSex() {
		return tSex;
	}

	public void settSex(String tSex) {
		this.tSex = tSex;
	}

	public int gettAge() {
		return tAge;
	}

	public void settAge(int tAge) {
		this.tAge = tAge;
	}

	public String gettAddress() {
		return tAddress;
	}

	public void settAddress(String tAddress) {
		this.tAddress = tAddress;
	}

	public String gettEmail() {
		return tEmail;
	}

	public void settEmail(String tEmail) {
		this.tEmail = tEmail;
	}

	public String gettPhone() {
		return tPhone;
	}

	public void settPhone(String tPhone) {
		this.tPhone = tPhone;
	}

	public String gettIsvip() {
		return tIsvip;
	}

	public void settIsvip(String tIsvip) {
		this.tIsvip = tIsvip;
	}

	public String gettImgurl() {
		return tImgurl;
	}

	public void settImgurl(String tImgurl) {
		this.tImgurl = tImgurl;
	}

	public List<UserTrain> getUserTrains() {
		return userTrains;
	}

	public void setUserTrains(List<UserTrain> userTrains) {
		this.userTrains = userTrains;
	}

	@Override
	public String toString() {
		return "Train [id=" + id + ", tUsername=" + tUsername + ", tLoginname=" + tLoginname + ", tPassword="
				+ tPassword + ", tSex=" + tSex + ", tAge=" + tAge + ", tAddress=" + tAddress + ", tEmail=" + tEmail
				+ ", tPhone=" + tPhone + ", tIsvip=" + tIsvip + ", tImgurl=" + tImgurl + ", userTrains=" + userTrains
				+ "]";
	}
	

	
}