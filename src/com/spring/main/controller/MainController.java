package com.spring.main.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {

	// All Java code start here
	@RequestMapping("/")
	public String showIndex() {
		return "home"; ///MVCProductAssignment/WebContent/WEB-INF/jsps
	}
	
	@RequestMapping("/dashboard") 
	public void showDashboard() {
		System.out.println("dashboard loaded...");
	}
}
