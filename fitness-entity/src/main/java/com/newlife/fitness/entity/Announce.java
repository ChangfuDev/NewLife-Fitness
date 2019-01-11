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
	private DUser dUser;
	private String codeContent;
	
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
	public DUser getdUser() {
		return dUser;
	}
	public void setdUser(DUser dUser) {
		this.dUser = dUser;
	}
	public Announce(Integer id, String content, Date createDate, DUser dUser) {
		super();
		this.id = id;
		this.content = content;
		this.createDate = createDate;
		this.dUser = dUser;
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
	@Override
	public String toString() {
		return "Announce [id=" + id + ", content=" + content + ", createDate=" + createDate + ", dUser=" + dUser
				+ ", codeContent=" + codeContent + "]";
	}
	
}
