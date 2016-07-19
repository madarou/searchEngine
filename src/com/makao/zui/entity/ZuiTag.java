package com.makao.zui.entity;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

public class ZuiTag  implements Serializable{
	private static final long serialVersionUID = -6960813598875353313L;
	private int id;
	private int level;//tag的级别，越往下越具体
	private String names;//标签名的总和，包含相似的名字,存储为：睡觉,睡眠
	private Set<ZuiTopic> topics;
	private Set<ZuiUser> users;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	public String getNames() {
		return names;
	}
	public void setNames(String names) {
		this.names = names;
	}
	public Set<ZuiTopic> getTopics() {
		return topics;
	}
	public void setTopics(Set<ZuiTopic> topics) {
		this.topics = topics;
	}
	public Set<ZuiUser> getUsers() {
		return users;
	}
	public void setUsers(Set<ZuiUser> users) {
		this.users = users;
	}
	
}
