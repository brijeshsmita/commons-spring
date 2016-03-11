package com.cg.jshcart.service.admin;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;







import com.cg.jshcart.dao.admin.AdminDao;
import com.cg.jshcart.feedback.Feedback;
import com.cg.jshcart.model.admin.Admin;
import com.cg.jshcart.model.category.Category;
import com.cg.jshcart.model.contactus.ContactUs;
import com.cg.jshcart.model.customer.Customer;
import com.cg.jshcart.model.item.Item;
import com.cg.jshcart.model.order.Order;


@Service
@ManagedBean(name="adminService")
@ApplicationScoped
public class AdminServiceImpl implements AdminService,Serializable {

	private static final long serialVersionUID = -5548949034111445521L;
@Autowired
  private AdminDao adminDao;
  
	@Override
	@Transactional
	public void addAdmin(Admin admin) {
		this.adminDao.addAdmin(admin);
		
	}
	public AdminDao getAdminDao() {
		return adminDao;
	}
	public void setAdminDao(AdminDao adminDao) {
		this.adminDao = adminDao;
	}
	@Override
	public String authenticateAdmin(Admin admin) {
		return this.adminDao.authenticateAdmin(admin);
		
	}
	@Override
	public Customer getCustomerById(int id) {
		return this.adminDao.getCustomerById(id);
	}
	@Override
	public Category getCategoryById(int id) {
		
		return this.adminDao.getCategoryById(id);
	}
	@Override
	public String addCategory(Category category) {
		
		return this.adminDao.addCategory(category);
	}
	@Override
	public int updateCategory(Category category) {
		
		return this.adminDao.updateCategory(category);
	}
	@Override
	public int deleteCategory(Category category) {
		
		return this.adminDao.deleteCategory(category);
	}
	@Override
	public String getItemById(int id) {
		
		return this.adminDao.getItemById(id);
	}
	@Override
	public String addItem(Item item) {
		
		return this.adminDao.addItem(item);
	}
	@Override
	public String updateItem(Item item) {
		
		return this.adminDao.updateItem(item);
	}
	@Override
	public int deleteItem(Item item) {
		
		return this.adminDao.deleteItem(item);
	}
	@Override
	public int setDiscountCoupon() {
		
		return this.adminDao.setDiscountCoupon();
	}
	@Override
	public List<Order> getPendingOrder(String status) {
		
		return this.adminDao.getPendingOrder(status);
	}
	@Override
	public List<Order> getCompletedOrder(String status) {
		
		return this.adminDao.getCompletedOrder(status);
	}
	
	@Override
	public void addCustomer(Customer customer) {
		this.adminDao.addCustomer(customer);
		
	}

	@Override
	public void updateCustomer(Customer customer) {
		this.adminDao.updateCustomer(customer);
		
	}

	@Override
	public List<Category> viewCategory() {
		return this.adminDao.viewCategory();
		
	}

	@Override
	public List<Order> viewOrderById(int customerId) {
		return this.adminDao.viewOrderById(customerId);
		
	}

	@Override
	public void placeOrder(Order order) {
		this.adminDao.placeOrder(order);
		
	}
	@Override
	public String addFeedback(Feedback feedback) {
		return getAdminDao().addFeedback(feedback);
		
	}

	@Override
	public String authenticateUser(Customer user) {
		
		return adminDao.authenticateUser(user);
	}
	@Override
	public List<Item> getAllItems() {
		
		return this.adminDao.getAllItems();
	}
	@Override
	public int getCustomerId(Customer user) {
		// TODO Auto-generated method stub
		return this.adminDao.getCustomerId(user);
	}
	@Override
	public String getCustomerName(Customer user) {
		// TODO Auto-generated method stub
		return this.adminDao.getCustomerName(user);
	}
	@Override
	public List<Item> getItemsByCategory(int categoryId)  {
		// TODO Auto-generated method stub
		return this.adminDao.getItemsByCategory(categoryId);
	}
	@Override
	public String addContactUs(ContactUs contactUs) {
		
		return adminDao.addContactUs(contactUs);
	}
	
}
