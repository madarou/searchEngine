/**
 * 
 */
package com.makao.action;

import java.util.List;

import org.apache.solr.client.solrj.SolrServerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.makao.model.User;
import com.makao.model.Weibo;
import com.makao.service.ISolrService;
import com.opensymphony.xwork2.ActionSupport;

/**
 * @author LiYanyu
 * @email 14210240081@fudan.edu.cn
 */
@Controller
@Scope("prototype")
public class SolrAction extends ActionSupport {

	private static final long serialVersionUID = 5972627948177669007L;
	@Autowired
	private ISolrService solrService;
	
	private User user;
	private List<User> userList;
	private Weibo weibo;
	private List<Weibo> weiboList;

	public String execute() throws Exception {
		return null;
	}
	
	public String queryWeiboUI(){
		return "queryWeiboUI";
	}
	public String queryUser()
	{
		try {
			userList = solrService.queryUser(user.getScreen_name());
		} catch (SolrServerException e) {
			e.printStackTrace();
			return "queryException";
		}
		return "queryUserRes";
	}

	public String queryWeibo()
	{
		try {
			long start= System.currentTimeMillis();
			weiboList = solrService.queryWeibo(weibo.getText());
			System.out.println("**********��ʱ:"+(System.currentTimeMillis()-start)+"***********");
		} catch (SolrServerException e) {
			e.printStackTrace();
			return "queryException";
		}
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

	public Weibo getWeibo() {
		return weibo;
	}

	public void setWeibo(Weibo weibo) {
		this.weibo = weibo;
	}

	public List<Weibo> getWeiboList() {
		return weiboList;
	}

	public void setWeiboList(List<Weibo> weiboList) {
		this.weiboList = weiboList;
	}

}
