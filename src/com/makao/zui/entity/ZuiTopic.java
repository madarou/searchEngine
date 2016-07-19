package com.makao.zui.entity;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;
import java.util.Set;

public class ZuiTopic implements Serializable{

	private static final long serialVersionUID = 6161007895375802286L;
	private int id;
	private String title;
	private String content;
	private Set<ZuiTag> tags;
	private Timestamp pubTime;
	private ZuiUser user;//发布者
	private Timestamp lastRelyTime;
	private int joinNumber;
	public int getId() {
		return id;
	}
	public void setId(int id) {
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
	public Set<ZuiTag> getTags() {
		return tags;
	}
	public void setTags(Set<ZuiTag> tags) {
		this.tags = tags;
	}
	public Timestamp getPubTime() {
		return pubTime;
	}
	public void setPubTime(Timestamp pubTime) {
		this.pubTime = pubTime;
	}
	public ZuiUser getUser() {
		return user;
	}
	public void setUser(ZuiUser user) {
		this.user = user;
	}
	public Timestamp getLastRelyTime() {
		return lastRelyTime;
	}
	public void setLastRelyTime(Timestamp latestRelyTime) {
		this.lastRelyTime = latestRelyTime;
	}
	public int getJoinNumber() {
		return joinNumber;
	}
	public void setJoinNumber(int joinNumber) {
		this.joinNumber = joinNumber;
	}
}
