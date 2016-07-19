/**
 * 
 */
package com.makao.action;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import weibo4j.Timeline;
import weibo4j.model.Status;
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
public class UpdateAction extends ActionSupport {

	private static final long serialVersionUID = 2370050324317055104L;
	private String access_token = "2.00MxaJ2EoUEKABb6531c3e7c0tDuGi";
	private String content;
	private List<Weibo> weiboList;
	
	@Autowired
	private IMiniService miniService;

	public String updateStatus() {
		try {
			content=URLDecoder.decode(content, "utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		System.out.println("*************content:="+this.content);
		Timeline tm = new Timeline(access_token);
		try {
			Status status = tm.updateStatus(this.content);
			Thread.sleep(500);
			/*Log.logInfo(status.toString());*/
		} catch (Exception e) {
			e.printStackTrace();
		}
		weiboList = miniService.getHomeTimeline();
        return SUCCESS;
    }

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
	
	public List<Weibo> getWeiboList() {
		return weiboList;
	}

	public void setWeiboList(List<Weibo> weiboList) {
		this.weiboList = weiboList;
	}

}
