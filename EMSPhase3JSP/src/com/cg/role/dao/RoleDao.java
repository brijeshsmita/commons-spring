package com.cg.role.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.sql.DataSource;

import com.cg.project.dao.ProjectDao;
import com.cg.project.domain.Project;
import com.cg.role.domain.Role;

public class RoleDao implements IRoleDao
{
	private DataSource dataSource=null;
	private Connection con=null;
	
	@Override
	public DataSource getDataSource() {
		return dataSource;
	}

	@Override
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		
	}
	@Override
	public void addRole(Role r) 
	{
	
		Statement stmt=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		String sql="insert into role values(?,?,?)";
		int pno = 0;
		try {
		//step 1: obtain connection
			con=getDataSource().getConnection();
			//System.out.println("Connection Obtained"+con);
		//step 2: obatin stmt
			stmt= con.createStatement();
			rs = stmt.executeQuery("SELECT SQ_PROJECT.NEXTVAL FROM dual");

			if ( rs!=null && rs.next() ) {
			 pno = rs.getInt(1);
			System.out.println(pno);
			rs.close();
			}
		//step 2: obatin ps
			ps= con.prepareStatement(sql);
		//step 3: set the value to ps
			ps.setInt(1, pno);
			ps.setString(2, r.getRoleName());//roleName
			ps.setString(3, r.getRoleDesc());//roleDesc
			
			//step 4: now executing the ps
			int noOfRecords=ps.executeUpdate();
			//getting the data from the rs
			if(noOfRecords==1){
				System.out.println("Role Inserted successfully--->");					
			}else{
				System.out.println("Sorry Boss! Role record"
						+ " not inserted");
			}
		} catch (Exception e2) {
			e2.printStackTrace();
		}
	}//end of addRole()

	@Override
	public void removeRole(int roleId) {
		
		PreparedStatement ps=null;
		String sql="delete from role where roleId=?";
		try {
			//obtain connection
			con=getDataSource().getConnection();
			//obtain PreparedStatement obj
			ps=con.prepareStatement(sql);
			//set the dynamic values of PS
			ps.setInt(1, roleId);
			//executeUpdate the ps
			int noOfRecords=ps.executeUpdate();
			//check weather record deleted or not
			if(noOfRecords==1){
				System.out.println("*****Role Deleted successfully--->");
				
			}else{
				System.out.println("Sorry Boss! Role record"
						+ " not deleted");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}//end of removeRole()

	@Override
	public Role modifyRole(Role r) {
		
		Statement stmt=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		String sql="update role set roleName=?,roleDesc=? where roleId=?";
		try {
			//obtain connection
			con=getDataSource().getConnection();
			//obtain PreparedStatement obj
				ps=con.prepareStatement(sql);
			//set the dynamic values of PS place holserd
				ps.setString(1, r.getRoleName());//roleName
				ps.setString(2, r.getRoleDesc());//roleDesc
				ps.setInt(3, r.getRoleId());//empId
		
				int noOfRecords=ps.executeUpdate();
				//check weather record deleted or not
				if(noOfRecords==1){
					System.out.println("Role Updated successfully--->");
					
				}else{
					System.out.println("Sorry Boss! Role record"
							+ " not Updated");
				}
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		return r;
	}//end of modifyRole()

	@Override
	public Role searchRole(int roleId) {
		
		PreparedStatement ps=null;
		ResultSet rs=null;
		Role e1= null;
		try {
			String sql="select * from role where roleId=?";
			con=getDataSource().getConnection();
			ps=con.prepareStatement(sql);//pre-compiled sql
			ps.setInt(1, roleId);//setting the value at runtime
			//now executing the ps
			rs=ps.executeQuery();
			//getting the data from the rs
			if(rs.next()){
				e1=new Role();
				System.out.println("Role Found--->");
				
				e1.setRoleId(rs.getInt(1));
				e1.setRoleName(rs.getString(2));
				e1.setRoleDesc(rs.getString(3));
			}else{
				System.out.println("Sorry Boss! Role record for "
						+roleId+ " does not Exists");
			}//end of if
		} catch (Exception e) {
			e.printStackTrace();
		}
		return e1;
	}//end of searchRole()

	@Override
	public ArrayList<Role> listAllRole() {
		ArrayList<Role> roleList= new ArrayList<Role>();
		Role p = null;
		String sql="select * from role";
		
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
			while(rs.next()){
				p = new Role();
				p.setRoleId(rs.getInt(1));
				p.setRoleName(rs.getString(2));
				p.setRoleDesc(rs.getString(3));
				roleList.add(p);
			}//end of while		
		} catch (Exception e) {
			e.printStackTrace();
		}//end of try
		if(roleList!=null){
			System.out.println("=======Role Records======");
		}//end of if
		return roleList;
	}//end of listAllRole()
	
	//main for test
	public static void main(String[] args) {
		RoleDao dao = new RoleDao();
		Role r=input();
		//dao.addRole(r);;
		
		//System.out.println(dao.modifyProject(p));
		//System.out.println(dao.searchRole(1002));
		//dao.removeProject(p.getProjectId());
		ArrayList<Role> list = dao.listAllRole();
		for(Role p1 : list)
		{
			System.out.println(p1);
		}//end of for
	}//end of main()
	
	//test for input
	public static Role input(){
		Role p = new Role();
		//p.setRoleId(1003);
		p.setRoleName("Secii");
		p.setRoleDesc("p1 desc");;
		return p;
	}//end of input
	
	@Override
	public ArrayList<Integer> getAllRoleNumber() {
		ArrayList<Integer> roleList=null;
		String sql="select roleId from role";
		
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
			System.out.println("======List Of role Number====== ");
			if(rs!=null)
				roleList= new ArrayList<Integer>();
			else
				System.out.println("No records in role");
			while(rs.next()){
				roleList.add(rs.getInt(1));
			}	
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("role list at Dao..."+roleList);
		return roleList;
	}//end of getId
}//end of class
