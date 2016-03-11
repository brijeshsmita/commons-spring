package com.cg.main;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cg.services.MyAwareService;
public class SpringAwareMain {
	public static void main(String[] args) {
		AbstractApplicationContext context = 
				new ClassPathXmlApplicationContext("spring-aware.xml");
		context.getBean("myAwareService", MyAwareService.class);
		context.close();
	}
}
