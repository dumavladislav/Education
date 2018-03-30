package servlets;

import accounts.AccountsService;
import dbService.dataSets.UsersDataSet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

public class SignUpServlet extends HttpServlet {
    private AccountsService accountsService;

    public SignUpServlet(AccountsService accountsService){
        this.accountsService = accountsService;
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter("login");
        String pass = req.getParameter("password");

        if(login==null || login.isEmpty() /*|| pass==null || pass.isEmpty()*/){
            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            return;
        }

        accountsService.addNewUser(new UsersDataSet(0, login));

    }
}
