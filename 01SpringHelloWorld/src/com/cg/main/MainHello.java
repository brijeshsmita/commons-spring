/**
 * 
 */
package com.cg.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cg.bean.HelloWorldService;
import com.cg.services.HelloService;

public class MainHello {
	
	public static void main(String[] args) {
		ApplicationContext context=
				new ClassPathXmlApplicationContext("/servlet-context.xml");
		HelloService service=
				(HelloWorldService) context.getBean("helloObj");
		System.out.println(service.sayHello());
	}
}
/*
HelloWorldService service = /*new HelloWorldService();*/
/*service.setName("smita");
System.out.println(service.sayHello());*/