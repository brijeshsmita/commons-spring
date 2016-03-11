package com.cg.mvc.controller;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.web.servlet.mvc.SimpleFormController;

import com.cg.mvc.domain.User;
import com.cg.mvc.service.UserService;
@SuppressWarnings("deprecation")
public class UserController extends SimpleFormController {
	private UserService userService;
	public UserController()	{
		setCommandClass(User.class);
		setCommandName("user");
	}	
	//getters and setters 
	//override unimplemented methods
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	public UserService getUserService() {
		return userService;
	}
	@Override
	protected ModelAndView onSubmit(Object command)
			throws Exception {
		User user = (User) command;
		userService.add(user);
		return new ModelAndView("userSuccess","user",user);
	}	
}
