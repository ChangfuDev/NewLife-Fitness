package com.newlife.fitness.entity;

import java.io.Serializable;
import java.util.Date;

public class Order implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	
	private String orderNumber;
	
	private String orderName;
	
	private String orderPrice;
	
	private Date createDate;
	
	private String isPlay;
	
	private FUser fUser;

	public Order() {
		super();
	}

	public Order(Integer id, String orderNumber, String orderName, String orderPrice, Date createDate, String isPlay,
			FUser fUser) {
		super();
		this.id = id;
		this.orderNumber = orderNumber;
		this.orderName = orderName;
		this.orderPrice = orderPrice;
		this.createDate = createDate;
		this.isPlay = isPlay;
		this.fUser = fUser;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}

	public String getOrderName() {
		return orderName;
	}

	public void setOrderName(String orderName) {
		this.orderName = orderName;
	}

	public String getOrderPrice() {
		return orderPrice;
	}

	public void setOrderPrice(String orderPrice) {
		this.orderPrice = orderPrice;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public String getIsPlay() {
		return isPlay;
	}

	public void setIsPlay(String isPlay) {
		this.isPlay = isPlay;
	}

	public FUser getfUser() {
		return fUser;
	}

	public void setfUser(FUser fUser) {
		this.fUser = fUser;
	}

	@Override
	public String toString() {
		return "Order [id=" + id + ", orderNumber=" + orderNumber + ", orderName=" + orderName + ", orderPrice="
				+ orderPrice + ", createDate=" + createDate + ", isPlay=" + isPlay + ", fUser=" + fUser + "]";
	}
	
}
