<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link type="text/css" rel="stylesheet" media="screen" href="stylesheets/style.css"/>
</head>
<body>
<div id="container">

<div id="title"><a href="BookCreate">Create New Book</a></div>

<table>
<tr>
<th>${book_isbn}</th>
<th>${book_title}</th>
<th>${book_author}</th>
<th>${book_price}</th>
<th>${book_publish}</th>
<th>${book_published}</th>
<th>&nbsp;</th>
</tr>

<c:forEach var="bean" items="${book_list}">
<tr>
	<td><a href='BookUpdate?isbn=<c:out value="${bean.isbn}"/>'><c:out value="${bean.isbn}"/></a></td>
	<td><c:out value="${bean.title}"/></td>
	<td><c:out value="${bean.author}"/></td>
	<td><c:out value="${bean.price}"/></td>
	<td><c:out value="${bean.publish}"/></td>
	<td><c:out value="${bean.published}"/></td>
	<td colspan="2"><a href='BookView?isbn=<c:out value="${bean.isbn}"/>'>View</a>|<a href='BookDestroy?isbn=<c:out value="${bean.isbn}"/>'>Destroy</a></td>
</tr>
</c:forEach>
</table>
</div>
</body>
</html>
