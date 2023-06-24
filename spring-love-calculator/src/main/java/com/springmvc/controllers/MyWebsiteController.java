package com.springmvc.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springmvc.api.WebsiteInfoDTO;

@Controller
//@ControllerAdvice // to make this webisteInfo object global to all controllers
//@ControllerAdvice(basePackages = {"com.package1", "com.package2"}) // to specific packages only
//@ControllerAdvice(assignableTypes = {xyz.class, pqr.class}) // to specific classes only
public class MyWebsiteController {

	@ModelAttribute("websiteInfo")
	public WebsiteInfoDTO getWebsiteInfoDTO() {
		
		System.out.println("@ModelAttribute at method level");

		WebsiteInfoDTO websiteInfoDTO = new WebsiteInfoDTO();
		websiteInfoDTO.setWebsiteName("Selenium Express");
		websiteInfoDTO.setWebsiteCategory("Education");

		return websiteInfoDTO;
	}

	@RequestMapping("/showWebsiteInfo")
	public String showWebsiteInfo(@ModelAttribute("websiteInfo") WebsiteInfoDTO websiteInfoDTO) {
		System.out.println("Inside showWebsiteInfo");
		return "index";
	}

	@RequestMapping("/showCompanyInfo")
	public String showCompanyInfo(@ModelAttribute("websiteInfo") WebsiteInfoDTO websiteInfoDTO) {
		System.out.println("Inside showCompanyInfo");
		return "index";
	}
}
