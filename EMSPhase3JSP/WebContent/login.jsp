<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">


<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login Page</title>
</head>
<body style="background-color: cyan;">
<h1 style="text-align:center;">Login Page</h1>
	<form name="LoginForm" method ="post" action="LoginServlet">
	<table>
		<tr>
			<td>Enter UserName:-</td><td><input type="text" name="username" size=17 required="required" ></td>
		</tr>
		<tr>
			<td>Enter Password:-</td><td><input type="password" name="password" size=17 required="required" ></td>
		</tr>
		<tr>
			<td><input type="submit" value="Login"></td>
		</tr>
	</table>
	</form>
	<br>
</body>
</html>