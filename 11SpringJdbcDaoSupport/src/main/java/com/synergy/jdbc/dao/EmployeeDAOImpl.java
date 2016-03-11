package com.synergy.jdbc.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import com.synergy.jdbc.model.Employee;
public class EmployeeDAOImpl  extends JdbcDaoSupport  implements EmployeeDAO{
	//save or insert employee
	public int insertRecord(Employee emp) 	{
		String empInsert = "insert into Employee  values (?,?,?)";
		try		{	
					int id= emp.getId();
					String name = emp.getName();
					String role = emp.getRole();
			getJdbcTemplate().update(empInsert,new Object[] {id,name,role});
					System.out.println("Record Has inserted");
					return 1;
		}
		catch(Exception exp)
		{
				exp.printStackTrace();
				return 0;
		}	
	}
	//Get Employee or search	
	public Employee retrieveRecord(int empid){
		String empSelect ="select id,name,role from Employee where id=?";
		List <Employee>emps =
		getJdbcTemplate().query(empSelect,new  EmployeeRowMapper(),empid);
		Employee emp = null;
		if(emps !=null)	{
			for(Employee e : emps){
				emp=e;
			}
		}
		return emp;			
	}
	//inner class for rowMapper--	Mapping Results to Java Objects
	private class EmployeeRowMapper implements RowMapper<Employee>{
		public Employee mapRow(ResultSet rs, int rownum) throws SQLException
		{
			//Employee emp1 = new Employee(rs.getInt(1),rs.getString(2),rs.getString(3));
			Employee emp = new Employee();
			emp.setId(rs.getInt(1));
			emp.setName(rs.getString(2));
			emp.setRole(rs.getString(3));
			return emp;
		}
	}

//update	
	public int updateRecord(Employee emp)
	{
		try {
			String empUpdate = "update Employee set  name=?, role=?  where id=?";
			getJdbcTemplate().update(empUpdate,new Object[] 
					{emp.getName(),emp.getRole(),emp.getId()});
			System.out.println("Record is Updated");
			return 1;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}	
		
	}
//get All Employee
	public List<Employee> retrieveAllRecord()
	{
			String empSelect = "select * from Employee";
			List <Employee>emps = getJdbcTemplate()
					.query(empSelect,new  EmployeeRowMapper());
			if(emps!=null)
				return emps;
			else
				return null;
	}
//Delete
	public int deleteRecord(int empId) {
		try {
			String empUpdate = "delete from employee where id=?";
			getJdbcTemplate().
			update(empUpdate,new Object[] {empId});
			System.out.println("Record is Deleted");
			return 1;
		} catch (Exception e) {
			return 0;
		}		
	}
	
	
	
	
	
	
}//end of class