<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s"  uri="/struts-tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>搜索用户</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">   

  </head>
  
  <body>
    <center>
    	<h2>搜索用户</h2>
    	<s:form action="solr_queryUser" namespace="/solr" method="post">
    		<s:textfield label="用户名" name="user.screen_name"></s:textfield>
    		<s:submit value="搜索"></s:submit>
    	</s:form>
    </center>
  </body>
</html>
