package com.cg.project.dao;

import java.util.ArrayList;

import javax.sql.DataSource;

import com.cg.project.domain.Project;

public interface IProjectDao 
{
	public DataSource getDataSource();
	public void setDataSource(DataSource dataSource);
	void addProject(Project e);
	void removeProject(int empNo);
	Project modifyProject(Project e);
	Project searchProject(int empNo);
	ArrayList<Project> listAllProject();
	void showAllProjectId();
	void checkProject(Project project);
	ArrayList<Integer> getAllProjectNumber();
}
