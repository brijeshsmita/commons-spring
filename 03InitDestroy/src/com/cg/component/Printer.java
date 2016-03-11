/**
 * 
 */
package com.cg.component;
import javax.annotation.PostConstruct;

import com.cg.services.PrintService;
/**
 * @author Brijesh
 *
 */
public class Printer {
	private PrintService service;	
	
	//dependency injection thru constructor injection
	public Printer(PrintService service)
	{
		this.service=service;
	}
	public void doPrinting(){
		System.out.println("doPrintinG()");
		service.print();
	}	
}
	
	
	
	
	//dependency injection thru setter or property injection
	/*public void setService(PrintService service) {
		this.service = service;
	}*/
	
