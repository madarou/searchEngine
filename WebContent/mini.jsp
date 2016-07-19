<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s"  uri="/struts-tags"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
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
    
    <title>mini weibo</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">   
	
    <script type="text/javascript">
    		var req;  
function loadInfo() {  
    //获取表单提交的内容  
    var idField = document.getElementById("content");  
    //访问validate.do这个servlet，同时把获取的表单内容idField加入url字符串，以便传递给validate.do  
    var url = "updateStatus.action?content=" + idField.value; 
    url=encodeURI(url);
   	url=encodeURI(url);                  
    //创建一个XMLHttpRequest对象req  
    if(window.XMLHttpRequest) {  
        //IE7, Firefox, Opera支持  
        req = new XMLHttpRequest();  
    }else if(window.ActiveXObject) {  
        //IE5,IE6支持  
        req = new ActiveXObject("Microsoft.XMLHTTP");  
    }  
    /* 
     open(String method,String url, boolean )函数有3个参数 
     method参数指定向servlet发送请求所使用的方法，有GET,POST等 
     boolean值指定是否异步，true为使用，false为不使用。 
     我们使用异步才能体会到Ajax强大的异步功能。 
     */  
    req.open("POST", url, true);  
    //onreadystatechange属性存有处理服务器响应的函数,有5个取值分别代表不同状态  
    req.onreadystatechange = callback;  
    //send函数发送请求  
    req.send(null);                  
} 

function callback() {  
    if(req.readyState == 4 && req.status == 200) {  
        var check = req.responseText;  
        var show = document.getElementById("weibos");
        show.innerHTML=check;
        
        var label = document.getElementById("publishSuc");
        label.innerHTML="<font color='red'>发布成功！</font>";
        
        document.getElementById("content").value="";
        
    }  
}
	</script>
	
  </head>
  
  <body>
  	<div class="fixed_div" style="right:0; top:0; width:100%;"><img src="<%=basePath%>image/navigation.jpg"/></div><br/><br/><br/><br/><br/>
    <div class="fixed_div" style="margin-left:165px;">
    	
    	<%-- <s:form action="mini_updateStatus" namespace="/mini" method="post">
    		<s:textarea name="status.text" cssClass="publishTxt"></s:textarea><s:submit value="发布" cssClass="publishBtn"></s:submit>
    	</s:form> --%>
    </div>
    <br/>
    <br/>
    <br/>
    <br/>
    	<div class="one">
    		<center>
    			<br/>
    			<span>
    				<img src="<s:property value='user.avatarLarge'/>" width="117px" height="117px"><br/>
    				<font size=4><s:property value='user.screenName'/></font><br/><br/>
    			</span>
    			<span>
    				<font size=3>
    				关注：<s:property value='user.friendsCount'/>&nbsp;
    				粉丝：<s:property value='user.followersCount'/>&nbsp;
    				微博：<s:property value='user.statusesCount'/>
    				</font>
    			</span>
    		</center>
    	</div>
    	<div class="two"><b><font size="6">有什么新鲜事想告诉大家？</font></b><br/>
    		<s:form namespace="" method="post">
    		<textarea class="publishTxt" id="content"></textarea><%-- <s:submit value="发布" cssClass="publishBtn"></s:submit> --%>
    		<input type="button" value="发布" id="btnGet" class="publishBtn" onclick="loadInfo()" /><label id="publishSuc"></label>
    	</s:form>
    	</div>
    	<div class="three">
    		<center>
    		<br/>
    		<b><font size="3">我的好友</font></b>
    		<s:iterator  value="userList" status="status">
    			<s:if test="#status.index % 3 == 0">
    				<br/><br/>
      			</s:if>
    			<a href="http://www.weibo.com/u/<s:property value='id'/>" target="_blank">
    				<img src="<s:property value='profileImageUrl'/>">
    			</a>&nbsp;&nbsp;
    		</s:iterator>
    		</center>
    	</div>
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
</html>
