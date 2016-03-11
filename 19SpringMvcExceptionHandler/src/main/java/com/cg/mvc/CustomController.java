package com.cg.mvc;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import com.cg.mvc.exception.CustomGenericException;
public class CustomController extends AbstractController {
	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		throw new CustomGenericException("404", 
				"This is custom message X");
	}
}