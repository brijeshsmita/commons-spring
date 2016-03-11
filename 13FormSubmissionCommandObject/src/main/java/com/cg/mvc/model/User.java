package com.cg.mvc.model;
import java.io.Serializable;
/**
 * @author Brijesh
 *
 */
public class User implements Serializable{
	private static final long serialVersionUID = 5720098564587405478L;
	private String name = null;
	private  String job = null;
	private int age;
	private String gender = null;
	//getters and setters
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	//toString
	@Override
	public String toString() {
		return "User [name=" + name + ", job=" + job + ", age=" + age
				+ ", gender=" + gender + "]";
	}	
}

