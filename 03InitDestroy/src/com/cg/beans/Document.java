/**
 * 
 */
package com.cg.beans;
import javax.annotation.PostConstruct;

import com.cg.services.PrintService;
/**
 * @author Brijesh
 *
 */
public class Document implements PrintService {
	private int id;
	private String name;
	private String type;
	public Document(){
		
	}
	public void init(){
		System.out.println("Document init()....... method");
	}
	public void exit(){
		System.out.println("Document exit()....... method");
	}
//constructor injection
	public Document(int id, String name, String type) {
		super();
		this.id = id;
		this.name = name;
		this.type = type;
	}

	@Override
	public void print() {
		System.out.println("Printing Document..."+this);
	}

	@Override
	public String toString() {
		return "Document [id=" + id + ", name=" + name + ", type=" + type + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

}
