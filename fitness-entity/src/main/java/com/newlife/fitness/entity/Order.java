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
	
	private Integer fUId;
	
	private String fUserName;

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

	public Integer getfUId() {
		return fUId;
	}

	public void setfUId(Integer fUId) {
		this.fUId = fUId;
	}

	public String getfUserName() {
		return fUserName;
	}

	public void setfUserName(String fUserName) {
		this.fUserName = fUserName;
	}

}
