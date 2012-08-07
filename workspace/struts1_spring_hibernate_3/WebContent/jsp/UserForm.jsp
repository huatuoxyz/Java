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
</html:link></div>

<%--
<!-- javascript -->
<html:javascript formName="BookUpdateForm" />
<html:form action="/BookWriteAction" onsubmit="return validateBookUpdateForm(this)">
--%> <html:errors /> <html:form action="/UserStore">
	<table border="0">
		<tr>
			<th align="right"><bean:message key="user.email" />：</th>
			<td><logic:equal name="update.flag" value="true">
				<html:text property="email" size="50" maxlength="50" readonly="true" />
			</logic:equal> <logic:notEqual name="update.flag" value="true">
				<html:text property="email" size="50" maxlength="50" />
			</logic:notEqual></td>
		</tr>
		<tr>
			<th><bean:message key="user.password" />：</th>
			<td><html:text property="password" size="50" maxlength="50" />
			<html:errors property="price_error" /></td>
		</tr>
		<tr>
			<th><bean:message key="user.name" />：</th>
			<td><html:text property="name" size="30" maxlength="30" /></td>
		</tr>
		<tr>
			<th><bean:message key="user.birthday" />：</th>
			<td><html:text property="birthday" size="15" maxlength="10" />

			</td>
		</tr>
		<tr>
			<th><bean:message key="user.gender" />：</th>
			<td>
			<html:radio property="gender" value="1"/><bean:message key="user.gender.man" />
			<html:radio property="gender" value="2"/><bean:message key="user.gender.woman" />
			<html:radio property="gender" value="3"/><bean:message key="user.gender.other" />
			</td>
		</tr>
		<tr>
			<th><bean:message key="user.website" />：</th>
			<td><html:text property="website" size="50" maxlength="100" />
			</td>
		</tr>
		<tr>
			<td colspan="2"><html:submit property="submit">
				<bean:message key="user.submit" />
			</html:submit> <html:reset property="reset">
				<bean:message key="user.reset" />
			</html:reset></td>
		</tr>
	</table>
</html:form>

<tiles:insert definition="footer" flush="true"/>

</div>
</body>
</html:html>
