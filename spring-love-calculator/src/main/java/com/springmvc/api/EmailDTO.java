package com.springmvc.api;

public class EmailDTO {
	
	private String userEmail;

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	@Override
	public String toString() {
		return "EmailDTO [userEmail=" + userEmail + "]";
	}
}
