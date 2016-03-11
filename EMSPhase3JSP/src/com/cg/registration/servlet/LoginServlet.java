package com.cg.registration.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

import com.cg.ems.model.UserBean;


public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Connection conn=null;
	private DataSource ds=null;
	
	@Override
	public void init() throws ServletException {
		ServletContext context = getServletContext();
		ds=(DataSource)context.getAttribute("appds");
		try {
			conn=ds.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
    public LoginServlet() {
        super();
        
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
    		throws ServletException, IOException {
    	// TODO Auto-generated method stub
    	doPost(req, resp);
    }
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try 
    	{
    		HttpSession session=request.getSession();
    		String username = request.getParameter("username");
    		String password = request.getParameter("password");
    		
    		PreparedStatement ps = conn.prepareStatement("select * from EMS where username=? and password=?");
    		session.setAttribute("username", username);
    		session.setAttribute("password", password);
    		ps.setString(1, username);
			ps.setString(2, password);
    		UserBean user = new UserBean();
    		ResultSet rs=ps.executeQuery();
    	
    		user.setConn(conn);
    		
        	PrintWriter out = response.getWriter();
  
        	RequestDispatcher dispatcher;
        	boolean status;
        	status=rs.next();
        	
        	if(status==true)
        	{
        		request.setAttribute("user", user);
        		out.print(status);
    			dispatcher = request.getRequestDispatcher("/home.jsp");
    			dispatcher.forward(request, response);
        	}
        	
        	else if(status==false)
        	{
        		request.setAttribute("error", "User is Not registred ");
    			 request.getRequestDispatcher("error.jsp").include(request, response);
    			//dispatcher;
        	}
        	
		}
		
    	catch (Exception e) 
    	{
    		e.printStackTrace();
		}
    }


	    }

