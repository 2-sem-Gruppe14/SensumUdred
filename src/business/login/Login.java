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
        String userTypeString = null;
        UserType userType;
        String DBpassword;
        IUser user = null;
        
        // gets the usernames password from the data base
        DBpassword = DB.GetPassword(username);
        
        // gets the usernames user type from the data base
        userTypeString = DB.getUserType(username);
        
        // if the database does not return any user type, return null
        if (userTypeString == null)
            return user;
        
        // retrieves the user type object from enum
        userType = getUserTypeObject(userTypeString);
        
        // if the getUserTypeObject method does not return any user type
        // return null
        if (userType == null)
            return user;

        // checks if the password from the database is null, and if it is
        // add failed login attempt
        if (DBpassword == null)
            failLoginAttempt();

        // checks if the given password is equal to the password from
        // the database
        if (password.equals(DBpassword)) {
            // gets a new user object with all the now verified informations
            user = creatActiveSystemUSer(username, userType, password);
            
            // logs the succesful login attempt
            logger.logLogin(user.getUserID());
            
            // clears the login attempts
            Attempts = 0;

        // if the given password was NOT equal to the password from
        // the database
        } else {
            failLoginAttempt();
        }
        
        // returns the user object if successful, else return null
        return user;
    }//m-login
    
    private UserType getUserTypeObject(String userTypeString) {
        // defines the user type object to be returned
        UserType userType = null;
        
        // checks which user type the given string is
        if (userTypeString.equals(UserType.ADMIN.toString())) {
            userType = UserType.ADMIN;
        } else if (userTypeString.equals(UserType.CASEWORKER.toString())) {
            userType = UserType.CASEWORKER;
        } else if (userTypeString.equals(UserType.CITIZEN.toString())) {
            userType = UserType.CITIZEN;
        } else if (userTypeString.equals(UserType.LEADER.toString())) {
            userType = UserType.LEADER;
        }
        
        // returns the user type or null if an error happened
        return userType;
    }

}
