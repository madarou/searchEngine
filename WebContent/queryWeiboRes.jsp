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
    
    <title>搜索结果</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">   
	
  </head>
  
  <body>
  	<div class="fixed_div" style="right:0; top:0; width:100%;"><img src="<%=basePath%>image/navigation.jpg"/></div><br/><br/><br/><br/><br/>
    <div class="fixed_div" style="margin-left:165px;">
    	
    	<s:form action="solr_queryWeibo" namespace="/solr" method="post" theme="simple">
    		<s:textfield name="weibo.text" cssClass="searchTxt"></s:textfield>&nbsp;&nbsp;<s:submit value="搜索" cssClass="searchBtn"></s:submit>
    	</s:form>
    </div>
    <br/>
    <br/>
    <br/>
    <br/>
    	<div>
        <table class="weiboList" cellspacing="10">
	        <s:iterator  value="weiboList">
	        	<tr>
	        		<td style="vertical-align:top" width="100px">
	        			<center>
	        			<img src="<s:property value='profile_image_url'/>"><br/>
	        			<a href="http://www.weibo.com/<s:property value='profile_url'/>" target="_blank"><s:property value="screen_name"/></a>
	        			</center>
	        		</td>
	        		<td bgcolor="#DFFFDF">
	        			<s:property value="text" escape="false"/><br/>
	        			<s:if test="original_pic!=''">
	        				<s:if test="isretweet=='false'">
	        					<center><img src="<s:property value='original_pic'/>" height="200px" width="200px"></center>
	        				</s:if>
	        			</s:if>
	        			<div class="retweet_text">
	        				<s:if test="isretweet=='true'">
	        					<b>@<s:property value="retweet_screenname"/></b><br/>
	        					<s:property value="retweet_text"/><br/>
	        					<s:if test="retweet_originalpic!=''">
	        						<center><img src="<s:property value='retweet_originalpic'/>" height="200px" width="200px"></center>
	        					</s:if>
	        					<br/>
	        					<div><a href="<s:property value='retweet_weibourl'/>" target="_blank"><s:property value="retweet_createdat"/></a><span style="float:right"><font size="2"><i>转发</i></font>:<s:property value="retweet_repostscount"/>&nbsp;&nbsp;<font size="2"><i>评论</i></font>:<s:property value="retweet_commentscount"/></span></div>
	        				</s:if>
	        			</div>
	        			<br/>
	        			<div><a href="<s:property value='weibourl'/>" target="_blank"><s:property value="created_at"/></a><span style="float:right"><font size="2"><i>转发</i></font>:<s:property value="reposts_count"/>&nbsp;&nbsp;<font size="2"><i>评论</i></font>:<s:property value="comments_count"/></span></div>

	        		</td>
	        	</tr>
	        </s:iterator>
        </table>
        </div>
  </body>
</html>
