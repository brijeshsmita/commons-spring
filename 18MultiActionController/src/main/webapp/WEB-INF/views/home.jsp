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
<hr>
<a href="${pageContext.request.contextPath}/user/add.htm" >Add</a>
|<a href="${pageContext.request.contextPath}/user/remove.htm" >Remove</a>
|<a href="${pageContext.request.contextPath}/user/update.htm" >Update</a>
|<a href="${pageContext.request.contextPath}/user/list.htm" >List</a>
<hr>
</body>
</html>
