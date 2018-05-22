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
import java.util.Arrays;
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
        
      /*  try {

            String Query = "SELECT * FROM Case WHERE "+caseID+" = Case_ID";
            ResultSet rs = db.query(Query);
            Case case2 = new Case(rs.getString("creator_id"),rs.getString("case_id"), rs.getString("case_description"));
            return case2;
        } catch (SQLException ex) {
            Logger.getLogger(DataFacade.class.getName()).log(Level.SEVERE, null, ex);
            throw new SQLException("Case" + ex.getMessage());
            
        }*/

        
    }
 
    @Override
    public int [] getCaseIDs(int caseID) throws SQLException{
        
       // try {
            String Query = "SELECT Case_ID FROM Case WHERE "+caseID+" = caseWorker";
            ResultSet rs = db.query(Query);
           // return Arrays.stream(rs.getArray("Case_ID")).mapToInt(Integer::parseInt).toArray();
                    
       // } catch (SQLException ex) {
        //    Logger.getLogger(DataFacade.class.getName()).log(Level.SEVERE, null, ex);
        //    throw new SQLException("CaseIDs" + ex.getMessage());    
            
      //  } 
            
        return null;
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
    public void addUser(Object User) {
        String Query = "INSERT INTO System_user(User_ID, username, password, user_type) VALUES (User, "+User+")";
        db.query(Query);
    }
    }
