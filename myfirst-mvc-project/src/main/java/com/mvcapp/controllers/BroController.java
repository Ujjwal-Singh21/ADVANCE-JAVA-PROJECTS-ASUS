package com.mvcapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;


@Controller
public class BroController {
	
//	@ResponseBody
	@RequestMapping("/cricketbat")
	public String getCricketBat() {
		return "MRFCricketbat";
	}

}
