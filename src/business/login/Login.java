/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.login;

import acquintaince.IData;
import business.User.IAdmin;
import business.User.ICaseWorker;
import business.User.ICitizen;
import business.User.ILeader;
import business.User.IUser;
import business.User.User;
import business.User.UserType;
import business.logger.ILogger;

/**
 *
 * @author Lenovo
 */
public class Login implements ILogin {

    ILogger logger;
    IData DB;
    int Attempts = 0;

    public Login(IData DB) {
        this.DB = DB;
    }

    /**
     * check that no more the 3 login attempts has happend
     *
     * @return
     */
    public boolean attemptControl() {
        if (Attempts < 3) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * adds 1 to login attempts if the login attempt fails do to wrong password
     * or username
     */
    public void failLoginAttempt() {
        Attempts++;
    }
/**
 * creates a instance of the interface the matches the user trying to logins securety clearens.
 * @param Username
 * @param userType
 * @return 
 */
    public IUser creatActiveSystemUSer(String Username, UserType userType) {
        User user = null;
        switch (userType) {
            case CITIZEN:
                ICitizen citizen = new User(userType, Username, Username, Username);
                return citizen;
            case CASEWORKER:
                ICaseWorker CaseWorker = new User(userType, Username, Username, Username);
                return CaseWorker;
            case LEADER:
                ILeader Leader = new User(userType, Username, Username, Username);
                return Leader;
            case ADMIN:
                IAdmin admin = new User(userType, Username, Username, Username);
                return admin;
                 }

        return user;

    }

 

    /**
     *
     * @param username
     * @param password
     * @return
     * @throws NullPointerException
     */
    public IUser verify(String username, String password) throws NullPointerException {
        UserType userType = null;
        String DBpassword = null;
        IUser user = null;
        if (attemptControl()) {
            try {
                DBpassword = DB.GetPassword(username);
            } catch (NullPointerException e) {
                failLoginAttempt();
            }//catch null
            if (password.equals(DBpassword)) {
                user = creatActiveSystemUSer(username, userType);
                logger.logLogin(user.getUserID());
                Attempts = 0;

            } else {
                failLoginAttempt();
            }

        }//if at 

        return user;
    }//m-login
}
