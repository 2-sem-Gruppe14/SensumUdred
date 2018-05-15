/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.login;

import acquintaince.IData;
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

    public User creatActiveSystemUSer(String Username, UserType userType) {
        User user = null;
        switch (userType) {
            case CITIZEN:

                break;
            case CASEWORKER:

                break;
            case LEADER:

                break;
            case ADMIN:

                break;
        }

        return user;

    }

    ;

    public User verify(String username, String password) throws NullPointerException {
        UserType userType = null;
        String DBpassword = null;
        User user = null;
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
