package com.demo.demo_mvc.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class ControllerAspect {

    @Pointcut("execution(* com.demo.demo_mvc.*Controller+.*(..))")
    public void coreMethods() {
    }
    
    @Around("coreMethods()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
    	System.out.println("Around!");
    	return joinPoint.proceed();
    }
}
