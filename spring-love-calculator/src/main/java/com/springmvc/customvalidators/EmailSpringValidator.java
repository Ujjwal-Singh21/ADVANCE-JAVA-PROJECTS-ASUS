package com.springmvc.customvalidators;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.springmvc.api.UserRegistrationDTO;

@Component
public class EmailSpringValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return UserRegistrationDTO.class.equals(clazz);
	}

	@Override
	public void validate(Object object, Errors errors) {

		// for null and empty space checks
//		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "communicationDTO.email", "email.EMPTY", " * e-mail field cannot be empty");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "communicationDTO.email", "email.EMPTY");

		// for ending with @seleniumexpress check
		String email = ((UserRegistrationDTO) object).getCommunicationDTO().getEmail();

		if (!email.endsWith("@seleniumexpress.com"))
//			errors.rejectValue("communicationDTO.email", "email.endsWithConstraint", " * e-mail field should ends with @seleniumexpress.com");
		    errors.rejectValue("communicationDTO.email", "email.endsWithConstraint");
	}

}
