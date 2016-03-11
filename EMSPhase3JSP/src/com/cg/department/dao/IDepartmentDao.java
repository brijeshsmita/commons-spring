package com.cg.department.dao;

import java.util.ArrayList;

import javax.sql.DataSource;

import com.cg.department.domain.Department;

public interface IDepartmentDao 
{
	void addDepartment(Department d) ;
	void removeDepartment(int deptId) ;
	Department modifyDepartment(Department d) ;
	Department searchDepartment(int deptId) ;
	ArrayList<Department> listAllDepartment() ;
	void showAllDeptId() ;
	void checkDepartment(Department department);
	void setDataSource(DataSource dataSource);
	DataSource getDataSource();
	ArrayList<Integer> getAllDeptNumber();
}
