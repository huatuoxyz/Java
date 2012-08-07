<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="/WEB-INF/struts-html.tld"  prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld"  prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-tiles.tld" prefix="tiles" %>

<html:html>
<head>
<link type="text/css" rel="stylesheet" media="screen" href="stylesheets/style.css"/>
<title><bean:message key="book.title.title" /></title>
</head>
<body>
<div id="container">

<h2 id="headtitle"><bean:message key="book.title.title" /></h2>

<div id="title"><html:link action="/BookFormAction"><bean:message key="book.title.new" /></html:link></div>

<table>
  <tr>
    <th><bean:message key="book.isbn" /></th>
    <th><bean:message key="book.title" /></th>
    <th><bean:message key="book.author" /></th>
    <th><bean:message key="book.price" /></th>
    <th><bean:message key="book.publish" /></th>
    <th><bean:message key="book.published" /></th>
    <th>&nbsp;</th>
  </tr>
  <logic:iterate id="bookInfo" name="book.view.info" scope="request">
    <tr>
      <td><bean:write name="bookInfo" property="isbn" /></td>
      <td><bean:write name="bookInfo" property="author" /></td>
      <td><bean:write name="bookInfo" property="title" /></td>
      <td><bean:write name="bookInfo" property="price" /></td>
      <td><bean:write name="bookInfo" property="publish" /></td>
      <td><bean:write name="bookInfo" property="formattedPublished" /></td>
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

<tiles:insert definition="footer" flush="true"/>

</div>
</body>
</html:html>
 