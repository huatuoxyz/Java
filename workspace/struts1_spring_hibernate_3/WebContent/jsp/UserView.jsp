<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/struts-tiles.tld" prefix="tiles" %>

<html:html>
<head>
<link type="text/css" rel="stylesheet" media="screen"
	href="stylesheets/style.css" />
<title><bean:message key="user.title" /></title>
</head>
<body>
<div id="container">

<h2 id="headtitle"><bean:message key="user.title" /></h2>

<div id="title"><html:link action="/UserList">
	<bean:message key="user.list" />
</html:link> | <html:link action="/UserForm">
	<bean:message key="user.new" />
</html:link></div>

<table border="1">
	<tr>
		<th><bean:message key="user.email" /></th>
		<td nowrap><bean:write name="user" property="email" /></td>
	</tr>
	<tr>
		<th><bean:message key="user.password" /></th>
		<td nowrap><bean:write name="user" property="password" /></td>
	</tr>
	<tr>
		<th><bean:message key="user.name" /></th>
		<td nowrap><bean:write name="user" property="name" /></td>
	</tr>
	<tr>
		<th><bean:message key="user.birthday" /></th>
		<td nowrap><bean:write name="user" property="formattedBirthday" /></td>
	</tr>
	<tr>
		<th><bean:message key="user.gender" /></th>
		<td nowrap><bean:write name="user" property="formattedGender" /></td>
	</tr>
	<tr>
		<th><bean:message key="user.website" /></th>
		<td nowrap><bean:write name="user" property="website" /></td>
	</tr>

</table>

<tiles:insert definition="footer" flush="true"/>

</div>
</body>
</html:html>
