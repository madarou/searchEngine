<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s"  uri="/struts-tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <% 
		String path = request.getContextPath(); 
		String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/"; 
	%>
    <style>
    	.retweet_text{background-color:#ADFEDC;margin-left:10px}
    	a:link {text-decoration: none;}
		a:visited {text-decoration: none;}
		a:hover {text-decoration: none;}
		a:active {text-decoration: none;}
		
		body{background-color:#c5d6ea;background-image:url(<%=basePath%>image/body_repeat_v6.png);background-repeat:repeat-x;background-position:center 0;}
		body,button,input,select,textarea{font:12px/1.125 Arial,Helvetica,sans-serif;_font-family:"SimSun";}
		
		.fixed_div{position:fixed;}
		
		.searchBtn{width:100px;height:36px;text-align:center;outline:none;background:#2f8ed8;border-radius:-2px;-webkit-border-radius:-2px;-moz-border-radius:-2px;-o-border-radius:-2px;color:#fefefe;font-size:16px;}
		.searchTxt{border:hidden; width:755px;height:40px;font-size:20px;}
		.weiboList{width:60%;margin-left:130px;table-layout:fixed;word-wrap:break-word;}    
    </style>
    <title>搜索微博</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">   

  </head>
  
  <body>
    <center>
    	<div class="fixed_div" style="right:0;top:210px;width:100%;"><img src="<%=basePath%>image/navigation.jpg"/></div><br/><br/><br/><br/><br/>
    	<div class="fixed_div" style="left:180px;top:285px;">
    		<s:form action="solr_queryWeibo" namespace="/solr" method="post" theme="simple">
    			<s:textfield name="weibo.text" cssClass="searchTxt"></s:textfield>&nbsp;&nbsp;<s:submit value="搜索" cssClass="searchBtn"></s:submit><s:a href="mini/mini_homeTimeline" namespace="/mini" method="post">Mini Weibo</s:a>
    		</s:form>
    		
    		<%-- <s:form action="mini_homeTimeline" namespace="/mini" method="post">
    			<s:submit value="MiniWeibo" cssClass="searchBtn"></s:submit>
    	</s:form> --%>
    	
    	</div>
    	
    </center>
  </body>
</html>
