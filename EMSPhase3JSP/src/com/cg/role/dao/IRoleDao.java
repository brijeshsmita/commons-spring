package com.cg.role.dao;

import java.util.ArrayList;

import javax.sql.DataSource;

import com.cg.role.domain.Role;

public interface IRoleDao 
{
	public DataSource getDataSource();
	public void setDataSource(DataSource dataSource);
	void addRole(Role e);
	void removeRole(int empNo);
	Role modifyRole(Role e);
	Role searchRole(int empNo);
	ArrayList<Role> listAllRole();
	ArrayList<Integer> getAllRoleNumber();
}
