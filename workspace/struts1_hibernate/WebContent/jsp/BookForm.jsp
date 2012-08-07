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

<div id="title"><html:link action="/BookListAction"><bean:message key="books.title.list" /></html:link></div>

<%--
<!-- javascript -->
<html:javascript formName="BookUpdateForm" />
<html:form action="/BookWriteAction" onsubmit="return validateBookUpdateForm(this)">
--%>

<html:errors />
<html:form action="/BookStoreAction" >
<table border="0">
  <tr>
    <th align="right"><bean:message key="books.header.isbn" />：</th>
    <td>
      <logic:equal name="update.flag" value="true">
        <html:text property="isbn" size="20" maxlength="20" readonly="true" />
      </logic:equal>
      <logic:notEqual name="update.flag" value="true">
        <html:text property="isbn" size="20" maxlength="20" />
      </logic:notEqual>
      <small>[0-9]{1,5}-[0-9]{1,7}-[0-9]{1,7}-[0-9A-Z]{1}</small>
    </td>
  </tr>
  <tr>
    <th><bean:message key="books.header.title" />：</th>
    <td>
      <html:text property="title" size="50" maxlength="50" />
    </td>
  </tr>
  <tr>
    <th><bean:message key="books.header.author" />：</th>
    <td>
      <html:text property="author" size="15" maxlength="15" />
    </td>
  </tr>
  <tr>
    <th><bean:message key="books.header.price" />：</th>
    <td>
      <html:text property="price" size="5" maxlength="5" /><bean:message key="books.header.currency" />
      <html:errors property="price_error" />
    </td>
  </tr>
  <tr>
    <th><bean:message key="books.header.publish" />：</th>
    <td>
      <html:text property="publish" size="25" maxlength="25" />
    </td>
  </tr>
  <tr>
    <th><bean:message key="books.header.published" />：</th>
    <td>
      <html:text property="published" size="12" maxlength="12" />
    </td>
  </tr>
  <tr>
    <td colspan="2">
      <html:submit property="submit"><bean:message key="books.header.submit" /></html:submit>
      <html:reset  property="reset"><bean:message key="books.header.reset" /></html:reset>
    </td>
  </tr>
</table>
</html:form>

</div>
</body>
</html:html>
