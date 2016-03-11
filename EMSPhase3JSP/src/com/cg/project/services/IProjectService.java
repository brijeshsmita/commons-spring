package com.cg.project.services;

import com.cg.employee.domain.Employee;
import com.cg.exception.EmsException;
import com.cg.project.domain.Project;

import java.util.ArrayList;

import javax.sql.DataSource;


public interface IProjectService {

	public DataSource getDataSource()throws EmsException;
	public void setDataSource(DataSource dataSource)throws EmsException;
	void addProject(Project p)throws EmsException ;
	void removeProject(int projectId)throws EmsException ;
	Project modifyProject(Project p)throws EmsException ;
	Project searchProject(int projectId) throws EmsException ;
	ArrayList<Project> listAllProject()throws EmsException ;
	void showAllProjectId()throws EmsException ;
	public void checkProject(Project project);
	ArrayList<Integer> getAllProjectNumber();
	
}
