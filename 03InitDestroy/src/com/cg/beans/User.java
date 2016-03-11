/**
 * 
 */
package com.cg.beans;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import com.cg.services.PrintService;
/**
 * @author Brijesh
 *
 */
public class User implements PrintService{
	private String name;
	@PostConstruct
	public void initUser(){
		System.out.println("User initUser()....... method");
	}
	@PreDestroy
	public void exit(){
		System.out.println("User exit()....... method");
	}
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
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}	
}
