package com.springmvc.service;

public interface LCAppEmailService {
	
	public abstract void sendEmail(String userName, String userEmail, String result);
}
