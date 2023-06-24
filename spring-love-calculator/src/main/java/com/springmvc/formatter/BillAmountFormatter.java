package com.springmvc.formatter;

import java.math.BigDecimal;
import java.text.ParseException;
import java.util.Currency;
import java.util.Locale;

import org.springframework.format.Formatter;

import com.springmvc.api.Amount;

public class BillAmountFormatter implements Formatter<Amount> {

	@Override
	public String print(Amount arg0, Locale arg1) {
		return null;
	}

	@Override
	public Amount parse(String amountEntered, Locale locale) throws ParseException {
		
		String amountArr[] = amountEntered.split(" ");
			
		if(amountArr[1].equalsIgnoreCase("EURO")) 
		   locale = Locale.GERMANY;
		else if (amountArr[1].equalsIgnoreCase("USD"))
			locale = Locale.US;
		else if(amountArr[1].equalsIgnoreCase("YEN"))
			locale = Locale.JAPAN;
		
		Amount amount = new Amount();
		
		amount.setBillAmount(new BigDecimal(amountArr[0]));
		
		Currency currency = Currency.getInstance(amountArr[1]);
		System.out.println(currency.getSymbol() + " " + currency.getCurrencyCode() + " " + currency.getDisplayName());
		
		amount.setLocaleDefinition(currency.getSymbol());
		
		return amount;
	}

}
