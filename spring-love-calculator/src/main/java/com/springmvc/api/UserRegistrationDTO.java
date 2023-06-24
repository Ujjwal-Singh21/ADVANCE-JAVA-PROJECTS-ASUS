package com.springmvc.api;

import java.util.Arrays;

import javax.validation.constraints.NotEmpty;

import com.springmvc.customvalidators.Age;

public class UserRegistrationDTO {

	@NotEmpty(message = "{string.notEmpty}")
	private String name;
	
	private String username;
	private char[] password;
	private String country;
	private String[] hobbyArr;
	private String gender;
	
//	@Age
	@Age(lower = 30, upper = 45)
	private Integer age;
		
	private CommunicationDTO communicationDTO;
	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public char[] getPassword() {
		return password;
	}

	public void setPassword(char[] password) {
		this.password = password;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String[] getHobbyArr() {
		return hobbyArr;
	}

	public void setHobbyArr(String[] hobbyArr) {
		this.hobbyArr = hobbyArr;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}
	
	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}
	
	public CommunicationDTO getCommunicationDTO() {
		return communicationDTO;
	}

	public void setCommunicationDTO(CommunicationDTO communicationDTO) {
		this.communicationDTO = communicationDTO;
	}

	@Override
	public String toString() {
		return "UserRegistrationDTO [name=" + name + ", username=" + username + ", password="
				+ Arrays.toString(password) + ", country=" + country + ", hobbyArr=" + Arrays.toString(hobbyArr)
				+ ", gender=" + gender + ", age=" + age + ", communicationDTO=" + communicationDTO + "]";
	}
}
