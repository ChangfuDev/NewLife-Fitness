package com.newlife.fitness.entity;

import java.io.Serializable;
import java.util.List;

/**
 * 审核类型类
 * 记录评论是否违规
 * AuditingType  -- 一对多 -- Comment（评论） && Forum（帖子）
 */
public class AuditingType implements Serializable {
	private static final long serialVersionUID = 1L;
	private int id;
	private String violationName;
	
	private List<Comments> comments;
	private List<Forum> forums;

	public AuditingType() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getViolationName() {
		return this.violationName;
	}

	public void setViolationName(String violationName) {
		this.violationName = violationName;
	}

	public List<Comments> getComments() {
		return this.comments;
	}

	public void setComments(List<Comments> comments) {
		this.comments = comments;
	}

	public Comments addComment(Comments comment) {
		getComments().add(comment);
		comment.setAuditingType(this);

		return comment;
	}

	public Comments removeComment(Comments comment) {
		getComments().remove(comment);
		comment.setAuditingType(null);

		return comment;
	}

	public List<Forum> getForums() {
		return this.forums;
	}

	public void setForums(List<Forum> forums) {
		this.forums = forums;
	}

	public Forum addForum(Forum forum) {
		getForums().add(forum);
		forum.setAuditingType(this);
		return forum;
	}

	public Forum removeForum(Forum forum) {
		getForums().remove(forum);
		forum.setAuditingType(null);

		return forum;
	}

}