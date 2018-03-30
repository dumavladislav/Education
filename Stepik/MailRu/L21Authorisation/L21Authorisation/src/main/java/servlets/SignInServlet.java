package servlets;

import accounts.AccountService;
import accounts.UserProfile;
import com.sun.scenario.effect.impl.sw.java.JSWBrightpassPeer;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class SignInServlet extends HttpServlet {

    AccountService accountService;

    public SignInServlet(AccountService accountService){
        this.accountService = accountService;
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter("login");
        String pass = req.getParameter("pass");

        System.out.println("SignIn -> Login: " + login + " password: "+ pass);

        resp.setContentType("text/html;charset=utf-8");


        if(login==null || pass==null || login.isEmpty() || pass.isEmpty()){
            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            return;
        }

        UserProfile userProfile = accountService.getUserByLogin(login);
        if(userProfile == null){
            resp.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            resp.getWriter().println("Unauthorized");
            return;
        }

        if(userProfile.getPass().equals(pass)) {
            resp.getWriter().println("Authorized: "+login);
            resp.setStatus(HttpServletResponse.SC_OK);
        }
        else{
            resp.getWriter().println("Login Failed!!!");
            resp.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        }


    }
}
