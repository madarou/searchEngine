package com.makao.zui;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.makao.zui.entity.User;
import com.opensymphony.xwork2.ActionSupport;

@Controller
@Scope("prototype")
public class PublishAction extends ActionSupport {
	private static final long serialVersionUID = -8729287438453212063L;
	private String keywords;
	private String topic;
	private User user;
	private List<User> users;

	public String execute() throws Exception {
		return null;
	}
	
	public String publish(){
		return "publish";
	}
	
	@SuppressWarnings("unchecked")
	public String post(){
		System.out.println("keywords: "+keywords);
		System.out.println("topic: "+topic);
		HttpServletRequest request = ServletActionContext.getRequest();
		user = (User) request.getServletContext().getAttribute(
				"user");
		users =	(List<User>) request.getServletContext().getAttribute(
				"users");
		if(users!=null&&users.size()>30){
			users = users.subList(8, 30);
			Collections.reverse(users);
		}
		return "invite";
	}

	public String getKeywords() {
		return keywords;
	}

	public void setKeywords(String keywords) {
		this.keywords = keywords;
	}

	public String getTopic() {
		return topic;
	}

	public void setTopic(String topic) {
		this.topic = topic;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}
	
	
}
