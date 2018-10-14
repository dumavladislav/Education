package com.luv2code.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(2)
public class MyDemoLoggingAspect {

    @Before("com.luv2code.aopdemo.aspect.AopDeclarations.forDAOPackageNoGetterSetter()") // Using pointcut declaration (above)
    public void beforeAddAccountAdvice() {
        System.out.println("=====>>> Executing @Before advice on method addAccount()");
    }
}
