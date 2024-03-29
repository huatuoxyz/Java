<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="/WEB-INF/struts-html.tld"  prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld"  prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>

<html:html>
<head>
<link type="text/css" rel="stylesheet" media="screen" href="stylesheets/style.css"/>
<title><bean:message key="book.title.title" /></title>
</head>
<body>
<div id="container">

<h2 id="headtitle"><bean:message key="book.title.title" /></h2>

<div id="title">
	<html:link action="/BookListAction"><bean:message key="book.title.list" /></html:link> | 
	<html:link action="/BookFormAction"><bean:message key="book.title.new" /></html:link>
</div>

<table border="1">
  <tr>
    <th><bean:message key="book.title" /></th><td nowrap><bean:write name="book" property="isbn" /></td>
  </tr>
  <tr>
    <th><bean:message key="book.isbn" /></th><td nowrap><bean:write name="book" property="title" /></td>
  </tr>
  <tr>
    <th><bean:message key="book.author" /></th><td nowrap><bean:write name="book" property="author" /></td>
  </tr>
  <tr>
    <th><bean:message key="book.price" /></th><td nowrap><bean:write name="book" property="price" /></td>
  </tr>
  <tr>
    <th><bean:message key="book.publish" /></th><td nowrap><bean:write name="book" property="publish" /></td>
  </tr>
  <tr>
    <th><bean:message key="book.published" /></th><td nowrap><bean:write name="book" property="formattedPublished" /></td>
  </tr>
  
</table>

</div>
</body>
</html:html>
