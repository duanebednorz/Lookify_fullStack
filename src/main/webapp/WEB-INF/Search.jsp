<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Lookify</title>
<link rel="stylesheet"
	href="/webjars/bootstrap/4.5.0/css/bootstrap.min.css" />
<script src="/webjars/jquery/3.5.1/jquery.min.js"></script>
<script src="/webjars/bootstrap/4.5.0/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="container">
		<div class="jumbotron">
			<h1>Welcome to Lookify!</h1>
		</div>
		<a href="/dashboard">Dashboard</a> 
		<hr>
		 <p>${artist}</p>
		<hr>
		<div class="col-sm-8">
			<table class="table table-striped">
				<tr class="bg-dark text-light">
					<th>Title</th>
					<th>Rating</th>
					<th>Action</th>
				</tr>
				<c:forEach items="${songs}" var="song">
					<tr>
						<td><a href="/song/${song.id}/view">${song.title}</a></td>
						<td>${song.rating}</td>
						<td><a href="/song/${song.id }/delete">Delete</a></td>
					</tr>
				</c:forEach>
			</table>
			<hr>
			<a href="/song/${song.id }/delete">Delete</a>
		</div>
	</div>
</html>