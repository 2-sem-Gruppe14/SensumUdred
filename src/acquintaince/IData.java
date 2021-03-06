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
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;

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
    Object getCase(int caseID) throws SQLException;

    HashMap<Integer,String> getAllCases();

    public void addCase(String caseContentJSONString) throws FileNotFoundException;

    //</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="log functions ">
    public void saveLog(String logType, int WorkerID, int CaseID, Timestamp Creation);

    void showLog();

    List getCaseLog(int caseID) throws SQLException;

    List getWorkerLog(int WorkerID) throws SQLException;

    void LogUserAdd(int createdUserID, int adminID);

    //</editor-fold> 
    //<editor-fold defaultstate="collapsed" desc="user funtions">
    Object getUser(int ID);

    Object getUser(String username);
    
    String getUserType(String username);
    
    int getID(String Username);

    String getName(String Username);

    String GetPassword(String username);

    void addUser(String username, String password, String UserType);

    boolean editUser(int UserID, String newUsername, String newPassword);
    
    boolean editCase(int CaseID, String caseContentJSONString);
    //</editor-fold>
}
