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

import com.cg.exception.EmsException;
import com.cg.role.services.IRoleServices;
import com.cg.role.services.RoleServices;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.reflect.TypeToken;


public class PopulateRoletId extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final IRoleServices roleService;
	static{
		roleService= new RoleServices();
    }
	 private DataSource dataSource;
	    @Override
		public void init(ServletConfig config) throws ServletException {
	    	// TODO Auto-generated method stub
	    			super.init(config);
	    			dataSource=(DataSource) config.getServletContext().getAttribute("appds");
	    			try {
	    				roleService.setDataSource(dataSource);
	    			} catch (EmsException e) {
	    				// TODO Auto-generated catch block
	    				e.printStackTrace();
	    			}
		}
   
    public PopulateRoletId() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<Integer> roleIdList=new ArrayList<Integer>();
		roleIdList=roleService.getAllRoleNumber();
		System.out.println("doPost.... "+roleIdList);
//deptIdList.add(10);deptIdList.add(20);deptIdList.add(30);
  Gson gson = new Gson();
  JsonElement element = gson.toJsonTree(roleIdList,
		  new TypeToken<List<Integer>>() {}.getType());
 
  JsonArray jsonArray = element.getAsJsonArray();
  response.setContentType("application/json");
  response.getWriter().print(jsonArray);
  System.out.println("In ajax roleId");
  System.out.println(jsonArray);
	}

}
