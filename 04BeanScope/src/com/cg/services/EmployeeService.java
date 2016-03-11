package com.cg.services;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

import com.cg.beans.Employee;
public class EmployeeService implements InitializingBean,
DisposableBean{
	private Employee employee;	
	public EmployeeService(){
		System.out.println("EmployeeService no-args "
				+ "constructor called");
	}
	public void destroy() throws Exception {
		System.out.println("EmployeeService Closing resources");
	}
	public void afterPropertiesSet() throws Exception {
		System.out.println("EmployeeService initializing "
				+ "to dummy value");
		if(employee.getName() == null){
			employee.setName("Smita");
		}
	}//getters and setters
	public Employee getEmployee() {
		return employee;
	}
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}	
}
