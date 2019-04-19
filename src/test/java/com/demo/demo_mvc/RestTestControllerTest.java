package com.demo.demo_mvc;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.demo.demo_mvc.dto.QueryDTO;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations = { "classpath:/spring-servlet.xml" })
public class RestTestControllerTest {

	@Autowired
	RestTestController controller;
	
	@Test
	public void test() {
		
		System.out.println(controller.test());
	}
	
	@Test
	public void testQueryByPost() {
		
		QueryDTO q = new QueryDTO();
		q.setUser_name("fangbo");
		q.setUserId("1");
		
		System.out.println(controller.queryByPost(q));
	}
	
	@Test
	public void testQuery() {
		
		QueryDTO q = new QueryDTO();
		q.setUser_name("fangbo");
		q.setUserId("1");
		
		System.out.println(controller.query(q));
	}
}
