package com.synergy.jdbc.service;

import java.util.List;

import com.synergy.jdbc.model.Employee;

//CRUD operations
public interface EmployeeService {
	
	//Create
	public int insertRecord(Employee emp);
	//Update
	public int updateRecord(Employee emp);
	//Delete
	public int deleteRecord(int empId);
	//search
	public Employee retrieveRecord(int empid);
	//List
	public List<Employee> retrieveAllRecord();

}
