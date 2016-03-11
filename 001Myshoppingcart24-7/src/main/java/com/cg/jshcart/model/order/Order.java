package com.cg.jshcart.model.order;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.cg.jshcart.model.customer.Customer;
import com.cg.jshcart.model.item.Item;

@Entity
@Table(name="Order",schema="jshCart")

public class Order implements Serializable
{
	private static final long serialVersionUID = 4027658618922733253L;
	@Id
	@Column(name="orderId")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int orderId;
	private Date orderDate;
	private Date orderShippingDate;
	private Date deliveryDate;
	private double amountpayable;
	private String status;
	private double discount;
	
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "customerId")
	private Customer customer;
	
	@OneToMany(cascade=CascadeType.ALL)
	@JoinTable(name="Order_Details",
	joinColumns={ @JoinColumn(name="orderId")},
	inverseJoinColumns={ @JoinColumn(name="itemId")})

	List<Item> items;
	public Order() {
		// TODO Auto-generated constructor stub
	}
	public Order(int orderId, Date orderDate, Date orderShippingDate,
			Date deliveryDate, double amountpayable, String status,
			double discount, Customer customer, int itemId, List<Item> items) {
		super();
		this.orderId = orderId;
		this.orderDate = orderDate;
		this.orderShippingDate = orderShippingDate;
		this.deliveryDate = deliveryDate;
		this.amountpayable = amountpayable;
		this.status = status;
		this.discount = discount;
		this.customer = customer;
		this.items = items;
	}
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public Date getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}
	public Date getOrderShippingDate() {
		return orderShippingDate;
	}
	public void setOrderShippingDate(Date orderShippingDate) {
		this.orderShippingDate = orderShippingDate;
	}
	public Date getDeliveryDate() {
		return deliveryDate;
	}
	public void setDeliveryDate(Date deliveryDate) {
		this.deliveryDate = deliveryDate;
	}
	public double getAmountpayable() {
		return amountpayable;
	}
	public void setAmountpayable(double amountpayable) {
		this.amountpayable = amountpayable;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public double getDiscount() {
		return discount;
	}
	public void setDiscount(double discount) {
		this.discount = discount;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public List<Item> getItemId() {
		return items;
	}
	public void setItemId(List<Item> items) {
		this.items = items;
	}
	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", orderDate=" + orderDate
				+ ", orderShippingDate=" + orderShippingDate
				+ ", deliveryDate=" + deliveryDate + ", amountpayable="
				+ amountpayable + ", status=" + status + ", discount="
				+ discount + ", customer=" + customer + ", itemId="
				+ items + "]";
	}
	

}
