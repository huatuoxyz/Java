<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
<link type="text/css" rel="stylesheet" media="screen" href="stylesheets/style.css"/>
</head>
<body>
<div id="container">

<div id="title"><a href="BookList">Cancel</a></div>
<ul>
<c:forEach var="bean" items="${messages}">
	<li class="error"><c:out value="${bean}"/></li>
</c:forEach>
</ul>

<jsp:useBean id="bookinfo" class="book.BookInfo" scope="request" />

<form action="BookUpdate" method="post">

<table>
<tr>
	<td>${book_isbn}</td><td><input type="text" name="isbn" value="<jsp:getProperty property="isbn" name="bookinfo"/>" readonly /></td>
</tr>
<tr>
	<td>${book_title}</td><td><input type="text" name="title" value="<jsp:getProperty property="title" name="bookinfo"/>"></td>
</tr>
<tr>
	<td>${book_author}</td><td><input type="text" name="author" value="<jsp:getProperty property="author" name="bookinfo"/>"></td>
</tr>
<tr>
	<td>${book_price}</td><td><input type="text" name="price" value="<jsp:getProperty property="price" name="bookinfo"/>"></td>
</tr>
<tr>
	<td>${book_publish}</td><td><input type="text" name="publish" value="<jsp:getProperty property="publish" name="bookinfo"/>"></td>
</tr>
<tr>
	<td>${book_published}</td><td><input type="text" name="published" value="<jsp:getProperty property="published" name="bookinfo"/>"></td>
</tr>
<tr>
	<td colspan="2"><input type="submit"></td>
</tr>
</table>
</form>
</div>
</html>
