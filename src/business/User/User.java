/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.User;

import acquintaince.IData;
import business.caseOpening.Case;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Lenovo
 */
public class User implements IUser, ICitizen, ICaseWorker, ILeader, IAdmin {

    private UserType userType;
    private String name;
    private int UserID;
    private String username;
    private String password;
    private int[] caseIDs;

    /**
     * constructor for all user (exseption citizen) ID will be autoincremented
     *
     * @param userType
     * @param name
     * @param username
     * @param password
     */
    public User(UserType userType, String name, String username, String password) {
        this.userType = userType;
        this.name = name;
        this.username = username;
        this.password = password;
    }

    /**
     * overloaded constructor for citizen
     *
     * @param userType
     * @param username
     * @param password
     */
    public User(UserType userType, String username, String password) {
        this.userType = userType;
        this.username = username;
        this.password = password;
    }

    //<editor-fold defaultstate="collapsed" desc="Setter/getter">
    /**
     * setter/getter methods to chance or return values of class variables
     *
     * @return the selected value or void if value is changed
     */
    public int getUserID() {
        return UserID;
    }

    public void setUserID(int UserID) {
        this.UserID = UserID;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public UserType getUserType() {
        return userType;
    }

    public void setUserType(UserType userType) {
        this.userType = userType;
    }

    /**
     * returns the uinque id of the user
     *
     * @return id as int
     */
    //</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="citizen">
    /**
     * Gets the case responding to this.CitizenID
     *
     * @param CitizenID
     * @return Case
     */
    @Override
    public void getPersonalCase(int CitizenID) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    //</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="CaseWorer">

    /**
     * Opens a new case
     *
     * @param caseID the interger representing the case's unique ID nr.
     * (generated in the database)
     * @param creationDate the date of creation
     * @param lastChanged the date the last modification happend
     * @param lastChangedBy the id of the last worker to chance the case
     * infromation
     * @param caseDescription a description of the case
     */
    @Override
    public void openCase(int caseID, Date creationDate, Date lastChanged, String lastChangedBy, String caseDescription) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * save the case give en args to the database
     *
     * @param currentCase the case that needs to be saved
     * @param caseWorkerID the id of the caseworker trying to save a case
     */
    @Override
    public void saveCase(Case currentCase, int caseWorkerID) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * used when a caseworker is created when user data is loaded from the
     * database
     *
     * @param caseWorkerID
     */
    private void setCaseWorkerID(int caseWorkerID) {
        this.UserID = caseWorkerID;
    }

    //</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="Leader">
   
    /**
     * returns a caseworker matching the id given in param
     *
     * @param caseWorkerID
     * @return User
     */
    @Override
    public User getCaseWorker(int caseWorkerID) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
 /**
     * adds a caseworker as a new user
     *
     * @param name
     * @param caseWorkerID
     * @param username
     * @param password
     */
    @Override
    public void addCaseWorker(String name, int caseWorkerID, String username, String password) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    //</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="Admin">
    /**
     * creates a new Caseworker in the system, and adds them to the database
     * @param name
     * @param caseWorkerID
     * @param username
     * @param password
     */
    @Override
    public void newCaseWorker(String name, int caseWorkerID, String username, String password) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
 /**
     * creates a new leader in the system, and adds them to the database
     * @param name
     * @param caseWorkerID
     * @param username
     * @param password
     */
    @Override
    public void newLeader(String name, int LeaderID, String username, String password) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
 /**
     * creates a new admin in the system, and adds them to the database
     * @param name
     * @param caseWorkerID
     * @param username
     * @param password
     */
    @Override
    public void newAdmin(String name, int adminID, String username, String password) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
/**
 * returns ID's of all caseworker in a department
 * @param departmentID 
 */
    @Override
    public void getDepartmentsCaseWorkers(int departmentID) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void getLogCaseViewing(int caseID) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void getlogCaseCreation(int caseID) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void getlogCaseediting(int caseID) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void getlogCaseDeletion(int caseID) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void getLogCaseWorkerViewing(int caseWorkerID) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void getlogCaseWorkerCreation(int caseWorkerID) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void getlogCaseWorkerEditing(int caseWorkerID) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void getlogCaseWorkerDeletion(int caseWorkerID) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    //</editor-fold>
    @Override
    public void loaded(int UserID) {
        this.UserID = UserID;
    }

    public void CaseWorkerloaded(int UserID, int[] caseIDs) {
        this.UserID = UserID;
        this.caseIDs = caseIDs;
    }

    @Override
    public void CaseWorkerloaded(int UserID, List<Integer> caseIDs) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}//Class-User
