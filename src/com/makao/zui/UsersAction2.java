package com.makao.zui;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.solr.client.solrj.SolrServerException;
import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.makao.zui.dao.TopicDao;
import com.makao.zui.dao.UserDao2;
import com.makao.zui.entity.Topic;
import com.makao.zui.entity.User;
import com.opensymphony.xwork2.ActionSupport;

@Controller
@Scope("prototype")
public class UsersAction2 extends ActionSupport {
	private static final long serialVersionUID = -7221134619817471817L;
	@Autowired
	private UserDao2 userDao2;
	private List<User> users;
	private String username;
	private User user;
	public String execute() throws Exception {
		return null;
	}
	
	public String users(){
		HttpServletRequest request = ServletActionContext.getRequest();
		User currentUser = (User) request.getServletContext().getAttribute(
				"user");
		System.out.println("current user: " + currentUser.getName());
		try {
			users = userDao2.queryUser(currentUser);
		} catch (SolrServerException | IOException e) {
			e.printStackTrace();
			return "queryException";
		}
		for (User t : users) {
			System.out.println(t.getName());
		}
		return "users";
	}
	
	public String profile() throws UnsupportedEncodingException, SolrServerException{
		username = new String(username.getBytes("iso-8859-1"),"UTF-8");
		System.out.println(username);
		user = userDao2.queryProfile(username);
		return "profile";
	}
	
	public String me() throws UnsupportedEncodingException, SolrServerException{
		HttpServletRequest request = ServletActionContext.getRequest();
		User currentUser = (User) request.getServletContext().getAttribute(
				"user");
		user = userDao2.queryProfile(currentUser.getName());
		return "me";
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
}
