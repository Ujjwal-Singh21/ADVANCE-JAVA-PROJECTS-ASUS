package com.springmvc.convertors;

import org.springframework.core.convert.converter.Converter;

import com.springmvc.api.CreditCard;

public class CreditCardConvertorObjectToString implements Converter<CreditCard, String> {

	@Override
	public String convert(CreditCard creditCard) {
		return "sample convertor : " + creditCard;
	}

}
