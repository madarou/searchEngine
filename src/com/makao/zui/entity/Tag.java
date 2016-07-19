package com.makao.zui.entity;

public class Tag{
	private int id;
	private int level;//tag的级别，越往下越具体
	private String names;//标签名的总和，包含相似的名字,存储为：睡觉 睡眠
	public Tag(String names){
		this.names = names;
	}
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
}
