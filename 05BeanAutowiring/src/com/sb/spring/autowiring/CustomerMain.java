package com.sb.spring.autowiring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class CustomerMain {
	public static void main(String[] args) {
		@SuppressWarnings("resource")
		ApplicationContext context = 
		new FileSystemXmlApplicationContext(
	"src\\com\\sb\\spring\\autowiring\\servlet-context.xml");

		Customer cust = (Customer) context.getBean("custObj");
		System.out.println(cust);
	}
}