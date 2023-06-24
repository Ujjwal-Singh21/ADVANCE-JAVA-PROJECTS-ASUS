package com.springmvc.formatter;

import java.text.ParseException;
import java.util.Locale;

import org.springframework.format.Formatter;

import com.springmvc.api.Phone;

public class PhoneNumberFormatter implements Formatter<Phone> {

	@Override
	public String print(Phone phone, Locale locale) {
		return phone.getCountryCode() + "-" + phone.getUserNumber();
	}

	@Override
	public Phone parse(String fullPhoneNumber, Locale locale) throws ParseException {

		String phnNumArr[] = fullPhoneNumber.split("-");
		Phone phone = new Phone();

		int index = fullPhoneNumber.indexOf("-");

		if (index == -1) {
			phone.setCountryCode("91");
			phone.setUserNumber(phnNumArr[0]);
		} else if (index == 0) {
			phone.setCountryCode("91");
			phone.setUserNumber(phnNumArr[1]);
		} else {
			phone.setCountryCode(phnNumArr[0]);
			phone.setUserNumber(phnNumArr[1]);
		}
		return phone;
	}

}
