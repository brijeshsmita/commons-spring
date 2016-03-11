package com.cg.mvc;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.cg.mvc.exception.CustomGenericException;
@Controller
public class CustomController2 {
	@RequestMapping(value ="/custom",method = RequestMethod.GET)
	public ModelAndView getPages() throws Exception {
		throw new CustomGenericException("404", 
				"404 Page not found");
	}
	@ExceptionHandler(CustomGenericException.class)
	public ModelAndView handleCustomException(
			CustomGenericException ex) {
		ModelAndView model = new ModelAndView("error/404");
		model.addObject("exception", ex);
		return model;
	}
	@ExceptionHandler(Exception.class)
	public ModelAndView handleAllException(Exception ex) {
		ModelAndView model = new ModelAndView("error/404");		
		return model;
	}
}
