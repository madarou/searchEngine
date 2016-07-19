/**
 * 
 */
package com.makao.action;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import weibo4j.model.Status;
import weibo4j.model.User;
import weibo4j.model.WeiboException;

import com.makao.model.Weibo;
import com.makao.service.IMiniService;
import com.opensymphony.xwork2.ActionSupport;

/**
 * @author LiYanyu
 * @email 14210240081@fudan.edu.cn
 */
@Controller
@Scope("prototype")
public class MiniAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 457741628460057501L;
	private String access_token = "2.00MxaJ2EoUEKABb6531c3e7c0tDuGi";
	
	@Autowired
	private IMiniService miniService;
	
	private User user;
	private List<User> userList;
	private Status status;
	private List<Weibo> weiboList;

	public String execute() throws Exception {
		return null;
	}
	
	public String updateStatus()
	{
		/*String statuses = status.getText().trim();
		if(statuses != null)
		{
			Timeline tm = new Timeline(access_token);
			try {
				Status status = tm.updateStatus(statuses);
				System.out.println(status.toString());
			} catch (WeiboException e) {
				e.printStackTrace();
			}	
			return "mini";
		}*/
		return "input";
	}
	
	public String homeTimeline()
	{
		weiboList = miniService.getHomeTimeline();
		userList = miniService.getFriendsByScreenName("¬Ì«ÔÃÔ");
		try {
			user = miniService.showUserById("3977121390");
		} catch (WeiboException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "mini";
	}
	public String queryUser()
	{
		/*try {
			userList = solrService.queryUser(user.getScreen_name());
		} catch (SolrServerException e) {
			e.printStackTrace();
			return "queryException";
		}*/
		return "queryUserRes";
	}

	public String queryWeibo()
	{
		/*try {
			long start= System.currentTimeMillis();
			weiboList = solrService.queryWeibo(weibo.getText());
			System.out.println("**********”√ ±:"+(System.currentTimeMillis()-start)+"***********");
		} catch (SolrServerException e) {
			e.printStackTrace();
			return "queryException";
		}*/
		return "queryWeiboRes";
	}
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<User> getUserList() {
		return userList;
	}

	public void setUserList(List<User> userList) {
		this.userList = userList;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public List<Weibo> getWeiboList() {
		return weiboList;
	}

	public void setWeiboList(List<Weibo> weiboList) {
		this.weiboList = weiboList;
	}


}
