package com.mvcapp.mycafe.controller;

import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MyCafeController {
	
	// this handlers simply returns/redirects user to welcome page
	@RequestMapping("/cafe")
	public String getWelcomePage() {
		return "Welcome-page";
	}
	
	@RequestMapping("/processOrder")
	public String processOrder(Model model, HttpServletRequest request) {
		String userEnteredFood = request.getParameter("foodType");
		model.addAttribute("foodName", userEnteredFood);
		return "Process-Order";
	}

}
