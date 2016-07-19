<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s"  uri="/struts-tags"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
    <head>
    <style>
    	.retweet_text{background-color:#ADFEDC;margin-left:10px}
    	a:link {text-decoration: none;}
		a:visited {text-decoration: none;}
		a:hover {text-decoration: none;}
		a:active {text-decoration: none;}
		
		body{background-color:#c5d6ea;background-image:url(<%=basePath%>image/body_repeat_v6.png);background-repeat:repeat-x;background-position:center 0;}
		body,button,input,select,textarea{font:12px/1.125 Arial,Helvetica,sans-serif;_font-family:"SimSun";}
		
		.fixed_div{position:fixed;}
		
		.publishBtn{width:100px;height:36px;text-align:center;outline:none;background:#2f8ed8;border-radius:-2px;-webkit-border-radius:-2px;-moz-border-radius:-2px;-o-border-radius:-2px;color:#fefefe;font-size:16px;}
		.publishTxt{border:hidden; width:755px;height:100px;resize:none;}
		.weiboList{table-layout:fixed;word-wrap:break-word;}    
		
		.one, .two{
			float:left;
			font-size:14px;
		}
		.one{
			border:1px;
			width:300px;
		}
		.two{
			border:1px solid;
			width:800px;
		}
		
		.three, .four{
			float:left;
			font-size:14px;
		}
		.three{
			border:1px solid;
			width:300px;
		}
		.four{
			border:1px solid;
			width:800px;
		}

    </style>
    
    <title>weibolist</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">   
  </head>
  
  <body>
  	<div class="four" id="weibos">
        <table class="weiboList" cellspacing="10">
	        <s:iterator  value="weiboList">
	        	<tr>
	        		<td style="vertical-align:top;" width="50px">
	        			<center>
	        				<img src="<s:property value='profile_image_url'/>">	    
	        			</center>
	        		</td>
	        		<td bgcolor="#DFFFDF">
	        			<b><a href="http://www.weibo.com/<s:property value='profile_url'/>" target="_blank"><s:property value="screen_name"/></a></b><br/>
	        			<s:property value="text" escape="false"/><br/>
	        			<s:if test="original_pic!=''">
	        				<s:if test="isretweet=='false'">
	        					&nbsp;&nbsp;<img src="<s:property value='original_pic'/>" >
	        				</s:if>
	        			</s:if>
	        			<div class="retweet_text">
	        				<s:if test="isretweet=='true'">
	        					<b>@<s:property value="retweet_screenname"/></b><br/>
	        					<s:property value="retweet_text"/><br/>
	        					<s:if test="retweet_originalpic!=''">
	        						&nbsp;&nbsp;<img src="<s:property value='retweet_originalpic'/>" >
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