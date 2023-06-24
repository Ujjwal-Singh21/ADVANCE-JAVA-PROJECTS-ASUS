package com.springmvc.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.springmvc.api.EmailDTO;
import com.springmvc.api.UserInfoDTO;
import com.springmvc.service.LCAppEmailServiceImpl;

@Controller
public class EmailController {
	
	@Autowired
	private LCAppEmailServiceImpl lCAppEmailServiceImpl;
	
	@RequestMapping("/sendEmail")
	public String sendEmail( @ModelAttribute("emailDTO") EmailDTO emailDTO) 
//	public String sendEmail(@CookieValue("lcapp.username") String userNameFromCookie, Model model) 
	{
//		model.addAttribute("CookieUserName", userNameFromCookie);
		
//		model.addAttribute("emailDTO", new EmailDTO());
		return "send-email-page";
	}

	@RequestMapping("/processEmail")
	public String processEmail(@SessionAttribute("userDTO") UserInfoDTO userDTO, 
			@ModelAttribute("emailDTO") EmailDTO emailDTO, HttpSession session, Model model) {
		
//		String userNameFromSession = (String) session.getAttribute("sessionUserName");
//		String newUserName = "Mr. " + userNameFromSession;
//		model.addAttribute("userName", newUserName);

		lCAppEmailServiceImpl.sendEmail(userDTO.getUsername(), emailDTO.getUserEmail(), "Friends");
		
		return "process-email-page";
	}

}
