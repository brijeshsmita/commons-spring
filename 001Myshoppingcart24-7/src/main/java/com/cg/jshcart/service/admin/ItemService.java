package com.cg.jshcart.service.admin;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.cg.jshcart.model.admin.Admin;
import com.cg.jshcart.model.category.Category;
import com.cg.jshcart.model.customer.Customer;
import com.cg.jshcart.model.item.Item;
import com.cg.jshcart.model.order.Order;

@Service
public interface ItemService {
	
	public List<Item> getAllItems();

	public void setImage(byte[] file);
}
	