package com.cg.beans;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

import com.cg.beans.User;
public class UserService implements InitializingBean,
DisposableBean{
	private User user;	
	public UserService(){
		System.out.println("UserService no-args constructor called");
	}
	public void destroy() throws Exception {
		System.out.println("UserService Closing resources");
	}
	public void afterPropertiesSet() throws Exception {
		System.out.println("EmployeeService initializing to dummy value");
		if(user.getName() == null){
			user.setName("Smita");
		}
	}
	public User getEmployee() {
		return user;
	}
	public void setEmployee(User user) {
		this.user = user;
	}	
}
