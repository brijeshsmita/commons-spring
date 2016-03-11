 package com.cg.jshcart.dao.admin;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ApplicationScoped;
import javax.faces.context.FacesContext;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;




import com.cg.jshcart.feedback.Feedback;
import com.cg.jshcart.model.admin.Admin;
import com.cg.jshcart.model.category.Category;
import com.cg.jshcart.model.contactus.ContactUs;
import com.cg.jshcart.model.customer.Customer;
import com.cg.jshcart.model.customer.CustomerBean;
import com.cg.jshcart.model.item.Item;
import com.cg.jshcart.model.order.Order;


@Repository
@ApplicationScoped
public class AdminDaoImpl implements AdminDao {
	
	private static final Logger logger = LoggerFactory.getLogger(AdminDaoImpl.class);
	private static final String SUCCESS = "success"; 
	private static final String SUCCESS1 = "success1";
	@Autowired
    private SessionFactory sessionFactory;
	CustomerBean cust1=new CustomerBean();
    public void setSessionFactory(SessionFactory sf){
        this.sessionFactory = sf;
    }
	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<Item> getAllItems() {
		Session session=this.sessionFactory.openSession();
		List<Item> itemList = session.createQuery("from Item").list();
	        
        if (itemList.size() > 0){
        	for(Item item : itemList){
	            logger.info("Item List::"+item);
	        }
        }else{
			FacesContext.getCurrentInstance().addMessage(
	                null,
	                new FacesMessage(FacesMessage.SEVERITY_WARN,
	                "No Item Found!",
	                "Please Try Again!"));
		}
        return itemList;
	}

		
	@Override
	public void addAdmin(Admin admin) {
		/*Session session=this.sessionFactory.getCurrentSession();
		session.persist(admin);
		Logger.info("Customer Saved Successfully , Customer Details="+admin);
*/
		}

	@Override
	public String authenticateAdmin(Admin admin) {

		System.out.println("Authenticating "+admin);
		Session session=((SessionFactory) this.sessionFactory).openSession();
		Admin admin1;
		
		List<Admin> adminList = new ArrayList<Admin>();
		String userName=admin.getUserName();
		String password=admin.getPassword();
        Query query = session.createQuery("from Admin u where u.userName = :userName and u.password= :password");
        query.setParameter("userName", userName);
        query.setParameter("password", password);
        adminList = query.list();
        
        if (adminList.size() > 0){
        	admin1= adminList.get(0);
			System.out.println("success "+admin1); 	
			return "adminPage";
		}else{
			FacesContext.getCurrentInstance().addMessage(
	                null,
	                new FacesMessage(FacesMessage.SEVERITY_WARN,
	                "Invalid Admin credentials!",
	                "Please Try Again!"));
	        return "adminLogin";
		}
	}

	
	
	@Override
	public Customer getCustomerById(int id) {
		System.out.println(id);
		System.out.println("authenticate");
		Session session=this.sessionFactory.openSession();
		Customer cust;
	
		cust=(Customer) session.get(Customer.class, id);
		 if (cust==null){
				FacesContext.getCurrentInstance().addMessage(
		                null,
		                new FacesMessage(FacesMessage.SEVERITY_WARN,
		                "Invalid Customer ID!",
		                "Please Try Again!"));
			}
		session.close();
		System.out.println(cust);
		return cust;
	}
	@Override
	public Category getCategoryById(int id) {
		System.out.println(id);
		System.out.println("authenticate");
		Session session=this.sessionFactory.openSession();
		Category ad;
	
		ad=(Category) session.get(Category.class, id);
		
		session.close();
		System.out.println(ad);
		return ad;
	}

	@Override
	public String addCategory(Category category) {
		System.out.println("12");
		Session session=this.sessionFactory.openSession();
		session.beginTransaction();
		Integer id=(Integer) session.save(category);
		category.setCategoryId(id);
		session.getTransaction().commit();
		session.close();
		System.out.println(category);
		return "welcomePage";

	}

	@Override
	public int updateCategory(Category category) {
		System.out.println("12");
		Session session=this.sessionFactory.openSession();
		session.beginTransaction();
		try{
			session.update(category);	
			session.getTransaction().commit();
		}catch(Exception e){
			FacesContext.getCurrentInstance().addMessage(
	                null,
	                new FacesMessage(FacesMessage.SEVERITY_WARN,
	                "Invalid Category details!",
	                "Please Try Again!"));
		}
		session.close();
		System.out.println(category);
		return 0;
	}

	
	@Override
	public int deleteCategory(Category category) {
		System.out.println("12");
		Session session=this.sessionFactory.openSession();
		session.beginTransaction();
	session.delete(category);
	
		session.getTransaction().commit();
		session.close();
		System.out.println(category);		return 0;
	}


	


	
	@Override
	public int deleteItem(Item item) {
		try{
			Session session=this.sessionFactory.openSession();
			
			session.beginTransaction();
			session.delete(item);
		
			session.getTransaction().commit();
			session.close();
			}catch(Exception e){
				FacesContext.getCurrentInstance().addMessage(
		                null,
		                new FacesMessage(FacesMessage.SEVERITY_WARN,
		                "Invalid item details!",
		                "Please Try Again!"));
			}		return 0;
	}

	@Override
	public int setDiscountCoupon() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Order> getPendingOrder(String status) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Order> getCompletedOrder(String status) {
		// TODO Auto-generated method stub
		return null;
	}

/*	@Override
	public List<Order> getPendingOrder(String status) {
		
		Session session=this.sessionFactory.openSession();
		Criteria cr = session.createCriteria(Order.class);
		cr.add(Restrictions.eq("status", status));
		cr.add(Restrictions.eq("customerId", 1));
		List results = cr.list();
		 for (Iterator iterator = 
                 results.iterator(); iterator.hasNext();){
			 Order order = (Order) iterator.next(); 
			 System.out.print("OrderId: " + order.getCustomerId()); 
			  System.out.print(" OrderDate: " + order.getStatus()); 
			  System.out.println(" OrderShippingDate: " + order.getItemId()); 
			  System.out.println(" deliveryDate: " + order.getItemId()); 
			  System.out.println(" Amountpayable: " + order.getItemId()); 
			  System.out.println(" Status: " + order.getItemId()); 
			  System.out.println(" Discount: " + order.getItemId()); 
			  System.out.println(" CustomerId: " + order.getItemId()); 
			  System.out.println(" ItemId " + order.getItemId()); 
}
		return results;
	}
	*/
	@Override
	public void addCustomer(Customer customer) {
		Session session=this.sessionFactory.openSession();
		session.beginTransaction();
		
		Integer result=(Integer) session.save(customer);
		if (result<1){
			FacesContext.getCurrentInstance().addMessage(
	                null,
	                new FacesMessage(FacesMessage.SEVERITY_WARN,
	                "Invalid Customer Deatils!",
	                "Please Try Again!"));
		}
		session.getTransaction().commit();
		session.close();
		System.out.println(customer);	
	}

	@Override
	public void updateCustomer(Customer customer) {
		try{
			Session session=this.sessionFactory.openSession();
			session.beginTransaction();
		
			session.update(customer);	
			session.getTransaction().commit();
			session.close();
		}catch(Exception e){
			FacesContext.getCurrentInstance().addMessage(
	                null,
	                new FacesMessage(FacesMessage.SEVERITY_WARN,
	                "Invalid Customer details!",
	                "Please Try Again!"));
		}
		System.out.println(customer);
		
	}

	@Override
	public List<Category> viewCategory() {
		Session session=this.sessionFactory.openSession();
		session.beginTransaction();
		@SuppressWarnings("unchecked")
		List<Category> categoryList = session.createQuery("from Category")
				.list();
		System.out.println(categoryList);
		if (categoryList.size() <1){
			FacesContext.getCurrentInstance().addMessage(
	                null,
	                new FacesMessage(FacesMessage.SEVERITY_WARN,
	                "Invalid Customer Id!",
	                "Please Try Again!"));
		}
		return categoryList;
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<Order> viewOrderById(int customerId) {
		Session session=this.sessionFactory.openSession();
		Criteria cr = session.createCriteria(Order.class);
		cr.add(Restrictions.eq("customerId",customerId));
		List<Order> results = cr.list(); 
		 
		 for (Iterator<Order> iterator = results.iterator();iterator.hasNext();){
		 	  Order order = (Order) iterator.next(); 
		      System.out.print("Customer Name: " + order.getCustomer().getCustomerName());
		      System.out.print("Order Id: " + order.getOrderId());
		      System.out.println("Status: " + order.getStatus());
		 }
		if (results.size() <1){
			FacesContext.getCurrentInstance().addMessage(
	                null,
	                new FacesMessage(FacesMessage.SEVERITY_WARN,
	                "Invalid Customer Id!",
	                "Please Try Again!"));
		}
		 return results;		
	}
	@Override
	public void placeOrder(Order order) {
		Session session=this.sessionFactory.openSession();
		session.beginTransaction();
		Integer result=(Integer) session.save(order);
		session.getTransaction().commit();
		session.close();
		if(result<1){
			FacesContext.getCurrentInstance().addMessage(
	                null,
	                new FacesMessage(FacesMessage.SEVERITY_WARN,
	                "Invalid Order Details!",
	                "Please Try Again!"));
		}
	}
	@Override
	public String addFeedback(Feedback feedback) {
		Session session=this.sessionFactory.openSession();
		session.beginTransaction();
		Integer result=(Integer) session.save(feedback);
		//session.save(feedback);
		session.getTransaction().commit();
		session.close();	
		if(result<1){
			FacesContext.getCurrentInstance().addMessage(
	                null,
	                new FacesMessage(FacesMessage.SEVERITY_WARN,
	                "Invalid Contact Details!",
	                "Please Try Again!"));
		}
		return SUCCESS;
		
	}
	@Override
	public String addContactUs(ContactUs contactUs) {
		Session session=this.sessionFactory.openSession();
		session.beginTransaction();
		Integer result=(Integer) session.save(contactUs);
		session.getTransaction().commit();
		session.close();
		if(result<1){
			FacesContext.getCurrentInstance().addMessage(
	                null,
	                new FacesMessage(FacesMessage.SEVERITY_WARN,
	                "Invalid Contact Details!",
	                "Please Try Again!"));
		}
		return SUCCESS1;
	}
	@Override
	public String authenticateUser(Customer user) {
		System.out.println("Authenticating "+user);
		Session session=((SessionFactory) this.sessionFactory).openSession();
		Customer cust;
		
		List<Customer> custList = new ArrayList<Customer>();
		String username=user.getUsername();
		String password=user.getPassword();
        Query query = session.createQuery("from Customer u where u.username = :username and u.password= :password");
        query.setParameter("username", username);
        query.setParameter("password", password);
        custList = query.list();
        
        if (custList.size() > 0){
        	cust= custList.get(0);
			System.out.println("success "+cust); 
		
			cust1.setCustomerId(cust.getCustomerId());
			cust1.setCustomerName(cust.getCustomerName());
			return "welcome";
		}else{
			FacesContext.getCurrentInstance().addMessage(
	                null,
	                new FacesMessage(FacesMessage.SEVERITY_WARN,
	                "Invalid Login!",
	                "Please Try Again!"));
	        return "customerLogin";
		}
	}
	@Override
	public int getCustomerId(Customer user) {
		Session session=((SessionFactory) this.sessionFactory).openSession();
		Customer cust;
		
		List<Customer> custList = new ArrayList<Customer>();
		String username=user.getUsername();
		String password=user.getPassword();
        Query query = session.createQuery("from Customer u where u.username = :username and u.password= :password");
        query.setParameter("username", username);
        query.setParameter("password", password);
        custList = query.list();
        if(custList.size()>0){
	    	cust= custList.get(0);
			System.out.println("Got "+cust); 		
			session.close();
			return cust.getCustomerId();
        }else{
			FacesContext.getCurrentInstance().addMessage(
	                null,
	                new FacesMessage(FacesMessage.SEVERITY_WARN,
	                "Invalid Customer Id!",
	                "Please Try Again!"));
	        return 0;
		}
	}
	
	@Override
	public String getCustomerName(Customer user) {
		Session session=((SessionFactory) this.sessionFactory).openSession();
		Customer cust;
		
		List<Customer> custList = new ArrayList<Customer>();
		String username=user.getUsername();
		String password=user.getPassword();
        Query query = session.createQuery("from Customer u where u.username = :username and u.password= :password");
        query.setParameter("username", username);
        query.setParameter("password", password);
        custList = query.list();
        if(custList.size()>0){
	    	cust= custList.get(0);
			System.out.println("Got "+cust); 		
			session.close();
			System.out.println(cust);
			return cust.getCustomerName();
        }else{
			FacesContext.getCurrentInstance().addMessage(
	                null,
	                new FacesMessage(FacesMessage.SEVERITY_WARN,
	                "Invalid Customer Name!",
	                "Please Try Again!"));
	        return "adminPage";
		}
	}
	@Override
	public List<Item> getItemsByCategory(int categoryId) {
		System.out.println(categoryId);
		Session session=this.sessionFactory.openSession();
		List<Item> itemList;
		Query query = session.createQuery("from Item u where u.categoryId = :categoryId");
        query.setParameter("categoryId", categoryId);
        itemList = query.list();
        
        if (itemList.size() > 0){
			System.out.println("Got Items By Category "+itemList); 
		}else{
			FacesContext.getCurrentInstance().addMessage(
	                null,
	                new FacesMessage(FacesMessage.SEVERITY_WARN,
	                "Ivalid CategoryId!",
	                "Please Try Again!"));
		}
		session.close();
		return itemList;
	}

	@Override
	public String getItemById(int id) {
		System.out.println(id);
		
		Session session=this.sessionFactory.openSession();
		Item item;
		item=(Item) session.get(Item.class, id);
		if (item==null){
			FacesContext.getCurrentInstance().addMessage(
	                null,
	                new FacesMessage(FacesMessage.SEVERITY_WARN,
	                "Invalid item ID!",
	                "Please Try Again!"));
		}
		session.close();
	
		return "updateitems";
	}

	@Override
	public String addItem(Item item) {
		System.out.println("12");
		Session session=this.sessionFactory.openSession();
		session.beginTransaction();
		Integer id=(Integer) session.save(item);
		item.setItemId(id);;
		if (id<1){
			FacesContext.getCurrentInstance().addMessage(
	                null,
	                new FacesMessage(FacesMessage.SEVERITY_WARN,
	                "Invalid Item Deatils!",
	                "Please Try Again!"));
		}
		session.getTransaction().commit();
		session.close();
		System.out.println(item);
		return "additems";
	}

	@Override
	public String updateItem(Item item) {
		try{
			Session session=this.sessionFactory.openSession();
			session.beginTransaction();
		
			session.update(item);	
			session.getTransaction().commit();
			session.close();
		}catch(Exception e){
			FacesContext.getCurrentInstance().addMessage(
	                null,
	                new FacesMessage(FacesMessage.SEVERITY_WARN,
	                "Invalid item details!",
	                "Please Try Again!"));
		}
		
		System.out.println(item);
		
		return "additems";
	}
	



	
}

	
	


