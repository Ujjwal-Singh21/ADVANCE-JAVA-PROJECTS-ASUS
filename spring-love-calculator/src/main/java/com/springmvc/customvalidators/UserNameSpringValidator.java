package com.springmvc.customvalidators;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.springmvc.api.UserRegistrationDTO;

public class UserNameSpringValidator implements Validator {

	// checks if username validator supports a given object
	@Override
	public boolean supports(Class<?> clazz) {
		return UserRegistrationDTO.class.equals(clazz);
	}

	// here we need to write our custom validation logic
	@Override
	public void validate(Object object, Errors errors) {

		// to check if the field is null
//		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username", "username.EMPTY", " * Username cannot be empty");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username", "username.EMPTY"); // using overloaded for loading error message from utils file

		// to check that STring should contain a "_"
		String userName = ((UserRegistrationDTO) object).getUsername();

		if (!userName.contains("_"))
//			errors.rejectValue("username", "username.UNDERSCORE", " * username must contain an underscore");
			errors.rejectValue("username", "username.UNDERSCORE");
	}

}
