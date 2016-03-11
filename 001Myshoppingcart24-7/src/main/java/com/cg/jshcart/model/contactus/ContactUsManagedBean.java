package com.cg.jshcart.model.contactus;
import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.dao.DataAccessException;

import com.cg.jshcart.service.admin.AdminService;

@ManagedBean(name="contactMB")
@RequestScoped
public class ContactUsManagedBean implements Serializable {
    private static final long serialVersionUID = 1L;
    private static final String SUCCESS = "success";
    private static final String ERROR   = "error";
    
    @ManagedProperty(value="#{adminService}")
    AdminService adminService;
  // List<ContactUs> contactUsList;
   
    private String name;
    private String email;
    private String phoneNo;

    public String addContactUs() {
   
            ContactUs contactUs = new ContactUs();
            contactUs.setName(getName());
            contactUs.setEmail(getEmail());
            contactUs.setPhoneNo(getPhoneNo());
            return adminService.addContactUs(contactUs);
    
    }
     public void reset() {
        this.setName("");
        this.setEmail("");;
        this.setPhoneNo("");
        
    }
	
	public void setAdminService(AdminService adminService) {
		this.adminService = adminService;
	}
	
	public String addContactUs(ContactUs contactUs){
		 return this.adminService.addContactUs(contactUs);
	}
	/*public List<ContactUs> getContactUsList() {
		return contactUsList;
	}
	public void setContactUsList(List<ContactUs> contactUsList) {
		this.contactUsList = contactUsList;
	}*/
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}
}
  