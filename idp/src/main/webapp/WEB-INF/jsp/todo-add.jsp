<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Welcome...!</title>
<link href="../webjars/bootstrap/3.3.6/css/bootstrap.min.css"
	rel="stylesheet">

</head>
<body>
	<div class="container">

		<h4>Welcome ${name} ...!</h4>

		<h5>Your todo to be added:</h5>

		<form:form action="/todo/add" method="post" modelAttribute="todo">
			<fieldset class="form-group">
				<form:label path="user"> Name : </form:label>
				<form:input path="user" class="form-control" type="text" name="name" /> 
				<form:label path="desc"> Desc : </form:label>
				<form:input path="desc" type="text" name="desc"	/>
				<button class="btn btn-success" type="submit">Submit</button>

			</fieldset>

		</form:form>
	</div>
	<script src="../webjars/jquery/1.9.1/jquery.min.js"></script>
	<script src="../webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>

</body>
</html>
