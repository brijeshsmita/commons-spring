<%@page contentType="text/html" pageEncoding="UTF-8"
errorPage="departmenterrorpage.jsp"%>
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
         <th>Department Id</th>
        <th>Department Name</th>
        <th>Department Desc</th>
       
        <th colspan=2>Action</th>
    </tr>
</thead>
<tbody>
    <c:forEach items="${departments}" var="department">
			<tr>
				<td><c:out value="${department.deptId}" /></td>
				<td><c:out value="${department.deptName}" /></td>
				<td><c:out value="${department.deptDesc}" /></td>
				
					
				<td><a href="Department1Servlet?action=edit&deptId=<c:out 
				value="${department.deptId}"/>">Update</a></td>
				<td><a href="Department1Servlet?action=delete&deptId=<c:out 
				value="${department.deptId}"/>">Delete</a></td>
			</tr>
          </c:forEach>
      </tbody>
</table>
    <p><b><i><a href="Department1Servlet?action=insert">Add Department</a></i></b></p><br/>
    <p><b><i><a href="home.jsp">Back To Home Page</a></i></b></p>
</body>
</html>
