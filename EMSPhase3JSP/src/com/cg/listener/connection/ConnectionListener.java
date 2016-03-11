package com.cg.listener.connection;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.sql.DataSource;

public class ConnectionListener implements ServletContextListener {

	private DataSource ds;
    public ConnectionListener() {
        // TODO Auto-generated constructor stub
    }

    public void contextDestroyed(ServletContextEvent arg0)  { 
         // TODO Auto-generated method stub
    }

    public void contextInitialized(ServletContextEvent event)  { 
    	Context initContext=null;
        try
        {
     	   //java jndi context
     	  initContext=new InitialContext();
     	  Context evnContext=(Context)initContext.lookup("java:comp/env");
     	  //datasource jndi context
     	  ds=(DataSource)evnContext.lookup("jdbc/empds");
     	  if(ds!=null)
     	  {
     		  System.out.println("DataSource obtained......"+ds);
     		  //making the datasource available at application level
     		  event.getServletContext().setAttribute("appds", ds);
     	  }
     	  else
     	  {
     		  System.out.println("Datasource NOT obtained......");
     	  }
     	   
        }catch(NamingException e)
        {
     	   e.printStackTrace();
     	   
        }
    }
	
}
