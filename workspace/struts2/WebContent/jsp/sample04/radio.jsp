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
<h1>Radio</h1>
<s:form method="post" action="Radio" >
	<s:radio name="radio" label="ラジオ" list="{\"転職\",\"子供\",\"お金\",\"健康\"}" />
	<s:radio name="radio" label="ラジオ" list="radiolist"/>
	<s:submit/>
	<br/>
	<s:label name="label"/><br/>
</s:form>
<hr/>

<s:include value="back.jsp"/>
 
</div>
 
</body>
</html>
