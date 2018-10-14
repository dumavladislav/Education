package com.luv2code.aopdemo.dao;

import org.springframework.stereotype.Component;

@Component
public class MembershipDAO {

    public boolean addSomeAccount() {
        System.out.println(getClass() + ": DOING MY DB WORK - ADDING SOME ACCOUNT");
        return true;
    }

    public boolean goToSleep() {
        System.out.println(getClass() + ": GO TO SLEEP");
        return true;
    }

}
