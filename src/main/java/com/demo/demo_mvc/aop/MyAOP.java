package com.demo.demo_mvc.aop;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class MyAOP {

    @Pointcut(value = "execution(* com.demo.demo_mvc.RestTestController.*(..))")
    public void pointcut(){
    }

//    @Around(value = "allMethods()")
//    @Around("com.demo.demo_mvc.RestTestController.test()")
//    @Around("pointcut()")
//    @Around(value="pointcut() && (args(request,..))")
    @Around(value="pointcut() && (args(request,..))")
    public Object around(ProceedingJoinPoint joinPoint, HttpServletRequest request) throws Throwable{
    	System.out.println("#AOP with HttpServletRequest");
    	System.out.println(request.getParameter("u"));
    	return joinPoint.proceed();
    }
    
    @Around(value="pointcut()")
    public Object around2(ProceedingJoinPoint joinPoint, HttpServletRequest request) throws Throwable{
    	System.out.println("#AOP");
    	return joinPoint.proceed();
    }
    
//    @Around("com.xyz.myapp.SystemArchitecture.businessService()")
//    @Around("com.demo.demo_mvc.RestTestController.test()")
//    public Object doConcurrentOperation(ProceedingJoinPoint pjp) throws Throwable {
//    	return null;
//    }
    
}
