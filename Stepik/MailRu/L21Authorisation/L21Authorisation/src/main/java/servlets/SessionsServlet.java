package servlets;

import accounts.AccountService;
import accounts.UserProfile;
import com.google.gson.Gson;
import org.eclipse.jetty.server.Authentication;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class SessionsServlet extends HttpServlet {

    private final AccountService accountService;

    public SessionsServlet(AccountService accountService){
        this.accountService = accountService;
    }

    //doGet - get active user session
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        AccountService accountService = new AccountService();

        resp.setContentType("text/html;charset=utf-8");

        UserProfile userProfile = accountService.getUserBySessionId(req.getSession().getId());
        if(userProfile == null){
            resp.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        }
        else
        {
            Gson gson = new Gson();
            String userJson = gson.toJson(userProfile);
            resp.getWriter().println(userJson);
            resp.setStatus(HttpServletResponse.SC_OK);
        }
    }


    // doPost - sign user in
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        System.out.println("Entered doGet!!!");

        String login = req.getParameter("login");
        String pass = req.getParameter("pass");

        resp.setContentType("text/html;charset=utf-8");

        System.out.println(login + "/" + pass);

        if(login==null || pass==null || login.isEmpty() || pass.isEmpty()){
            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            return;
        }

        UserProfile userProfile = accountService.getUserByLogin(login);
        if(userProfile==null){
            resp.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            return;
        }

        accountService.addSession(req.getSession().getId(), userProfile);
        resp.getWriter().println(new Gson().toJson(userProfile));
        resp.setStatus(HttpServletResponse.SC_OK);

    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String sessionId = req.getSession().getId();

        resp.setContentType("text/html;charset=utf-8");

        AccountService accountService = new AccountService();
        UserProfile userProfile = accountService.getUserBySessionId(sessionId);
        if(userProfile == null){
            resp.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        }
        else {
            accountService.deleteSession(sessionId);
            resp.getWriter().println("Goodbye, " + userProfile.getLogin());
            resp.setStatus(HttpServletResponse.SC_OK);
        }
    }
}
