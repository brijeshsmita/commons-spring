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
import com.cg.employee.services.IEmployeeServices;
import com.cg.exception.EmsException;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.reflect.TypeToken;

public class PopulateDeptId extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final IDepartmentServices departmentService;
	static{
    	departmentService= new DepartmentServices();
    }
	 private DataSource dataSource;
	    @Override
		public void init(ServletConfig config) throws ServletException {
	    	// TODO Auto-generated method stub
	    			super.init(config);
	    			dataSource=(DataSource) config.getServletContext().getAttribute("appds");
	    			try {
	    				departmentService.setDataSource(dataSource);
	    			} catch (EmsException e) {
	    				// TODO Auto-generated catch block
	    				e.printStackTrace();
	    			}
		}
    public PopulateDeptId() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<Integer> deptIdList=new ArrayList<Integer>();
		deptIdList=departmentService.getAllDeptNumber();
		System.out.println("doPost.... "+deptIdList);
//deptIdList.add(10);deptIdList.add(20);deptIdList.add(30);
  Gson gson = new Gson();
  JsonElement element = gson.toJsonTree(deptIdList,
		  new TypeToken<List<Integer>>() {}.getType());
 
  JsonArray jsonArray = element.getAsJsonArray();
  response.setContentType("application/json");
  response.getWriter().print(jsonArray);
  System.out.println("In ajax deptId");
  System.out.println(jsonArray);
	}

}
