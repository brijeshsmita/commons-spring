package com.cg.jshcart.model.customer;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;



import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import com.cg.jshcart.model.item.Item;
import com.cg.jshcart.model.order.OrderBean;
import com.cg.jshcart.service.admin.AdminService;
@ManagedBean(name="cartBean")
@ApplicationScoped
public class CartBean implements Serializable {
	private static final long serialVersionUID = 2525167276067373655L;
	private long cartId;
	private List<Item> cartItems;
    @ManagedProperty("#{adminService}")
    private AdminService adminService;
 
    @ManagedProperty("#{orderBean}")
    private OrderBean orderBean;
	public AdminService getAdminService() {
		return adminService;
	}
	public void setAdminService(AdminService adminService) {
		this.adminService = adminService;
	}
	public long getCartId() {
		return cartId;
	}
	public void setCartId(long cartId) {
		this.cartId = cartId;
	}
	public List<Item> getCartItems() {
		if (cartItems == null) {
			cartItems = new ArrayList<Item>();
		}
		return cartItems;
	}
	public void setCartItems(List<Item> cartItems) {
		this.cartItems = cartItems;
	}
	@Override
	public String toString() {
		return "CartBean [cartId=" + cartId + ", cartItems=" + cartItems + "]";
	}
	
	
	public void removeItem(Item item) {
		System.out.println("rem");
		getCartItems().remove(item);
	}
	public void addItem(Item item) {
		System.out.println(item);
		getCartItems().add(item);
		System.out.println("Added");
	}

	public void empty() {
		setCartItems(new ArrayList<Item>());
	}

	public double getBalance() {
		double balance = 0;
		for (Item item : getCartItems()) {
			balance = balance + item.getItemPrice();
		}
		return balance;
	}
	public int getItemCount() {
		return getCartItems().size();
	}
	public String showCartItem(){
		orderBean.setCartItems(cartItems);
		return "cart";
	}
	public OrderBean getOrderBean() {
		return orderBean;
	}
	public void setOrderBean(OrderBean orderBean) {
		this.orderBean = orderBean;
	}
	
}
