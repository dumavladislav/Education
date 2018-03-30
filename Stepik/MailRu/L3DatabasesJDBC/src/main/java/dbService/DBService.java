package dbService;

import dbService.dao.UsersDAO;
import dbService.dataSets.UsersDataSet;
import org.h2.jdbcx.JdbcDataSource;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBService {

    private final Connection connection;

    public DBService(){
        connection = getH2Connection();
    }

    public static Connection getH2Connection(){

        String url = "jdbc:h2:./h2db";
        String name = "sa";
        String pass = "";

        JdbcDataSource ds = new JdbcDataSource();
        ds.setURL(url);
        ds.setUser(name);

        try {
            Connection connection = DriverManager.getConnection(url, name, pass);
            return connection;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void printConnectionInfo(){
        try {
            System.out.println("DB name: " + connection.getMetaData().getDatabaseProductName());
            System.out.println("DB Version: " + connection.getMetaData().getDatabaseProductVersion());
            System.out.println("DB Driver: " + connection.getMetaData().getDriverName());
            System.out.println("Autocommit: " + connection.getAutoCommit());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public long addUser(String name){
        try {
            connection.setAutoCommit(false);
            UsersDAO usersDAO = new UsersDAO(connection);
            usersDAO.insertUser(name);
            return usersDAO.getUserId(name);
        } catch (SQLException e) {
            try {
                connection.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        } finally {
            try {
                connection.setAutoCommit(true);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return -1;
    }

    public UsersDataSet getUserData(String login){

        try {
            UsersDAO usersDAO = new UsersDAO(connection);
            return usersDAO.get(usersDAO.getUserId(login));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

}
