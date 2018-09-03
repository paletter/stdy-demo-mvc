package com.demo.demo_mvc.service;

import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

	public String userName = "fangbo";
	
	@Override
	public String getUserName() {
		return userName;
	}

}
