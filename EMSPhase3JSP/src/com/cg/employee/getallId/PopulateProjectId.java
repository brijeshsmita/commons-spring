package com.cg.employee.getallId;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import com.cg.department.services.DepartmentServices;
import com.cg.department.services.IDepartmentServices;
import com.cg.exception.EmsException;
import com.cg.project.services.IProjectService;
import com.cg.project.services.ProjectService;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.reflect.TypeToken;

public class PopulateProjectId extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final IProjectService projectService;
	static{
		projectService= new ProjectService();
    }
	
	 private DataSource dataSource;
	    @Override
		public void init(ServletConfig config) throws ServletException {
	    	// TODO Auto-generated method stub
	    			super.init(config);
	    			dataSource=(DataSource) config.getServletContext().getAttribute("appds");
	    			try {
	    				projectService.setDataSource(dataSource);
	    			} catch (EmsException e) {
	    				// TODO Auto-generated catch block
	    				e.printStackTrace();
	    			}
		}

    public PopulateProjectId() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<Integer> projectIdList=new ArrayList<Integer>();
		projectIdList=projectService.getAllProjectNumber();
		System.out.println("doPost.... "+projectIdList);
//deptIdList.add(10);deptIdList.add(20);deptIdList.add(30);
  Gson gson = new Gson();
  JsonElement element = gson.toJsonTree(projectIdList,
		  new TypeToken<List<Integer>>() {}.getType());
 
  JsonArray jsonArray = element.getAsJsonArray();
  response.setContentType("application/json");
  response.getWriter().print(jsonArray);
  System.out.println("In ajax deptId");
  System.out.println(jsonArray);
	}

}
