package com.cg.jshcart.model.customer;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import com.cg.jshcart.model.category.Category;
import com.cg.jshcart.model.item.Item;
import com.cg.jshcart.service.admin.AdminService;

@ManagedBean(name="userMB")
@ApplicationScoped
public class UserBean implements Serializable {
    private static final long serialVersionUID = 1L;
    private static final String SUCCESS = "success";
    private static final String ERROR   = "error";
    
    @ManagedProperty(value="#{adminService}")
    AdminService adminService;
    public AdminService getAdminService() {
		return adminService;
	}
	public void setAdminService(AdminService adminService) {
		this.adminService = adminService;
	}


	private String userName;
    private String password;
    private int userId;
    private String userFullName;
    private Category category;
    
	public String getUserFullName() {
		return userFullName;
	}
	public void setUserFullName(String userFullName) {
		this.userFullName = userFullName;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

    
    public String authenticateUser(){
    	Customer user=new  Customer();
    	user.setUsername(userName);
    	user.setPassword(password);
    	return adminService.authenticateUser(user);
    }
    public String logout(){
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        return "/pages/logout?faces-redirect=true";
     }
    
    public void getCustomerId(){
    	Customer user=new  Customer();
    	user.setUsername(userName);
    	user.setPassword(password);
    	 userId=adminService.getCustomerId(user);
    }
    public void getCustomerName(){
    	Customer user=new  Customer();
    	user.setUsername(userName);
    	user.setPassword(password);
     userFullName=adminService.getCustomerName(user);
    }
    public List<Category> getCategory(){
    	return this.adminService.viewCategory();
    }
    public List<Item> getItems() {
    	return this.adminService.getAllItems();
    }
    public List<Item> getItemsByCategory(int categoryId) {
    	return this.adminService.getItemsByCategory(categoryId);
    }
}	
		

