package com.cg.main;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cg.beans.CompanyInfo;
import com.cg.beans.Employee;
import com.cg.services.EmployeeService;
public class EmployeeServiceMain {
	public static void main(String[] args) {
		@SuppressWarnings("resource")
		ApplicationContext context = 
				new ClassPathXmlApplicationContext("bean_annotation.xml");
		
		EmployeeService service = 
			context.getBean("employeeService",EmployeeService.class);
			System.out.println(service.getEmployee());
	}
}




