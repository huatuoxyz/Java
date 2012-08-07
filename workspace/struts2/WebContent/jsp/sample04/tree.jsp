<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<%@ taglib prefix="sx" uri="/struts-dojo-tags" %>
<html>
<head>
  <title>sample04-tags</title>
  <link rel="stylesheet" type="text/css" href="<s:url value="/stylesheets/style.css"/>">
  <sx:head parseContent="true" />
</head>
<body>
<div id="container">

<h1>Struts2 Tags</h1>

<hr/>

<h1>ツリー</h1>
<sx:tree label="ツリー表示">
	<sx:treenode label="項目その１">
		<sx:treenode label="サブ項目その１" />
		<sx:treenode label="サブ項目その２" />
	</sx:treenode>
	<sx:treenode label="項目その２">
		<sx:treenode label="サブ項目その３" />
		<sx:treenode label="サブ項目その４" />
	</sx:treenode>
</sx:tree>

<hr/>

<s:include value="back.jsp"/>
 
</div>
 
</body>
</html>
