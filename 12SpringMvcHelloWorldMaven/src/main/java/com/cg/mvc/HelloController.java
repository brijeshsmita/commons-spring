package com.cg.mvc;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
/**
 * @author Brijesh
 *
 */
@Controller
public class HelloController {
	@RequestMapping("/welcome.html")
    public ModelAndView welcomeWorld() { 
        String message = "Welcome to spring MVC World, Smita Spring 4!";
        return new ModelAndView("welcome", "storedMessage", message);
        //welcome --- name of jsp page
        //storedMessage is the key
        //message is the actual message        
    }
	@RequestMapping(value="/greet.html")
	public String sayHello(HttpServletRequest req,Model model)
			throws ServletException,IOException{
		String viewName="greet";
		String strUser=req.getParameter("username");
		String msg="Welcome to Spring-MVC , "+strUser;
		model.addAttribute("modelKey", msg);//model
		return viewName;//view
	}
}
/*Note:
 * To display the hello world message we will create a JSP.
 *  Note that this JSP is created in folder /WEB-INF/jsp. 
 *  Create welcome.jsp under WEB-INF/jsp directory 
 *In Above code....
 * we have annotated the HelloController class with @Controller 
 * and @RequestMapping("/welcome") on line 7 and 10. 
 * When Spring scans our package, 
 * it will recognize this bean as being a Controller bean for processing requests.
 *  The @RequestMapping annotation tells Spring that 
 *  this Controller should process all requests 
 *  beginning with /welcome in the URL path. 
 *  That includes /welcome/* and /welcome.html.
The welcomeWorld() method returns ModelAndView object. 
The ModelAndView object tries to resolve to a view named “welcome” 
and the data model is being passed back to the browser 
so we can access the data within the JSP. 
The logical view name will resolve to "/WEB-INF/jsp/welcome.jsp". 
We will discuss this just after few min how the logical name “welcome” 
which is return in ModelAndView 
object is mapped to path /WEB-INF/jsp/welcome.jsp.
The ModelAndView object also contains a message with key “message” 
and value “welcome World, Smita Spring 4!”. 
This is the data that we are passing to our view.
 Normally this will be a value object in form of java bean 
 that will contain the data to be displayed on our view. 
Here we are simply passing a string.

 * */