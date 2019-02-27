package com.newlife.fitness.entity;

import java.io.Serializable;
import java.util.Date;
/**
 * @ClassName: Announce  
 * @Description: 新增的通知表
 * @author Unruly  
 * @date 2019年1月5日
 */
public class Announce implements Serializable{
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String content;
	private Date createDate;
	private Integer dUserId;
	private String codeContent;
	private String createUser;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	
	public Announce() {
		super();
	}

	public String getCodeContent() {
		return codeContent;
	}
	
	public void setCodeContent(String codeContent) {
		this.codeContent = codeContent;
	}
	
	public Integer getdUserId() {
		return dUserId;
	}
	
	public void setdUserId(Integer dUserId) {
		this.dUserId = dUserId;
	}
	
	public String getCreateUser() {
		return createUser;
	}
	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}
}
