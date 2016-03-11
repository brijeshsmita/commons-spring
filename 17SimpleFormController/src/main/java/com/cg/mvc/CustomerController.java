package com.cg.mvc;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;

import com.cg.mvc.model.Customer;
@SuppressWarnings("deprecation")
public class CustomerController extends SimpleFormController{	
	public CustomerController(){
		setCommandClass(Customer.class);
		setCommandName("customerForm");
	}
	@Override
	protected ModelAndView onSubmit(HttpServletRequest request,
			HttpServletResponse response, Object command,
			BindException errors)
			throws Exception {
		Customer customer = (Customer)command;
		System.out.println(customer);
		return new ModelAndView("customerSuccess",
				"customer",customer);
	}
	@Override
	protected Object formBackingObject(HttpServletRequest request)
			throws Exception {
		Customer cust = new Customer();
		//Make "Spring MVC" as default checked value
		cust.setFavFramework(new String []{"Spring MVC"});		
		//Make "Make" as default radio button selected value
		cust.setSex("M");		
		//make "Hibernate" as the default java skills selection
		cust.setJavaSkills("Hibernate");		
		//initilize a hidden value
		cust.setSecretValue("I'm hidden value");		
		cust.setCountry("IN");
		return cust;
	}	
	@Override
	protected Map<String, Object> referenceData(HttpServletRequest request) 
			throws Exception {
		Map<String, Object> referenceData = new HashMap<>();
		//Data referencing for web framework checkboxes
		List<String> webFrameworkList = new ArrayList<String>();
		webFrameworkList.add("Spring MVC");
		webFrameworkList.add("Struts 1");
		webFrameworkList.add("Struts 2");
		webFrameworkList.add("JSF");
		webFrameworkList.add("Apache Wicket");
		referenceData.put("webFrameworkList", webFrameworkList);
		//Data referencing for number radiobuttons
		List<String> payMode = new ArrayList<>();
		payMode.add("Cash");
		payMode.add("Cheque");
		payMode.add("Credit Card");
		payMode.add("Debit Card");
		payMode.add("Net Banking");
		referenceData.put("payMode", payMode);		
		//Data referencing for country dropdown box
		Map<String,String> country = new LinkedHashMap<>();
		country.put("IN", "India");
		country.put("US", "United Stated");
		country.put("CHINA", "China");
		country.put("SG", "Singapore");
		country.put("MY", "Malaysia");
		referenceData.put("countryList", country);		
		//Data referencing for java skills list box
		Map<String,String> javaSkill = new LinkedHashMap<>();
		javaSkill.put("Hibernate", "Hibernate");
		javaSkill.put("Spring", "Spring");
		javaSkill.put("Apache Wicket", "Apache Wicket");
		javaSkill.put("Struts", "Struts");
		referenceData.put("javaSkillsList", javaSkill);		
		return referenceData;
	}
}