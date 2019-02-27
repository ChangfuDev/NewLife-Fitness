package com.newlife.fitness.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 评论贴实体类
 * 
 * Comment -- 多对一 -- AuditingType （违规类型）
 * 
 * Comment -- 多对一 -- User	（用户）
 * 
 * Comment -- 多对一 -- Forum	（帖子）
 */
public class Comments implements Serializable {
	private static final long serialVersionUID = 1L;

	private int id;

	private Date commentTime;

	private String content;

	private String isAdopt;

	private AuditingType auditingType;
	
	private  int  auditing_id;

	private FUser FUser;

	private Forum forum;
	
	private int user_id;
	private int forum_id;

	public Comments() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getCommentTime() {
		return this.commentTime;
	}

	public void setCommentTime(Date commentTime) {
		this.commentTime = commentTime;
	}

	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getIsAdopt() {
		return this.isAdopt;
	}

	public void setIsAdopt(String isAdopt) {
		this.isAdopt = isAdopt;
	}

	public AuditingType getAuditingType() {
		return this.auditingType;
	}

	public void setAuditingType(AuditingType auditingType) {
		this.auditingType = auditingType;
	}

	public FUser getFUser() {
		return this.FUser;
	}

	public void setFUser(FUser FUser) {
		this.FUser = FUser;
	}

	public Forum getForum() {
		return this.forum;
	}

	public void setForum(Forum forum) {
		this.forum = forum;
	}

	public int getAuditing_id() {
		return auditing_id;
	}

	public void setAuditing_id(int auditing_id) {
		this.auditing_id = auditing_id;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public int getForum_id() {
		return forum_id;
	}

	public void setForum_id(int forum_id) {
		this.forum_id = forum_id;
	}
}