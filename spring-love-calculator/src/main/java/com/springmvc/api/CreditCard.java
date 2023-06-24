package com.springmvc.api;

public class CreditCard {

	private Integer firstFourDigits;
	private Integer secondFourDigits;
	private Integer thirdFourDigits;
	private Integer lastFourDigits;

	public CreditCard() {
		System.out.println("Credit card constructor");
	}

	public Integer getFirstFourDigits() {
		return firstFourDigits;
	}

	public void setFirstFourDigits(Integer firstFourDigits) {
		this.firstFourDigits = firstFourDigits;
	}

	public Integer getSecondFourDigits() {
		return secondFourDigits;
	}

	public void setSecondFourDigits(Integer secondFourDigits) {
		this.secondFourDigits = secondFourDigits;
	}

	public Integer getThirdFourDigits() {
		return thirdFourDigits;
	}

	public void setThirdFourDigits(Integer thirdFourDigits) {
		this.thirdFourDigits = thirdFourDigits;
	}

	public Integer getLastFourDigits() {
		return lastFourDigits;
	}

	public void setLastFourDigits(Integer lastFourDigits) {
		this.lastFourDigits = lastFourDigits;
	}
	
	@Override
	public String toString() {
		return firstFourDigits + "-" + secondFourDigits + "-" + thirdFourDigits + "-" + lastFourDigits;
	}
}
