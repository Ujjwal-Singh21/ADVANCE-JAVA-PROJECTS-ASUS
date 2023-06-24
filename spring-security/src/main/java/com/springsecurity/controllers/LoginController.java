package com.springsecurity.controllers;

import java.security.Principal;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.springsecurity.dto.ChangePasswordDTO;
import com.springsecurity.dto.SignupDTO;
import com.springsecurity.signupdao.ISignUpDAO;

@Controller
public class LoginController {
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private ISignUpDAO dao;
	
	@Autowired
	private DataSource dataSource;
	
	@Autowired
	JdbcUserDetailsManager jdbcUserDetailsManager;
	
	@GetMapping("/myCustomLoginPage")
	public String getCustomLoginPage() {
		return "login";
	}
	
	@GetMapping("/signUpPage")
	public String getSignUpPage(@ModelAttribute("signupDTO") SignupDTO signupDTO) {
		return "signup";
	}
	
	@PostMapping("/process-signup")
	public String processSignUpPage(SignupDTO signupDTO) {
		String rawPswd  = signupDTO.getPassword();
		String encodedPswd = passwordEncoder.encode(rawPswd);
		signupDTO.setPassword(encodedPswd);
		
		 UserDetails userDetails = User.withUsername(signupDTO.getUsername()).password(signupDTO.getPassword())
				                      .authorities("USER").build();
		
//		 JdbcUserDetailsManager jdbcUserDetailsManager = new JdbcUserDetailsManager();
//		 jdbcUserDetailsManager.setDataSource(dataSource);
		 
		 // used from autowired
		 jdbcUserDetailsManager.createUser(userDetails);
		 
//		dao.saveUser(signupDTO);
		return "redirect:/myCustomLoginPage";
	}
	
	// DELETE USER
	//-------------
	@GetMapping("/delete-user")
	public String deleteUser(@RequestParam("username") String userName) {
		jdbcUserDetailsManager.deleteUser(userName);
		return "redirect:/myCustomLoginPage";
	}
	
	// CHANGE PASSWORD
	//----------------
	@GetMapping("/change-password")
	public String changePassword(@ModelAttribute("change-password-dto") ChangePasswordDTO changePasswordDTO) {
		return "change-password";
	}
	
	@PostMapping("/process-password-change")
	public String processPasswordChange(ChangePasswordDTO changePasswordDTO, Principal principal) {
		
		// 1) check first whether oldPassword exits in db, by comparing old pswd and current user pswd from db
		UserDetails loadedUserFromDb = jdbcUserDetailsManager.loadUserByUsername(principal.getName());
		String encodedPasswordFromDb = loadedUserFromDb.getPassword();
		
		boolean matches = passwordEncoder.matches(changePasswordDTO.getOldPassword(), encodedPasswordFromDb);
		
		// 2) checking if new password and confirm new password matches first
		if(!changePasswordDTO.getNewPassword().equals(changePasswordDTO.getConfirmNewPassword())) {
			return "redirect:/change-password?newAndConfirmPasswordsDoesNotMatch";
		}
		
		if(matches) {
			// encoding new pswd before updating in db
			String encodedPswd = passwordEncoder.encode(changePasswordDTO.getConfirmNewPassword());
			
			jdbcUserDetailsManager.changePassword(changePasswordDTO.getOldPassword(), encodedPswd);
			System.out.println("passwords changed");
			return "redirect:/";
		}
		
		return "redirect:/change-password?InvalidPassword";	
	}
	
}
