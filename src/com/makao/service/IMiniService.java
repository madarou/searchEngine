/**
 * 
 */
package com.makao.service;

import java.util.List;

import weibo4j.model.User;
import weibo4j.model.WeiboException;

import com.makao.model.Weibo;

/**
 * @author LiYanyu
 * @email 14210240081@fudan.edu.cn
 */
public interface IMiniService {
	public abstract List<Weibo> getHomeTimeline();
	public abstract List<User> getFriendsByScreenName(String screenname);
	public abstract User showUserById(String id) throws WeiboException;
}
