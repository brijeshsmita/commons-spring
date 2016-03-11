package com.cg.mvc.validator;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import com.cg.mvc.domain.User;
public class UserValidator implements Validator {
	@Override
	public boolean supports(Class<?> clazz) {
		return User.class.isAssignableFrom(clazz);
	}
	@Override
	public void validate(Object target, Errors errors) {
		User user = (User) target;
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name",
				"name.required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email",
				"email.required");
		ValidationUtils.rejectIfEmpty(errors, "profession",
				"profession.required");
		if(user.getCountry().equals("select"))
		{
			errors.rejectValue("country", "country.required");
		}		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "feedback",
				"feedback.required");
		if(user.getFrameworks().length == 0)
		{
			errors.rejectValue("frameworks","frameworks.required");
		}
	}

	
}
