package com.cg.jshcart.model.item;

import java.io.Serializable;
import java.sql.Blob;
import java.util.List;
import java.util.UUID;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.persistence.Lob;

import com.cg.jshcart.service.admin.ItemService;

@ManagedBean(name="itemBeanCarousel")
@ViewScoped
public class ItemBeanCarousel implements Serializable {
	private static final long serialVersionUID = 3449038318575373535L;
	private List<Item> items;
    private int itemId;
	private String itemName;
	@Lob
	private Blob itemImage;
	private String itemSize;
	private String itemColour;
	private String itemPrice;
	private String itemQuantity;
	private String itemDescription;
	
    @ManagedProperty("com.cg.jshcart.service.admin.ItemService@df48e2")
    private ItemService itemService;
 
    private Item selectedItem;
    
    @PostConstruct
    public void init() {
        items = itemService.getAllItems();
    }
    
     
    public Item getSelectedItem() {
		return selectedItem;
	}


	public void setSelectedItem(Item selectedItem) {
		this.selectedItem = selectedItem;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
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

	public String getItemPrice() {
		return itemPrice;
	}

	public void setItemPrice(String itemPrice) {
		this.itemPrice = itemPrice;
	}

	public String getItemQuantity() {
		return itemQuantity;
	}

	public void setItemQuantity(String itemQuantity) {
		this.itemQuantity = itemQuantity;
	}

	public String getItemDescription() {
		return itemDescription;
	}

	public void setItemDescription(String itemDescription) {
		this.itemDescription = itemDescription;
	}

	public ItemService getItemService() {
		return itemService;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}
	private String getRandomId() {
        return UUID.randomUUID().toString().substring(0, 8);
    }

}

