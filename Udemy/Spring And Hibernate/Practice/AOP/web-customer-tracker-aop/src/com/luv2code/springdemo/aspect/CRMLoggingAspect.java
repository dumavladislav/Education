package com.luv2code.springdemo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Aspect
@Component
public class CRMLoggingAspect {

    // setup logger
    private Logger myLogger = Logger.getLogger(getClass().getName());

    // setup pointcut declarations
    @Pointcut("execution(* com.luv2code.springdemo.controller.*.*(..))")
    private void forControllerPackage() {}

    @Pointcut("execution(* com.luv2code.springdemo.dao.*.*(..))")
    private void forDaoPackage() {}

    @Pointcut("execution(* com.luv2code.springdemo.service.*.*(..))")
    private void forServicePackage() {}

    @Pointcut("forControllerPackage() || forDaoPackage() || forServicePackage()")
    private void forAppFlow() {}

    // add @Before advice
    @Before("forAppFlow()")
    public void logBeforeEvent(
            JoinPoint theJoinPoint
    ) {
        // log the method name
        myLogger.info("========>>> @Before method: " + theJoinPoint.getSignature().toShortString());

        // print out method parameters
        Object[] args = theJoinPoint.getArgs();
        for(Object arg: args) {
            myLogger.info("========>>> Arguments: " + arg);
        }
    }

    // add @AfterReturning advice
    @AfterReturning(
            pointcut="forAppFlow()",
            returning = "theResult")

    public void logAfterReturningEvent(
            JoinPoint theJoinPoint, Object theResult
    ) {
        // log the method name
        myLogger.info("========>>> @AfterReturning from method: " + theJoinPoint.getSignature().toShortString());

        // display data return
        myLogger.info("========>>> result: " + theResult);
    }

}
