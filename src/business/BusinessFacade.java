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
    private ILogger logger = new InteractionLogger(dataBase);
    private ILogin login = new Login(dataBase,logger);

    private UserType usertype;
    private IUser ActiveUser;

    //</editor-fold>
    public BusinessFacade() {
    }

    //<editor-fold defaultstate="collapsed" desc="TEST METHODS/layering">
    @Override
    public String TestData() {
        return dataBase.DataBaseTest();
    }

    public String TestCPRAPI() {

        return CPRAPI.callCPRRegister();
    }
   @Override
    public void injectData(IData data) {
        this.dataBase = data;
    }

    @Override
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
    @Override
    public void login(String username, String password) throws NullPointerException {
        String DBpassword = null;
        User user = null;
        if (login.attemptControl()) {
            try {
                DBpassword = dataBase.GetPassword(username);
            } catch (NullPointerException e) {
                login.failLoginAttempt();
            }//catch null
            if (password.equals(DBpassword)) {
                user = (User) dataBase.getUser(username);

                logger.logLogin(user.getUserID());
            } else {
                login.failLoginAttempt();
            }

        }//if at 
        ActiveUser = user;
    }//m-login

    @Override
    public boolean GUILogin(String username, String password) {
        if (login.verify(username, password) == null) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Login Fejl");
            alert.setHeaderText("Kunne ikke finde kontoen");
            alert.setContentText("Kontroller om Brugernavn og password er korrekt");

            //alert.showAndWait();
            return true;
        } else {
            login(username, password);
            return true;
        }

    }

    //</editor-fold> 
    //<editor-fold defaultstate="collapsed" desc="CASE">
    @Override
    public Case getCase(int caseID) {
        try {
            return (Case) dataBase.getCase(caseID);
        } catch (SQLException ex) {
            Logger.getLogger(BusinessFacade.class.getName()).log(Level.SEVERE, null, ex);
        return null;
        }
    }

    @Override
    public boolean addCase(int caseID, int CPR, String caseContent) {
        try {
            dataBase.addCase(caseID, CPR, caseContent);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(BusinessFacade.class.getName()).log(Level.SEVERE, null, ex);

        }
        return true;
    }

    //</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="ADD USERS">
    @Override
    public boolean addAdmin(String username, String password) {
        User admin = new User(usertype.ADMIN, username, password);
        dataBase.addUser(admin.getUsername(), admin.getPassword(), admin.getUserType().toString());
        return true;
    }

    @Override
    public boolean addLeader(String username, String password) {
        User leader = new User(usertype.LEADER, username, password);
        dataBase.addUser(leader.getUsername(), leader.getPassword(), leader.getUserType().toString());

        return true;
    }

    @Override
    public boolean addCaseWorker(String username, String password) {
        User caseWorker = new User(usertype.CASEWORKER, username, password);
        dataBase.addUser(caseWorker.getUsername(), caseWorker.getPassword(), caseWorker.getUserType().toString());

        return true;
    }

    @Override
    public boolean addCitizen(int CPR, String username, String password) {
        User citizen = new User(usertype.CITIZEN, username, password);
        //dataBase.addUser(citizen);
        return true;
    }

    //</editor-fold>
}
