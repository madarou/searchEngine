package com.makao.zui;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.core.SolrCore;
import org.apache.solr.schema.FieldType;
import org.apache.solr.schema.IndexSchema;
import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.makao.service.ISolrService;
import com.makao.zui.dao.TopicDao;
import com.makao.zui.dao.UserDao2;
import com.makao.zui.entity.Tag;
import com.makao.zui.entity.Topic;
import com.makao.zui.entity.User;
import com.opensymphony.xwork2.ActionSupport;

@Controller
@Scope("prototype")
public class IndexAction extends ActionSupport {
	private static final long serialVersionUID = -2341117888860800890L;
	@Autowired
	private TopicDao topicDao;
	@Autowired
	private UserDao2 userDao2;
	private List<Topic> topics;
	private String username;

	public String execute() throws Exception {
		return null;
	}

	public String index() {
		HttpServletRequest request = ServletActionContext.getRequest();
		User currentUser = (User) request.getServletContext().getAttribute(
				"user");
		System.out.println("current user: " + currentUser.getName());
		List<Tag> tagList = currentUser.getTags();
		Boolean isChuangye = false;
		for(Tag t: tagList){
			if("创业".equals(t.getNames())||"创新".equals(t.getNames())){
				isChuangye = true;
				break;
			}
		}
		try {
			topics = topicDao.queryTopic(currentUser);
			if(isChuangye){
				Topic w = new Topic();
				w.setContent("[【思路决定道路】1.打工的:这不太可能吧？创业的:一切皆有可能！2.打工的:没办法，老板逼的；创业的:没办法，自己逼的！3.打工的:算了吧，明天再说；创业的:快回来，今天干完！4.打工的:别别别，出了问题我担当不起；创业的:上上上，如果闯祸我来负责！5..打工的:不行；创业的:我看行!]");
				List<String> tags = new ArrayList<String>();tags.add("创业");
				w.setTags(tags);
				w.setJoinNumber("15");
				w.setUser("在路上");
				w.setPubTime("Mon Feb 20 21:00:27");
				topics.add(0, w);
			}
		} catch (SolrServerException | IOException e) {
			e.printStackTrace();
			return "queryException";
		}
		return "index";
	}

//	private String[] getAnalyzerKeyWords(SolrCore core, String name, String val)
//			throws IOException {
//		//Assert.notNull(core, "core required");
//		IndexSchema schema = core.getLatestSchema();
//		FieldType ft = schema.getFieldTypes().get(name);
//		Analyzer analyzer = ft.getAnalyzer();
//		Set<String> searchKeys = new LinkedHashSet<String>();
//		if (analyzer instanceof TokenizerChain) {
//			TokenizerChain tchain = (TokenizerChain) analyzer;
//			TokenizerFactory tfac = tchain.getTokenizerFactory();
//			TokenFilterFactory[] filtfacs = tchain.getTokenFilterFactories();
//			TokenStream tstream = tfac.create(tchain
//					.charStream(new StringReader(val)));
//			List<Token> tokens = null;
//			tokens = getTokens(tstream);
//			for (TokenFilterFactory filtfac : filtfacs) {
//				final Iterator<Token> iter = tokens.iterator();
//				tstream = filtfac.create(new TokenStream() {
//					public Token next() throws IOException {
//						return iter.hasNext() ? iter.next() : null;
//					}
//				});
//				tokens = getTokens(tstream);
//				if (tokens != null) {
//					for (Token token : tokens) {
//						String term = token.term().toString();
//						if (!searchKeys.contains(term)) {
//							searchKeys.add(term);
//						}
//					}
//				}
//			}
//		} else {
//			SchemaField field = new SchemaField("fakefieldoftype:" + name, ft);
//			TokenStream tstream = analyzer.reusableTokenStream(field.getName(),
//					new StringReader(val));
//			tstream.reset();
//			List<Token> tokens = null;
//			tokens = getTokens(tstream);
//			if (tokens != null) {
//				for (Token token : tokens) {
//					String term = token.term().toString();
//					if (!searchKeys.contains(term)) {
//						searchKeys.add(term);
//					}
//				}
//			}
//		}
//		return searchKeys.toArray(new String[0]);
//	}

	public void login() throws IOException {
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		String userid = request.getParameter("id");
		// ZuiUser zu = new ZuiUserDao().getById(Integer.valueOf(userid));
		User u = new User();
		List<Tag> tags = new ArrayList<Tag>();
		Tag t = new Tag("学习 睡觉");
		tags.add(t);
		u.setTags(tags);
		request.getServletContext().setAttribute("user", u);

		response.setHeader("content-type", "text/html;charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		out.write("User: " + userid + " login succeed!<br>");
		out.write("<a href=\"/searchEngine/index/index\">跳转到话题页面</a><br>");
		out.write("<a href=\"/searchEngine/users/users\">跳转到用户页面</a>");
	}
	
	public String checkLogin() throws SolrServerException{
		HttpServletRequest request = ServletActionContext.getRequest();
		User u = userDao2.queryProfile(username);
		request.getServletContext().setAttribute("user", u);
		List<Tag> tagList = u.getTags();
		Boolean isChuangye = false;
		for(Tag t: tagList){
			if("创业".equals(t.getNames())||"创新".equals(t.getNames())){
				isChuangye = true;
				break;
			}
		}
		try {
			topics = topicDao.queryTopic(u);
			if(isChuangye){
				Topic w = new Topic();
				w.setContent("[【思路决定道路】1.打工的:这不太可能吧？创业的:一切皆有可能！2.打工的:没办法，老板逼的；创业的:没办法，自己逼的！3.打工的:算了吧，明天再说；创业的:快回来，今天干完！4.打工的:别别别，出了问题我担当不起；创业的:上上上，如果闯祸我来负责！5..打工的:不行；创业的:我看行!]");
				List<String> tags = new ArrayList<String>();tags.add("创业");
				w.setTags(tags);
				w.setJoinNumber("15");
				w.setUser("在路上");
				w.setPubTime("Mon Feb 20 21:00:27");
				topics.add(0, w);
			}
		} catch (SolrServerException | IOException e) {
			e.printStackTrace();
			return "queryException";
		}
		return "index";
	}
	
	public String login2(){
		return "login";
	}

	public List<Topic> getTopics() {
		return topics;
	}

	public void setTopics(List<Topic> topics) {
		this.topics = topics;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

}
