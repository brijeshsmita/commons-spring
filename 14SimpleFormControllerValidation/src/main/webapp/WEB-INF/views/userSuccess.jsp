<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Success Page</title>
</head>
<body>
User Details
<hr>
User Name   : ${user.name} <br/>
Email       : ${user.email} <br/>
Profession  : ${user.profession} <br/>
Country     : ${user.country} <br/>
Feedback    : ${user.feedback} <br/>
Frameworks  : ${user.frameworks[0]} 
	, ${user.frameworks[1]}, ${user.frameworks[2]}
	, ${user.frameworks[3]}<br/>
Mailing List: ${user.mailingList} 
</body>
</html>