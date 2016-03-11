<%@page contentType="text/html" pageEncoding="UTF-8" errorPage="employeeErrorPage.jsp"%>
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
         <th>Employee Id</th>
        <th>Employee Name</th>
        <th>Employee KIN Id</th>
        <th>Email ID</th>
        <th>Phone no</th>
        <th>Date Of Birth</th>
        <th>Date Of Joing</th>
        <th>Address</th>
        <th>Dept Id</th>
        <th>Project Id</th>
        <th>Role Id</th>
        <th colspan=2>Action</th>
    </tr>
</thead>
<tbody>
    <c:forEach items="${employees}" var="employee">
			<tr>
				<td><c:out value="${employee.empId}" /></td>
				<td><c:out value="${employee.empName}" /></td>
				<td><c:out value="${employee.kinId}" /></td>
				<td><c:out value="${employee.emailId}" /></td>
				<td><c:out value="${employee.phoneNo}" /></td>
				<td><fmt:formatDate pattern="dd MMM,yyyy" 
					value="${employee.dob}" /></td>
				<td><fmt:formatDate pattern="dd MMM,yyyy" 
					value="${employee.doj}" /></td>
				<td><c:out value="${employee.address}" /></td>
					
				<td><c:out value="${employee.deptId}" /></td>
				<td><c:out value="${employee.projectId}" /></td>
				<td><c:out value="${employee.roleId}" /></td>
					
				<td><a href="EmployeeServlet?action=edit&empId=<c:out 
				value="${employee.empId}"/>">Update</a></td>
				<td><a href="EmployeeServlet?action=delete&empId=<c:out 
				value="${employee.empId}"/>">Delete</a></td>
			</tr>
          </c:forEach>
      </tbody>
</table>
    <p><b><i><a href="EmployeeServlet?action=insert">Add User</a></i></b></p>
	<p><b><i><a href="home.jsp">Back To Home Page</a></i></b></p>
</body>
</html>
