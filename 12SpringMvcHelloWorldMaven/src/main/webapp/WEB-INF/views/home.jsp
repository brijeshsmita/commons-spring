<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	Hello world!  
</h1>

<P>  The time on the server is ${serverTime}. </P>

<form action="greet.html">  
	Name:<input type="text" name="username"/><br/> 
	<input type="submit" value="Say Hello"/>  
</form>  
</body>
</html>
