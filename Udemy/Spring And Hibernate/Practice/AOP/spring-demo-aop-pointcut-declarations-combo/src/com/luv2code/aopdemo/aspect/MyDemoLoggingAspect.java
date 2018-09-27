package com.luv2code.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {

    // this is where we add all of our related advices for logging

    @Pointcut("execution(* com.luv2code.aopdemo.dao.*.*(..))")  // Any method in package "com.luv2code.aopdemo.dao"
    private void forDAOPackage() {}

    // create pointcut for getter methods
    @Pointcut("execution(* com.luv2code.aopdemo.dao.*.get*(..))")
    private void getter() {}

    // create pointcut for setter methods
    @Pointcut("execution(* com.luv2code.aopdemo.dao.*.set*(..))")
    private void setter() {}

    // create pointcut: include package ... exclude getters and setters
    @Pointcut("forDAOPackage() && !(getter() || setter())")
    private void forDAOPackageNoGetterSetter() {}

    // let's start with an @Before advice
    //@Before("execution(public void addAccount())") // Any public void addAccount() method in any class
    //@Before("execution(public void com.luv2code.aopdemo.dao.AccountDAO.addAccount())")  // specifically in package com.luv2code.aopdemo.dao.AccountDAO
    //@Before("execution(public void add*())") // Any public void method with name starting with "add" in any class
    //@Before("execution(* add*())") // Any method with name starting with "add" in any class with any return type and access modifier
    //@Before("execution(* add*(com.luv2code.aopdemo.Account))") // Any method with name starting with "add" in any class with any return type and access modifier WITH paramter of type com.luv2code.aopdemo.Account
    //@Before("execution(* add*(com.luv2code.aopdemo.Account, boolean))") // Any method with name starting with "add" in any class with any return type and access modifier WHICH takes 2 paramters of type com.luv2code.aopdemo.Account AND boolean
    //@Before("execution(* add*(com.luv2code.aopdemo.Account, ..))") // Any method with name starting with "add" in any class with any return type and access modifier WHICH takes any number of paramters but first of type type com.luv2code.aopdemo.Account
    //@Before("execution(* com.luv2code.aopdemo.dao.*.*(..))") // Any method in package "com.luv2code.aopdemo.dao"
    @Before("forDAOPackageNoGetterSetter()") // Using pointcut declaration (above)
    public void beforeAddAccountAdvice() {
        System.out.println("\n=====>>> Executing @Before advice on method addAccount()");
    }

    @Before("forDAOPackageNoGetterSetter()")
    public void performApiAnalytics() {
        System.out.println("=====>>> Performing analytics");
    }

}
