package com.cg.jshcart.model.order;

import java.io.Serializable;
import java.sql.Date;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import com.cg.jshcart.model.customer.Customer;
import com.cg.jshcart.model.item.Item;
import com.cg.jshcart.service.admin.AdminService;




@ManagedBean(name="orderBean")
@ApplicationScoped
public class OrderBean implements Serializable
{
	private static final long serialVersionUID = -6751207249767336756L;
	
	   @ManagedProperty("#{adminService}")
	    private AdminService adminService;
	    private Customer customer;
	    private List<Item> cartItems;
	    
	    @ManagedProperty("#{order}")
	    private Order order;
	    
	
	    
	    
	   
	    //checkout will place order by calling adminService.placeOrder
	public String checkOut(int customerId,List<Item> cartItems){
		System.out.println(customerId);
		this.order=new Order();
		this.cartItems=cartItems;
		double amount,totalAmount=0;
		
		//calculate amount for each item
		for(Item item : cartItems){
			amount=item.getItemPrice();
			totalAmount+=amount;//calculate totalOrderAmount
			
		}
		
		//apply discount
		if(totalAmount>1000){
			order.setDiscount(totalAmount*5/100);
			totalAmount=totalAmount-order.getDiscount();//5% discount
			
		}else if(totalAmount>5000){
			order.setDiscount(totalAmount*10/100);
			totalAmount=totalAmount-order.getDiscount();//10% discount
		}else if(totalAmount>10000){
			order.setDiscount(totalAmount*20/100);
			totalAmount=totalAmount-order.getDiscount();//20% discount
		}
//setting total Amount Payable 
		order.setAmountpayable(totalAmount);
		System.out.println("Total Bill Amount ="+totalAmount);
		java.util.Date date = new java.util.Date();
		    GregorianCalendar calendar = new GregorianCalendar();
		    calendar.setTime(date);
		Calendar cNow = calendar;  
        java.util.Date dNow = cNow.getTime();
//dNow s date converted into sql date
        Date orderDate=new Date(dNow.getTime());
		order.setOrderDate(orderDate);
//shipping date will be after 2 days        
        cNow.add(Calendar.DATE, 3);  
        Date shippingDate= new Date(cNow.getTime().getTime());
		order.setOrderShippingDate(shippingDate);
//delivery date will be after 7 days of placing order
		cNow.add(Calendar.DATE, 7);  
        Date deliveryDate= new Date(cNow.getTime().getTime());
		order.setDeliveryDate(deliveryDate);
		order.setStatus("pending");
		customer=adminService.getCustomerById(customerId);
		System.out.println(customer);
		order.setCustomer(customer);
		order.setItemId(cartItems);
		
		//applyDiscount
		adminService.placeOrder(order);
		return "showorder";		
	}
	public AdminService getAdminService() {
		return adminService;
	}
	public void setAdminService(AdminService adminService) {
		this.adminService = adminService;
	}
	public List<Item> getCartItems() {
		return cartItems;
	}
	public void setCartItems(List<Item> cartItems) {
		this.cartItems = cartItems;
	}
	public Order getOrder() {
		return order;
	}
	public void setOrder(Order order) {
		this.order = order;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
}
