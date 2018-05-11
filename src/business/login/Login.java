/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.login;

import business.User.Citizen;
import business.User.Interfaces.User;
import business.logger.ILogger;
import business.logger.IServer;

/**
 *
 * @author Lenovo
 */
public class Login implements ILogin {

    IServer server;
    ILogger logger;

    int Attempts = 0;

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

    public User verify(String username, String password) throws NullPointerException {
        String DBpassword = null;
        User user = null;
        if (attemptControl()) {
            try {
                DBpassword = server.GetPassword(username);
            } catch (NullPointerException e) {
                failLoginAttempt();
            }//catch null
            if (password.equals(DBpassword)) {
                user = server.getUser(username);
                logger.logLogin(user.getID());
                Attempts=0;

            } else {
                failLoginAttempt();
            }

        }//if at 

        return user;
    }//m-login
}
