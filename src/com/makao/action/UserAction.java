/**
 * 
 */
package com.makao.action;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.makao.model.User;
import com.makao.service.IUserService;
import com.opensymphony.xwork2.ActionSupport;
/**
 * @author LiYanyu
 * @email 14210240081@fudan.edu.cn
 */
@Controller
@Scope("prototype")
public class UserAction extends ActionSupport{

	private static final long serialVersionUID = -490116226111432083L;
	@Autowired
	private IUserService userService;
	private User user;
	private List<User> userList;

	public String execute() throws Exception {
		return null;
	}
	
	public String login()
	{
		return SUCCESS;
	}

	public String addUI() {
		return "addUser";
	}

	public String updateUI() {
		user = userService.findByUserName(user.getScreen_name());
		return "updateUser";
	}

	public String add() {
		userService.insert(user);
		return SUCCESS;
	}

	public String delete() {
		userService.delete(user.getScreen_name());
		return SUCCESS;
	}

	public String update() {
		userService.update(user);
		return SUCCESS;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String queryAllUser() {
		userList = userService.selectAll();
		return "userList";
	}

	public List<User> getUserList() {
		return userList;
	}

	public void setUserList(List<User> userList) {
		this.userList = userList;
	}

}
