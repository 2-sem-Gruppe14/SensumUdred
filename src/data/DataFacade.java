/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import acquintaince.IData;
import business.User.User;
import business.caseOpening.Case;
import java.io.FileNotFoundException;
import java.sql.Timestamp;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author BenPaxIndustries
 */
public class DataFacade implements IData {
    //<editor-fold defaultstate="collapsed" desc="variable">

    private IData data;
    private SaveToFile SaveToFile = new SaveToFile();

    //</editor-fold>
    public DataFacade() {

    }

    //<editor-fold defaultstate="collapsed" desc="LAYERING/TEST">
    @Override
    public String DataBaseTest() {
        return "DataBase Layer";
    }

    @Override
    public IData getData() {

        if (data == null) {
            data = new DataFacade();
            return data;
        }

        return data;

    }

    //</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="Case">
    @Override
    public Case getCase(int caseID) {
        String Query = "SELECT * FROM Case WHERE "+caseID+" = Case_ID";
        
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int[] getCaseIDs(int CaseWorker) {
        String Query = "SELECT Case_ID FROM Case WHERE "+CaseWorker+" = Case_ID";
        
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void addCase(int caseID, int CPR, String caseContent) throws FileNotFoundException {
        String Query = "INSERT INTO Case(Case_ID, CPR, caseContent) VALUES (Case, CPR, "+caseContent+")";
        
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    //</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="log">
    @Override
    public void saveLog(String logType, int WorkerID, int CaseID, Timestamp Creation) { 
        String Query = "INSERT INTO Log VALUES (logType, WorkerID, CaseID, Timestamp Creation)";
        
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void showLog() {
        String Query = "SELECT * FROM Log WHERE Log = Log_ID"; 
        
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getCaseLog(int caseID) {
        String Query = "SELECT * FROM Log WHERE "+caseID+" = Log_ID"; 
        
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void LogUserAdd(int createdUserID, int adminID) {
        String Query = "INSERT INTO Log VALUES (createdUserID, "+adminID+")";
        
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    //</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="user">
    public User getUser(int ID) {
        String Query = "SELECT * FROM System_user WHERE "+ID+" = User_ID";
        
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public User getUser(String username) {
        String Query = "SELECT * FROM System_user WHERE "+username+" = User_ID";
        
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getID(String username) {
        String Query = "SELECT ID FROM System_user WHERE "+username+" = User_ID";
        
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getName(String username) {
        String Query = "SELECT name FROM System_user WHERE "+username+" = User_ID";
        
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String GetPassword(String username) {
        String Query = "SELECT password FROM System_user WHERE "+username+" = User_ID";
        
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void addUser(User User) {
        String Query = "INSERT INTO System_user(User_ID, username, password, user_type) VALUES (User, "+User+")";
        
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    //</editor-fold>

    @Override
    public String inquiry(String quiry) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
