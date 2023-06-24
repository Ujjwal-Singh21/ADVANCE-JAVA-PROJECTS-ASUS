package com.springmvc.api;

public class BillDTO {

	private CreditCard creditCard;
	private Amount amount;

	public BillDTO() {
		System.out.println("Bill class Constructor");
	}

	public CreditCard getCreditCard() {
		return creditCard;
	}

	public void setCreditCard(CreditCard creditCard) {
		this.creditCard = creditCard;
	}

	public Amount getAmount() {
		return amount;
	}

	public void setAmount(Amount amount) {
		this.amount = amount;
	}
	
	
}
