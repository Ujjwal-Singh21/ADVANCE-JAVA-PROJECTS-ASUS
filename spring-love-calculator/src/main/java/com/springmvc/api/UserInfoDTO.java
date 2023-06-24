package com.springmvc.api;

import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class UserInfoDTO {
	
	@NotBlank(message= " * Username can't be empty")
//	@Size(min = 3, max = 15, message = " * Username should be between 3-15 characters")
	@Size(min = 3, max = 15, message = "{username.size}")
	private String username;
	
	@NotBlank(message= " * Crushname can't be empty")
	@Size(min = 3, max = 15, message = " * Crushname should be between 3-15 characters")
	private String crushname;
	
	@AssertTrue(message = " * please agree terms&conditions to proceed")
	private boolean termsAndCondition;
	
	public UserInfoDTO() {
		System.out.println("User DTO constructor executed");
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getCrushname() {
		return crushname;
	}

	public void setCrushname(String crushname) {
		this.crushname = crushname;
	}
	
	public boolean isTermsAndCondition() {
		return termsAndCondition;
	}

	public void setTermsAndCondition(boolean termsAndCondition) {
		this.termsAndCondition = termsAndCondition;
	}

	@Override
	public String toString() {
		return "UserInfoDTO [username=" + username + ", crushname=" + crushname + ", termsAndCondition="
				+ termsAndCondition + "]";
	}
}
