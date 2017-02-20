package com.demo.demo_mvc;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class StartTestController {

	@RequestMapping(value="/StartTestController/startTest", method = RequestMethod.GET)
	public String startTest(HttpServletRequest request) {
		System.out.println("Start test!");
		return "/login"; 
	}
	
	@RequestMapping(value="/welcome", method = RequestMethod.GET)
	public String welcome() {
		return "/welcome"; 
	}

	@RequestMapping(value="/login", method = RequestMethod.GET)
	public String login(HttpServletRequest request) {
		String u = request.getParameter("u");
		String p = request.getParameter("p");
		
		if(u.equals("1") && p.equals("2")) return "/success";
		else return "/error"; 
	}
	
	@RequestMapping(value="/anyone", method = RequestMethod.GET)
	public String anyone() {
		System.out.println("Anyone");
		return "/anyone"; 
	}
}
