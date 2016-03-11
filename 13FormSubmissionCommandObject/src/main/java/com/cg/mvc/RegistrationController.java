package com.cg.mvc;
/**
 * @author Brijesh
 *
 */
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cg.mvc.model.User;
@Controller
@RequestMapping(value="/registration.htm")
public class RegistrationController {		
	@RequestMapping(method=RequestMethod.GET)
	public String showForm(ModelMap model){
		User user = new User();
		model.addAttribute("USER", user);//model
		return "registration";//view
	}
	@RequestMapping(method=RequestMethod.POST)
	public String processForm(@ModelAttribute(value="USER") 
	User user,
			BindingResult result){
		if(result.hasErrors()){
			return "registration";
		}else{
			System.out.println("User values is : " + user);
			return "success";
		}		
	}
/*@ModelAttribute refers to a property of the Model object 
 * (the M in MVC ;). 
 * @ModelAttribute is a Spring-MVC specific annotation
 *  used for preparing the model data. 
 * It is also used to define the command object 
 * that would be bound with the HTTP request data.
 *  The annotation works only if the class is a Controller class 
 *  (i.e. annotated with @Controller).
 * It serves two purposes depending on how it is used:
 * One is not better then the other. 
 * They both serve another purpose.
Method: If you need the model for a particular controller 
to be always populated with certain attributes the method level 
@ModelAttribute makes more sense.
eg:@ModelAttribute("productsList")
    public Collection<Product> populateProducts() {
        return this.productsService.getProducts();
    }
Parameter: Use it on a parameter when you want to bind data from the request
 			and add it to the model implicitly.
*/
	
}
