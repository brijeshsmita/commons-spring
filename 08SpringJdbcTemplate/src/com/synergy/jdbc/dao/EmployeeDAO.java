package com.synergy.jdbc.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.synergy.jdbc.model.Employee;
@Repository(value="employeeDAO")
public class EmployeeDAO implements IEmployeeDAO {
	@Autowired
	private DataSource dataSource;
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;		
	}	
	public int insertRecord(Employee employee) {
		String query=
		"insert into Employee (id, name, role) values (?,?,?)";
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		Object[] args = new Object[] {
				employee.getId(),
				employee.getName(),
				employee.getRole()
		};
int out = jdbcTemplate.update(query, args);
if(out !=0){
	System.out.println("Employee saved with id="+employee.getId());
}else System.out.println("Employee save failed with id="
	+employee.getId());
return out;
}	//end of insert record
public Employee retrieveRecord(int id) {
String query = "select id, name, role from Employee where id = ?";
JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
//using RowMapper anonymous class, 
//we can create a separate RowMapper for reuse
Employee emp = 
jdbcTemplate.queryForObject(query, new Object[]{id}, 
		new RowMapper<Employee>(){
		public Employee mapRow(ResultSet rs, int rowNum)
				throws SQLException {
			Employee emp = new Employee();
			emp.setId(rs.getInt("id"));
			emp.setName(rs.getString("name"));
			emp.setRole(rs.getString("role"));
		return emp;
	}});
return emp;
}//end of retrieve
public int updateRecord(Employee employee) {
String query = "update Employee set name=?, role=? where id=?";
JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
Object[] args = new Object[] {employee.getName(),
		employee.getRole(), employee.getId()};
int out = jdbcTemplate.update(query, args);
if(out !=0){
	System.out.println("Employee updated with id="+employee.getId());
}else System.out.println("No Employee found with id="
	+employee.getId());
	return out;
}
public int deleteRecord(int id) {
	String query = "delete from Employee where id=?";
JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
int out = jdbcTemplate.update(query, id);
if(out !=0){
	System.out.println("Employee deleted with id="+id);
}else System.out.println("No Employee found with id="+id);
	return out;
}
public List<Employee> retrieveAllRecord() {
String query = "select id, name, role from Employee";
JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
List<Employee> empList = new ArrayList<Employee>();
List<Map<String,Object>> empRows = 
jdbcTemplate.queryForList(query);
for(Map<String,Object> empRow : empRows){
	Employee emp = new Employee();
	emp.setId(Integer.parseInt(String.valueOf(empRow.get("id"))));
	emp.setName(String.valueOf(empRow.get("name")));
	emp.setRole(String.valueOf(empRow.get("role")));
	empList.add(emp);
}
return empList;
}
}
