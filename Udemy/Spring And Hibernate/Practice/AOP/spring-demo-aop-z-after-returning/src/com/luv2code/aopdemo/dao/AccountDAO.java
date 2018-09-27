package com.luv2code.aopdemo.dao;

import com.luv2code.aopdemo.Account;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class AccountDAO {

    private String name;
    private String level;

    public void addAccount(Account theAccount, boolean vipFlag) {
        System.out.println(getClass() + ": DOING MY DB WORK - ADDING ACCOUNT " + theAccount.getName());
    }

    public boolean doWork() {
        System.out.println(getClass() + ": DOING SOME WORK");
        return false;
    }

    public String getName() {
        System.out.println(getClass() + ": in getName");
        return name;
    }

    public void setName(String name) {
        System.out.println(getClass() + ": in setName");
        this.name = name;
    }

    public String getLevel() {
        System.out.println(getClass() + ": in getLevel");
        return level;
    }

    public void setLevel(String level) {
        System.out.println(getClass() + ": in setLevel");
        this.level = level;
    }

    // add a new method: findAccounts()
    public List<Account> findAccounts() {
        List<Account> myAccounts = new ArrayList();
        myAccounts.add(new Account("Account1", "Premium"));
        myAccounts.add(new Account("Account2", "Silver"));
        myAccounts.add(new Account("Account3", "Gold"));
        myAccounts.add(new Account("Account4", "Bronze"));

        return myAccounts;
    }
}
