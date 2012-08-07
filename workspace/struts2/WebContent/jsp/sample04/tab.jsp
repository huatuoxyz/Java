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

<h1>タブパネル</h1>
<table width="300"><tr><td>
<sx:tabbedpanel id="tabpanel1">
	<sx:div id="tab1" label="TAB1" theme="ajax">タブ１<br/>タブ１<br/>タブ１タブ１タブ１タブ１</sx:div>
	<sx:div id="tab2" label="TAB2" theme="ajax">タブ２タブ２<br/>タブ２タブ２<br/>タブ２タブ２</sx:div>
	<sx:div id="tab3" label="TAB3" theme="ajax">タブ３タブ３<br/>タブ３タブ３<br/>タブ３</sx:div>
</sx:tabbedpanel>
</td></tr></table>

<hr/>

<s:include value="back.jsp"/>
 
</div>
 
</body>
</html>
