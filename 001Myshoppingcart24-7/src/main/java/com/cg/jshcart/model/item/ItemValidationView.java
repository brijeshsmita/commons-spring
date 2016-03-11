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
import java.util.Date;
import javax.faces.bean.ManagedBean;
import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Future;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@ManagedBean
@ViewScoped
public class ItemValidationView implements Serializable {
	private static final long serialVersionUID = 3449038318575373535L;
	private List<Item> items;
    private int itemId;
    @Size(min=2,max=20)
	private String itemName;
	
	private Blob itemImage;
	@Min(4) @Max(10)
	private String itemSize;
	private String itemColour;
	@DecimalMax(value= "99.9", message = "Shold not exceed 99999.99")
	private String itemPrice;
	
	@Min(1) @Max(2)
	private String itemQuantity;
	@Size(max=100)
	private String itemDescription;
	/*
	 * @Digits(integer=3,fraction=2)
    private Double amount2;
     
    @AssertTrue
    private boolean checked;
 
    @Past
    private Date pastDate;
     
    @Future
    private Date futureDate;
     
    @Pattern(regexp="^[-+]?\\d+$")
    private String pattern;

	 */
    
	@ManagedProperty("#{itemService}")
    private ItemService itemService;
 
   
 
    @PostConstruct
    public void init() {
        items = itemService.getAllItems();
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
	/*private String getRandomId() {
        return UUID.randomUUID().toString().substring(0, 8);
    }*/

}

