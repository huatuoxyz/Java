<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<%@ taglib prefix="sx" uri="/struts-dojo-tags" %>
<html>
<head>
  <title>sample04-tags</title>
  <link rel="stylesheet" type="text/css" href="<s:url value="/stylesheets/style.css"/>">
  
</head>
<body>
<div id="container">

<h1>Struts2 Tags</h1>

<hr/>
<h1>Select</h1>

<s:label name="label"/><br/>
<s:form method="post" action="Select" >
	<s:select name="select" label="SELECT" size="3" multiple="true"
				list="{\"Recruit\",\"Baby\",\"Money\",\"Health\"}" />
	<s:submit/>
</s:form>

<hr/>

<s:include value="back.jsp"/>
 
</div>
 
</body>
</html>
