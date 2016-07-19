/**
 * 
 */
package com.makao.util;

/**
 * @author LiYanyu
 * @email 14210240081@fudan.edu.cn
 */
public class WeiboUtil {
	
	/**
	 * ��profile_image_url����ȡ�û���id
	 * �磺profile_image_urlΪhttp://tp3.sinaimg.cn/1642482194/50/5662088971/1
	 * �û�idΪ1642482194
	 * @param profile_image_url
	 * @return
	 */
	public static String extractUserID(String profile_image_url)
	{
		if("".equals(profile_image_url)){
			return "";
		}
		int end = profile_image_url.indexOf('/', 22);
		return profile_image_url.substring(22, end);
	}
	
	public static void main(String[] args){
		System.out.println(extractUserID("http://tp3.sinaimg.cn/1642482194/50/5662088971/1"));
	}
}
