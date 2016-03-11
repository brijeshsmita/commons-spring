/**
 * 
 */
package com.cg.spring.di;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

/**
 * @author Smita Brijesh
 *
 */
public class TestCoInfo {
	public static void main(String[] args) {
		ApplicationContext context= 
	new FileSystemXmlApplicationContext("src\\com\\cg\\spring\\di\\servlet-context.xml");
		InformationService service=
				(InformationService)context.getBean("coInfoObj");
		service.getCompanyInfo();
		
		/*Employee e = new Employee();
		e.setCompanyInfo(new CompanyInfo("Snergy","Mumbai"));*/
		Employee e = (Employee)context.getBean("employee");
		e.getCompanyInfo();
		System.out.println("CompanyInfo "+service.hashCode());
		service=(InformationService)context.getBean("coInfoObj");
		System.out.println("CompanyInfo "+service.hashCode());
		System.out.println("Employee "+e.hashCode());
		Employee e1 = (Employee)context.getBean("employee");
		System.out.println("Employee "+e1.hashCode());
		Employee e2 = (Employee)context.getBean("employee");
		System.out.println("Employee "+e2.hashCode());
		
	}

}
