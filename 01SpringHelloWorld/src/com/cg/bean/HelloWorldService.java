package com.cg.bean;
import com.cg.services.HelloService;
/** * @author Smita Brijesh * */
public class HelloWorldService implements HelloService {
	private String name;	 
	public void setName(String name) {
		this.name = name;
	} 
	public String sayHello() {
		return "Hello! " + name;
	}
}
