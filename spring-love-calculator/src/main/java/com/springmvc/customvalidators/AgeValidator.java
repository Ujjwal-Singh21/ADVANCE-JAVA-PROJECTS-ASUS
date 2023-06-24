package com.springmvc.customvalidators;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class AgeValidator implements ConstraintValidator<Age, Integer> {

	private int upper;
	private int lower;

	@Override
	public void initialize(Age age) {
		// this age in parameter can be used to read values specified on annotation.
		// Inside this method we get access of initial values specified
		upper = age.upper();
		lower = age.lower();
	}

	@Override
	public boolean isValid(Integer age, ConstraintValidatorContext context) {
		
		// here parameter age is the value entered by user in age textbox in form
		// here we write our constraint logic for validation using initial upper lower values achieved above

		if (age == null)
			return false;

		if (age < lower || age > upper)
			return false;

		return true;
	}

}
