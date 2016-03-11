package com.cg.main;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.cg.component.Printer;
/** * @author Brijeshmita * */
public class XMLClientApp {
	public static void main(String[] args) {
		AbstractApplicationContext context =
	new ClassPathXmlApplicationContext("/servlet-context.xml");
		//step 1 declaring  springconatiner to load the beans.xml
		//step 2: getting the user object from the spring container
		Printer printer = (Printer)context.getBean("printer");
		printer.doPrinting();
		/*
		Printer printer1 = (Printer)context.getBean("printer1");
		printer1.doPrinting();
		//register the shutDownHook for the container
		//inorder to explicitly call the user defined destroy method
		context.registerShutdownHook();
		context.close();*/
	}

}
