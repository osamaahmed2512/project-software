package com.aryan.ecom.aop;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.stereotype.Component;


@Aspect
@Component
public class trycatch {
    private static final Logger logger = LoggerFactory.getLogger(trycatch.class);

    @Pointcut("execution(* com.aryan.ecom.services..*(..))")
    public void serviceMethods() {
    }

    @AfterThrowing(pointcut = "serviceMethods()", throwing = "ex")
    public void handleServiceError(JoinPoint joinPoint, Exception ex) {
        String methodName = joinPoint.getSignature().getName();
        String className = joinPoint.getTarget().getClass().getName();
        logger.error("An error occurred in service method {} of class {}: {}", methodName, className, ex.getMessage(),ex);
    }

    @AfterThrowing(pointcut = "serviceMethods()", throwing = "ex")
    public void handleGenericError(Exception ex) {
        throw new RuntimeException("An unexpected error occurred: " + ex.getMessage());
    } 
}
