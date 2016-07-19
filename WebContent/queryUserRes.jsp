<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s"  uri="/struts-tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>搜索结果</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">   

  </head>
  
  <body>
    <center>
    
    	<s:form action="solr_queryUser" namespace="/solr" method="post">
    		<s:textfield label="用户名" name="user.screen_name"></s:textfield>
    		<s:submit value="搜索"></s:submit>
    	</s:form>
    	
    	<h2>用户列表</h2>
        <table width="90%" border="1">
            <tr>
            	<th>用户id</th>
            	<th>用户名称</th>
            </tr>
	        <s:iterator  value="userList">
	        	<tr>
	        		<td><s:property value="id"/> </td>
	        		<td><s:property value="screen_name"/> </td>
	        	</tr>
	        </s:iterator>
        </table>
        
    </center>
  </body>
</html>
