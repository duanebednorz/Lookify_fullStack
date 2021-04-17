<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Lookify Edit</title>
<link rel="stylesheet"
	href="/webjars/bootstrap/4.5.0/css/bootstrap.min.css" />
<script src="/webjars/jquery/3.5.1/jquery.min.js"></script>
<script src="/webjars/bootstrap/4.5.0/js/bootstrap.min.js"></script>
</head>
<body>
<div class = "container">
<div class="jumbotron">
			<h1>Welcome to Lookify!</h1>
		</div>
<div class="col-sm-8">
				<table class="table table-striped">
					<tr class="bg-dark text-light">
						<th>Title</th>
						<th>Artist</th>
						<th>Rating</th>
					</tr>
					<c:forEach items="${allSongs}" var="song">
						<tr>
							<td>${song.title}</td>
							<td>${song.artist}</td>
							<td>${song.rating}</td>
						</tr>
					</c:forEach>
				</table>
			</div>
</div>

</body>
</html>