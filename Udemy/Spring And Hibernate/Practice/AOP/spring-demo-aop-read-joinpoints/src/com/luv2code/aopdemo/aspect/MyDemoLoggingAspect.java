package com.luv2code.aopdemo.aspect;

import com.luv2code.aopdemo.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(2)
public class MyDemoLoggingAspect {

    @Before("com.luv2code.aopdemo.aspect.AopDeclarations.forDAOPackageNoGetterSetter()") // Using pointcut declaration (above)
    public void beforeAddAccountAdvice(JoinPoint theJoinPoint) {
        System.out.println("=====>>> Executing @Before advice on method addAccount()");

        // display method signature
        MethodSignature mSig = (MethodSignature) theJoinPoint.getSignature();
        System.out.println("Method signture: " + mSig);

        // display method arguments
        Object[] args = theJoinPoint.getArgs();

        for (Object arg : args) {
            System.out.println(arg);

            if (arg instanceof Account) {
                // downcast and print Account info
                Account theAccount = (Account) arg;
                System.out.println("Account Name: " + theAccount.getName());
                System.out.println("Account Level: " + theAccount.getLevel());
            }
        }


    }
}
