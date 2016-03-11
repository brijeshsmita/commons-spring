package com.synergy.jdbc.service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.synergy.jdbc.dao.IEmployeeDAO;
import com.synergy.jdbc.model.Employee;
@Service(value="employeeService")
public class EmployeeService implements IEmployeeService{
	
	private IEmployeeDAO employeeDAO;
	public IEmployeeDAO getEmployeeDAO() {
		return employeeDAO;
	}
	@Autowired
	public void setEmployeeDAO(IEmployeeDAO employeeDAO) {
		this.employeeDAO = employeeDAO;
	}
	//save or insert employee
	public int insertRecord(Employee emp) 	{
		return employeeDAO.insertRecord(emp);
	}
//update	
	public int updateRecord(Employee emp)	{
		return employeeDAO.updateRecord(emp);
	}
//Get Employee or search	
	public Employee retrieveRecord(int empId)	{
		return employeeDAO.retrieveRecord(empId);
	}
	//get All Employee
	public List<Employee> retrieveAllRecord()	{
		return employeeDAO.retrieveAllRecord();
	}
//Delete
	public int deleteRecord(int empId) {
		return employeeDAO.deleteRecord(empId);
	}
}