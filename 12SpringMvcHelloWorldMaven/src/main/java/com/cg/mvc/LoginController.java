package com.cg.mvc;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {	
	@RequestMapping(value="/login")
	public String sayHello(HttpServletRequest req,Model model)
			throws ServletException,IOException{
		String viewName="greet";
		String strUser=req.getParameter("username");
		String strPass=req.getParameter("password");
		String msg="<h5 style='color:red'>"
				+ "Sorry Boss Something went Wrong!! "
				+ ",Kindly Relogin</span>";
		if(strUser.equals("123")&&strPass.equals("123")){
			viewName="valid";
			msg="Welcome to Spring-MVC , "+strUser;
			System.out.println("strUser "+strUser+"\tstrPass:"
			+strPass);
		}				
		model.addAttribute("modelKey", msg);//model
		System.out.println("viewName:"+viewName);
		return viewName;//view
	}
}
