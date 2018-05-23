/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import acquintaince.*;
import business.User.IUser;
import business.User.User;
import business.User.UserType;
import business.caseOpening.Case;
import business.logger.ILogger;
import business.logger.InteractionLogger;
import business.login.ILogin;
import business.login.Login;
import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.control.Alert;

/**
 *
 * @author BenPaxIndustries
 */
public class BusinessFacade implements IBusiness {

//<editor-fold defaultstate="collapsed" desc="variables">
    private IData dataBase;
    private ICPRRegisterAPI CPRAPI;
    private ILogger logger;
    private ILogin login;

    private UserType usertype;
    private IUser ActiveUser;

    //</editor-fold>
    public BusinessFacade() {
        logger = new InteractionLogger(dataBase);
        login = new Login(dataBase, logger);
    }

    //<editor-fold defaultstate="collapsed" desc="TEST METHODS/layering">
    /**
     * returns a value from the datalayer to check that layering is done correct
     *
     * @return confurmation String
     */
    @Override
    public String TestData() {
        return dataBase.DataBaseTest();
    }

    @Override
    public HashMap getcaseValue(HashMap<String, String> caseValue) {

        return null;
    }

    public String TestCPRAPI() {
        return CPRAPI.callCPRRegister();
    }

    @Override
    /**
     * injects the data object, in the glueclass, into the bussiness class
     */
    public void injectData(IData data) {
        this.dataBase = data;
    }

    @Override
    /**
     * injects the API object, in the glueclass, into the bussiness class
     */
    public void injectAPI(ICPRRegisterAPI API) {
        this.CPRAPI = API;
    }

    //</editor-fold> 
    //<editor-fold defaultstate="collapsed" desc="dataBase">
    User getuser(int UserID) {
        return (User) dataBase.getUser(UserID);
    }

    //</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="login">
    /**
     * login is used to log people in takes a username and password, and send
     * them to a login and database classes to validate the login attempt
     *
     * @param username
     * @param password
     */
    @Override
    public String login(String username, String password) {
        // database password and user is declared and set to null
        String DBpassword = null;
        User user = null;
        
        // if statement that checks logins have not exceeded max attempts
        if (login.attemptControl()) {
            // tries to connect to the data layer
            try {
                // gets the password from the data layer
                DBpassword = dataBase.GetPassword(username);
            } catch (NullPointerException e) {
                // returns a string that tells connection to database has failed
                return "NoDbConnection";
            }
            
            System.out.println(DBpassword);
            
            // checks if the login verification is null
            if (login.verify(username, password) == null) {
                // notifies login that a failed login attempt has happened
                login.failLoginAttempt();
                return "PasswordWrong";
            // if login verification is not null
            } else {
                // gets user
                System.out.println("Pik");
                user = (User) dataBase.getUser(username);
                ActiveUser = user;
                logger.logLogin(user.getUserID());
                return user.getUserType().toString();
            }

        } else {
            return "NoLoginAttemps";
        }

    }//m-login

    /**
     * calls the login methods and select the correct "String"/messege to return
     * to show the user
     *
     * @param username
     * @param password
     * @return a boolean to show if the login attempt was succesful
     */
    /**@Override
    public String GUILogin(String username, String password) {
        if (login.verify(username, password) == null) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Login Fejl");
            alert.setHeaderText("Kunne ikke finde kontoen");
            alert.setContentText("Kontroller om Brugernavn og password er korrekt");

            alert.showAndWait();
            return null;
        } else {
            login(username, password);
            return ActiveUser.getUserType().toString();
        }

    }**/

    //</editor-fold> 
    //<editor-fold defaultstate="collapsed" desc="CASE">
     
    /**
     * updates content of a case 
     * @param CaseID
     * @param caseInfo
     * @return 
     */
    @Override
    public boolean editCase(int CaseID, Object caseInfo) {
        return dataBase.editCase(CaseID, caseInfo);
    }
    /**
     * finds a case by its Case-ID
     *
     * @param caseID
     * @return the case matching the ID
     */
    @Override
    public Case getCase(int caseID) {
        try {
            return (Case) dataBase.getCase(caseID);
        } catch (SQLException ex) {
            Logger.getLogger(BusinessFacade.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public void SaveCase(String casePersonName, String caseCPR, String caseDescription, HashMap<String, String> caseValues1, HashMap<String, String> caseValues2) {
        Case caseTest = new Case(casePersonName, caseCPR, caseDescription, caseValues1, caseValues2);
        editCase(1, caseTest);
    }

    /**
     * creates a new case and saves it to the database
     *
     * @param caseID
     * @param CPR
     * @param caseContent
     * @return validation of the process
     */
    @Override
    public boolean addCase(int caseID, int CPR, Object caseContent) {
        try {
            dataBase.addCase(CPR, caseContent);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(BusinessFacade.class.getName()).log(Level.SEVERE, null, ex);

        }
        return true;
    }

    //</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="USERS">
    /**
     * adds citiezen as a user
     *
     * @param name
     * @param CPR
     * @param username
     * @param password
     * @return
     */
    @Override
    public boolean addCitizen(String name, int CPR, String username, String password) {
        User citizen = new User(usertype.CITIZEN, username, password);
        dataBase.addUser(username, password, usertype.CITIZEN.toString());
        return true;
    }

    /**
     * edits a user
     *
     * @param UserID
     * @param newUsername
     * @param newPassword
     * @return
     */
    @Override
    public boolean editUser(int UserID, String newUsername, String newPassword) {
        return dataBase.editUser(UserID, newUsername, newPassword);
    }

    /**
     * creates and adds a admin to the database
     *
     * @param username
     * @param password
     * @return validation of the process
     */
    @Override
    public boolean addAdmin(String username, String password) {
        User admin = new User(usertype.ADMIN, username, password);
        dataBase.addUser(admin.getUsername(), admin.getPassword(), admin.getUserType().toString());
        return true;
    }

    /**
     * creates and adds a leader to the database
     *
     * @param username
     * @param password
     * @return validation of the process
     */
    @Override
    public boolean addLeader(String username, String password) {
        User leader = new User(usertype.LEADER, username, password);
        dataBase.addUser(leader.getUsername(), leader.getPassword(), leader.getUserType().toString());

        return true;
    }

    /**
     * creates and adds a CaseWorker to the database
     *
     * @param username
     * @param password
     * @return validation of the process
     */
    @Override
    public boolean addCaseWorker(String username, String password) {
        User caseWorker = new User(usertype.CASEWORKER, username, password);
        dataBase.addUser(caseWorker.getUsername(), caseWorker.getPassword(), caseWorker.getUserType().toString());

        return true;
    }

    //</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="log">
    @Override
    public List getCaseLog(int caseID) throws SQLException {
        return dataBase.getCaseLog(caseID);
    }

    @Override
    public List getWorkerLog(int WorkerID) throws SQLException {
        return dataBase.getWorkerLog(WorkerID);
    }

    //</editor-fold>
    @Override
    public void Logout() {
        logger.logLogOut(ActiveUser.getUserID());
        ActiveUser = null;
    }


}
