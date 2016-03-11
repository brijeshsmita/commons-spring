package com.cg.mvc;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;
/*
 * Using Spring MultiActionController class you can group 
 * related actions into a single controller class. 
 * The handler method for each action should be 
 * in the following form.
 * public (ModelAndView | Map | String | void) 
 * 			actionName(HttpServletRequest, 
 * 			HttpServletResponse [,HttpSession] [,CommandObject]);
 */
public class UserController extends MultiActionController {	
	public ModelAndView add(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		System.out.println("Add method called");
		return new ModelAndView("user", "message", 
				"Add method called");
	}	
	public ModelAndView remove(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		System.out.println("Remove method called");
		return new ModelAndView("user", "message", 
				"Remove method called");
	}	 
	public ModelAndView update(HttpServletRequest request,
		HttpServletResponse response) throws Exception { 
		return new ModelAndView("user", "message",
				"update() method called");

	} 
	public ModelAndView list(HttpServletRequest request,
		HttpServletResponse response) throws Exception { 
		return new ModelAndView("user", "message","list() method called");
 
	}
	 
}
