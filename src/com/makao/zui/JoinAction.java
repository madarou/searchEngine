package com.makao.zui;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

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
public class JoinAction extends ActionSupport {
	private static final long serialVersionUID = -8729287438453212063L;
	private String topic;
	private User user;

	public String execute() throws Exception {
		return null;
	}
	
	public String join() throws UnsupportedEncodingException{
		topic = new String(topic.getBytes("iso-8859-1"),"UTF-8");
		System.out.println(topic);
		HttpServletRequest request = ServletActionContext.getRequest();
		user = (User) request.getServletContext().getAttribute(
				"user");
		return "join";
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
	
}
