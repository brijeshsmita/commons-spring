<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title> WELCOME </title>
<link rel="stylesheet" href="css/jquery-ui.css">
<link rel="stylesheet" href="css/style.css">
<script src="js/jquery-1.11.1.js"></script>
<script src="js/jquery-ui.js"></script>

<script>
$(function() {
  $( "#tabs" ).tabs();
});
</script>

</head>
<body bgcolor="cyan">
<center>
<h3>EMS</h3>
<div id="tabs">
<ul>

<!-- <li><a href="blank" >Home</a></li> -->
<li><a href="EmployeeServlet?action=listEmployee" >Employee</a></li>
<li><a href="Department1Servlet?action=listDepartment">Department</a></li>
<li><a href="ProjectServlet?action=listProject" >Project</a></li>
<li><a href="role.jsp">role</a></li>

</ul>

</div>

	

</center>

</body>
</html>