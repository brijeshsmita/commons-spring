package com.cg.jshcart.model.admin;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.cg.jshcart.service.admin.AdminService;

@ManagedBean(name="adminMB")
@SessionScoped
public class AdminBean implements Serializable {
    private static final long serialVersionUID = 1L;
    private static final String SUCCESS = "adminPage4";
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

    
    public String authenticate(){
    	Admin admin=new  Admin();
    	admin.setUserName(userName);
    	admin.setPassword(password);
    	return adminService.authenticateAdmin(admin); 	
   
    }
    public String logout(){
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        return "/pages/logout?faces-redirect=true";
     }

}	
		

