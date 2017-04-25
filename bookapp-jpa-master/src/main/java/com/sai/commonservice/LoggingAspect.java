package com.sai.commonservice;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;


@EnableAspectJAutoProxy
public class LoggingAspect {
	
	@After("execution(* com.janani.service.UserService.*(..))")
		
    public void logAfterAllMethods(JoinPoint joinPoint) 
    {
        System.out.println("****LoggingAspect.logAfterAllMethods() : " + joinPoint.getSignature().getName());
    }
     
    

}
