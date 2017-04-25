package com.sai.commonservice;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;





@Aspect
public class LoggingAspect {
	
	
	private static final Logger LOGGER = Logger.getLogger(LoggingAspect.class);
	
	@After("execution(* com.janani.controller.AuthenticationController.*(..))")
		
    public void logAfterAllMethods(JoinPoint joinPoint) 
        {
		
		LOGGER.info("entering AuthController Methods");
        System.out.println("****LoggingAspect.logAfterAllMethods() : " + joinPoint.getSignature().getName());
    }
     
	@After("execution(* com.janani.controller.AuthenticationController.login(..))")
    public void logAfterLogin(JoinPoint joinPoint) 
    {
		LOGGER.info("Entering login");
        System.out.println("****LoggingAspect.logAfterLogin() : " + joinPoint.getSignature().getName());
}
    

}
