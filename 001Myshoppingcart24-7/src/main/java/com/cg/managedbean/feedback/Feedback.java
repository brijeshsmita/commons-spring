package com.cg.managedbean.feedback;

import java.io.Serializable;
import java.sql.Date;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Feedback",schema="jshcart")
@ManagedBean(name="feedback")
@SessionScoped
public class Feedback implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="customerId")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int customerId;
	 
	 private String customerName;
	 private String phoneNo;
	 private String address;
	 private String customerEmail;
	
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
	
public Feedback() {
	// TODO Auto-generated constructor stub
}
public Feedback(String customerName,String phoneNo,String address, String customerEmail) {
	super();
	this.customerName = customerName;
	this.phoneNo = phoneNo;
	this.address = address;
	this.customerEmail = customerEmail;
}
@Override
public String toString() {
	return "Feedback [customerId=" + customerId + ", customerName="
			+ customerName + ", phoneNo="	+ phoneNo + ", address=" + address + ", customerEmail=" + customerEmail + "]";
}

	
	
	
}
