package com.demo.demo_mvc;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.demo_mvc.dto.QueryDTO;

@RestController
public class RestTestController {

	private static Integer cnt = 0;
	
	@RequestMapping(value="/resttest")
	public String test() {
		System.out.println(cnt ++);
		return "1";
	}
	
	@RequestMapping(value="/resttest2")
	public String test(HttpServletRequest request) {
		System.out.println(cnt ++);
		return "1";
	}
	
	@RequestMapping(value="/rest/query")
	public String query(QueryDTO query) {
		System.out.println(query.getUser_name());
		System.out.println(query.getUserId());
		return query.getUser_name();
	}
	
	@RequestMapping(value="/rest/query/post")
	public String queryByPost(@RequestBody QueryDTO query) {
		System.out.println(query.getUser_name());
		System.out.println(query.getUserId());
		return query.getUser_name();
	}
}
