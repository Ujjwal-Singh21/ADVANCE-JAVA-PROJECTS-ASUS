package com.springmvc.propertyeditor;

import java.beans.PropertyEditorSupport;

import com.springmvc.api.CreditCard;

public class CreditCardPropertyEditor extends PropertyEditorSupport {

	@Override
	public String getAsText() {
		CreditCard creditCard = (CreditCard) getValue();
		return "sample p.editor : " + creditCard;
	}

	@Override
	public void setAsText(String fullCrediCardNumber) throws IllegalArgumentException {

		int index = fullCrediCardNumber.indexOf("-");
		CreditCard creditCard = new CreditCard();

		if (index != -1) {
			String creditCardArr[] = fullCrediCardNumber.split("-");
			creditCard.setFirstFourDigits(Integer.parseInt(creditCardArr[0]));
			creditCard.setSecondFourDigits(Integer.parseInt(creditCardArr[1]));
			creditCard.setThirdFourDigits(Integer.parseInt(creditCardArr[2]));
			creditCard.setLastFourDigits(Integer.parseInt(creditCardArr[3]));
		}
		setValue(creditCard);
	}

}
