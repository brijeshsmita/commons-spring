package com.cg.department.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.sql.DataSource;
import com.cg.department.domain.Department;
import com.cg.exception.EmsException;

public class DepartmentDao implements IDepartmentDao 
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
	public void checkDepartment(Department department) {
		try {
			con=getDataSource().getConnection();
            PreparedStatement ps = 
            		con.prepareStatement(
		"select deptId from department where deptId = ?");
            ps.setInt(1, department.getDeptId());
            ResultSet rs = ps.executeQuery();
            if (rs.next()) // found
            {
                modifyDepartment(department);
            } else {
               addDepartment(department);
            }
        } catch (Exception ex) {
            System.out.println("Error in check() -->" 
        + ex.getMessage());
        } 
		
	}
	@Override
	public void addDepartment(Department d){
		Connection con=null;
		Statement stmt=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		String sql="insert into department values(?,?,?)";
		int rno = 0;
		try {
			con=getDataSource().getConnection();
			//System.out.println("Connection Obtained"+con);
			stmt= con.createStatement();
			rs = stmt.executeQuery("SELECT SEQ_DEPT.NEXTVAL FROM dual");
			if ( rs!=null && rs.next() ) {
			 rno = rs.getInt(1);
			System.out.println(rno);
			rs.close();
			}
			ps= con.prepareStatement(sql);
			ps.setInt(1, rno);
			ps.setString(2, d.getDeptName());
			ps.setString(3, d.getDeptDesc());
			int noOfRecords=ps.executeUpdate();
			if(noOfRecords==1){
				System.out.println("Department Inserted successfully--->");					
			}else{
				System.out.println("Sorry Boss! Department record"
						+ " not inserted");
			}
		} catch (Exception e2) {
			e2.printStackTrace();
		}
	}//end of addDepartment()

	@Override
	public void removeDepartment(int deptId) {
		Connection con=null;
		PreparedStatement ps=null;
		String sql="delete from department where deptId=?";
		try {
			//obtain connection
			con=getDataSource().getConnection();
			//obtain PreparedStatement obj
			ps=con.prepareStatement(sql);
			//set the dynamic values of PS
			ps.setInt(1, deptId);
			//executeUpdate the ps
			int noOfRecords=ps.executeUpdate();
			//check weather record deleted or not
			if(noOfRecords==1){
				System.out.println("*****Department Deleted successfully--->");
				
			}else{
				System.out.println("Sorry Boss! Department record"
						+ " not deleted");
			}
		} catch (Exception e) {
			e.printStackTrace();
		
		}

	}//end of removeDepartment()

	@Override
	public Department modifyDepartment(Department d){
		Connection con=null;
		Statement stmt=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		String sql="update department set deptName=?,deptDesc=? where deptId=?";
		try {
			//obtain connection
			con=getDataSource().getConnection();
			//obtain PreparedStatement obj
				ps=con.prepareStatement(sql);
			//set the dynamic values of PS place holserd
				ps.setString(1, d.getDeptName());//ename
				ps.setString(2, d.getDeptDesc());//grade
				ps.setDouble(3, d.getDeptId());
			
			//executeUpdate the ps
				int noOfRecords=ps.executeUpdate();
				//check weather record deleted or not
				if(noOfRecords==1){
					System.out.println("Department Updated successfully--->");
					
				}else{
					System.out.println("Sorry Boss! Department record"
							+ " not Updated");
				}
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		return d;
	}//end of modifyDepartment()

	@Override
	public Department searchDepartment(int deptId){
		
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		Department d1=null;
		try {
			String sql="select * from department where deptId=?";
			con=getDataSource().getConnection();
			ps=con.prepareStatement(sql);//pre-compiled sql
			ps.setInt(1, deptId);//setting the value at runtime
			//now executing the ps
			rs=ps.executeQuery();
			//getting the data from the rs
			if(rs.next()){
				d1= new Department();
				System.out.println("Department Found--->");
				
				d1.setDeptId(rs.getInt(1));
				d1.setDeptName(rs.getString(2));
				d1.setDeptDesc(rs.getString(3));
			}else{
				System.out.println("Sorry Boss! Department record for "
						+deptId+ " does not Exists");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return d1;
		
	}//end of searchDepartment()

	@Override
	public ArrayList<Department> listAllDepartment() {
		ArrayList<Department> deptList= new ArrayList<Department>();
		Department d1 = null;
		String sql="select * from department";
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
			while(rs.next()){
				d1 = new Department();
				d1.setDeptId(rs.getInt(1));
				d1.setDeptName(rs.getString(2));
				d1.setDeptDesc(rs.getString(3));
				deptList.add(d1);
			}			
		} catch (Exception e) {
			e.printStackTrace();
		}
		if(deptList!=null){
			System.out.println("=======Department Records======");
		}
		return deptList;
	}//end of listAllDepartment()
	
	//for test
	public static void main(String[] args) throws EmsException {
		DepartmentDao dao = new DepartmentDao();
		/*Department d=input();
		dao.addDepartment(d);
		d=input();
	   System.out.println(dao.modifyDepartment(d));
	  System.out.println(dao.searchDepartment(d.getDeptId()));
		dao.removeDepartment(d.getDeptId());*/
		ArrayList<Department> list = dao.listAllDepartment();
		for(Department dept : list){
			System.out.println(dept);
		}
	}//end of main
	
	//for test
	public static Department input(){
		
		Department d = new Department();
		d.setDeptId(1111);
		d.setDeptName("Java");
		d.setDeptDesc("Apps1");
		return d;
	}//end of input()

	@Override
	public void showAllDeptId() 
	{

		ArrayList<Department> empList= new ArrayList<>();
		Department e1 = null;
		String sql="select deptId from department";
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
				e1 = new Department();
			
				e1.setDeptId(rs.getInt(1));
				
				empList.add(e1);
			}			
		} catch (Exception e) {
			e.printStackTrace();
		}
		if(empList!=null){
			System.out.println("===========Department Id============");
			for(Department dept : empList){
				System.out.println(dept.getDeptId());
			}
		}
	
	}//end of showAllDeptId()
	
	@Override
	public ArrayList<Integer> getAllDeptNumber() {
		ArrayList<Integer> deptList=null;
		String sql="select deptId from department";
		
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
			System.out.println("======List Of Department Number====== ");
			if(rs!=null)
				deptList= new ArrayList<Integer>();
			else
				System.out.println("No records in Deaprtment");
			while(rs.next()){
				deptList.add(rs.getInt(1));
			}	
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("dept list at Dao..."+deptList);
		return deptList;
	}//end of getId
}//end of class



