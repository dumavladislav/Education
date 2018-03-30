package main;

import accounts.AccountsService;
import dbService.DBService;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import servlets.SignInServlet;
import servlets.SignUpServlet;

import javax.servlet.ServletContext;
import java.sql.SQLException;

public class Main {

    public static void main(String[] args){

        DBService dbService= new DBService();
        dbService.printConnectionInfo();
        AccountsService accountsService = new AccountsService(dbService);

        ServletContextHandler context = new ServletContextHandler();
        context.addServlet(new ServletHolder(new SignUpServlet(accountsService)), "/signup");
        context.addServlet(new ServletHolder(new SignInServlet(accountsService)), "/signin");

        Server server = new Server(8080);
        server.setHandler(context);

        try {
            server.start();
            System.out.println("Server started");
            server.join();
        } catch (Exception e) {
            e.printStackTrace();
        }

        /*
        try {
            long newUserId = dbService.addUser("kuku");
        } catch (SQLException e) {
            e.printStackTrace();
        }*/
    }

}
