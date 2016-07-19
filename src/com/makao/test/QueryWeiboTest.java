package com.makao.test;

import static org.junit.Assert.*;

import org.apache.solr.client.solrj.SolrServer;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrServer;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocumentList;
import org.apache.solr.common.params.ModifiableSolrParams;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class QueryWeiboTest {
	private SolrServer server;
    private HttpSolrServer httpServer;
    private static final String DEFAULT_URL = "http://localhost:8081/solr/collection1";

    @Before
    public void init(){
    	server = new HttpSolrServer(DEFAULT_URL);
		httpServer = new HttpSolrServer(DEFAULT_URL);
    }
    
    @After
    public void destory() {
        server = null;
        httpServer = null;
        System.runFinalization();
        System.gc();
    }

    public final void fail(Object o) {
        System.out.println(o);
    }
    

    @Test
    public void server() {
        fail(server);
        fail(httpServer);
    }
	@Test
	public void queryAll() {

	    ModifiableSolrParams params = new ModifiableSolrParams();

	    // 查询关键词，*:*代表所有属性、所有值，即所有index

	    params.set("q", "*:*");

	    // 分页，start=0就是从0开始，，rows=5当前返回5条记录，第二页就是变化start这个值为5就可以了。

	    params.set("start", 0);

	    params.set("rows", Integer.MAX_VALUE);

	    

	    // 排序，，如果按照id 排序，，那么将score desc 改成 id desc(or asc)

	    params.set("sort", "score desc");

	 

	    // 返回信息 * 为全部 这里是全部加上score，如果不加下面就不能使用score

	    params.set("fl", "*,score");

	    

	    try {

	        QueryResponse response = server.query(params);

	        SolrDocumentList list = response.getResults();

	        for (int i = 0; i < list.size(); i++) {
	            fail(list.get(i));
	        }

	    } catch (SolrServerException e) {

	        e.printStackTrace();

	    }

	}

}
