package com.sb.core;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sb.customer.bo.CustomerBo;
public class AopApp {
	public static void main(String[] args) throws Exception {
		ApplicationContext appContext = 
		new ClassPathXmlApplicationContext("servlet-context.xml");
		CustomerBo customer = (CustomerBo) 
				appContext.getBean("customerBo");
		customer.addCustomer();
		customer.addCustomerReturnValue();
		customer.addCustomerThrowException();
		customer.addCustomerAround("sb");
	}
}
//