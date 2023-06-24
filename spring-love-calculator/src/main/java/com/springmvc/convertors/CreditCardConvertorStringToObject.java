package com.springmvc.convertors;

import org.springframework.core.convert.converter.Converter;

import com.springmvc.api.CreditCard;

public class CreditCardConvertorStringToObject implements Converter<String, CreditCard>{

	@Override
	public CreditCard convert(String fullCreditCardNumber) {
		
		int index = fullCreditCardNumber.indexOf("-");
		
		CreditCard creditCard = new CreditCard();
		
		if(index != -1) {
			String creditCardArr[] = fullCreditCardNumber.split("-");
			creditCard.setFirstFourDigits(Integer.parseInt(creditCardArr[0]));
			creditCard.setSecondFourDigits(Integer.parseInt(creditCardArr[1]));
			creditCard.setThirdFourDigits(Integer.parseInt(creditCardArr[2]));
			creditCard.setLastFourDigits(Integer.parseInt(creditCardArr[3]));
		}
		return creditCard;
	}

}
