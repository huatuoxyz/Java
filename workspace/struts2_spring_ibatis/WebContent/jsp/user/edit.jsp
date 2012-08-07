<%@page pageEncoding="utf-8" %>
<%@taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sx" uri="/struts-dojo-tags" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <link type="text/css" rel="stylesheet" media="screen" href="<s:url value="/stylesheets/style.css"/>" />
	<title><s:text name="application.title"/></title>
	<sx:head parseContent="true" />
</head>
<body>
<div id="container">
<s:if test="%{controlflag=='new'}">
	<h1><s:text name="title.new"/></h1>
</s:if>
<s:elseif test="%{controlflag=='edit'}">
	<h1><s:text name="title.edit"/></h1>
</s:elseif>

<s:actionerror />
<s:fielderror /> 

<s:form theme="simple">
<s:hidden name="controlflag"/>
<table>
	<tr>
		<th><s:text name="label.email"/></th>
		<td>
		<s:if test="%{controlflag=='new'}">
			<s:textfield key="user.email"/>
		</s:if>
		<s:elseif test="%{controlflag=='edit'}">
			<s:textfield key="user.email" readonly="true"/>
		</s:elseif>
		
		
		
		
		
		</td>
	</tr>
	<tr>
		<th><s:text name="label.password"/></th>
		<td><s:textfield key="user.password"/></td>
	</tr>
	<tr>
		<th><s:text name="label.name"/></th>
		<td><s:textfield key="user.name"/></td>
	</tr>
	<tr>
		<th><s:text name="label.birthday"/></th>
		<td><!-- s:textfield key="user.birthday"/  -->
			<sx:datetimepicker name="user.birthday" displayFormat="yyyy/MM/dd"/>
		</td>
	</tr>
	<tr>
		<th><s:text name="label.gender"/></th>
		<td><!-- s:textfield key="user.gender"/ -->
			<s:radio name="user.gender" list="#{\"1\":\"♂\",\"2\":\"♀\"}" />
		</td>
	</tr>
	<tr>
		<th><s:text name="label.website"/></th>
		<td><s:textfield key="user.website"/></td>
	</tr>
	<tr>
		<td colspan="2">
		<s:if test="%{controlflag=='new'}">
			<s:submit action="user" method="createUser" value="作成"/>
		</s:if>
		<s:elseif test="%{controlflag=='edit'}">
			<s:submit action="user" method="updateUser" value="更新"/>
		</s:elseif>
		</td>
	</tr>
	
</table>
</s:form>
<p/>
<s:url id="listUrl" namespace="/" action="user" method="listUser"/>
<s:a href="%{listUrl}"><s:text name="link.list"/></s:a>
</div>

</body>
</html>
