package com.cg.project.servlet;
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

import com.cg.employee.services.EmployeeServices;
import com.cg.exception.EmsException;
import com.cg.project.domain.Project;
import com.cg.project.services.IProjectService;
import com.cg.project.services.ProjectService;


public class ProjectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	private IProjectService projectServices;
	private static String INSERT_OR_EDIT = "/project.jsp";
    private static String LIST_PROJECT = "/listProject.jsp";
    private DataSource dataSource;
  
    
    @Override
	public void init(ServletConfig config) throws ServletException {
    	// TODO Auto-generated method stub
		super.init(config);
		dataSource=(DataSource) config.getServletContext().getAttribute("appds");
		try {
			projectServices.setDataSource(dataSource);
		} catch (EmsException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public ProjectServlet() {
        super();
        projectServices=new ProjectService();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String forward="";
        String action = request.getParameter("action");
        try
        {
	        if (action.equalsIgnoreCase("delete")){
	            int projectId =Integer.parseInt(request.getParameter("projectId"));
	            projectServices.removeProject(projectId);
	            forward = LIST_PROJECT;
	            request.setAttribute("projects", projectServices.listAllProject());    
	        } else if (action.equalsIgnoreCase("edit")){
	            forward = INSERT_OR_EDIT;
	            int projectId = Integer.parseInt(request.getParameter("projectId"));
	            Project project = projectServices.searchProject(projectId);
	            request.setAttribute("project", project);
	        } else if (action.equalsIgnoreCase("listProject")){
	            forward = LIST_PROJECT;
	        request.setAttribute("projects", projectServices.listAllProject());
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
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Project project = new Project();
		project.setProjectId(Integer.parseInt(request.getParameter("projectId")));
		project.setProjectName(request.getParameter("projectName"));
		project.setProjectDescription(request.getParameter("projectDescription"));
		project.setDeptId(Integer.parseInt(request.getParameter("deptId")));

        int projectId = Integer.parseInt(request.getParameter("projectId"));
//         user.setUname(userid);
        projectServices.checkProject(project);//       
        RequestDispatcher view = 
        		request.getRequestDispatcher(LIST_PROJECT);
        try {
			request.setAttribute("projects", projectServices.listAllProject());
		} catch (EmsException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        view.forward(request, response);
		//doGet(request, response);
	}


}
