package com.cg.registration.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

/**
 * Servlet implementation class Registration
 */
public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Connection conn=null;
    private DataSource ds=null;
	
	public void init() throws ServletException {
		ServletContext context = getServletContext();
		ds=(DataSource)context.getAttribute("appds");
		try {
			conn=ds.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try{
			
		String name=request.getParameter("name");
		//String address=request.getParameter("address");
		//String phone=request.getParameter("phone");
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		//System.out.println(name+address+phone+username+password);
		
		
		PrintWriter out = response.getWriter();
		
		PreparedStatement ps = conn.prepareStatement("insert into EMS values(?,?,?)");
		ps.setString(1, name);
		ps.setString(2, username);
		ps.setString(3, password);
		
		if(ps.executeUpdate()==1){
		
			response.sendRedirect("login.jsp");
		}else{
			out.println("User Not registered");
			request.getRequestDispatcher("/index2.jsp")
			.include(request, response);
		}
		ps.close();		
		} catch(Exception e) {
		e.printStackTrace();
		}		
	}

}
