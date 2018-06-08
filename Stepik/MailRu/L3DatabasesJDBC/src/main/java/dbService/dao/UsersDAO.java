package dbService.dao;

import dbService.dataSets.UsersDataSet;
import dbService.executor.Executor;

import java.sql.Connection;
import java.sql.SQLException;

public class UsersDAO {

    private Executor executor;

    public UsersDAO(Connection connection){

        this.executor = new Executor(connection);

        try {
            createTable();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public UsersDataSet get(long userId) throws SQLException{
        return executor.execQuery("select * from users where id = " + userId,
                result -> {
                    result.next();
                    return new UsersDataSet(result.getLong("id"), result.getString("user_name"));
                }
                );
    }

    public long getUserId(String name) throws SQLException{
        return executor.execQuery("select id from users where user_name = '"+name+"'",
                result -> {
                    result.next();
                    return result.getLong(1);
                }
                );
    }

    public void insertUser(String name) throws SQLException {
        executor.execUpdate("insert into users (user_name) values ('" + name + "')");
    }

    public void createTable() throws SQLException {
        executor.execUpdate("create table if not exists users (id bigint auto_increment, user_name varchar(256), primary key (id))");
    }

    public void dropTable() throws SQLException {
        executor.execUpdate("drop table users");
    }

}