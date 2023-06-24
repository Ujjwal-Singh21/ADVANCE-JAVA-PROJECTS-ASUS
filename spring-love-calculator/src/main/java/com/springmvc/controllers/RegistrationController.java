package com.springmvc.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springmvc.api.CommunicationDTO;
import com.springmvc.api.Phone;
import com.springmvc.api.UserRegistrationDTO;
import com.springmvc.customvalidators.EmailSpringValidator;
import com.springmvc.customvalidators.UserNameSpringValidator;
import com.springmvc.formatter.BillAmountFormatter;
import com.springmvc.formatter.CreditCardFormatter;
import com.springmvc.formatter.PhoneNumberFormatter;
import com.springmvc.propertyeditor.NamePropertyEditor;

@Controller
public class RegistrationController {
	
	@Autowired 
	private EmailSpringValidator emailValidator;
	
	@RequestMapping("/register")
	public String showRegisterPage(@ModelAttribute("userReg") UserRegistrationDTO userRegistrationDTO) {
		System.out.println("inside showRegisterPage");
		
		// load data from database and populate the initially rendered form
		Phone phone  = new Phone();
		phone.setCountryCode("91");
		phone.setUserNumber("11111");
		
		CommunicationDTO communicationDTO = new CommunicationDTO();
		communicationDTO.setPhone(phone);
		
		userRegistrationDTO.setCommunicationDTO(communicationDTO);
		
		return "user-registration-page";
	}
	
	@RequestMapping("/registration-success")
	public String processRegisterPage(@Valid @ModelAttribute("userReg") UserRegistrationDTO userRegistrationDTO, BindingResult result) {
		
		System.out.println("inside processRegisterPage"); // store the user's entered data in database
		System.out.println("Name value entered by user is " + "|" + userRegistrationDTO.getName() + "|");
		
		// Either create object directly or inject using @Autowired, 
		// make sure to scan package in config file and annotate Email validator with @Component
		emailValidator.validate(userRegistrationDTO, result);
		
		if(result.hasErrors()) {
			
			 List<ObjectError> allErrors = result.getAllErrors();
			 
			 for(ObjectError error : allErrors) {
				 System.out.println(error);
			 }
			 
			return "user-registration-page";
		}
		
		return "registration-success";
	}
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		System.out.println("Inside init binder");
		
		// another way to register our custom formatters with Spring
		binder.addCustomFormatter(new PhoneNumberFormatter());
		
//		binder.setDisallowedFields("name");
		
		StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
		// registering our custom editor with Spring
		binder.registerCustomEditor(String.class, "name", stringTrimmerEditor);
		
		// Change name to uppercase using custom property editor
		NamePropertyEditor namePropertyEditor = new NamePropertyEditor();
		binder.registerCustomEditor(String.class, "name", namePropertyEditor);
		
		// adding custom spring validator for username field & email field
		binder.addValidators(new UserNameSpringValidator());
//		binder.addValidators(new EmailSpringValidator()); // instead of registering here, it can also be used in above processPage controller
	}
}
