package servlets;

import accounts.AccountService;

import javax.servlet.http.HttpServlet;

public class UsersServlet extends HttpServlet {

    private final AccountService accountService;

    public UsersServlet(AccountService accountService){
        this.accountService = accountService;
    }

}
