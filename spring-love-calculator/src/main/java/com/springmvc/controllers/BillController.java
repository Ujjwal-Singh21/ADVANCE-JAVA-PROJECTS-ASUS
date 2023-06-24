package com.springmvc.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springmvc.api.BillDTO;
import com.springmvc.api.CreditCard;
import com.springmvc.formatter.BillAmountFormatter;
import com.springmvc.formatter.CreditCardFormatter;
import com.springmvc.propertyeditor.CreditCardPropertyEditor;

@Controller
public class BillController {

	@RequestMapping("/show-bill")
	public String showBillForm(@ModelAttribute("billDTO") BillDTO billDTO) {
		
		CreditCard creditCard = new CreditCard();
		creditCard.setFirstFourDigits(1111);
		creditCard.setSecondFourDigits(2222);
		creditCard.setThirdFourDigits(3333);
		creditCard.setLastFourDigits(4444);
		
		billDTO.setCreditCard(creditCard);
		return "show-bill";
	}
	
	@RequestMapping("/process-bill")
	public String processBillForm(@ModelAttribute("billDTO") BillDTO billDTO) {
		return "process-bill";
	}
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.addCustomFormatter(new CreditCardFormatter());
		binder.addCustomFormatter(new BillAmountFormatter());
		
//		CreditCardPropertyEditor creditCardPropertyEditor = new CreditCardPropertyEditor();
//		binder.registerCustomEditor(CreditCard.class, "creditCard", creditCardPropertyEditor);
	}
}
