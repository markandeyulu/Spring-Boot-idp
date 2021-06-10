<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="../webjars/bootstrap/3.3.6/css/bootstrap.min.css" rel="stylesheet">
	
<title>Welcome...!</title>
</head>
<body>
	<div class="container">
	<h4>Welcome ${name} ...!</h4>

	<!-- <h5>Your todo's are:</h5> -->
	
	<table class="table table-stripped">
		<caption>Your todo's are:</caption>
		<thead>
			<tr>
				<th>#</th>
				<th>Name</th>
				<th>Description</th>
				<th>Target Date</th>
				<th>Is it Completed</th>
				<th>Update</th>
				<th>Delete</th>
			</tr>
		</thead>
			<c:forEach items="${todoList}" var="todo">
				<tr>
					<td>${todo.id}</td>
					<td>${todo.user}</td>
					<td>${todo.desc}</td>
					<td>${todo.targetDate}</td>
					<td>${todo.done}</td>
					<td><a type="button" class="btn btn-success" href="/todo/update?id=${todo.id}">Update</a></td>
					<td><a type="button" class="btn btn-warning" href="/todo/delete?id=${todo.id}">Delete</a></td>
				</tr>
			</c:forEach>
		<tbody>
		
		</tbody>
	</table>
	
	<a href="/todo/add">Add ToDo</a>
	
	
	<script src="../webjars/jquery/1.9.1/jquery.min.js"></script>
	<script src="../webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>
</div>
</body>
</html>