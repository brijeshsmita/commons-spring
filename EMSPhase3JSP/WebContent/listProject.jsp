<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Show All Users</title>
</head>
<body style="background-color: cyan;">
    <table border=20 align="center" style="background-color: silver;">
<thead>
    <tr>
         <th>Project Id</th>
        <th>Project Name</th>
        <th>Project Description</th>
        <th>Dept Id</th>
        
        <th colspan=2>Action</th>
    </tr>
</thead>
<tbody>
    <c:forEach items="${projects}" var="project">
			<tr>
				<td><c:out value="${project.projectId}" /></td>
				<td><c:out value="${project.projectName}" /></td>
				<td><c:out value="${project.projectDescription}" /></td>
				<td><c:out value="${project.deptId}" /></td>
				
				<td><a href="ProjectServlet?action=edit&projectId=<c:out 
				value="${project.projectId}"/>">Update</a></td>
				<td><a href="ProjectServlet?action=delete&projectId=<c:out 
				value="${project.projectId}"/>">Delete</a></td>
			</tr>
          </c:forEach>
         
      </tbody>
</table>
    <p><b><i><a href="ProjectServlet?action=insert">Add Project</a></i></b></p>
	<b><i><a href="home.jsp">Back To Home Page</a></i></b>
</body>
</html>
