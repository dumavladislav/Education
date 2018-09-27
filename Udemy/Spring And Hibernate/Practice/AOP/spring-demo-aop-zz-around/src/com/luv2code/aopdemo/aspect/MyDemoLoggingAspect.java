package com.luv2code.aopdemo.aspect;

import com.luv2code.aopdemo.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;

@Aspect
@Component
@Order(2)
public class MyDemoLoggingAspect {

    @Around("execution(* com.luv2code.aopdemo.service.*.getFortune(..))")
    public Object aroundGetFortune(
            ProceedingJoinPoint theProceedingJoinPoint) throws Throwable {

        // print the method
        System.out.println("======>>> Executing @Around advice on method: " + theProceedingJoinPoint.getSignature().toShortString());

        // get begin timestamp
        long begin = System.currentTimeMillis();

        // execute the method
        Object result = theProceedingJoinPoint.proceed();

        // get end timestamp
        long end = System.currentTimeMillis();

        // compute duration and display it
        long duration = end - begin;
        System.out.println("=====>>> Duration: " + duration/1000.0 + " seconds");

        return result;
    }


    @After("execution(* com.luv2code.aopdemo.dao.AccountDAO.findAccounts(..))")
    public void afterFinallyFindAccountsAdvice(JoinPoint theJoinPoint) {
        // print the method
        System.out.println("======>>> Executing @After (finally) advice on method: " + theJoinPoint.getSignature().toShortString());
    }








    @AfterThrowing(
            pointcut="execution(* com.luv2code.aopdemo.dao.AccountDAO.findAccounts(..))",
            throwing = "theExc"
    )
    public void afterThrowingFindAccountAdvice(JoinPoint theJoinPoint, Throwable theExc) {

        // print the method
        System.out.println("======>>> Executing @AfterThrowing advice on method: " + theJoinPoint.getSignature().toShortString());

        // print the exception
        System.out.println("======>>> Exception: " + theExc);
    }





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

    @AfterReturning(
            pointcut = "execution(* com.luv2code.aopdemo.dao.AccountDAO.findAccounts(..))",
            returning="result")
    private void afterReturningFindAccountAdvice(JoinPoint theJoinPoint, List<Account> result) {

        // print which method we are advicing on
        String method = theJoinPoint.getSignature().toShortString();
        System.out.println("=======>>> Executing @AfterReturning on method: " + method);

        // print method result
        System.out.println("=======>>> Method result is:");
        System.out.println(result);

        // let's post-process the data (modify it)

        // MODIFICATION OF THE RESULTS: convert the account names to uppercase
        convertAccountNamesToUpperCase(result);
    }

    private void convertAccountNamesToUpperCase(List<Account> result) {

        // loop through accounts
        for(Account tempAccount: result) {

            // get uppercase version of name
            String theUpperName = tempAccount.getName().toUpperCase();

            // update the name on the account
            tempAccount.setName(theUpperName);

        }
    }
}
