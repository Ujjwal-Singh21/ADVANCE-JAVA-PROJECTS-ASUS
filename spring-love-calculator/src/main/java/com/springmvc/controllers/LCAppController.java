package com.springmvc.controllers;
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.springmvc.api.UserInfoDTO;
 
@Controller
//During using this annotation, we can't use @ModelAttribute, we have to use Model and add model object explicitly by ourselves
@SessionAttributes({"userDTO"}) 
public class LCAppController {

	@RequestMapping("/")
	public String showHomepage(Model model)
//	public String showHomepage(@ModelAttribute("userDTO") UserInfoDTO initialUserDTO, HttpServletRequest request)
//	public String showHomepage(@ModelAttribute("userDTO") UserInfoDTO initialUserDTO)
	{
		// cookies
//		Cookie[] cookies = request.getCookies();
//		
//		for(Cookie c : cookies) {
//			if(c.getName().equals("lcapp.username")) {
//				String userNameFromCookie = c.getValue();
//				initialUserDTO.setUsername(userNameFromCookie);
//			}
//		}
		
		UserInfoDTO initialUserDTO = new UserInfoDTO();
		model.addAttribute("userDTO", initialUserDTO );
		
		return "home-page";
	}

	@RequestMapping("/process-homepage")
	 // public String showResultPage(@RequestParam("username") String userName, @RequestParam("crushname") String crushName, Model model)
    //  public String showResultPage(UserInfoDTO userDTO, Model model)
//    	public String showResultPage(@ModelAttribute("userDTO") UserInfoDTO userDTO)
	public String showResultPage(@Valid @ModelAttribute("userDTO") UserInfoDTO userDTO, BindingResult result)
	{
//		model.addAttribute("userDTO", userDTO);
		
		if(result.hasErrors()) {
			
			List<ObjectError> allErrors = result.getAllErrors();
			
			for(ObjectError e : allErrors) {
				System.out.println(e);
			}
				
			return "home-page";
		}
		
//		Cookie cookie = new Cookie("lcapp.username", userDTO.getUsername());
//		cookie.setMaxAge(60*60*24);
//		response.addCookie(cookie);
		
//		HttpSession session = request.getSession();
//		session.setAttribute("sessionUserName", userDTO.getUsername());
//		session.setMaxInactiveInterval(120);
		
		return "result-page";
	}
}
