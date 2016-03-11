package com.cg.mvc.model;

import java.io.Serializable;

public class Customer implements Serializable{
	private static final long serialVersionUID = 2335956350282983825L;

	//textbox
	String userName;
	
	//textarea
	String address;
	
	//password
	String password;
	String confirmPassword;
	
	//checkbox
	boolean receiveNewsletter;
	String [] favFramework;
	
	//radio button
	String payMode;
	String sex;
	
	//dropdown box
	String country;
	String javaSkills;
	
	//hidden value
	String secretValue;
	
	public String getSecretValue() {
		return secretValue;
	}
	public void setSecretValue(String secretValue) {
		this.secretValue = secretValue;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getConfirmPassword() {
		return confirmPassword;
	}
	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}
	public boolean isReceiveNewsletter() {
		return receiveNewsletter;
	}
	public void setReceiveNewsletter(boolean receiveNewsletter) {
		this.receiveNewsletter = receiveNewsletter;
	}
	public String[] getFavFramework() {
		return favFramework;
	}
	public void setFavFramework(String[] favFramework) {
		this.favFramework = favFramework;
	}
	
	public String getPayMode() {
		return payMode;
	}
	public void setPayMode(String payMode) {
		this.payMode = payMode;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getJavaSkills() {
		return javaSkills;
	}
	public void setJavaSkills(String javaSkills) {
		this.javaSkills = javaSkills;
	}
}