package com.synergy.jdbc.service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.synergy.jdbc.dao.EmployeeDAO;
import com.synergy.jdbc.model.Employee;
@Service(value="employeeServiceImpl")
public class EmployeeServiceImpl implements EmployeeService{
	@Autowired
	private EmployeeDAO employeeDao;
	
public EmployeeDAO getEmployeeDao() {
		return employeeDao;
	}
	public void setEmployeeDao(EmployeeDAO employeeDao) {
		this.employeeDao = employeeDao;
	}
	//save or insert employee
	public int insertRecord(Employee emp) 	{
		return employeeDao.insertRecord(emp);
	}
//update	
	public int updateRecord(Employee emp)	{
		return employeeDao.updateRecord(emp);
	}
//Get Employee or search	
	public Employee retrieveRecord(int empId)	{
		return employeeDao.retrieveRecord(empId);
	}
	//get All Employee
	public List<Employee> retrieveAllRecord()	{
		return employeeDao.retrieveAllRecord();
	}
//Delete
	public int deleteRecord(int empId) {
		return employeeDao.deleteRecord(empId);
	}
}