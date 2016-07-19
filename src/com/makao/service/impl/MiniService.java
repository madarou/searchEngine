/**
 * 
 */
package com.makao.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import weibo4j.Friendships;
import weibo4j.Timeline;
import weibo4j.Users;
import weibo4j.model.Status;
import weibo4j.model.StatusWapper;
import weibo4j.model.User;
import weibo4j.model.UserWapper;
import weibo4j.model.WeiboException;

import com.makao.model.Weibo;
import com.makao.service.IMiniService;

/**
 * @author LiYanyu
 * @email 14210240081@fudan.edu.cn
 */
@Service
@Transactional
public class MiniService implements IMiniService{
	private String access_token = "2.00MxaJ2EoUEKABb6531c3e7c0tDuGi";
	/* (non-Javadoc)
	 * @see com.makao.service.IMiniService#getHomeTimeline()
	 */
	@Override
	public List<Weibo> getHomeTimeline() {
		Timeline tm = new Timeline(access_token);
		List<Weibo> weibos = new ArrayList<Weibo>();
		try {
			StatusWapper status = tm.getHomeTimeline();
			//System.out.println(status.toString());
			List<Status> statuses =status.getStatuses();
			for(Status s : statuses)
			{
				Weibo w = new Weibo();
				w.setId(s.getId());
				w.setText(s.getText());
				//w.setSource(s.getSource().getName());
				w.setCreated_at(s.getCreatedAt().toString());
				w.setOriginal_pic(s.getThumbnailPic());
				w.setReposts_count(Integer.toString(s.getRepostsCount()));
				w.setComments_count(Integer.toString(s.getCommentsCount()));
				w.setScreen_name(s.getUser().getScreenName());
				w.setProfile_image_url(s.getUser().getProfileImageUrl());
				//w.setProfile_url(s.getUser().getUserDomain());
				w.setProfile_url("u/"+s.getUser().getId());
					
				if(s.getRetweetedStatus()!=null)
				{
					Status rs = s.getRetweetedStatus();
					//System.out.println(rs.getText());
					w.setIsretweet("true");
					w.setRetweet_id(rs.getId());
					w.setRetweet_text(rs.getText());
					//w.setRetweet_source(rs.getSource().getName());
					w.setRetweet_createdat(rs.getCreatedAt().toString());
					w.setRetweet_originalpic(rs.getThumbnailPic());
					w.setRetweet_repostscount(Integer.toString(rs.getRepostsCount()));
					w.setRetweet_commentscount(Integer.toString(rs.getCommentsCount()));
					w.setRetweet_screenname(rs.getUser().getScreenName());
					w.setRetweet_profileimageurl(rs.getUser().getProfileImageUrl());
					w.setRetweet_profileurl("u/"+rs.getUser().getId());
				}
				weibos.add(w);
			}
		} catch (WeiboException e) {
			e.printStackTrace();
		}
		return weibos;
	}
	/* (non-Javadoc)
	 * @see com.makao.service.IMiniService#getFriendsByScreenName(java.lang.String)
	 */
	@Override
	public List<User> getFriendsByScreenName(String screenname) {
		Friendships fm = new Friendships(access_token);
		List<User> friends = new ArrayList<User>();
		try {
			UserWapper users = fm.getFriendsByScreenName(screenname);
			friends= users.getUsers();
		} catch (WeiboException e) {
			e.printStackTrace();
		}
		return friends;
	}
	/* (non-Javadoc)
	 * @see com.makao.service.IMiniService#showUserById(java.lang.String)
	 */
	@Override
	public User showUserById(String id) throws WeiboException {
		Users um = new Users(access_token);
		User user = um.showUserById(id);
		
		return user;
	}
	
}
