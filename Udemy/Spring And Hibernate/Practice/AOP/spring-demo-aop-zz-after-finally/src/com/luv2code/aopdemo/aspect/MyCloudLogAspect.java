package com.luv2code.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(3)
public class MyCloudLogAspect {

    @Before("com.luv2code.aopdemo.aspect.AopDeclarations.forDAOPackageNoGetterSetter()")
    public void logToCloud() {
        System.out.println("=====>>> Logging to Cloud");
    }
}
