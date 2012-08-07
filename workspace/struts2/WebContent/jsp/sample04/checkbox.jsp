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
<h1>CheckBox</h1>
<s:form method="post" action="Checkbox" theme="simple">
	<s:label value="チェック："/><s:checkbox label="チェック" labelposition="left" name="checkbox"/><br/>
	<s:label name="label"/><br/>
	<s:submit/>
</s:form>
<hr/>

<s:include value="back.jsp"/>

</div>
</body>
</html>
