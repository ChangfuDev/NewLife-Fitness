package com.newlife.fitness.entity;

import java.io.Serializable;

/**
 *	用户教练中间类
 *	一个ID记录 -- 对应 --> 一位教练、一个用户。
 *	多对多
 */
public class UserTrain implements Serializable {
	private static final long serialVersionUID = 1L;

	private int id;

	private String userMassage;

	private FUser FUser;

	private Train train;

	public UserTrain() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUserMassage() {
		return this.userMassage;
	}

	public void setUserMassage(String userMassage) {
		this.userMassage = userMassage;
	}

	public FUser getFUser() {
		return this.FUser;
	}

	public void setFUser(FUser FUser) {
		this.FUser = FUser;
	}

	public Train getTrain() {
		return this.train;
	}

	public void setTrain(Train train) {
		this.train = train;
	}

}