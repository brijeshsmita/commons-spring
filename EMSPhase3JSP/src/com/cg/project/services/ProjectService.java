package com.cg.project.services;

import java.util.ArrayList;

import javax.sql.DataSource;

import com.cg.employee.dao.EmployeeDao;
import com.cg.employee.dao.IEmployeeDao;
import com.cg.employee.domain.Employee;
import com.cg.exception.EmsException;
import com.cg.project.dao.IProjectDao;
import com.cg.project.dao.ProjectDao;
import com.cg.project.domain.Project;

public class ProjectService  implements IProjectService{

	private static IProjectDao projectDao;
	static{
		projectDao = new ProjectDao();
	}
	public static IProjectDao getProjectDao() {
		return projectDao;
	}

	public static void setProjectDao(IProjectDao projectDao) {
		ProjectService.projectDao = projectDao;
	}

	@Override
	public void addProject(Project e)throws EmsException  {
		projectDao.addProject(e);
		
	}

	@Override
	public void removeProject(int projectId)throws EmsException  {
		
		projectDao.removeProject(projectId);
	}

	@Override
	public Project modifyProject(Project e)throws EmsException  {
		return projectDao.modifyProject(e);
	}

	@Override
	public Project searchProject(int projectId) throws EmsException {
		return projectDao.searchProject(projectId);
	}

	@Override
	public ArrayList<Project> listAllProject()throws EmsException  {
		return projectDao.listAllProject();
	}

	@Override
	public void showAllProjectId()throws EmsException  {
		projectDao.showAllProjectId();
	}
	
	@Override
	public DataSource getDataSource() throws EmsException {
		return projectDao.getDataSource();
	}
	@Override
	public void setDataSource(DataSource dataSource) throws EmsException {
		System.out.println("Project services setDataSource "+dataSource);
		projectDao.setDataSource(dataSource);
		
	}
	@Override
	public void checkProject(Project project) {
		projectDao.checkProject(project);
		
	}

	@Override
	public ArrayList<Integer> getAllProjectNumber() {
		// TODO Auto-generated method stub
		return projectDao.getAllProjectNumber();
	}

}//end of class
