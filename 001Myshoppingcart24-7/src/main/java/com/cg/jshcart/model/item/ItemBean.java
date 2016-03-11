package com.cg.jshcart.model.item;

import java.io.Serializable;
import java.sql.Blob;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.persistence.Lob;

import com.cg.jshcart.service.admin.AdminService;
import com.cg.jshcart.service.admin.ItemService;

@ManagedBean(name="itemBean")
@ApplicationScoped
public class ItemBean implements Serializable{
	private static final long serialVersionUID = 8794800244856508845L;
	private List<Item> items;
    private int itemId;
	private String itemName;
	private Blob itemImage;
	private double itemPrice;
	private String itemSize;
	private String itemColour;
	
	private int itemQuantity;

	private String itemDescription;
	private int categoryId;
	
	   @ManagedProperty("#{adminService}")
	    private AdminService adminService;
	   
	
    public AdminService getAdminService() {
		return adminService;
	}

	public void setAdminService(AdminService adminService) {
		this.adminService = adminService;
	}

	@ManagedProperty("#{itemService}")
    private ItemService itemService;
 
    @PostConstruct
    public void init() {
        items = itemService.getAllItems();
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

	public int getItemQuantity() {
		return itemQuantity;
	}

	public void setItemQuantity(int itemQuantity) {
		this.itemQuantity = itemQuantity;
	}

	public String getItemDescription() {
		return itemDescription;
	}

	public void setItemDescription(String itemDescription) {
		this.itemDescription = itemDescription;
	}

	public List<Item> getItems() {
        return items;
    }
 
    public void setItemService(ItemService itemService) {
        this.itemService = itemService;
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

	public double getItemPrice() {
		return itemPrice;
	}

	public void setItemPrice(double itemPrice) {
		this.itemPrice = itemPrice;
	}

	

	public void setItems(List<Item> items) {
		this.items = items;
	}
    
	public ItemService getItemService() {
		return itemService;
	}

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public String addItem(){
		Item item=new  Item();

	item.setItemName(itemName);
	item.setItemPrice(itemPrice);
	item.setItemSize(itemSize);
	item.setItemColour(itemColour);
	item.setItemQuantity(itemQuantity);
	item.setItemDescription(itemDescription);
	item.setCategoryId(categoryId);
          return adminService.addItem(item);
          
		}
	
	public void getAllItems(){
		items=itemService.getAllItems();
	}
	
	public void deleteItem(Item item){
		adminService.deleteItem(item);
	}
	
	public String  getItemById(int id){
		
		Item item=new Item();
		item.setItemName(itemName);
		item.setItemPrice(itemPrice);
		item.setItemSize(itemSize);
		item.setItemColour(itemColour);
		item.setItemQuantity(itemQuantity);
		item.setItemDescription(itemDescription);
		item.setCategoryId(categoryId);
		
		return adminService.getItemById(id);
	}
	
	public String updateItem(){
		
		Item item= new Item();
		
		item.setItemName(itemName);
		item.setItemPrice(itemPrice);
		item.setItemSize(itemSize);
		item.setItemColour(itemColour);
		item.setItemQuantity(itemQuantity);
		item.setItemDescription(itemDescription);
		item.setCategoryId(categoryId);
		
		return adminService.updateItem(item);
	
		
		
		
		
		
	}
}
