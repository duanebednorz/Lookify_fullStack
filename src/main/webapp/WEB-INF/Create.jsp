<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Lookify Create</title>
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
		<a href ="/dashboard">Dashboard</a>
		<hr>
		<div class="row">
			<div class="col-sm-4">
				<form:form action="/song/create" method="post" modelAttribute="aSong">
					<div class="form-group">
						<label>Song Name:</label>
						<form:input path="title" class="form-control" />
						<form:errors path="title" class="text-danger" />
					</div>
					<div class="form-group">
						<label>Song Artist:</label>
						<form:input path="artist" class="form-control" />
						<form:errors path="artist" class="text-danger" />
					</div>
					<div class="form-group">
						<label>Song Rating:</label>
						<form:input type="number" path="rating" class="form-control" />
						<form:errors path="rating" class="text-danger" />
					</div>
					<input type="submit" value="Add Song" class="btn btn-primary" />
				</form:form>
			</div>
		</div>
	</div>
</body>
</html>