package com.cg.project.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.sql.DataSource;

import com.cg.employee.dao.EmployeeDao;
import com.cg.employee.services.EmployeeServices;
import com.cg.project.domain.Project;
import com.cg.employee.dao.IEmployeeDao;
import com.cg.employee.domain.Employee;


public class ProjectDao implements IProjectDao 
{
	EmployeeDao empdao=new EmployeeDao();
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
	public void checkProject(Project project) {
		try {
			con=getDataSource().getConnection();
            PreparedStatement ps = 
            		con.prepareStatement(
		"select projectId from project where projectId = ?");
            ps.setInt(1, project.getProjectId());
            ResultSet rs = ps.executeQuery();
            if (rs.next()) // found
            {
               modifyProject(project);
            } else {
               addProject(project);
            }
        } catch (Exception ex) {
            System.out.println("Error in check() -->" 
        + ex.getMessage());
        } 
		
	}

	@Override
	public void addProject(Project p) {
	
		Statement stmt=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		String sql="insert into project values(?,?,?,?)";
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
			ps.setString(2, p.getProjectName());//ename
			ps.setString(3, p.getProjectDescription());//grade
			ps.setInt(4, p.getDeptId());//deptno
		
			//step 4: now executing the ps
			int noOfRecords=ps.executeUpdate();
			//getting the data from the rs
			if(noOfRecords==1){
				System.out.println("Project Inserted successfully--->");					
			}else{
				System.out.println("Sorry Boss! Project record"
						+ " not inserted");
			}
		} catch (Exception e2) {
			e2.printStackTrace();
		}
	}//end of addProject()

	@Override
	public void removeProject(int projectId) {
		
		PreparedStatement ps=null;
		
		empdao.modifyEmployeeByProjectId(projectId);
		String sql="delete from project where projectId=?";
		try {
			//obtain connection
			con=getDataSource().getConnection();
			//obtain PreparedStatement obj
			ps=con.prepareStatement(sql);
			//set the dynamic values of PS
			ps.setInt(1, projectId);
			//executeUpdate the ps
			int noOfRecords=ps.executeUpdate();
			//check weather record deleted or not
			if(noOfRecords==1){
				System.out.println("*****Project Deleted successfully--->");
				
			}else{
				System.out.println("Sorry Boss! Project record"
						+ " not deleted");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}//end of removeProject()

	@Override
	public Project modifyProject(Project p) {
		
		Statement stmt=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		String sql="update project set projectName=?,projectDescription=?,deptId=? where projectId=?";
		try {
			//obtain connection
			con=getDataSource().getConnection();
			//obtain PreparedStatement obj
				ps=con.prepareStatement(sql);
			//set the dynamic values of PS place holserd
				ps.setInt(4, p.getProjectId());//ename
				ps.setString(1, p.getProjectName());//grade
				
				ps.setString(2, p.getProjectDescription());
				ps.setInt(3, p.getDeptId());
		
				int noOfRecords=ps.executeUpdate();
				//check weather record deleted or not
				if(noOfRecords==1){
					System.out.println("Project Updated successfully--->");
					
				}else{
					System.out.println("Sorry Boss! Project record"
							+ " not Updated");
				}
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		return p;
	}//end of modifyProject()

	@Override
	public Project searchProject(int projectId) {
		
		PreparedStatement ps=null;
		ResultSet rs=null;
		Project e1= null;
		try {
			String sql="select * from project where projectId=?";
			con=getDataSource().getConnection();
			ps=con.prepareStatement(sql);//pre-compiled sql
			ps.setInt(1, projectId);//setting the value at runtime
			//now executing the ps
			rs=ps.executeQuery();
			//getting the data from the rs
			if(rs.next()){
				e1=new Project();
				System.out.println("Project Found--->");
				
				e1.setProjectId(rs.getInt(1));
				e1.setProjectName(rs.getString(2));
				e1.setProjectDescription(rs.getString(3));
				e1.setDeptId(rs.getInt(4));
			}else{
				System.out.println("Sorry Boss! Project record for "
						+projectId+ " does not Exists");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return e1;
	}//end of searchProject()

	@Override
	public ArrayList<Project> listAllProject() {
		ArrayList<Project> empList= new ArrayList<Project>();
		Project p = null;
		String sql="select * from project";
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
				p = new Project();
				p.setProjectId(rs.getInt(1));
				p.setProjectName(rs.getString(2));
				p.setProjectDescription(rs.getString(3));
				p.setDeptId(rs.getInt(4));
				empList.add(p);
			}			
		} catch (Exception e) {
			e.printStackTrace();
		}
		if(empList!=null){
			System.out.println("=======Project Records======");
		}
		return empList;
	}//end of listAllProject()
	
	//for test
	public static void main(String[] args) {
		ProjectDao dao = new ProjectDao();
		Project p=input();
		//dao.addProject(p);
		
		//System.out.println(dao.modifyProject(p));
		System.out.println(dao.searchProject(100));
		//dao.removeProject(p.getProjectId());
		/*ArrayList<Project> list = dao.listAllProject();
		for(Project p1 : list)
		{
			System.out.println(p1);
		}*/
	}//end of main
	
	//input for test
	public static Project input(){
		
		Project p = new Project();
		
		p.setProjectId(40);
		p.setProjectName("Prj1 desc");
		p.setDeptId(20);
		return p;
	}//end of input

	@Override
	public void showAllProjectId() 
	{
		ArrayList<Project> projectList= new ArrayList<>();
		Project e1 = null;
		String sql="select projectId from project";
		
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
				e1 = new Project();
			
				e1.setDeptId(rs.getInt(1));
				
				projectList.add(e1);
			}			
		} catch (Exception e) {
			e.printStackTrace();
		}
		if(projectList!=null){
			System.out.println("=======Department Id======");
			for(Project dept : projectList){
				System.out.println(dept.getDeptId());
			}
		}	
	}//end of showAllProjectId()
	
	@Override
	public ArrayList<Integer> getAllProjectNumber() {
		ArrayList<Integer> projectList=null;
		String sql="select projectId from project";
		
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
			System.out.println("======List Of Project Number====== ");
			if(rs!=null)
				projectList= new ArrayList<Integer>();
			else
				System.out.println("No records in Deaprtment");
			while(rs.next()){
				projectList.add(rs.getInt(1));
			}	
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("dept list at Dao..."+projectList );
		return projectList;
	}//end of getId
}//end of class
