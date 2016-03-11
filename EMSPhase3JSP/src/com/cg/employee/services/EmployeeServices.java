package com.cg.employee.services;

import java.util.ArrayList;

import javax.sql.DataSource;

import com.cg.employee.dao.EmployeeDao;
import com.cg.employee.dao.IEmployeeDao;
import com.cg.employee.domain.Employee;
import com.cg.exception.EmsException;
public class EmployeeServices implements IEmployeeServices
{

	private static IEmployeeDao employeeDao;
	static{
		
		employeeDao = new EmployeeDao();
	}
	public static IEmployeeDao getEmployeeDao() {
		return employeeDao;
	}
	public static void setEmployeeDao(IEmployeeDao employeeDao) {
		EmployeeServices.employeeDao = employeeDao;
	}
	@Override
	public void addEmployee(Employee e) throws EmsException {
		employeeDao.addEmployee(e);
		
	}
	@Override
	public void removeEmployee(int empNo) throws EmsException {
		employeeDao.removeEmployee(empNo);
	}
	@Override
	public Employee modifyEmployee(Employee e) throws EmsException {
		return employeeDao.modifyEmployee(e);
	}
	@Override
	public Employee searchEmployee(int empNo) throws EmsException {
		return employeeDao.searchEmployee(empNo);
	}
	@Override
	public ArrayList<Employee> listAllEmployee()throws EmsException  {
		return employeeDao.listAllEmployee();
	}
	@Override
	public DataSource getDataSource() throws EmsException {
		return employeeDao.getDataSource();
	}
	@Override
	public void setDataSource(DataSource dataSource) throws EmsException {
		System.out.println("EmpService setDataSource "+dataSource);
		employeeDao.setDataSource(dataSource);
		
	}
	@Override
	public void checkUser(Employee employee) {
		employeeDao.checkUser(employee);
		
	}
}//end of class
