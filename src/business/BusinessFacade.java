/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import acquintaince.*;
import business.User.User;
import business.User.UserType;
import business.caseOpening.Case;
import business.logger.InteractionLogger;
import business.login.Login;
import java.io.FileNotFoundException;
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
    private Login login = new Login(dataBase);
    private InteractionLogger logger = new InteractionLogger();
    private UserType usertype;
    //</editor-fold>
    public BusinessFacade() {
    }

    //<editor-fold defaultstate="collapsed" desc="TEST METHODS">
    @Override
    public String TestData() {
        return dataBase.DataBaseTest();
    }

    public String TestCPRAPI() {

        return CPRAPI.callCPRRegister();
    }

    //</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="Layering">
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
        return dataBase.getUser(UserID);
    }

    //</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="login">
    @Override
    public User login(String username, String password) throws NullPointerException {
        String DBpassword = null;
        User user = null;
        if (login.attemptControl()) {
            try {
                DBpassword = dataBase.GetPassword(username);
            } catch (NullPointerException e) {
                login.failLoginAttempt();
            }//catch null
            if (password.equals(DBpassword)) {
                user = dataBase.getUser(username);
                dataBase.logLogin(user.getUserID());
            } else {
                login.failLoginAttempt();
            }

        }//if at 
        return user;
    }//m-login

    @Override
    public boolean GUILogin(String username, String password) {
        if (login(username, password) == null) {
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
        return dataBase.getCase(caseID);
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
    public boolean addAdmin(String name, String username, String password) {
        User admin = new User(usertype.ADMIN, name, username, password);
        dataBase.addUser(admin);
        return true;
    }

    @Override
    public boolean addLeader(String name, String username, String password) {
        User leader = new User(usertype.LEADER, name, username, password);
        dataBase.addUser(leader);

        return true;
    }

    @Override
    public boolean addCaseWorker(String name, String username, String password) {
        User caseWorker = new User(usertype.CASEWORKER, name, username, password);
        dataBase.addUser(caseWorker);

        return true;
    }

    @Override
    public boolean addCitizen(String name, int CPR, String username, String password) {
        User citizen = new User(usertype.CITIZEN, name, username, password, CPR);
        dataBase.addUser(citizen);
        return true;
    }

    //</editor-fold>
}
