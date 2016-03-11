package com.cg.jshcart.service.admin;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.servlet.ModelAndView;

import com.cg.jshcart.dao.admin.AdminDao;
import com.cg.jshcart.model.admin.Admin;
import com.cg.jshcart.model.category.Category;
import com.cg.jshcart.model.customer.Customer;
import com.cg.jshcart.model.item.Item;
import com.cg.jshcart.model.order.Order;

@Service
@ManagedBean(name="itemService")
@ApplicationScoped
public class ItemServiceImpl implements ItemService,Serializable{

	private static final long serialVersionUID = 905303236629208931L;
@Autowired
  private AdminDao adminDao;

	public void setAdminDao(AdminDao adminDao) {
	this.adminDao = adminDao;
}

	@Override
	public List<Item> getAllItems() {
		// TODO Auto-generated method stub
		return adminDao.getAllItems();
	}

	@Override
	public void setImage(byte[] file) {
		// TODO Auto-generated method stub
		
	}

}
