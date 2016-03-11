package com.cg.jshcart.service.admin;

import java.util.List;

import org.springframework.stereotype.Service;







import com.cg.jshcart.feedback.Feedback;
import com.cg.jshcart.model.admin.Admin;
import com.cg.jshcart.model.category.Category;
import com.cg.jshcart.model.contactus.ContactUs;
import com.cg.jshcart.model.customer.Customer;
import com.cg.jshcart.model.item.Item;
import com.cg.jshcart.model.order.Order;


@Service
public interface AdminService {
	public void addAdmin(Admin admin);
	public String authenticateAdmin(Admin admin);
	public String authenticateUser(Customer user);
	
	public Customer getCustomerById(int id);
	public Category getCategoryById(int id);
	
	public String addCategory(Category category);
	public int updateCategory(Category category);
	public String addItem(Item item);
	public int deleteCategory(Category category);
	public List<Category> viewCategory();
	
	public List<Item> getItemsByCategory(int categoryId);


	public String getItemById(int id);

	public String updateItem(Item item);
	public int deleteItem(Item item);
	public int setDiscountCoupon();
	public List<Order> getPendingOrder(String status);
	public List<Order> getCompletedOrder(String status);
	
	public void addCustomer(Customer customer);
	public void updateCustomer(Customer customer);
	
	public List<Order> viewOrderById(int orderId);
	public void placeOrder(Order order);
	public List<Item> getAllItems();
	
	public String addFeedback(Feedback feedback);

	public int getCustomerId(Customer user);
	public String getCustomerName(Customer user);
	public String addContactUs(ContactUs contactUs);
}
	