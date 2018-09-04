package com.demo.demo_mvc;

import java.lang.reflect.Field;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.aop.framework.AdvisedSupport;
import org.springframework.aop.support.AopUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.demo.demo_mvc.controller.StartTestController;
import com.demo.demo_mvc.service.UserService;
import com.demo.demo_mvc.service.UserServiceImpl;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations="file:src/main/webapp/WEB-INF/spring-servlet.xml")
public class TestController {

	@Autowired
	StartTestController startTestController;
	
	@Autowired
	ApplicationContext context;
	
	@Test
	public void test() {
		
		UserService us1 = (UserService)context.getBean("userServiceImpl");
		System.out.println(us1.getUserName());
				
		
		ConfigurableApplicationContext configurableContext = (ConfigurableApplicationContext) context;
		DefaultListableBeanFactory bf = (DefaultListableBeanFactory) configurableContext.getBeanFactory();
		bf.removeBeanDefinition("userServiceImpl");
		UserServiceImpl us = new UserServiceImpl();
		us.userName = "i";
		bf.registerSingleton("userServiceImpl", us);
		
		UserService us2 = (UserService)context.getBean("userServiceImpl");
		System.out.println(us2.getUserName());

		System.out.println(startTestController.getUserName());
	}
	
	@Test
	public void test2() {
		
		UserService us1 = (UserService)context.getBean("userServiceImpl");
		System.out.println(us1.getUserName());
		
		ConfigurableApplicationContext configurableContext = (ConfigurableApplicationContext) context;
		DefaultListableBeanFactory bf = (DefaultListableBeanFactory) configurableContext.getAutowireCapableBeanFactory();
		bf.removeBeanDefinition("userServiceImpl");
		UserServiceImpl us = new UserServiceImpl();
		us.userName = "i";
		bf.registerSingleton("userServiceImpl", us);
		
		UserService us2 = (UserService)context.getBean("userServiceImpl");
		System.out.println(us2.getUserName());
		
		startTestController.setUserService(us2);
		System.out.println(startTestController.getUserName());
	}
	
	
	@Test
	public void test3() throws Throwable, SecurityException {

		UserServiceImpl us = new UserServiceImpl();
		us.userName = "i";

		System.out.println(AopUtils.isAopProxy(startTestController));
		
		Field f1 = startTestController.getClass().getDeclaredField("CGLIB$CALLBACK_0");
		f1.setAccessible(true);
		Object dai = f1.get(startTestController);
		
		Field f2 = dai.getClass().getDeclaredField("advised");
		f2.setAccessible(true);
		AdvisedSupport advice = (AdvisedSupport)f2.get(dai);
		
		Field f3 = advice.getTargetSource().getTarget().getClass().getDeclaredField("userService");
		f3.setAccessible(true);
		f3.set(advice.getTargetSource().getTarget(), us);
		
		System.out.println(startTestController.getUserName());
	}
}
