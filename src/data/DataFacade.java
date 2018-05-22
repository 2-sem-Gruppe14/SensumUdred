/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import acquintaince.IData;
import data.dataBase.Database;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
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
    public Database db = new Database();


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
    public Object getCase(int caseID) throws SQLException{
        
        try {

            String Query = "SELECT * FROM Case WHERE "+caseID+" = Case_ID";
            ResultSet rs = db.query(Query);
            Object case2 = rs.getObject("case_object");
            return case2;
        } catch (SQLException ex) {
            Logger.getLogger(DataFacade.class.getName()).log(Level.SEVERE, null, ex);
            throw new SQLException("Case" + ex.getMessage());
            
        }

        
    }
 
    @Override
    public List<Integer> getCaseIDs(int caseWorkerID) {
        
        String Query = "SELECT Case_ID FROM Case WHERE "+caseWorkerID+" = caseWorker";
        ResultSet rs = db.query(Query);
        List<Integer> caseIds = new ArrayList<>();
        
        try {
            caseIds.add(rs.getInt("Case_ID"));
            return caseIds;
        } catch (SQLException ex) {
            Logger.getLogger(DataFacade.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        
    }

    @Override
    public void addCase(int caseID, int CPR, String caseContent){
        String Query = "INSERT INTO Case(Case_ID, CPR, caseContent) VALUES (Case, CPR, "+caseContent+")";
        db.query(Query);
    }

    //</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="log">
    @Override
    public void saveLog(String logType, int WorkerID, int CaseID, Timestamp Creation) { 
        String Query = "INSERT INTO Log VALUES (logType, WorkerID, CaseID, Timestamp Creation)";
        db.query(Query);
    }

    @Override
    public void showLog() {
        String Query = "SELECT * FROM Log WHERE Log = Log_ID"; 
        db.query(Query);
    }

    @Override
    public String getCaseLog(int caseID) {
        String Query = "SELECT * FROM Log WHERE "+caseID+" = Log_ID"; 
       ResultSet rs = db.query(Query);
        return rs.toString();
    }

    @Override
    public void LogUserAdd(int createdUserID, int adminID) {
        String Query = "INSERT INTO Log VALUES (createdUserID, "+adminID+")";
        db.query(Query);
    }

    //</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="user">
    @Override
    public Object getUser(int ID) /*throws SQLException*/ {
       // try {
            String Query = "SELECT * FROM System_user WHERE "+ID+" = User_ID";
            ResultSet rs = db.query(Query);
         // User user1 = new User(UserType., rs.getString("username"), rs.getString("password"), rs.getString("User_ID"));
        //    return user1;
       // } catch (SQLException ex) {
        //    Logger.getLogger(DataFacade.class.getName()).log(Level.SEVERE, null, ex);
          //  throw new SQLException("User" + ex.getMessage());
       // }
       return null;
    }
    
    @Override
    public Object getUser(String username) {
        String Query = "SELECT * FROM System_user WHERE "+username+" = User_ID";
       ResultSet rs = db.query(Query);
        return rs.toString();
    }

    @Override
    public int getID(String username) {
        String Query = "SELECT ID FROM System_user WHERE "+username+" = User_ID";
        ResultSet rs = db.query(Query);
        return Integer.parseInt(rs.toString());
    }

    @Override
    public String getName(String username) {
        String Query = "SELECT name FROM System_user WHERE "+username+" = User_ID";
        ResultSet rs = db.query(Query);
        return rs.toString();    
    }

    @Override
    public String GetPassword(String username) {
        String Query = "SELECT password FROM System_user WHERE "+username+" = User_ID";
        ResultSet rs = db.query(Query);
        return rs.toString();
    }

    @Override
    public void addUser(String username, String password, String UserType) {
        String Query = "INSERT INTO \"public\".\"system_user\" (\"user_id\", \"username\", \"password\", \"user_type\", \"login_attempts\") VALUES (DEFAULT, '"+username+"', '"+password+"', '"+UserType+"', 3)";
        db.query(Query);
    }
    }
