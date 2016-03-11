package com.sb.spring.autowiring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Required;

public class Customer {
	@Autowired	
	@Qualifier("personObjA")
	private Person person;	
	private int type;
	private String action;
	
	public Customer(){
		
	}
	
	public Customer(Person person, int type, String action) {
		super();
		this.person = person;
		this.type = type;
		this.action = action;
	}

	public Person getPerson() {
		return person;
	}
	public void setPerson(Person person) {
		this.person = person;
	}
	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public String getAction() {
		return action;
	}
/*	@Required*/
	public void setAction(String action) {
		this.action = action;
	}

	@Override
	public String toString() {
		return "Customer [person=" + person + ", type=" + type + ", action="
				+ action + "]";
	}

	
}