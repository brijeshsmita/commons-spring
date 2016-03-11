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
<a href="${pageContext.request.contextPath}/welcome.htm">Welcome</a>
|<a href="${pageContext.request.contextPath}/processWelcome.htm">processWelcome</a>
|<a href="${pageContext.request.contextPath}/processHome.htm">Home</a>
|<a href="${pageContext.request.contextPath}/processMvc.htm">Mvc</a>
</body>
</html>
