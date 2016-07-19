package com.makao.model;

/**
 * @author LiYanyu
 *
 */
public class Weibo {
	private String id;
	private String text;
	private String source="";
	private String created_at="";
	private String pic_urls="";//微博图片列表
	private String original_pic="";//原始图片地址
	private String reposts_count="0";
	private String comments_count="0";
	private String isretweet="false";//是不是转发的微博
	
	private String screen_name="";
	private String profile_image_url="";//头像地址
	private String profile_url="";//微博地址
	
	private String retweet_id="";//被转发的微博的id
	private String retweet_text="";
	private String retweet_source="";
	private String retweet_createdat="";
	private String retweet_picurls="";
	private String retweet_originalpic="";
	private String retweet_repostscount="";
	private String retweet_commentscount="";
	
	private String retweet_screenname="";
	private String retweet_profileimageurl="";
	private String retweet_profileurl="";
	
	private String mid="";
	private String retweet_mid="";
	
	private String weibourl="";
	private String retweet_weibourl="";
	public String getWeibourl() {
		return weibourl;
	}
	public void setWeibourl(String weibourl) {
		this.weibourl = weibourl;
	}
	public String getRetweet_weibourl() {
		return retweet_weibourl;
	}
	public void setRetweet_weibourl(String retweet_weibourl) {
		this.retweet_weibourl = retweet_weibourl;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public String getCreated_at() {
		return created_at;
	}
	public void setCreated_at(String created_at) {
		this.created_at = created_at;
	}
	public String getPic_urls() {
		return pic_urls;
	}
	public void setPic_urls(String pic_urls) {
		this.pic_urls = pic_urls;
	}
	public String getOriginal_pic() {
		return original_pic;
	}
	public void setOriginal_pic(String original_pic) {
		this.original_pic = original_pic;
	}
	public String getReposts_count() {
		return reposts_count;
	}
	public void setReposts_count(String reposts_count) {
		this.reposts_count = reposts_count;
	}
	public String getComments_count() {
		return comments_count;
	}
	public void setComments_count(String comments_count) {
		this.comments_count = comments_count;
	}
	public String getIsretweet() {
		return isretweet;
	}
	public void setIsretweet(String isretweet) {
		this.isretweet = isretweet;
	}
	public String getScreen_name() {
		return screen_name;
	}
	public void setScreen_name(String screen_name) {
		this.screen_name = screen_name;
	}
	public String getProfile_image_url() {
		return profile_image_url;
	}
	public void setProfile_image_url(String profile_image_url) {
		this.profile_image_url = profile_image_url;
	}
	public String getProfile_url() {
		return profile_url;
	}
	public void setProfile_url(String profile_url) {
		this.profile_url = profile_url;
	}
	public String getRetweet_id() {
		return retweet_id;
	}
	public void setRetweet_id(String retweet_id) {
		this.retweet_id = retweet_id;
	}
	public String getRetweet_text() {
		return retweet_text;
	}
	public void setRetweet_text(String retweet_text) {
		this.retweet_text = retweet_text;
	}
	public String getRetweet_source() {
		return retweet_source;
	}
	public void setRetweet_source(String retweet_source) {
		this.retweet_source = retweet_source;
	}
	public String getRetweet_createdat() {
		return retweet_createdat;
	}
	public void setRetweet_createdat(String retweet_createdat) {
		this.retweet_createdat = retweet_createdat;
	}
	public String getRetweet_picurls() {
		return retweet_picurls;
	}
	public void setRetweet_picurls(String retweet_picurls) {
		this.retweet_picurls = retweet_picurls;
	}
	public String getRetweet_originalpic() {
		return retweet_originalpic;
	}
	public void setRetweet_originalpic(String retweet_originalpic) {
		this.retweet_originalpic = retweet_originalpic;
	}
	public String getRetweet_repostscount() {
		return retweet_repostscount;
	}
	public void setRetweet_repostscount(String retweet_repostscount) {
		this.retweet_repostscount = retweet_repostscount;
	}
	public String getRetweet_commentscount() {
		return retweet_commentscount;
	}
	public void setRetweet_commentscount(String retweet_commentscount) {
		this.retweet_commentscount = retweet_commentscount;
	}
	public String getRetweet_screenname() {
		return retweet_screenname;
	}
	public void setRetweet_screenname(String retweet_screenname) {
		this.retweet_screenname = retweet_screenname;
	}
	public String getRetweet_profileimageurl() {
		return retweet_profileimageurl;
	}
	public void setRetweet_profileimageurl(String retweet_profileimageurl) {
		this.retweet_profileimageurl = retweet_profileimageurl;
	}
	public String getRetweet_profileurl() {
		return retweet_profileurl;
	}
	public void setRetweet_profileurl(String retweet_profileurl) {
		this.retweet_profileurl = retweet_profileurl;
	}
	public String getMid() {
		return mid;
	}
	public void setMid(String mid) {
		this.mid = mid;
	}
	public String getRetweet_mid() {
		return retweet_mid;
	}
	public void setRetweet_mid(String retweet_mid) {
		this.retweet_mid = retweet_mid;
	}
}
