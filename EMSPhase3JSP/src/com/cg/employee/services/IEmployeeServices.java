package com.cg.employee.services;

import java.util.ArrayList;

import javax.sql.DataSource;

import com.cg.employee.domain.Employee;
import com.cg.exception.EmsException;

public interface IEmployeeServices 
{
	public DataSource getDataSource()throws EmsException;
	public void setDataSource(DataSource dataSource)throws EmsException;
	void addEmployee(Employee e)throws EmsException ;
	void removeEmployee(int empNo)throws EmsException ;
	Employee modifyEmployee(Employee e)throws EmsException ;
	Employee searchEmployee(int empNo)throws EmsException ;
	ArrayList<Employee> listAllEmployee()throws EmsException ;
	public void checkUser(Employee employee);
}
