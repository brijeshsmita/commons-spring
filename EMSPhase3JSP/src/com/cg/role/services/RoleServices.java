package com.cg.role.services;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.sql.DataSource;

import com.cg.exception.EmsException;
import com.cg.role.dao.IRoleDao;
import com.cg.role.dao.RoleDao;
import com.cg.role.domain.Role;

public class RoleServices implements IRoleServices
{
	private static IRoleDao roleDao;
	static
	{
		roleDao = new RoleDao();
	}
	public static IRoleDao getRoleDao() {
		return roleDao;
	}

	public static void setRoleDao(IRoleDao roleDao) {
		RoleServices.roleDao = roleDao;
	}

	@Override
	public void addRole(Role r)
	{
		roleDao.addRole(r);
		
	}

	@Override
	public void removeRole(int roleId) 
	{
		roleDao.removeRole(roleId);
		
	}

	@Override
	public Role modifyRole(Role r) 
	{
		return roleDao.modifyRole(r);
	}

	@Override
	public Role searchRole(int roleId) 
	{
		return roleDao.searchRole(roleId);
	}

	@Override
	public ArrayList<Role> listAllRole() 
	{
		return roleDao.listAllRole();
	}

	@Override
	public void showAllRoleId() 
	{
		ArrayList<Role> roleList= new ArrayList<>();
		Role r = null;
		String sql="select roleId from role";
		Connection con=null;
		Statement stmt=null;
		ResultSet rs=null;
		try {
		//step 1 : get connection
			con=getDataSource().getConnection();
		//step 2: obtain statement obj
			stmt= con.createStatement();
		//step 3: execute sql
			rs=stmt.executeQuery(sql);		
		//step 4: traverse ResultSet
			
			while(rs.next())
			{
				r = new Role();
			
				r.setRoleId(rs.getInt(1));
				
				roleList.add(r);
			}//end of while		
		} catch (Exception e) {
			e.printStackTrace();
		}//end of try
		if(roleList!=null){
			System.out.println("=======Role Id======");
			
			for(Role r1 : roleList){
				System.out.println(r1.getRoleId());
			}//end of for
		}//end of if	
	}//end of showAllRoleId()
	
	@Override
	public DataSource getDataSource() throws EmsException {
		return roleDao.getDataSource();
	}
	@Override
	public void setDataSource(DataSource dataSource) throws EmsException {
		System.out.println("Project services setDataSource "+dataSource);
		roleDao.setDataSource(dataSource);
		
	}

	@Override
	public ArrayList<Integer> getAllRoleNumber() {
		// TODO Auto-generated method stub
		return roleDao.getAllRoleNumber();
	}
}//end of class
