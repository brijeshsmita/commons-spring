
<%@page contentType="text/html" pageEncoding="UTF-8" errorPage="employeeErrorPage.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" 
prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" 
prefix="fmt"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Add New EMPLOYEE</title>
        <script src="js/jquery-2.1.1.js" type="text/javascript"></script>
       <script type="text/javascript">
			$(document).ready(function () {                          
			   /*  $('#deptId').click(function () {    */              
			        $.get('PopulateDeptId', function (responseJson)
			        	{    
			            var $select = $('#deptId');                           
			            $select.find('option').remove();                          
			            $.each(responseJson, function (key, value) {               
			                $('<option>').val(key).text(value).appendTo($select); 
			            });
			        });
			   /*  }); */
			        
			       /*  $('#projectId').click(function () {     */             
				        $.get('PopulateProjectId', function (responseJson)
				        	{    
				            var $select = $('#projectId');                           
				            $select.find('option').remove();                          
				            $.each(responseJson, function (key, value) {               
				                $('<option>').val(key).text(value).appendTo($select); 
				            });
				        });
			  /*   }); */
			        
			       /*  $('#roleId').click(function () {  */                
				        $.get('PopulateRoletId', function (responseJson)
				        	{    
				            var $select = $('#roleId');                           
				            $select.find('option').remove();                          
				            $.each(responseJson, function (key, value) {               
				                $('<option>').val(key).text(value).appendTo($select); 
				            });
				        });
				  /*   }); */
			});
		</script> 
       <script type="text/javascript" src="js/employee.js"></script> 
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

        <form method="POST" action='EmployeeServlet' 
        name="frmAddEmployee" onsubmit="return validateForm();">
        
        <table border="20" align="center" style="background-color: silver;">
            <% String action = request.getParameter("action");
                System.out.println(action);
            %>
            <tr>
            <% if (action.equalsIgnoreCase("edit")) {%>
            
           <td> Employee Id : </td>
           <td><input type="number" name="empId"
                          value="<c:out value="${employee.empId}" />"
                           readonly="readonly"/> </td>
             <td>              (You Can't Change this)</td> 
            
            <%}else {%>
            <td><input type="number" name="empId"
                          value="<c:out value="0" />"
                         readonly="readonly" style="visibility: hidden;"/><br /> 
            <%}%></td>
            </tr>
            
            <tr>
           <td> Employee Name : </td>
           <td><input type="text" name="empName"
                value="<c:out value="${employee.empName}" />" required="required"/> 
             </td>
              </tr>
              
              <tr>  
            <% if (action.equalsIgnoreCase("edit")) {%>
            <td>Employee KINId : </td>
            <td><input type="text" name="kinId"
                          value="<c:out value="${employee.kinId}" />"
                           readonly="readonly"/> 
              </td>
              <td>(You Can't Change this)</td> 
            <%}else {%>
           <td><input type="text" name="kinId"
                          value="<c:out value="0" />"
                         readonly="readonly" style="visibility: hidden;" /><br /> 
            <%}%></td>
            </tr>
            
            <tr>
            <td>Email : </td>
            <td><input
                type="text" name="emailId"
                value="<c:out value="${employee.emailId}" />" required="required"/>
            </td> 
             </tr>  
             
             <tr>
            <td>Phone No : </td>
            <td><input
                type="text" name="phoneNo"
                value="<c:out value="${employee.phoneNo}" />" required="required"/> <br /> 
             </td>
             </tr> 
             
             <tr> 
            <% if (action.equalsIgnoreCase("edit")) {%>
            <td>Date Of Birth: </td>
            <td><input
                type="text" name="dob"
                value="<fmt:formatDate pattern="yyyy/MM/dd" 
                value="${employee.dob}" />" 
                readonly="readonly"/></td>
                <td>(You Can't Change this) </td> 
               
            <%} else {%>
            <td>Date Of Birth :</td>
            <td> <input
                type="text" name="dob"
                value="<fmt:formatDate pattern="yyyy/MM/dd" 
                value="${employee.dob}" />" required="required"/>
              </td>
                <td>(yyyy/MM/dd)  </td>    
            <%}%>
            </tr>
            <tr>
            <% if (action.equalsIgnoreCase("edit")) {%>
            
            <td>Date Of Joining: </td>
            <td><input
                type="text" name="doj"
                value="<fmt:formatDate pattern="yyyy/MM/dd" 
                value="${employee.doj}" />" 
                readonly="readonly"/></td>
               <td>(You Can't Change this)  </td>
             
            <%} else {%>
           <td> Date Of Joining : </td>
           <td><input
                type="text" name="doj"
                value="<fmt:formatDate pattern="yyyy/MM/dd" 
                value="${employee.doj}" />" required="required"/>
               </td>
               <td> (yyyy/MM/dd)  </td>
              
            <%}%>
            </tr>
            
            <tr>
            <td> Address : </td>
            <td><input type="text" name="address"
                value="<c:out value="${employee.address}" />" /> 
			</td>
			</tr>
          
         <%--  <% if (action.equalsIgnoreCase("edit")) {%>
             department Id : <input
                type="number" name="deptId"
                value="<c:out value="${employee.deptId}" />" /> <br />
            <%} else {%>
            	<td> department Id :<select id="deptId" name="deptId">
                	<option>10</option>
        		</select></td>
            <%}%>   --%>
            
            <tr>
            <% if (action.equalsIgnoreCase("edit")) {%>
            
             <td>department Id :</td>
             <td> <input
                type="number" name="deptId"
                value="<c:out value="${employee.deptId}" />" /></td>
           
            <%} else {%>
            
            <td>department Id :</td>
            <td><select id="deptId" name="deptId">
                	<option value="0"<%-- "<c:out value="${employee.deptId}" --%> />">Id</option>
        		</select></td>
        		
        		<%}%>
                </tr>
             <%-- Project Id : <input
                type="number" name="projectId"
                value="<c:out value="${employee.projectId}" />" /> <br />
                 --%>
               <tr> 
                <% if (action.equalsIgnoreCase("edit")) {%>
             
             <td>Project Id : </td>
             <td><input
                type="number" name="projectId"
                value="<c:out value="${employee.projectId}" />" /></td>
            
            <%} else {%> 
            
              <td>Project Id : </td>
              <td><select id="projectId" name="projectId" >
                	<option value="0"<%-- "<c:out value="${employee.projectId}" />" --%>>Id</option>
        		</select>
        		</td>
        		
               <%}%>  
               </tr>
                <tr>
                <% if (action.equalsIgnoreCase("edit")) {%>
	            
	             <td>Role Id : </td>
	             <td><input
	                type="number" name="roleId"
	                value="<c:out value="${employee.roleId}" />" /></td>
            	
            <%} else {%> 
           
             <td> Role Id </td>
             <td><select id="roleId" name="roleId" >
                	<option value="0"<%-- "<c:out value="${employee.roleId}" />" --%>>Id</option>
        		</select></td>
        		
        		<%}%> 
        	</tr>
        		<tr>
            <td><input  type="submit" value="Submit" /></td>
            </tr>
            
            </table>
        </form>
        
    </body>
</html>
