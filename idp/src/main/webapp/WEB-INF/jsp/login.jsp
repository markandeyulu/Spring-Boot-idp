<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Login</title>
	</head>
	<body>
	<h4>${message}</h4>
		<form method="post">
			User Name : <input type="text" name="name"/> <br/><br/>
			Password : <input type="password" name="password"/>
			<input type="submit"/>
		</form>
	</body>
</html>