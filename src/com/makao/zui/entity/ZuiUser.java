package com.makao.zui.entity;

import java.io.Serializable;
import java.sql.Date;
import java.util.Set;

public class ZuiUser implements Serializable{
	private static final long serialVersionUID = -8105446152727599101L;
	private int id;
	private String name;
	private String avatar;
	private Set<ZuiTag> tags;
	private Set<ZuiUser> followers;//粉丝
	private Set<ZuiUser> follows;//被该用户关注的人
	private Set<ZuiTopic> topics;//发表的话题
	private String location;
	private String job;
	private Date joinDate;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAvatar() {
		return avatar;
	}
	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}
	public Set<ZuiTag> getTags() {
		return tags;
	}
	public void setTags(Set<ZuiTag> tags) {
		this.tags = tags;
	}
	public Set<ZuiUser> getFollowers() {
		return followers;
	}
	public void setFollowers(Set<ZuiUser> followers) {
		this.followers = followers;
	}
	public Set<ZuiUser> getFollows() {
		return follows;
	}
	public void setFollows(Set<ZuiUser> follows) {
		this.follows = follows;
	}
	public Set<ZuiTopic> getTopics() {
		return topics;
	}
	public void setTopics(Set<ZuiTopic> topics) {
		this.topics = topics;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	public Date getJoinDate() {
		return joinDate;
	}
	public void setJoinDate(Date joinDate) {
		this.joinDate = joinDate;
	}
	
}
