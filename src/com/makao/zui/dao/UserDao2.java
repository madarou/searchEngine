package com.makao.zui.dao;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrServer;
import org.apache.solr.client.solrj.request.FieldAnalysisRequest;
import org.apache.solr.client.solrj.response.AnalysisResponseBase.AnalysisPhase;
import org.apache.solr.client.solrj.response.AnalysisResponseBase.TokenInfo;
import org.apache.solr.client.solrj.response.FieldAnalysisResponse;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;
import org.apache.solr.core.SolrCore;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.makao.model.Weibo;
import com.makao.util.WeiboUtil;
import com.makao.util.WordUtil;
import com.makao.zui.entity.Tag;
import com.makao.zui.entity.Topic;
import com.makao.zui.entity.User;
import com.makao.zui.entity.ZuiTopic;
import com.makao.zui.entity.ZuiUser;

@Service
@Transactional
public class UserDao2 {
	private static Logger log = Logger.getLogger(UserDao2.class);
	private HttpSolrServer httpSolrServer;
	private static final String DEFAULT_URL = "http://115.159.109.12:80/collection1";
	private static String path = "/Users/makao/Desktop/tagdic.txt";
	private static HashSet<String> tagdic = getTagDic();

	public UserDao2() {
		httpSolrServer = new HttpSolrServer(DEFAULT_URL);
		httpSolrServer.setAllowCompression(true);
	}
	private static HashSet<String> getTagDic() {
		HashSet<String> tagsSet= new HashSet<String>();
		try {
			String encoding = "UTF-8";
			File file = new File(path);
			if (file.isFile() && file.exists()) { // 判断文件是否存在
				InputStreamReader read = new InputStreamReader(
						new FileInputStream(file), encoding);// 考虑到编码格式
				BufferedReader bufferedReader = new BufferedReader(read);
				String lineTxt = null;
				while ((lineTxt = bufferedReader.readLine()) != null) {
					System.out.println(lineTxt);
					tagsSet.add(lineTxt);
				}
				read.close();
			} else {
				System.out.println("找不到指定的文件");
			}
		} catch (Exception e) {
			System.out.println("读取文件内容出错");
			e.printStackTrace();
		}
		return tagsSet;
	}

	/**
	 * @param zu
	 * @return 根据ZuiUser推荐话题
	 */
	public List<ZuiTopic> getRecTopicsByUser(ZuiUser zu) {
		return null;

	}

	public List<User> queryUser(User user) throws SolrServerException,
			IOException {
		List<Tag> tags = user.getTags();
		StringBuilder sb = new StringBuilder();
		for (Tag t : tags) {
			String[] tagArray = t.getNames().split(" ");
			for(String str:tagArray){
				sb.append("tagNames:"+str+" or ");
			}
		}
		//String query_string = sb.toString();
		//String queryString = String.format("tagNames:%s", query_string.trim());
		String queryString = sb.substring(0, sb.length()-4);
		System.out.println("queryString:"+queryString);
		SolrQuery q = new SolrQuery();
		q.setQuery(queryString);
		q.setRequestHandler("/browse");
		q.setStart(0);
		//q.setRows(Integer.MAX_VALUE);
		q.setRows(100);

//		q.setHighlight(true).setHighlightFragsize(180)
//				.setHighlightSimplePre("<span style=\"color:red\">")// ���ÿ�ͷ
//				.setHighlightSimplePost("</span>"); // ���ý�β
//		q.setParam("hl.fl", "text");

		QueryResponse response = httpSolrServer.query(q);
		List<User> users = new ArrayList<User>();

		SolrDocumentList res = response.getResults();
		System.out.println("*******Hits: " + res.getNumFound() + "*******");
		for (SolrDocument doc : res) {
			String id = doc.getFieldValue("id").toString();
			if(doc.getFieldValue("tagNames")==null)
				continue;
			String tagNames = doc.getFieldValue("tagNames").toString();
			List<Tag> tagList = new ArrayList<Tag>();
			String[] tagArray = tagNames.split(",");
			for(String t:tagArray){
				Tag tg = new Tag(t);
				tagList.add(tg);
			}

			User w = new User();
			w.setId(id);
			w.setName(doc.getFieldValue("screen_name").toString());
			w.setTags(tagList);
			// if(doc.getFieldValue("pic_urls")!=null)
			// w.setPic_urls(doc.getFieldValue("pic_urls").toString());
			// if(doc.getFieldValue("original_pic")!=null)
			// w.setOriginal_pic(doc.getFieldValue("original_pic").toString());
			if(doc.getFieldValue("followers_count")!=null)
				w.setFollowers_count(doc.getFieldValue("followers_count").toString());
			if (doc.getFieldValue("statuses_count") != null)
				w.setComments_count(doc.getFieldValue("statuses_count").toString());
			if(doc.getFieldValue("profile_image_url")!=null)
				w.setAvatar(doc.getFieldValue("profile_image_url").toString());
			if(doc.getFieldValue("description")!=null){
				w.setDescription(doc.getFieldValue("description").toString());
			}
			// if(doc.getFieldValue("profile_url")!=null)
			// w.setProfile_url(doc.getFieldValue("profile_url").toString());
//			if (doc.getFieldValue("created_at") != null)
//				w.setPubTime(doc.getFieldValue("created_at").toString()
//						.substring(0, 19));
			// if(doc.getFieldValue("mid")!=null)
			// {
			// String weibourl = "http://www.weibo.com/"+
			// WeiboUtil.extractUserID(w.getProfile_image_url())+"/"
			// +doc.getFieldValue("mid").toString();
			// w.setWeibourl(weibourl);
			// }
			// String isretweet = (String) doc.getFieldValue("isretweet");
			// w.setIsretweet(isretweet);
			// if("true".equals(isretweet))
			// {
			// //������ת����΢�������ԭ����ɾ�ˣ�����ȡ����user��Ϣ�ģ�ֻ��
			// //retweet_id��retweet_text����Ǹ����΢�������˶��⹫�����������������ϵ�ͷ���http://t.cn/z0D6ZaQ��
			// if(doc.getFieldValue("retweet_screenname")!=null)
			// {
			// w.setRetweet_screenname(doc.getFieldValue("retweet_screenname").toString());
			// if(doc.getFieldValue("retweet_picurls")!=null)
			// w.setRetweet_picurls(doc.getFieldValue("retweet_picurls").toString());
			// if(doc.getFieldValue("retweet_originalpic")!=null)
			// w.setRetweet_originalpic(doc.getFieldValue("retweet_originalpic").toString());
			// if(doc.getFieldValue("retweet_repostscount")!=null)
			// w.setRetweet_repostscount(doc.getFieldValue("retweet_repostscount").toString());
			// if(doc.getFieldValue("retweet_commentscount")!=null)
			// w.setRetweet_commentscount(doc.getFieldValue("retweet_commentscount").toString());
			// if(doc.getFieldValue("retweet_profileimageurl")!=null)
			// {
			// w.setRetweet_profileimageurl(doc.getFieldValue("retweet_profileimageurl").toString());
			// if(doc.getFieldValue("retweet_mid")!=null)
			// {
			// String retweet_weibourl = "http://www.weibo.com/"+
			// WeiboUtil.extractUserID(w.getRetweet_profileimageurl())+"/"
			// +doc.getFieldValue("retweet_mid").toString();
			// w.setRetweet_weibourl(retweet_weibourl);
			// }
			// }
			// if(doc.getFieldValue("retweet_profileurl")!=null)
			// w.setRetweet_profileurl(doc.getFieldValue("retweet_profileurl").toString());
			// if(doc.getFieldValue("retweet_createdat")!=null)
			// w.setRetweet_createdat(doc.getFieldValue("retweet_createdat").toString());
			//
			// }
			//
			// w.setRetweet_text(doc.getFieldValue("retweet_text").toString());
			// }
			// weibos.add(w);
			users.add(w);
		}
		Collections.reverse(users);
		return users;
	}

	/**
	 * 给指定的语句分词。
	 * 
	 * @param sentence
	 *            被分词的语句
	 * @return 分词结果
	 */
	public HashSet<String> getAnalysis(String sentence) {
		FieldAnalysisRequest request = new FieldAnalysisRequest(
				"/analysis/field");
		request.addFieldName("text");// 字段名，随便指定一个支持中文分词的字段
		request.setFieldValue("");// 字段值，可以为空字符串，但是需要显式指定此参数
		request.setQuery(sentence);

		FieldAnalysisResponse response = null;
		try {
			response = request.process(httpSolrServer);
		} catch (Exception e) {
			log.error("获取查询语句的分词时遇到错误", e);
		}

		HashSet<String> results = new HashSet<String>();
		Iterator<AnalysisPhase> it = response.getFieldNameAnalysis("text")
				.getQueryPhases().iterator();
		while (it.hasNext()) {
			AnalysisPhase pharse = (AnalysisPhase) it.next();
			List<TokenInfo> list = pharse.getTokens();
			for (TokenInfo info : list) {
				if (info.getText().length() <= 1 || !tagdic.contains(info.getText()))
					continue;
				results.add(info.getText());
			}

		}

		return results;
	}
	public User queryProfile(String username) throws SolrServerException {
		SolrQuery q = new SolrQuery();
		q.setQuery("screen_name:"+username);
		q.setRequestHandler("/browse");
		q.setStart(0);
		q.setRows(Integer.MAX_VALUE);
		QueryResponse response = httpSolrServer.query(q);
		List<User> users = new ArrayList<User>();

		SolrDocumentList res = response.getResults();
		System.out.println("*******Hits: " + res.getNumFound() + "*******");
		for (SolrDocument doc : res) {
			String id = doc.getFieldValue("id").toString();
			List<Tag> tagList = new ArrayList<Tag>();
			if(doc.getFieldValue("tagNames")==null){
				Tag tg1 = new Tag("创业");
				tagList.add(tg1);
				Tag tg2 = new Tag("创新");
				tagList.add(tg2);
			}
			else{
				String tagNames = doc.getFieldValue("tagNames").toString();
				String[] tagArray = tagNames.split(",");
				for(String t:tagArray){
					Tag tg = new Tag(t);
					tagList.add(tg);
				}
			}
//			if(tagArray.length==0){
//				Tag tg1 = new Tag("星座命理");
//				tagList.add(tg1);
//				Tag tg2 = new Tag("娱乐");
//				tagList.add(tg2);
//			}
			User w = new User();
			w.setId(id);
			w.setName(doc.getFieldValue("screen_name").toString());
			w.setTags(tagList);
			// if(doc.getFieldValue("pic_urls")!=null)
			// w.setPic_urls(doc.getFieldValue("pic_urls").toString());
			// if(doc.getFieldValue("original_pic")!=null)
			// w.setOriginal_pic(doc.getFieldValue("original_pic").toString());
			if(doc.getFieldValue("followers_count")!=null)
				w.setFollowers_count(doc.getFieldValue("followers_count").toString());
			if (doc.getFieldValue("statuses_count") != null)
				w.setComments_count(doc.getFieldValue("statuses_count").toString());
			if(doc.getFieldValue("profile_image_url")!=null)
				w.setAvatar(doc.getFieldValue("profile_image_url").toString());
			if(doc.getFieldValue("description")!=null){
				w.setDescription(doc.getFieldValue("description").toString());
			}
			// if(doc.getFieldValue("profile_url")!=null)
			// w.setProfile_url(doc.getFieldValue("profile_url").toString());
//			if (doc.getFieldValue("created_at") != null)
//				w.setPubTime(doc.getFieldValue("created_at").toString()
//						.substring(0, 19));
			// if(doc.getFieldValue("mid")!=null)
			// {
			// String weibourl = "http://www.weibo.com/"+
			// WeiboUtil.extractUserID(w.getProfile_image_url())+"/"
			// +doc.getFieldValue("mid").toString();
			// w.setWeibourl(weibourl);
			// }
			// String isretweet = (String) doc.getFieldValue("isretweet");
			// w.setIsretweet(isretweet);
			// if("true".equals(isretweet))
			// {
			// //������ת����΢�������ԭ����ɾ�ˣ�����ȡ����user��Ϣ�ģ�ֻ��
			// //retweet_id��retweet_text����Ǹ����΢�������˶��⹫�����������������ϵ�ͷ���http://t.cn/z0D6ZaQ��
			// if(doc.getFieldValue("retweet_screenname")!=null)
			// {
			// w.setRetweet_screenname(doc.getFieldValue("retweet_screenname").toString());
			// if(doc.getFieldValue("retweet_picurls")!=null)
			// w.setRetweet_picurls(doc.getFieldValue("retweet_picurls").toString());
			// if(doc.getFieldValue("retweet_originalpic")!=null)
			// w.setRetweet_originalpic(doc.getFieldValue("retweet_originalpic").toString());
			// if(doc.getFieldValue("retweet_repostscount")!=null)
			// w.setRetweet_repostscount(doc.getFieldValue("retweet_repostscount").toString());
			// if(doc.getFieldValue("retweet_commentscount")!=null)
			// w.setRetweet_commentscount(doc.getFieldValue("retweet_commentscount").toString());
			// if(doc.getFieldValue("retweet_profileimageurl")!=null)
			// {
			// w.setRetweet_profileimageurl(doc.getFieldValue("retweet_profileimageurl").toString());
			// if(doc.getFieldValue("retweet_mid")!=null)
			// {
			// String retweet_weibourl = "http://www.weibo.com/"+
			// WeiboUtil.extractUserID(w.getRetweet_profileimageurl())+"/"
			// +doc.getFieldValue("retweet_mid").toString();
			// w.setRetweet_weibourl(retweet_weibourl);
			// }
			// }
			// if(doc.getFieldValue("retweet_profileurl")!=null)
			// w.setRetweet_profileurl(doc.getFieldValue("retweet_profileurl").toString());
			// if(doc.getFieldValue("retweet_createdat")!=null)
			// w.setRetweet_createdat(doc.getFieldValue("retweet_createdat").toString());
			//
			// }
			//
			// w.setRetweet_text(doc.getFieldValue("retweet_text").toString());
			// }
			// weibos.add(w);
			users.add(w);
		}

		return users.get(0);
	}

//	public static void main(String[] args) {
//		List<String> results = new TopicDao()
//				.getAnalysis("笑星潘长江当上“男媒婆”了，但这回可不是演小品——由他自编自导自演的都市喜剧《男媒婆》将于1月13日在北"
//						+ "京卫视首播。剧中，潘长江变身成为能说会道、古道热肠的“新时代男媒婆”丁二春，与“台湾第一酒窝美女2”张庭上演了一出“屌丝逆袭”"
//						+ "的浪漫追爱记。李明启、李文启、冯远征、任程伟、马丽、徐等明星也齐齐上阵制造“笑料”《男媒婆》围绕着丁二春和他所开"
//						+ "办的“全成热恋”婚介所展开。人到中年的丁二春眼看来势汹涌的“婚恋大潮”商机不断，想凭借一张巧嘴开创事业和人生"
//						+ "“第二春”。婚介所开张大吉，顾客盈门，提出的要求却也千奇百怪，拜金女、宅男、小老板粉墨登场，展开了一系列令人捧腹"
//						+ "大笑又不失温情的精彩故事。剧中的一大看点是美女搭配“丑男”的搭配，张庭与潘长江成了一对欢喜冤家。张庭表示，剧中两人“"
//						+ "身高有差距、年龄有距离，相貌不对等”。而潘长江谈到这种主角设定时认为：“张庭以往的角色都特别独立、可爱，而‘大女人’和‘"
//						+ "小男人’正是我俩这对情侣的设定，所以张庭是非常合适的人选。”此外，该剧也是潘长江继《能人冯天贵》、《清凌凌的水蓝莹莹的天》"
//						+ "第一、第二部之后第四次自导自演的喜剧作品。潘长江表示，全剧通过“媒婆”这个特殊职业的视角，展示着当代社会种种婚恋价值观，涵盖了"
//						+ "黄昏恋、拜金女、凤凰男等诸多引发热议的时代话题。(记者 尹春芳)免责声明：本文仅代表作者个人观点，与环球网无关。其原创性以及文中"
//						+ "陈述文字和内容未经本站证实，对本文以及其中全部或者部分内容、文字的真实性、完整性、及时性本站不作任何保证或承诺，请读者仅作参考，"
//						+ "并请自行核实相关内容。");
//		for (String word : results) {
//			System.out.println(word);
//		}
//	}
}
