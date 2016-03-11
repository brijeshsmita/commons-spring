package com.cg.main;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cg.model.Employee;
import com.cg.services.CompanyInfo;

/**
 * 
 */

/**
 * @author BrijeshSMita
 */
public class MainClass {
	public static void main(String[] args) {
		@SuppressWarnings("resource")
		ApplicationContext context = 
				new ClassPathXmlApplicationContext("servlet-context.xml");
		CompanyInfo companyInfo = (CompanyInfo) context.getBean("companyInfo");
		
		companyInfo.setCoName("Synergy");
		companyInfo.setCoAddress("Mumbai");
		Employee emp = (Employee) context.getBean("employee");
		emp.setCompanyInfo(companyInfo);
		System.out.println(emp.getCompanyInfo());
		
	}
}
