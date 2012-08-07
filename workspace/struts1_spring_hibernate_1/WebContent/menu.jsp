<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html:html>
<head>
<link type="text/css" rel="stylesheet" media="screen" href="stylesheets/style.css"/>
<title>SSH Menu</title>
</head>
<body>
<div id="container">
<h2 id="headtitle">Struts + Spring + Hibernate</h2>
<ul>
	<li><html:link action="/BookListAction"><bean:message key="book.title.title" /></html:link></li>
	<li><html:link action="/UserList"><bean:message key="user.title" /></html:link></li>
</ul>
</div>
</body>
</html:html>
