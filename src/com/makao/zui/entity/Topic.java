package com.makao.zui.entity;

import java.sql.Timestamp;
import java.util.List;
import java.util.Set;

public class Topic {
	private String id;
	private String title;
	private String content;
	private List<String> tags;
	private String pubTime;
	private String user;//发布者
	private Timestamp lastRelyTime;
	private String joinNumber;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public List<String> getTags() {
		return tags;
	}
	public void setTags(List<String> tags) {
		this.tags = tags;
	}
	public String getPubTime() {
		return pubTime;
	}
	public void setPubTime(String pubTime) {
		this.pubTime = pubTime;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public Timestamp getLastRelyTime() {
		return lastRelyTime;
	}
	public void setLastRelyTime(Timestamp lastRelyTime) {
		this.lastRelyTime = lastRelyTime;
	}
	public String getJoinNumber() {
		return joinNumber;
	}
	public void setJoinNumber(String joinNumber) {
		this.joinNumber = joinNumber;
	}
	
}
