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
<ol>

	<li><a href="<s:url action="Textfield"/>">TextField</a></li>
	<li><a href="<s:url action="Checkbox"/>">CheckBox</a></li>
	<li><a href="<s:url action="Checkboxlist"/>">CheckBoxlist</a></li>
	<li><a href="<s:url action="Radio"/>">Radio</a></li>
	<li><a href="<s:url action="Select"/>">Select</a></li>
	<li><a href="<s:url action="Combobox"/>">ComboBox</a></li>
	<li><a href="<s:url action="Tab"/>">Tab</a></li>
	<li><a href="<s:url action="Tree"/>">Tree</a></li>
	<li><a href="<s:url action="Calendar"/>">Calendar</a></li>

</ol>
</div>

</body>
</html>

