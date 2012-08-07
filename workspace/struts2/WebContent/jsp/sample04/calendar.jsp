<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<%@ taglib prefix="sx" uri="/struts-dojo-tags" %>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
  	<title>sample04-tags</title>
  	<link rel="stylesheet" type="text/css" href="<s:url value="/stylesheets/style.css"/>">
  	<sx:head parseContent="true" />
</head>
<body>
<div id="container">

<h1>Struts2 Tags</h1>

<hr/>
<h1>カレンダー</h1>

<s:form method="post" action="Calendar" theme="simple">
	<sx:datetimepicker name="datetime" label="Calendar" displayFormat="yyyy/MM/dd"/>
	<s:submit/>
	<br/>
	<s:label name="label"/>
</s:form>
<hr/>

<s:include value="back.jsp"/>
 
</div>
 
</body>
</html>
