package com.cg.jshcart.model.item;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
@ManagedBean(name="cartBean")
@ApplicationScoped
public class CartBean implements Serializable {
	private static final long serialVersionUID = 2525167276067373655L;
	private long cartId;
	private List<Item> cartItems;
	
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
		System.out.println("remove");
		getCartItems().remove(item);
	}
	public void addItem(Item item) {
		System.out.println(item);
		getCartItems().add(item);
		System.out.println("Added");
	}
	public String showCartItem(){
		return "cart";
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
	
}
