package ru.dumsky284.testdb;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;

@WebServlet(name = "TestDbServlet")
public class TestDbServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // setup connection variables
        String user = "springstudent";
        String pass = "springstudent";

        String jdbcUrl = "jdbc:mysql://192.168.99.100:32768/web_customer_tracker?useSSL=false";
        String driver = "com.mysql.jdbc.Driver";

        // connect to the database

        try {
            PrintWriter out = response.getWriter();
            out.println("Connecting to database: " + jdbcUrl);

            Class.forName(driver);

            Connection myConn = DriverManager.getConnection(jdbcUrl, user, pass);

            out.println("Connection SUCCESSFUL!!!");

            myConn.close();

        }
        catch(Exception exc) {
            exc.printStackTrace();
            throw new ServletException(exc);
        }
    }
}
