package com.cg.beans;
import com.cg.services.PrintService;
/** * @author BrijeshSmita * */
public class User implements PrintService{
	private String name;	
	public User() {
		// TODO Auto-generated constructor stub
	}	
	//constructor injection
	public User(String name) {
		super();
		this.name = name;
	}
	@Override
	public void print() {
		System.out.println("Printing user......\n"+this);			
	}
	@Override
	public String toString() {
		return "User [name=" + name + "]";
	}	
}
