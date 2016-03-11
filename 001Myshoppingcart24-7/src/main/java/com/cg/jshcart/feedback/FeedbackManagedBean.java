package com.cg.jshcart.feedback;
import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;

import org.springframework.dao.DataAccessException;

import com.cg.jshcart.service.admin.AdminService;
@ManagedBean(name="feedbackBean")
@SessionScoped
public class FeedbackManagedBean implements Serializable {
    private static final long serialVersionUID = 1L;
    private static final String SUCCESS = "success";
    private static final String ERROR   = "error";
  /*  private static final String SUCCESS = "success";
    private static final String ERROR   = "error";*/
    @ManagedProperty(value="#{adminService}")
    AdminService adminService;
    
    public AdminService getAdminService() {
    	return adminService;
    	}
    	public void setAdminService(AdminService adminService) {
    		this.adminService = adminService;
    	}

    
    private List<Feedback> feedbackList;
   
	private String customerName;
	private String phoneNo;
	private String address;
	private String customerEmail;
	private String commentFeedback;
	
	
  
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
	public String getCommentFeedback() {
		return commentFeedback;
	}
	public void setCommentFeedback(String commentFeedback) {
		this.commentFeedback = commentFeedback;
	}
	public List<Feedback> getFeedbackList() {
		return feedbackList;
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

    public String addFeedback() {
 
            Feedback feedback = new Feedback();
           
            feedback.setCustomerName(customerName);
            feedback.setPhoneNo(phoneNo);
            feedback.setAddress(address);
            feedback.setCustomerEmail(customerEmail);
            feedback.setCommentFeedback(commentFeedback);
            return adminService.addFeedback(feedback);
          
    }
    /* public void reset() {
       
        this.setCustomerName("");
        this.setPhoneNo("");
        this.setAddress("");
        this.setCustomerEmail("");
        this.setCommentFeedback("");
    }
 */
}
