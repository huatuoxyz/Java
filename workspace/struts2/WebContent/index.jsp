<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <!-- META HTTP-EQUIV="Refresh" CONTENT="0;URL=example/Top.action" -->
    <!-- 
    <link type="text/css" rel="stylesheet" media="screen" href="/stylesheets/style.css" />
    -->
    <link rel="stylesheet" type="text/css" href="<s:url value="/stylesheets/style.css"/>">
</head>
<body>

<div id="container">
	<div id="round">
	<b class="rtop">
	  <b class="r1"></b> <b class="r2"></b> <b class="r3"></b> <b class="r4"></b>
	</b>
	<h2>Struts2 Examples</h2>
	<b class="rbottom">
	  <b class="r4"></b> <b class="r3"></b> <b class="r2"></b> <b class="r1"></b>
	</b>
	</div>

<ol>
	<li><a href="<s:url action="sample01/Hello"/>">Hello World!</a></li>
	<li><a href="<s:url action="sample02/hello"/>">Annotation</a></li>
	<li><a href="<s:url action="sample03/hello"/>">@Result</a></li>
	<li><a href="<s:url action="sample04/Index"/>">Tags</a></li>
	<li><a href="jsp/sample05/">Validation</a></li>
</ol>
</div>
</body>
</html>
