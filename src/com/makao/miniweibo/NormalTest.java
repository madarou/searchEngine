/**
 * 
 */
package com.makao.miniweibo;

import weibo4j.Users;
import weibo4j.model.User;
import weibo4j.model.WeiboException;

/**
 * 测试openAPI工作是否正常
 * @author LiYanyu
 * @email 14210240081@fudan.edu.cn
 */
public class NormalTest {
	public static void main(String[] args) {
		String access_token = "2.00MxaJ2EoUEKABb6531c3e7c0tDuGi";
		String domain = "qingnanerhao";
		Users um = new Users(access_token);
		try {
			User user = um.showUserByDomain(domain);
			System.out.println(user.toString());
		} catch (WeiboException e) {
			e.printStackTrace();
		}
	}
}
