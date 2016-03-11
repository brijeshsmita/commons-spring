package com.cg.employee.dao;

import java.util.ArrayList;

import javax.sql.DataSource;

import com.cg.employee.domain.Employee;

public interface IEmployeeDao
{
	public DataSource getDataSource();
	public void setDataSource(DataSource dataSource);
	void addEmployee(Employee e);
	void removeEmployee(int empNo);
	Employee modifyEmployee(Employee e);
	Employee searchEmployee(int empNo);
	ArrayList<Employee> listAllEmployee();
	void modifyEmployeeByProjectId(int projectId);
	public void checkUser(Employee employee);
}
