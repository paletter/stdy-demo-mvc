package com.demo.demo_mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.demo.demo_mvc.dto.SearchUserParamVo;
import com.demo.demo_mvc.entity.User;

@Controller
public class ContentNegotiatingViewTestController {

	@RequestMapping(value="/user/{userId}")
	public User getUser(@PathVariable("userId") String userId) {
		
		if(userId.equals("0001")) {
			User user = new User();
			user.setId(userId);
			user.setName("Jame");
			user.setAge("10");
			return user;
		}
		
		return null;
	}
	
	@RequestMapping(value="/user/searchUser")
	public User searchUser(@RequestBody SearchUserParamVo param) {
		
		User user = new User();
		user.setName("测试");
		user.setAge("10");
		return user;
	}
}
