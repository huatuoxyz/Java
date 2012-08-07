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

<div id="title"><html:link action="/BookFormAction"><bean:message key="books.title.new" /></html:link></div>

<table>
  <tr>
    <th><bean:message key="books.header.isbn" /></th>
    <th><bean:message key="books.header.title" /></th>
    <th><bean:message key="books.header.author" /></th>
    <th><bean:message key="books.header.price" /></th>
    <th><bean:message key="books.header.publish" /></th>
    <th><bean:message key="books.header.published" /></th>
    <th>&nbsp;</th>
  </tr>
  <logic:iterate id="bookInfo" name="book.view.info" scope="request">
    <tr>
      <td><bean:write name="bookInfo" property="isbn" /></td>
      <td><bean:write name="bookInfo" property="title" /></td>
      <td><bean:write name="bookInfo" property="author" /></td>
      <td><bean:write name="bookInfo" property="price" /></td>
      <td><bean:write name="bookInfo" property="publish" /></td>
      <td><bean:write name="bookInfo" property="published" /></td>
      <td>
      	<html:link action="/BookViewAction">
      	  <html:param name="isbn"><bean:write name="bookInfo" property="isbn" /></html:param>
      	  View
      	</html:link>
      	 | 
        <html:link action="/BookFormAction"
          paramId="isbn" paramName="bookInfo" paramProperty="isbn">
          Update
        </html:link>
         | 
        <html:link action="/BookDestroyAction"
          paramId="isbn" paramName="bookInfo" paramProperty="isbn">
          Destroy
        </html:link>
 
      </td>
    </tr>
  </logic:iterate>
</table>
</div>
</body>
</html:html>
 