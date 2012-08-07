<%@page pageEncoding="utf-8" %>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <link type="text/css" rel="stylesheet" media="screen" href="<s:url value="/stylesheets/style.css"/>" />
	<title><s:text name="application.title"/></title>
</head>
<body>
<div id="container">
<h1><s:text name="title.show"/></h1>

<table>
	<tr>
		<th><s:text name="label.email"/></th>
		<td><s:property value="user.email"/></td>
	</tr>
	<tr>
		<th><s:text name="label.password"/></th>
		<td><s:property value="user.password"/></td>
	</tr>
	<tr>
		<th><s:text name="label.name"/></th>
		<td><s:property value="user.name"/></td>
	</tr>
	<tr>
		<th><s:text name="label.birthday"/></th>
		<td><s:property value="user.formattedBirthday"/></td>
	</tr>
	<tr>
		<th><s:text name="label.gender"/></th>
		<td><s:property value="user.formattedGender"/></td>
	</tr>
	<tr>
		<th><s:text name="label.website"/></th>
		<td><s:property value="user.website"/></td>
	</tr>	
</table>
<p/>
<s:url id="listUrl" namespace="/" action="user" method="listUser"/>
<s:a href="%{listUrl}"><s:text name="link.list"/></s:a>
 | 
<s:url id="insert" namespace="/" action="user" method="newUser"/>
<s:a href="%{insert}"><s:text name="link.new"/></s:a>
 | 
<s:url id="editUrl" action="user" method="editUser">
	<s:param name="email" value="email"/>
</s:url>
<s:a href="%{editUrl}"><s:text name="link.edit"/></s:a>

</div>

</body>
</html>
