package com.cg.department.services;

import java.util.ArrayList;

import javax.sql.DataSource;

import com.cg.department.dao.DepartmentDao;
import com.cg.department.dao.IDepartmentDao;
import com.cg.department.domain.Department;
import com.cg.exception.EmsException;

public class DepartmentServices implements IDepartmentServices
{
	private static IDepartmentDao departmentDao;
	static{
		departmentDao = new DepartmentDao();
	}
	@Override
	public void addDepartment(Department d) throws EmsException 
	{
		departmentDao.addDepartment(d);
		
	}

	@Override
	public void removeDepartment(int deptId) throws EmsException 
	{
		departmentDao.removeDepartment(deptId);
		
	}

	@Override
	public Department modifyDepartment(Department d) throws EmsException
	{
		return departmentDao.modifyDepartment(d);
	}

	@Override
	public Department searchDepartment(int deptId) throws EmsException 
	{
		return departmentDao.searchDepartment(deptId);
	}

	@Override
	public ArrayList<Department> listAllDepartment() throws EmsException
	{
		return departmentDao.listAllDepartment();
	}

	@Override
	public void showAllDeptId()  throws EmsException {
		
		departmentDao.showAllDeptId();
	}
	
	
	
	@Override
	public DataSource getDataSource() throws EmsException {
		return departmentDao.getDataSource();
	}
	@Override
	public void setDataSource(DataSource dataSource) throws EmsException {
		System.out.println("EmpService setDataSource "+dataSource);
		departmentDao.setDataSource(dataSource);
		
	}
	@Override
	public void checkDepartment(Department department) {
		departmentDao.checkDepartment(department);
	}

	@Override
	public ArrayList<Integer> getAllDeptNumber() {
		// TODO Auto-generated method stub
		return departmentDao.getAllDeptNumber();
	}	
}//end of class
