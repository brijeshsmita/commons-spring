package com.cg.main;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cg.beans.Employee;
import com.cg.services.InformationService;
/** * @author Smita Brijesh* */
public class BeanScopeMain {
	public static void main(String[] args) {
		AbstractApplicationContext context= 
	new ClassPathXmlApplicationContext("servlet-context.xml");
		InformationService service=
				(InformationService)context.getBean("companyInfo");
		service.getCompanyInfo();
		
		/*Employee e = new Employee();
		e.setCompanyInfo(new CompanyInfo("Snergy","Mumbai"));*/
		Employee e = (Employee)context.getBean("employee");
		e.getCompanyInfo();
		System.out.println("CompanyInfo "+service.hashCode());
		service=(InformationService)context.getBean("companyInfo");
		System.out.println("CompanyInfo "+service.hashCode());
		System.out.println("Employee "+e.hashCode());
		Employee e1 = (Employee)context.getBean("employee");
		System.out.println("Employee "+e1.hashCode());
		Employee e2 = (Employee)context.getBean("employee");
		System.out.println("Employee "+e2.hashCode());
		context.registerShutdownHook();
		context.close();
		
	}

}
