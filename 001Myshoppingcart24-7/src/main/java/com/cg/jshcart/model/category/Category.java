package com.cg.jshcart.model.category;


import java.util.Collection;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.cg.jshcart.model.item.Item;
@Entity
@Table(name="Category",schema="jshcart")
public class Category {
	@Id
	@Column(name="categoryId")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
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
}/*
public Collection<Item> getItemDetails() {
	return itemDetails;
}
public void setItemDetails(Collection<Item> itemDetails) {
	this.itemDetails = itemDetails;
}*/
@Override
public String toString() {
	return "Category [categoryId=" + categoryId + ", categoryName="
			+ categoryName + ", itemDetails=" +"]";
}
public Category() {
	// TODO Auto-generated constructor stub
}
public Category(String categoryName, Collection<Item> itemDetails) {
	super();
	this.categoryName = categoryName;
	/*this.itemDetails = itemDetails;*/
}


}
