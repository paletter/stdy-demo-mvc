package com.demo.demo_mvc;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;
import org.springframework.web.servlet.mvc.method.annotation.ServletModelAttributeMethodProcessor;

public class SnakeToCamelModelAttributeMethodProcessor extends ServletModelAttributeMethodProcessor {

	@Autowired
	private RequestMappingHandlerAdapter mha;
	
	public SnakeToCamelModelAttributeMethodProcessor(boolean annotationNotRequired) {
		super(annotationNotRequired);
	}

	@Override
	protected void bindRequestParameters(WebDataBinder binder, NativeWebRequest request) {
		
		System.out.println(request.getNativeRequest(ServletRequest.class).getClass().getName());
		HttpServletRequest r = request.getNativeRequest(HttpServletRequest.class);

//		if (r.getMethod().equals("GET") && binder.getTarget().getClass().isAnnotationPresent(GetReqSnakeToCamel.class)) {
		if (binder.getTarget().getClass().isAnnotationPresent(GetReqSnakeToCamel.class)) {
			SnakeToCamelRequestDataBinder cb = new SnakeToCamelRequestDataBinder(binder.getTarget());
//			RequestMappingHandlerAdapter mha = applicationContext.getBean(RequestMappingHandlerAdapter.class);
			mha.getWebBindingInitializer().initBinder(cb, request);
			cb.bind(request.getNativeRequest(ServletRequest.class));
		} else {
			super.bindRequestParameters(binder, request);
		}
	}
}
