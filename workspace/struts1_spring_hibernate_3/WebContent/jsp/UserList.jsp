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

<div id="title"><html:link action="/UserForm">
	<bean:message key="user.new" />
</html:link></div>

<table>
	<tr>
		<th><bean:message key="user.email" /></th>
		<th><bean:message key="user.password" /></th>
		<th><bean:message key="user.name" /></th>
		<th><bean:message key="user.birthday" /></th>
		<th><bean:message key="user.gender" /></th>
		<th><bean:message key="user.website" /></th>
		<th>&nbsp;</th>
	</tr>
	<logic:iterate id="user" name="user.view.info" scope="request">
		<tr>
			<td><bean:write name="user" property="email" /></td>
			<td><bean:write name="user" property="password" /></td>
			<td><bean:write name="user" property="name" /></td>
			<td><bean:write name="user" property="formattedBirthday" /></td>
			<td><bean:write name="user" property="formattedGender" /></td>
			<td><bean:write name="user" property="website" /></td>
			<td><html:link action="/UserView">
				<html:param name="email">
					<bean:write name="user" property="email" />
				</html:param>
      	  View
      	</html:link> | <html:link action="/UserForm" paramId="email" paramName="user"
				paramProperty="email">
          Update
        </html:link> | <html:link action="/UserDestroy" paramId="email"
				paramName="user" paramProperty="email">
          Destroy
        </html:link></td>
		</tr>
	</logic:iterate>
</table>

<tiles:insert definition="footer" flush="true"/>

</div>
</body>
</html:html>
