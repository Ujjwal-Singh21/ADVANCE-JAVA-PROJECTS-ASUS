package com.springmvc.api;

import java.math.BigDecimal;
import java.util.Currency;

public class Amount {

	private BigDecimal billAmount;
	private String localeDefinition;

	public Amount() {
		System.out.println("Amount class constructor");
	}

	public BigDecimal getBillAmount() {
		return billAmount;
	}

	public void setBillAmount(BigDecimal billAmount) {
		this.billAmount = billAmount;
	}

	public String getLocaleDefinition() {
		return localeDefinition;
	}

	public void setLocaleDefinition(String localeDefinition) {
		this.localeDefinition = localeDefinition;
	}

	@Override
	public String toString() {
		return getBillAmount() + " " + getLocaleDefinition();
	}

}
