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

	    // ��ѯ�ؼ��ʣ�*:*�����������ԡ�����ֵ��������index

	    params.set("q", "*:*");

	    // ��ҳ��start=0���Ǵ�0��ʼ����rows=5��ǰ����5����¼���ڶ�ҳ���Ǳ仯start���ֵΪ5�Ϳ����ˡ�

	    params.set("start", 0);

	    params.set("rows", Integer.MAX_VALUE);

	    

	    // ���򣬣��������id ���򣬣���ô��score desc �ĳ� id desc(or asc)

	    params.set("sort", "score desc");

	 

	    // ������Ϣ * Ϊȫ�� ������ȫ������score�������������Ͳ���ʹ��score

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
