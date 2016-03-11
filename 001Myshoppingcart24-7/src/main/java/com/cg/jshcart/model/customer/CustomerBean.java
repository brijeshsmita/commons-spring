package com.cg.jshcart.model.customer;

import java.io.Serializable;


import java.util.Date;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.cg.jshcart.service.admin.AdminService;

@ManagedBean(name="customerMB")
@SessionScoped
public class CustomerBean implements Serializable {
	private static final long serialVersionUID = 1L;

    @ManagedProperty("#{adminService}")
    private AdminService adminService;
    private int customerId;	 
	 private String customerName;
	 private Date customerDob;
	 private String phoneNo;
	 private String username;
	 private String password;
	 private String address;
	 private String customerEmail;
   
	public AdminService getAdminService() {
		return adminService;
	}
	public void setAdminService(AdminService adminService) {
		this.adminService = adminService;
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
	public String addCustomer(){
		try{
			Customer customer= new Customer();
			customer.setCustomerId(customerId);
			customer.setCustomerName(customerName);
			java.sql.Date sqlDob = new java.sql.Date(getCustomerDob().getTime());
			customer.setCustomerDob(sqlDob);
			customer.setAddress(address);
			customer.setPhoneNo(phoneNo);
			customer.setCustomerEmail(customerEmail);
			customer.setUsername(username);
			customer.setPassword(password);
			adminService.addCustomer(customer);			
			return "customerLogin";
		}catch(Exception e){
			e.printStackTrace();
			return "error";
			//throw new IllegalStateException("Wrong value has been submitted !");
		}
	}	
}
