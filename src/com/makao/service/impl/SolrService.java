/**
 * 
 */
package com.makao.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrServer;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;
import org.apache.solr.common.params.SolrParams;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.makao.dao.IWeiboDao;
import com.makao.model.User;
import com.makao.model.Weibo;
import com.makao.service.ISolrService;
import com.makao.util.WeiboUtil;

/**
 * @author LiYanyu
 * @email 14210240081@fudan.edu.cn
 */
@Service
@Transactional
public class SolrService implements ISolrService{
	//private SolrServer server;
		
    private HttpSolrServer httpSolrServer;
    private static final String DEFAULT_URL = "http://115.159.109.12:80/collection1";
    
    public SolrService()
    {
    	httpSolrServer = new HttpSolrServer(DEFAULT_URL);
    	httpSolrServer.setAllowCompression(true);
    }
    
    public void addUser(User user)
    {
    	
    }
    
    @Override
    public List<User> queryUser(String query_string) throws SolrServerException
    {
    	String queryString = String.format("screen_name:*%s*", query_string);
    	SolrQuery q = new SolrQuery();
    	q.setQuery(queryString);
    	
    	q.setStart(0);
    	q.setRows(Integer.MAX_VALUE);
    	
    	QueryResponse response = httpSolrServer.query(q);
    	List<User> users = new ArrayList<User>();
    	
    	SolrDocumentList res = response.getResults();
    	for(SolrDocument doc : res)
    	{
    		String id = doc.getFieldValue("id").toString();
    		String screen_name = doc.getFieldValue("screen_name").toString();
    		User u = new User();
    		u.setId(id);
    		u.setScreen_name(screen_name);
    		users.add(u);
    	}
    	
    	return users;
    }

	/* (non-Javadoc)
	 * @see com.makao.service.ISolrService#queryWeibo(java.lang.String)
	 */
	@Override
	public List<Weibo> queryWeibo(String query_string)
			throws SolrServerException {
		String queryString = String.format("text:%s", query_string.trim());
    	SolrQuery q = new SolrQuery();
    	q.setQuery(queryString);
    	q.setRequestHandler("/browse");
    	q.setStart(0);
    	q.setRows(Integer.MAX_VALUE);
    	
    	//��������
    	//q.setSort("reposts_count", SolrQuery.ORDER.desc);
    
    	//��������
    	q.setHighlight(true).setHighlightFragsize(180)
    		.setHighlightSimplePre("<span style=\"color:red\">")//���ÿ�ͷ
    		.setHighlightSimplePost("</span>"); //���ý�β
    	q.setParam("hl.fl", "text");
    	
    	QueryResponse response = httpSolrServer.query(q);
    	List<Weibo> weibos = new ArrayList<Weibo>();
    	
    	SolrDocumentList res = response.getResults();
    	System.out.println("*******Hits: "+res.getNumFound()+"*******");
    	for(SolrDocument doc : res)
    	{
    		String id = doc.getFieldValue("id").toString();
    		String text = doc.getFieldValue("text").toString();
    		if(response.getHighlighting().get(id)!=null){
    			text = response.getHighlighting().get(id).get("text").get(0);
    		}
    		    		    		    		
    		Weibo w = new Weibo();
    		w.setId(id);
    		w.setText(text);
    		if(doc.getFieldValue("pic_urls")!=null)
    			w.setPic_urls(doc.getFieldValue("pic_urls").toString());
    		if(doc.getFieldValue("original_pic")!=null)
    			w.setOriginal_pic(doc.getFieldValue("original_pic").toString());
    		if(doc.getFieldValue("reposts_count")!=null)
    			w.setReposts_count(doc.getFieldValue("reposts_count").toString());
    		if(doc.getFieldValue("comments_count")!=null)
    			w.setComments_count(doc.getFieldValue("comments_count").toString());
    		if(doc.getFieldValue("screen_name")!=null)
    			w.setScreen_name(doc.getFieldValue("screen_name").toString());
    		if(doc.getFieldValue("profile_image_url")!=null)
    			w.setProfile_image_url(doc.getFieldValue("profile_image_url").toString());
    		if(doc.getFieldValue("profile_url")!=null)
    			w.setProfile_url(doc.getFieldValue("profile_url").toString());
    		if(doc.getFieldValue("created_at")!=null)
    			w.setCreated_at(doc.getFieldValue("created_at").toString());
    		if(doc.getFieldValue("mid")!=null)
    		{
    			String weibourl = "http://www.weibo.com/"+
    					WeiboUtil.extractUserID(w.getProfile_image_url())+"/"
    					+doc.getFieldValue("mid").toString();
    			w.setWeibourl(weibourl);    			
    		}
    		String isretweet = (String) doc.getFieldValue("isretweet");
    		w.setIsretweet(isretweet);
    		if("true".equals(isretweet))
    		{
    			//������ת����΢�������ԭ����ɾ�ˣ�����ȡ����user��Ϣ�ģ�ֻ��
    			//retweet_id��retweet_text����Ǹ����΢�������˶��⹫�����������������ϵ�ͷ���http://t.cn/z0D6ZaQ��
    			if(doc.getFieldValue("retweet_screenname")!=null)
    			{
    				w.setRetweet_screenname(doc.getFieldValue("retweet_screenname").toString());
    				if(doc.getFieldValue("retweet_picurls")!=null)
    					w.setRetweet_picurls(doc.getFieldValue("retweet_picurls").toString());
    				if(doc.getFieldValue("retweet_originalpic")!=null)
    					w.setRetweet_originalpic(doc.getFieldValue("retweet_originalpic").toString());
    				if(doc.getFieldValue("retweet_repostscount")!=null)
    					w.setRetweet_repostscount(doc.getFieldValue("retweet_repostscount").toString());
    				if(doc.getFieldValue("retweet_commentscount")!=null)
    					w.setRetweet_commentscount(doc.getFieldValue("retweet_commentscount").toString());
    				if(doc.getFieldValue("retweet_profileimageurl")!=null)
    				{
    					w.setRetweet_profileimageurl(doc.getFieldValue("retweet_profileimageurl").toString());
    					if(doc.getFieldValue("retweet_mid")!=null)
        	    		{
        	    			String retweet_weibourl = "http://www.weibo.com/"+
        	    					WeiboUtil.extractUserID(w.getRetweet_profileimageurl())+"/"
        	    					+doc.getFieldValue("retweet_mid").toString();
        	    			w.setRetweet_weibourl(retweet_weibourl);   			
        	    		}
    				}
    				if(doc.getFieldValue("retweet_profileurl")!=null)
    					w.setRetweet_profileurl(doc.getFieldValue("retweet_profileurl").toString());
    				if(doc.getFieldValue("retweet_createdat")!=null)
    					w.setRetweet_createdat(doc.getFieldValue("retweet_createdat").toString());
    				
    			}
    			
    			w.setRetweet_text(doc.getFieldValue("retweet_text").toString());
    		}
    		weibos.add(w);
    	}
    	
    	return weibos;
	}
}
