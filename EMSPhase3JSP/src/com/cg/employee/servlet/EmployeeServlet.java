package com.cg.employee.servlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import com.cg.employee.domain.Employee;
import com.cg.employee.services.EmployeeServices;
import com.cg.employee.services.IEmployeeServices;
import com.cg.exception.EmsException;




public class EmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private IEmployeeServices employeeServices;
	private static String INSERT_OR_EDIT = "/employee.jsp";
    private static String LIST_EMPLOYEE = "/listEmployee.jsp";
    private DataSource dataSource;
    @Override
	public void init(ServletConfig config) throws ServletException {
    	// TODO Auto-generated method stub
    			super.init(config);
    			dataSource=(DataSource) config.getServletContext().getAttribute("appds");
    			try {
    				employeeServices.setDataSource(dataSource);
    			} catch (EmsException e) {
    				// TODO Auto-generated catch block
    				e.printStackTrace();
    			}
	}

	public EmployeeServlet() {
        super();
        employeeServices=new EmployeeServices();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		String forward="";
        String action = request.getParameter("action");
        try
        {
        if (action.equalsIgnoreCase("delete")){
            int empId =Integer.parseInt(request.getParameter("empId"));
            employeeServices.removeEmployee(empId);
            forward = LIST_EMPLOYEE;
            request.setAttribute("employees", employeeServices.listAllEmployee());    
        } else if (action.equalsIgnoreCase("edit")){
            forward = INSERT_OR_EDIT;
            int empId = Integer.parseInt(request.getParameter("empId"));
            Employee employee = employeeServices.searchEmployee(empId);
            request.setAttribute("employee", employee);
        } else if (action.equalsIgnoreCase("listEmployee")){
            forward = LIST_EMPLOYEE;
        request.setAttribute("employees", employeeServices.listAllEmployee());
        } else {
            forward = INSERT_OR_EDIT;
        } 
        }
        catch(EmsException e)
        {
        	e.printStackTrace();
        }
        RequestDispatcher view = 
        		request.getRequestDispatcher(forward);
        view.forward(request, response);
	}//end of doget

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Employee employee = new Employee();
		employee.setEmpId(Integer.parseInt(request.getParameter("empId")));
		employee.setEmpName(request.getParameter("empName"));
		employee.setKinId(request.getParameter("kinId"));
		employee.setEmailId(request.getParameter("emailId"));
		employee.setPhoneNo(request.getParameter("phoneNo"));

        try {
            Date dob = new SimpleDateFormat("yyyy/MM/dd")
            	.parse(request.getParameter("dob"));
            System.out.println("dob "+ dob);
            employee.setDob(dob);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        try {
            Date doj = new SimpleDateFormat("yyyy/MM/dd")
            	.parse(request.getParameter("doj"));
            System.out.println("doj "+ doj);
            employee.setDoj(doj);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        employee.setAddress(request.getParameter("address"));
		employee.setDeptId(Integer.parseInt(request.getParameter("deptId")));
		employee.setProjectId(Integer.parseInt(request.getParameter("projectId")));
		employee.setRoleId(Integer.parseInt(request.getParameter("roleId")));
		System.out.println("deptid="+request.getParameter("deptId"));
		System.out.println("projectId="+request.getParameter("projectId"));
		System.out.println("roleId="+request.getParameter("roleId"));


        int empId = Integer.parseInt(request.getParameter("empId"));
//         user.setUname(userid);
        employeeServices.checkUser(employee);//       
        RequestDispatcher view = 
        		request.getRequestDispatcher(LIST_EMPLOYEE);
        try {
			request.setAttribute("employees", employeeServices.listAllEmployee());
		} catch (EmsException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        view.forward(request, response);
		//doGet(request, response);
	}


}
