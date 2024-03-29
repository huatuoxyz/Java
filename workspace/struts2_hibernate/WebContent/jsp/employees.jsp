<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
    <link href="<s:url value="/css/main.css"/>" rel="stylesheet" type="text/css"/>
    <title><s:text name="label.employees"/></title>
</head>
<body>
<h1><s:text name="label.employees"/></h1>		   
	<table width=600 align=center>
	    <tr> <s:url id="insert" action="setUpForInsertOrUpdate"/>
	         <td><s:a href="%{insert}">Click Here to Add New Employee</s:a></td>
	     </tr>
	</table><br/>
<table align=center class="borderAll">
    <tr>
        <th><s:text name="label.firstName"/></th>
        <th><s:text name="label.lastName"/></th>
        <th><s:text name="label.age"/></th>
        <th><s:text name="label.department"/></th>	 
        <th>&nbsp;</th>
    </tr>
    <s:iterator value="employees" status="status">
        <tr class="<s:if test="#status.even">even</s:if><s:else>odd</s:else>">
            <td class="nowrap"><s:property value="firstName"/></td>
            <td class="nowrap"><s:property value="lastName"/></td>
            <td class="nowrap"><s:property value="age"/></td>
            <td class="nowrap"><s:property value="department.name"/></td>
            <td class="nowrap">
                	<s:url id="update" action="setUpForInsertOrUpdate">
		       		   <s:param name="employee.employeeId" value="employeeId"/>
		       		</s:url> 
                <s:a href="%{update}">Edit</s:a>
                &nbsp;&nbsp;&nbsp;
                <s:url id="delete" action="delete">
		       		   <s:param name="employee.employeeId" value="employeeId"/>
		       		</s:url>
                <s:a href="%{delete}">Delete</s:a>
            </td>
        </tr>  		
	 </s:iterator>
    </table>
</body>
</html>