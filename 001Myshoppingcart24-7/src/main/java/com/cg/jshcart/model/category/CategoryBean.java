package com.cg.jshcart.model.category;


import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.cg.jshcart.model.admin.Admin;
import com.cg.jshcart.model.item.Item;
import com.cg.jshcart.service.admin.AdminService;

@ManagedBean(name="categoryBean")
@SessionScoped
public class CategoryBean implements Serializable{

	private static final long serialVersionUID = 1749406623125246599L;
	
	
	@ManagedProperty("#{adminService}")
    private AdminService adminService;
	
	 
    public AdminService getAdminService() {
		return adminService;
	}
	public void setAdminService(AdminService adminService) {
		this.adminService = adminService;
	}
private List<Category> categories;
private int categoryId;
private String categoryName;


/*private Collection<Item> itemDetails;*/
public int getCategoryId() {
	return categoryId;
}
public void setCategoryId(int categoryId) {
	this.categoryId = categoryId;
}
public String getCategoryName() {
	return categoryName;
}
public void setCategoryName(String categoryName) {
	this.categoryName = categoryName;
}

public List<Category> getCategories() {
	return categories;
}
public void setCategories(List<Category> categories) {
	this.categories = categories;
}
public void addCategory(){
	Category category=new  Category();

	category.setCategoryName(categoryName);

	adminService.addCategory(category);

	}

public void getAllCategory(){

	 categories=adminService.viewCategory();
}

public void deleteCategory(Category category){

	adminService.deleteCategory(category);
	
}
	
public void updateCategory(Category category){
	Category category1=new  Category();
	
	category.setCategoryId(categoryId);
	category.setCategoryName(categoryName);
	adminService.updateCategory(category1);
		
		
		
	}
	
	
	
}




