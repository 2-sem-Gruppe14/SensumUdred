/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import acquintaince.*;
import business.User.Admin;
import business.User.CaseWorker;
import business.User.Citizen;
import business.User.Leader;
import business.User.User;
import business.caseOpening.Case;
import business.login.Login;
import javafx.scene.control.Alert;

/**
 *
 * @author BenPaxIndustries
 */
public class BusinessFacade implements IBusiness {

//<editor-fold defaultstate="collapsed" desc="variables">
    private IData dataBase;
    private ICPRRegisterAPI CPRAPI;
    private Login login = new Login();
    //</editor-fold>

    public BusinessFacade() {
    }

    @Override
    public void injectData(IData data) {
        this.dataBase = data;
    }

//<editor-fold defaultstate="collapsed" desc="dataBase">
    @Override
    public String TestData() {
        return dataBase.DataBaseTest();
    }

    Admin getAdmin(int adminID) {
        return dataBase.getAdmin(adminID);
    }

    Leader getLeader(int leaderID) {
        return dataBase.getLeader(leaderID);
    }

    CaseWorker getCaseWorker(int caseWorkerID) {
        return dataBase.getCaseWorker(caseWorkerID);
    }

    Citizen getCitizen(int citizenID) {
        return dataBase.getCitizen(citizenID);
    }

    //</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="login">
    @Override
    public User login(String username, String password) throws NullPointerException {
        String DBpassword = null;
        User user=null;
        if (login.attemptControl()) {
            try {
                DBpassword = dataBase.GetPassword(username);
            } catch (NullPointerException e) {
                login.failLoginAttempt();
            }//catch null
            if (password.equals(DBpassword)) {
                user = dataBase.getUser(username);
                  dataBase.logLogin(user.getID());
            } else {
                login.failLoginAttempt();
            }
            

        }//if at 
        return user;
    }//m-login

    @Override
    public void GUILogin(String username, String password){
    if(login(username, password)==null){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Login Fejl");
            alert.setHeaderText("Kunne ikke finde kontoen");
            alert.setContentText("Kontroller om Brugernavn og password er korrekt");

            alert.showAndWait();
        }else{
            login(username, password);
        }
    
    }
    
    //</editor-fold> 

    @Override
    public void injectAPI(ICPRRegisterAPI API) {
        this.CPRAPI=API;
                }

    @Override
    public String TestCPRAPI() {
        
    return CPRAPI.callCPRRegister();  }

    @Override
    public Case getCase(int caseID) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean addCase(Case currentCase) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean addAdmin(String name, String username, String password) {
        Admin admin = new Admin(name, username, password);
        dataBase.addAdmin(admin);
        admin.setAdminID(dataBase.getUser().getID());
        dataBase.LogAdminAdd();
        
        return true;
    }

    @Override
    public boolean addLeader(String name, String username, String password) {
        Leader leader = new Leader(name, username, password);
        dataBase.addLeader(leader);
        dataBase.LogLeaderAdd(leader.getID(), );
        
        return true;
    }

    @Override
    public boolean addCaseWorker(String name, String username, String password) {
        CaseWorker caseWorker = new CaseWorker(name, username, password);
        dataBase.addCaseWorker(caseWorker);
        dataBase.LogCaseworkerAdd();
        
        return true;
    }

    @Override
    public boolean addCitizen(String name, int CPR, String citizenAdress) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    }
