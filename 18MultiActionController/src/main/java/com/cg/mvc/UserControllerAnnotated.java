package com.cg.mvc;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;
/*
 *  MultiActionController is used 
 *  to group related actions into a single controller,
 */		
//@Controller
public class UserControllerAnnotated extends MultiActionController {	
	@RequestMapping("/user/add.htm")
	public ModelAndView add(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		System.out.println("Add method called");
		return new ModelAndView("user", "message", "Add method called");
	}
	@RequestMapping("/user/remove.htm")
	public ModelAndView remove(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		System.out.println("Remove method called");
		return new ModelAndView("user", "message", "Remove method called");
	}
	@RequestMapping("/user/update.htm")
	public ModelAndView update(HttpServletRequest request,
		HttpServletResponse response) throws Exception { 
		return new ModelAndView("user", "message","update() method called");
 	}
	@RequestMapping("/user/list.htm")
	public ModelAndView list(HttpServletRequest request,
		HttpServletResponse response) throws Exception { 
		return new ModelAndView("user", "message","list() method called");
 	}	 
}
