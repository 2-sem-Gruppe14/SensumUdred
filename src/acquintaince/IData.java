/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package acquintaince;

import business.caseOpening.Case;
import business.*;
import business.User.*;
import java.io.FileNotFoundException;
import java.sql.Timestamp;

/**
 *
 * @author BenPaxIndustries
 */
public interface IData {

    //<editor-fold defaultstate="collapsed" desc="LAYERING/TEST FUNTIOND">
    String DataBaseTest();

    /* layering */
    IData getData();

    //</editor-fold> 
    //<editor-fold defaultstate="collapsed" desc="case funtions">
    Case getCase(int caseID);

    public void addCase(int caseID, int CPR, String caseContent) throws FileNotFoundException;

    //</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="log functions ">
    void LogCaseViewing(int caseID, int WorkerID);

    void logCaseCreation(int caseID, int WorkerID);

    void logCaseEditing(int caseID, int WorkerID);

    void logCaseDeletion(int caseID, int WorkerID);

    void LogAdminAdd(int createdUserID, int adminID);

    void LogLeaderAdd(int leaderID, int adminID);

    void logLogin(int UserID);

    void showLog();

    String getCaseLog(int caseID);

    void LogUserAdd(int createdUserID, int adminID);

    //</editor-fold> 
    //<editor-fold defaultstate="collapsed" desc="user funtions">
    User getUser(int ID);

    User getUser(String username);

    void addUser(User User);

    String GetPassword(String username);

    //</editor-fold>
    public String inquiry(String quiry);
}
