package com.cg.role.services;

import java.util.ArrayList;

import javax.sql.DataSource;

import com.cg.exception.EmsException;
import com.cg.role.domain.Role;

public interface IRoleServices 
{
	public DataSource getDataSource()throws EmsException;
	public void setDataSource(DataSource dataSource)throws EmsException;
	void addRole(Role r);
	void removeRole(int empNo);
	Role modifyRole(Role r);
	Role searchRole(int empNo) ;
	ArrayList<Role> listAllRole();
	void showAllRoleId();
	ArrayList<Integer> getAllRoleNumber();
}
