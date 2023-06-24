package com.springsecurity.controllers;

import java.security.Principal;
import java.util.Collection;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TestController {

	@GetMapping("/")
	public String getHomePage(Authentication auth, Principal principal, Model model) {
		// capturing signed in username, and roles from Authentication(I) and -> Principal(I)
		String username = principal.getName();
		Collection<? extends GrantedAuthority> authorities = auth.getAuthorities();
		model.addAttribute("username", username);
		model.addAttribute("roles", authorities);
		return "home-page";
	}
	
	@ResponseBody
	@GetMapping("/hello")
	public String getHello() {
		return "hello guys welcome";
	}

	@ResponseBody
	@GetMapping("/bye")
	public String getBye() {
		return "Bye bye guys";
	}
	
	@GetMapping("/trainer")
	public String getTrainersDashboard() {
		return "trainer-dashboard";
	}
	
	@GetMapping("/coder")
	public String getCodersDashboard() {
		return "coder-dashboard";
	}
	
	@GetMapping("/access-denied")
	public String getAccessDenied() {
		return "access-denied";
	}
}
