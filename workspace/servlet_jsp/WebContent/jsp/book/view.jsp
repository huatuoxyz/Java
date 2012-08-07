<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>

<html>
<head>
<link type="text/css" rel="stylesheet" media="screen" href="stylesheets/style.css"/>
</head>
<body>
<div id="container">

<div id="title"><a href="BookList">List</a></div>

<jsp:useBean id="bookinfo" class="book.BookInfo" scope="request" />
<table>
<tr>
	<td>${book_isbn}</td><td><jsp:getProperty property="isbn" name="bookinfo"/></td>
</tr>
<tr>
	<td>${book_title}</td><td><jsp:getProperty property="title" name="bookinfo"/></td>
</tr>
<tr>
	<td>${book_author}</td><td><jsp:getProperty property="author" name="bookinfo"/></td>
</tr>
<tr>
	<td>${book_price}</td><td><jsp:getProperty property="price" name="bookinfo"/></td>
</tr>
<tr>
	<td>${book_publish}</td><td><jsp:getProperty property="publish" name="bookinfo"/></td>
</tr>
<tr>
	<td>${book_published}</td><td><jsp:getProperty property="published" name="bookinfo"/></td>
</tr>
</table>
</div>
</html>
