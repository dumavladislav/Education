package accounts;

import dbService.DBService;
import dbService.dataSets.UsersDataSet;

public class AccountsService {

    private DBService dbService;

    public AccountsService(DBService dbService){
        this.dbService = dbService;
    }

    public void addNewUser(UsersDataSet userProfile){
        long userId = dbService.addUser(userProfile.getName());
    }

    public UsersDataSet getUserByLogin(String login){
        return dbService.getUserData(login);
    }
}
