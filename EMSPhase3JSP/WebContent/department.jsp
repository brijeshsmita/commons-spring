<%@page contentType="text/html" pageEncoding="UTF-8"
errorPage="departmenterrorpage.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" 
prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" 
prefix="fmt"%>
<!DOCTYPE html>
<html> 
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add new Department</title>
        <script type="text/javascript"  src="js/department.js"></script>
    </head>
    <body style="background-color: cyan;">
        <form method="POST" action='Department1Servlet' 
        name="frmAddDepartment" onsubmit="return validateForm();" >
        <table border="20" align="center" style="background-color: silver;">
            <% String action = request.getParameter("action");
                System.out.println(action);
            %>
            <tr>
            <% if (action.equalsIgnoreCase("edit")) {%>
            <td>Department Id :</td>
            <td> <input type="number" name="deptId"
                          value="<c:out value="${department.deptId}" />"
                           readonly="readonly" /> </td>
             <td>(You Can't Change this)</td>
            <%}else {%>
            <td><input type="number" name="deptId"
                          value="<c:out value="0" />"
                         readonly="readonly" style="visibility: hidden;"/><br /> 
            </td>
            <%}%>
            </tr>
            <tr>
            <td>Department Name : </td>
            <td><input type="text" name="deptName" 
                value="<c:out value="${department.deptName}" />" /> 
            </td>
            </tr>
              
           <tr>
           <td> Department Desc : </td>
           <td><input type="text" name="deptDesc"
                          value="<c:out value="${department.deptDesc}" />"
                           /> </td>
          </tr>
           
           <tr>
            <td><input  type="submit" value="Submit" /></td>
            </tr>
      
            </table>
            <p><b><i><button value="Logout" action="logout">Logout</button></i></b></p>
        </form>
    </body>
</html>
