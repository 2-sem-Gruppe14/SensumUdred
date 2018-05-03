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
import business.login.Login;

/**
 *
 * @author BenPaxIndustries
 */
public class BusinessFacade implements IBusiness {

//<editor-fold defaultstate="collapsed" desc="variables">
    private IData dataBase;
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

        if (login.attemptControl()) {
            try {
               String userData = login.userSeachConditions(username, password);
               dataBase.inquiry(userData);
            } catch (NullPointerException e) {
                login.failLoginAttempt();
            }//catch null
            dataBase.logLogin(0000);
        }//if at
return login.getUser();    
    }//m-login

    //</editor-fold> 
}
