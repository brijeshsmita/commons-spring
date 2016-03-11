
package com.cg.department.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import com.cg.department.domain.Department;
import com.cg.department.services.DepartmentServices;
import com.cg.department.services.IDepartmentServices;
import com.cg.exception.EmsException;

public class Department1Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private IDepartmentServices departmentServices;
	private static String INSERT_OR_EDIT = "/department.jsp";
    private static String LIST_Department = "/listDepartment.jsp";
    private DataSource dataSource;
    @Override
	public void init(ServletConfig config) throws ServletException {
    	// TODO Auto-generated method stub
    			super.init(config);
    			dataSource=(DataSource) config.getServletContext().getAttribute("appds");
    			try {
    				departmentServices.setDataSource(dataSource);
    			} catch (EmsException e) {
    				// TODO Auto-generated catch block
    				e.printStackTrace();
    			}
	}

	public Department1Servlet() {
        super();
        departmentServices=new DepartmentServices();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		String forward="";
        String action = request.getParameter("action");
        try
        {
        if (action.equalsIgnoreCase("delete")){
            int deptId =Integer.parseInt(request.getParameter("deptId"));
            departmentServices.removeDepartment(deptId);
            forward = LIST_Department;
            request.setAttribute("departments", departmentServices.listAllDepartment());    
        } else if (action.equalsIgnoreCase("edit")){
            forward = INSERT_OR_EDIT;
            int deptId = Integer.parseInt(request.getParameter("deptId"));
            Department department = departmentServices.searchDepartment(deptId);
            request.setAttribute("department", department);
        } else if (action.equalsIgnoreCase("listDepartment")){
            forward = LIST_Department;
        request.setAttribute("departments", departmentServices.listAllDepartment());
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
		Department department = new Department();
		department.setDeptId(Integer.parseInt(request.getParameter("deptId")));
		department.setDeptName(request.getParameter("deptName"));
		department.setDeptDesc(request.getParameter("deptDesc"));
		

        int empId = Integer.parseInt(request.getParameter("deptId"));
//         user.setUname(userid);
        departmentServices.checkDepartment(department);//       
        RequestDispatcher view = 
        		request.getRequestDispatcher(LIST_Department);
        try {
			request.setAttribute("departments", departmentServices.listAllDepartment());
		} catch (EmsException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        view.forward(request, response);
		//doGet(request, response);
	}

}
