<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="/WEB-INF/struts-html.tld"  prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld"  prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<html:html>
<head>
<link type="text/css" rel="stylesheet" media="screen" href="stylesheets/style.css"/>
<title><bean:message key="books.title" /></title>
</head>
<body>
<div id="container">

<h2 id="headtitle"><bean:message key="books.title" /></h2>

<div id="title">
	<html:link action="/BookListAction"><bean:message key="books.title.list" /></html:link> | 
	<html:link action="/BookFormAction"><bean:message key="books.title.new" /></html:link>
</div>

<table border="1">
  <tr>
    <th><bean:message key="books.header.title" /></th><td nowrap><bean:write name="bookinfo" property="isbn" /></td>
  </tr>
  <tr>
    <th><bean:message key="books.header.isbn" /></th><td nowrap><bean:write name="bookinfo" property="title" /></td>
  </tr>
  <tr>
    <th><bean:message key="books.header.author" /></th><td nowrap><bean:write name="bookinfo" property="author" /></td>
  </tr>
  <tr>
    <th><bean:message key="books.header.price" /></th><td nowrap><bean:write name="bookinfo" property="price" /></td>
  </tr>
  <tr>
    <th><bean:message key="books.header.publish" /></th><td nowrap><bean:write name="bookinfo" property="publish" /></td>
  </tr>
  <tr>
    <th><bean:message key="books.header.published" /></th><td nowrap><bean:write name="bookinfo" property="published" /></td>
  </tr>
  
</table>
</div>
</body>
</html:html>
