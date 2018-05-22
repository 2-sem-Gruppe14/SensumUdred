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

    int[] getCaseIDs(int CaseWorker);

    public void addCase(int caseID, int CPR, String caseContent) throws FileNotFoundException;

    //</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="log functions ">
    public void saveLog(String logType, int WorkerID, int CaseID, Timestamp Creation);

    void showLog();

    String getCaseLog(int caseID);

    void LogUserAdd(int createdUserID, int adminID);

    //</editor-fold> 
    //<editor-fold defaultstate="collapsed" desc="user funtions">
    Object getUser(int ID);

    Object getUser(String username);

    int getID(String Username);

    String getName(String Username);

    String GetPassword(String username);

    void addUser(User User);

    //</editor-fold>
}
