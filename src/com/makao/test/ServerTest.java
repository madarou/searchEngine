package com.makao.test;

import java.io.IOException;

import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServer;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrServer;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.client.solrj.response.UpdateResponse;
import org.apache.solr.common.SolrDocumentList;
import org.apache.solr.common.SolrInputDocument;
import org.apache.solr.common.params.SolrParams;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ServerTest {

    

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
 
/*    @Test
    public void addDoc() {
    //创建doc文档
    	SolrInputDocument doc = new SolrInputDocument();
    	doc.addField("id", 1);

    	doc.addField("name", "Solr Input Document");
    	doc.addField("manu", "this is SolrInputDocument content");
    	try {
        //添加一个doc文档
        UpdateResponse response = server.add(doc);
        fail(server.commit());//commit后才保存到索引库
        fail(response);
        fail("query time：" + response.getQTime());
        fail("Elapsed Time：" + response.getElapsedTime());
        fail("status：" + response.getStatus());
    } catch (SolrServerException e) {
        e.printStackTrace();
    } catch (IOException e) {
        e.printStackTrace();
    }
    query("name:Input");
}*/
    /**
     * <b>function:</b> 根据query参数查询索引
     */
    public void query(String query) {
        SolrParams params = new SolrQuery(query);
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

    @Test
    public void remove() {
        try {
            //删除id为1的索引
        	query("id:1");
            server.deleteById("1");
            server.commit();
            query("id:1");
        } catch (SolrServerException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
