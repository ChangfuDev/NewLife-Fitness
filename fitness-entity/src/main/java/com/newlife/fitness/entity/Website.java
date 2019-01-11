package com.newlife.fitness.entity;

import java.io.Serializable;

/**
 * 网站SEO表
 * @ClassName: Website  
 * @Description: 修改系统设置
 * @author Unruly  
 * @date 2019年1月7日
 */
public class Website implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String domainName;
	private Integer catchTime;
	private String title;
	private String description;
	private String copyright;
	private String keyword;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getDomainName() {
		return domainName;
	}
	public void setDomainName(String domainName) {
		this.domainName = domainName;
	}
	public Integer getCatchTime() {
		return catchTime;
	}
	public void setCatchTime(Integer catchTime) {
		this.catchTime = catchTime;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getCopyright() {
		return copyright;
	}
	public void setCopyright(String copyright) {
		this.copyright = copyright;
	}
	public String getKeyword() {
		return keyword;
	}
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	public Website(Integer id, String domainName, Integer catchTime, String title, String description, String copyright,
			String keyword) {
		super();
		this.id = id;
		this.domainName = domainName;
		this.catchTime = catchTime;
		this.title = title;
		this.description = description;
		this.copyright = copyright;
		this.keyword = keyword;
	}
	public Website() {
		super();
	}
	@Override
	public String toString() {
		return "Website [id=" + id + ", domainName=" + domainName + ", catchTime=" + catchTime + ", title=" + title
				+ ", description=" + description + ", copyright=" + copyright + ", keyword=" + keyword + "]";
	}
}
