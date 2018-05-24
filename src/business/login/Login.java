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
    
    public Login(IData DB,ILogger logger) {
        this.logger=logger;
        this.DB = DB;
    }
    
/**
 * sets logger to null to avoid acess when program is running
 */
    /**
     * check that no more the 3 login attempts has happend
     *
     * @return
     */
    @Override
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
    @Override
    public void failLoginAttempt() {
        Attempts++;
    }

    /**
     * creates a instance of the interface the matches the user trying to logins
     * securety clearens.
     *
     * @param Username
     * @param userType
     * @param Password
     * @return
     */
    public IUser creatActiveSystemUSer(String Username, UserType userType, String Password) {
        User user = null;
        switch (userType) {
            case CITIZEN:
                ICitizen citizen = new User(userType, DB.getName(Username), Username, Password);
                citizen.loaded(DB.getID(Username));
                return citizen;
            case CASEWORKER:
                ICaseWorker CaseWorker = new User(userType, DB.getName(Username), Username, Password);
                int ID = DB.getID(Username);
               // CaseWorker.CaseWorkerloaded(ID, DB.getCaseIDs(ID));
                return CaseWorker;
            case LEADER:
                ILeader Leader = new User(userType, DB.getName(Username), Username, Password);
                Leader.loaded(DB.getID(Username));
                return Leader;
            case ADMIN:
                IAdmin admin = new User(userType, DB.getName(Username), Username, Password);
                admin.loaded(DB.getID(Username));
                return admin;
        }

        return user;
//test
    }

    /**
     *
     * @param username
     * @param password
     * @return
     * @throws NullPointerException
     */
    @Override
    public IUser verify(String username, String password) throws NullPointerException {
        UserType userType = null;
        String DBpassword = null;
        IUser user = null;
        
        if (attemptControl()) {
            DBpassword = DB.GetPassword(username);
            
            if (DBpassword == null)
                failLoginAttempt();
            
            
            if (password.equals(DBpassword)) {
                user = creatActiveSystemUSer(username, userType, password);
                logger.logLogin(user.getUserID());
                Attempts = 0;

            } else {
                failLoginAttempt();
            }

        }//if at 

        return user;
    }//m-login

}
