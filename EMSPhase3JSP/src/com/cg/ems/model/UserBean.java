package com.cg.ems.model;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
public class UserBean
{
	private String name,username,password;

	private Connection conn;
	public UserBean() {
		
	}
	public UserBean(String username, String password)
	{
		super();
		this.username = username;
		this.password = password;
	}

	public UserBean(String name, String address, String phone, String username,
			String password) {
		super();
		this.name = name;
		
		this.username = username;
		this.password = password;
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Connection getConn() {
		return conn;
	}

	public  void setConn(Connection conn) {
		this.conn = conn;
	}

	public String registerUser()
	{
		String status="";
		return status;
	}
	
	public String  getLoginStatus() throws SQLException 
	{
		String status="";
		System.out.println("Connection in doget()->"+conn);
		PreparedStatement pstmt = conn.prepareStatement
				("select password from customerPizza where username=?");
		
		pstmt.setString(1, username);
		ResultSet rs = pstmt.executeQuery();
		if(rs.next())
    	{
			if(rs.getString(1).equals(password))
    		{
				status="found";
    		}
			else
			{
				status="wrong";
			}
    		
    	}
		else
		{
			status="notfound";
		}
		return status;
	}
}
