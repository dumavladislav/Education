package com.luv2code.aopdemo;

import com.luv2code.aopdemo.dao.AccountDAO;
import com.luv2code.aopdemo.dao.MembershipDAO;
import org.aspectj.weaver.Member;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainDemoApp {
    public static void main(String[] args) {

        // read spring config java class
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);

        // get the bean from spring container
        AccountDAO theAccountDAO = context.getBean("accountDAO", AccountDAO.class);
        MembershipDAO theMembershipDAO = context.getBean("membershipDAO", MembershipDAO.class);

        // call the business method
        Account theAccount = new Account();
        theAccount.setName("dumsky284");
        theAccountDAO.addAccount(theAccount, true);
        theAccountDAO.doWork();
        theAccountDAO.setName("QQQQ");
        theAccountDAO.setLevel("111");

        theAccountDAO.getName();
        theAccountDAO.getLevel();


        theMembershipDAO.addSomeAccount();
        theMembershipDAO.goToSleep();


        //close the context
        context.close();
    }
}
