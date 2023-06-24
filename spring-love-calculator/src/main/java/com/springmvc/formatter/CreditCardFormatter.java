package com.springmvc.formatter;

import java.text.ParseException;
import java.util.Locale;

import org.springframework.format.Formatter;

import com.springmvc.api.CreditCard;

public class CreditCardFormatter implements Formatter<CreditCard> {

	@Override
	public String print(CreditCard creditCard, Locale locale) {
		return "sample formatter" + creditCard;
	}

	@Override
	public CreditCard parse(String fullCreditCardNumber, Locale locale) throws ParseException {
		
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
