<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<link type="text/css" rel="stylesheet" media="screen" href="stylesheets/style.css"/>
</head>
<body>
<div id="container">

<div id="title"><a href="BookList">List</a></div>
<ul>
<c:forEach var="bean" items="${messages}">
	<li class="error"><c:out value="${bean}"/></li>
</c:forEach>
</ul>

<form action="BookCreate" method="post">
<table>
<tr>
	<td>${book_isbn}</td><td><input type="text" name="isbn" value="${isbn}" /></td>
</tr>
<tr>
	<td>${book_title}</td><td><input type="text" name="title" value="${title}" /></td>
</tr>
<tr>
	<td>${book_author}</td><td><input type="text" name="author" value="${author}" /></td>
</tr>
<tr>
	<td>${book_price}</td><td><input type="text" name="price" value="${price}" /></td>
</tr>
<tr>
	<td>${book_publish}</td><td><input type="text" name="publish" value="${publish}" /></td>
</tr>
<tr>
	<td>${book_published}</td><td><input type="text" name="published" value="${published}" /></td>
</tr>
<tr>
	<td colspan="2"><input type="submit"></td>
</tr>
</table>
</form>
</div>
</html>
