package com.demo.demo_mvc;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StartTestRestController {
	
	@RequestMapping(value="/welcome/rest", method = RequestMethod.GET)
	public String welcome() {
		return "/welcome"; 
	}
	
	@RequestMapping(value="/anyone/rest", method = RequestMethod.GET)
	public String anyone() {
		System.out.println("Anyone");
		return "/demo-mvc/anyone"; 
	}
}
