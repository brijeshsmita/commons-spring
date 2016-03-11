package com.cg.jshcart.model.customer;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Customer",schema="jshcart")
@Embeddable
public class Customer implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="customerId")
	@GeneratedValue(strategy=GenerationType.IDENTITY)	
	private int customerId;
	 
	 private String customerName;
	 private Date customerDob;
	 private String phoneNo;
	 private String username;
	 private String password;
	 private String address;
	 private String customerEmail;
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public Date getCustomerDob() {
		/*java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());*/

		return customerDob;
	}
	public void setCustomerDob(Date customerDob) {
		this.customerDob = customerDob;
	}
	public String getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCustomerEmail() {
		return customerEmail;
	}
	public void setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
	}
	
public Customer() {
	// TODO Auto-generated constructor stub
}
public Customer(String customerName, Date customerDob, String phoneNo,
		String username, String password, String address, String customerEmail) {
	super();
	this.customerName = customerName;
	this.customerDob = customerDob;
	this.phoneNo = phoneNo;
	this.username = username;
	this.password = password;
	this.address = address;
	this.customerEmail = customerEmail;
}
@Override
public String toString() {
	return "Customer [customerId=" + customerId + ", customerName="
			+ customerName + ", customerDob=" + customerDob + ", phoneNo="
			+ phoneNo + ", username=" + username + ", password=" + password
			+ ", address=" + address + ", customerEmail=" + customerEmail + "]";
}

	
	
	
}
