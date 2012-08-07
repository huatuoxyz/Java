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
<h1><s:text name="title.list"/></h1>
<table>
	<tr>
		<th><s:text name="label.email"/></th>
		<th><s:text name="label.password"/></th>
		<th><s:text name="label.name"/></th>
		<th><s:text name="label.birthday"/></th>
		<th><s:text name="label.gender"/></th>
		<th><s:text name="label.website"/></th>
		<th>&nbsp;</th>
	</tr>
	<s:iterator value="users">
	<tr>
		<td><s:property value="email"/></td>
		<td><s:property value="password"/></td>
		<td><s:property value="name"/></td>
		<td><s:property value="formattedBirthday"/></td>
		<td><s:property value="formattedGender"/></td>
		<td><s:property value="website"/></td>
		<td>
			<s:url id="showUrl" action="user" method="showUser">
				<s:param name="email" value="email"/>
	        </s:url>
	        <s:a href="%{showUrl}"><s:text name="link.show"/></s:a>
	         | 
			<s:url id="editUrl" action="user" method="editUser">
				<s:param name="email" value="email"/>
	        </s:url>
	        <s:a href="%{editUrl}"><s:text name="link.edit"/></s:a>
	         | 
	        <s:url id="deleteUrl" action="user" method="deleteUser">
				<s:param name="email" value="email"/>
	        </s:url>
	        <s:a href="%{deleteUrl}"><s:text name="link.delete"/></s:a>
	        
	    </td>
	</tr>
	</s:iterator>
</table>
<p/>
<s:url id="newUrl" namespace="/" action="user" method="newUser"/>
<s:a href="%{newUrl}"><s:text name="link.new"/></s:a>

</div>

</body>
</html>
