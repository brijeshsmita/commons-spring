package com.cg.jshcart.feedback;

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
public class Feedback implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;	
	 private String customerName;
	 private String phoneNo;
	 private String address;
	 private String customerEmail;
	 private String commentFeedback;

	
public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
public Feedback() {
	// TODO Auto-generated constructor stub
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
public String getCommentFeedback() {
	return commentFeedback;
}
public void setCommentFeedback(String commentFeedback) {
	this.commentFeedback = commentFeedback;
}
@Override
public String toString() {
	return "Feedback [customerName=" + customerName + ", phoneNo=" + phoneNo
			+ ", address=" + address + ", customerEmail=" + customerEmail
			+ ", commentFeedback=" + commentFeedback + "]";
}


}

	
	
	

