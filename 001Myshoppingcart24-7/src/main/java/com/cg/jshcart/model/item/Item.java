package com.cg.jshcart.model.item;

import java.sql.Blob;
import java.util.Arrays;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
@Entity
@Table(name="Item",schema="jshcart")
public class Item {


	@Id
	@Column(name="itemId")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int itemId;
	private String itemName;
	@Lob
	private Blob itemImage;
	private String itemSize;
	private String itemColour;
	private double itemPrice;
	private int itemQuantity;
	private int categoryId;
	private String itemDescription;
	
	
	public Item() {
		// TODO Auto-generated constructor stub
	}
	
	
	public int getCategoryId() {
		return categoryId;
	}


	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}


	public String getItemDescription() {
		return itemDescription;
	}
	
	
	public void setItemDescription(String itemDescription) {
		this.itemDescription = itemDescription;
	}
	
	

	
	
	public Item(int itemId, String itemName, Blob itemImage, String itemSize,
			String itemColour, double itemPrice, int itemQuantity,
			int categoryId, String itemDescription) {
		super();
		this.itemId = itemId;
		this.itemName = itemName;
		this.itemImage = itemImage;
		this.itemSize = itemSize;
		this.itemColour = itemColour;
		this.itemPrice = itemPrice;
		this.itemQuantity = itemQuantity;
		this.categoryId = categoryId;
		this.itemDescription = itemDescription;
	}


	public int getItemId() {
		return itemId;
	}
	
	
	public void setItemId(int itemId) {
		this.itemId = itemId;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public Blob getItemImage() {
		return itemImage;
	}
	public void setItemImage(Blob itemImage) {
		this.itemImage = itemImage;
	}
	
	public String getItemSize() {
		return itemSize;
	}
	public void setItemSize(String itemSize) {
		this.itemSize = itemSize;
	}
	public String getItemColour() {
		return itemColour;
	}
	public void setItemColour(String itemColour) {
		this.itemColour = itemColour;
	}
	
	
	public double getItemPrice() {
		return itemPrice;
	}
	
	
	public void setItemPrice(double itemPrice) {
		this.itemPrice = itemPrice;
	}
	
	
	public int getItemQuantity() {
		return itemQuantity;
	}
	
	
	public void setItemQuantity(int itemQuantity) {
		this.itemQuantity = itemQuantity;
	}


	@Override
	public String toString() {
		return "Item [itemId=" + itemId + ", itemName=" + itemName
				+ ", itemImage=" + itemImage + ", itemSize=" + itemSize
				+ ", itemColour=" + itemColour + ", itemPrice=" + itemPrice
				+ ", itemQuantity=" + itemQuantity + ", categoryId="
				+ categoryId + ", itemDescription=" + itemDescription + "]";
	}
	
	
	



}
