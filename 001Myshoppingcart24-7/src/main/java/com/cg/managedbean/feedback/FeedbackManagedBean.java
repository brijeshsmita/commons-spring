package com.cg.managedbean.feedback;
import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import org.springframework.dao.DataAccessException;

import com.cg.jshcart.service.admin.AdminService;
@ManagedBean(name="feedbackMB")
@RequestScoped
public class FeedbackManagedBean implements Serializable {
    private static final long serialVersionUID = 1L;
    private static final String SUCCESS = "success";
    private static final String ERROR   = "error";
    @ManagedProperty(value="#{adminService}")
    AdminService adminService;
    List<Feedback> feedbackList;
    private int customerId;
	private String customerName;
	private String phoneNo;
	private String address;
	private String customerEmail;
    public String addFeedback() {
        try {
            Feedback feedback = new Feedback();
            feedback.setCustomerId(getCustomerId());
            feedback.setCustomerName(getCustomerName());
            feedback.setPhoneNo(getPhoneNo());
            feedback.setAddress(getAddress());
            feedback.setCustomerEmail(getCustomerEmail());
             return SUCCESS;
        } catch (DataAccessException e) {
            e.printStackTrace();
        }   
         return ERROR;
    }
     public void reset() {
        this.getCustomerId();
        this.setCustomerName("");
        this.setPhoneNo("");
        this.setAddress("");
        this.setCustomerEmail("");
    }
 
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

	public void setFeedbackList(List<Feedback> feedbackList) {
		this.feedbackList = feedbackList;
	}
}
