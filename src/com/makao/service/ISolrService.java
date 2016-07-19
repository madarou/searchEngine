/**
 * 
 */
package com.makao.service;

import java.util.List;

import org.apache.solr.client.solrj.SolrServerException;

import com.makao.model.User;
import com.makao.model.Weibo;

/**
 * @author LiYanyu
 * @email 14210240081@fudan.edu.cn
 */
public interface ISolrService {
	 public abstract List<User> queryUser(String query_string) throws SolrServerException;
	 public abstract List<Weibo> queryWeibo(String query_string) throws SolrServerException;
}
