/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import acquintaince.IData;
import com.google.gson.Gson;
import data.dataBase.Database;
import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
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
    private SaveToFile SaveToFile;
    private Database db;

    //</editor-fold>
    public DataFacade() {
        SaveToFile = new SaveToFile();
        db = new Database();
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
    public Object getCase(int caseID) throws SQLException {

        try {

            String Query = "SELECT * FROM Case WHERE " + caseID + " = Case_ID";
            ResultSet rs = db.query(Query);
            Object case2 = rs.getObject("case_object");
            return case2;
        } catch (SQLException ex) {
            Logger.getLogger(DataFacade.class.getName()).log(Level.SEVERE, null, ex);
            throw new SQLException("Case" + ex.getMessage());

        }

    }

    @Override
    public HashMap<Integer, String> getAllCases() {
        String Query = "SELECT case_ID, case_object FROM \"Case\"";
        ResultSet rs = db.query(Query);
        HashMap<Integer, String> cases = new HashMap<>();
        try {
            while (rs.next()) {
                cases.put(rs.getInt("case_id"), rs.getString("case_Object"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(DataFacade.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cases;
   
    }

    @Override
    public void addCase(String caseContentJSONString) throws FileNotFoundException {
        
        
        String Query = "INSERT INTO \"public\".\"Case\" (\"creator_id\", \"case_id\", \"case_object\") VALUES (NULL, DEFAULT, '"+caseContentJSONString+"')";
        db.query(Query);
    }
 /**
     * updates the case information with the matching case ID
     * @param CaseID
     * @param caseInfo
     * @return boolean if chance has happend
     */
public boolean editCase(int CaseID, String caseContentJSONString) {

        String Query = "UPDATE Case SET Case.case_object=" + caseContentJSONString + "WHERE Case_ID=" + CaseID;
        ResultSet rs = db.query(Query);
        if (rs != null) {
            return true;
        } else {
            return false;
        }
}
    //</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="log">
    /**
     * get all caselog related to a case (ordered by date)
     * @param caseID
     * @return
     * @throws SQLException 
     */
    @Override
    public List getCaseLog(int caseID) throws SQLException {
//        ArrayList<HashMap> list = new ArrayList<>();
//        int logNumber = 0;
//        try {
//
//            String Query = "SELECT Date,LogType,WorkerID,CaseID FROM Case WHERE " + caseID + " = Case_ID ORDER BY date";
//            ResultSet rs = db.query(Query);
//            ;
//            while (rs.next()) {
//                HashMap<String, String> map = new HashMap<>();
//                map.put("Date", rs.getDate("interaction_date").toString());
//                map.put("LogType", rs.getString("interaction_type"));
//                map.put("WorkerID", rs.getString("WorkerId"));
//                map.put("CaseID", rs.getString("Case_ID"));
//                list.set(logNumber, map);
//                logNumber++;
//
//            }
//
//        } catch (SQLException ex) {
//            Logger.getLogger(DataFacade.class.getName()).log(Level.SEVERE, null, ex);
//            throw new SQLException("Case" + ex.getMessage());
//
//        }
        ArrayList<HashMap> list2 = new ArrayList<>();
        HashMap<String,String> list3 = new HashMap<>();
        list3.put("Date", "interaction_date");
        list3.put("LogType", "interaction_type");
        list3.put("WorkerID", "WorkerId");
        list3.put("CaseID", "Case_ID");
        HashMap<String,String> list4 = new HashMap<>();
        list4.put("Date", "interaction_date");
        list4.put("LogType", "interaction_type");
        list4.put("WorkerID", "WorkerId");
        list4.put("CaseID","Case_ID");
        list2.add(list3);
        list2.add(list4);
        System.out.println("hey");
        return list2;
    }

    /**
     * get all caselog related to a worker (ordered by date) 
     *
     * @param WorkerID
     * @return
     * @throws SQLException
     */
    @Override
    public List getWorkerLog(int WorkerID) throws SQLException {
        ArrayList<HashMap> list = new ArrayList<>();
        int logNumber = 0;
        try {

            String Query = "SELECT Date,LogType,WorkerID,CaseID FROM Case WHERE " + WorkerID + " = Worker_ID ORDER BY date";
            ResultSet rs = db.query(Query);
            ;
            while (rs.next()) {
                HashMap<String, String> map = new HashMap<>();
                map.put("Date", rs.getDate("interaction_date").toString());
                map.put("LogType", rs.getString("interaction_type"));
                map.put("WorkerID", rs.getString("WorkerId"));
                map.put("CaseID", rs.getString("Case_ID"));
                list.set(logNumber, map);
                logNumber++;

            }

        } catch (SQLException ex) {
            Logger.getLogger(DataFacade.class.getName()).log(Level.SEVERE, null, ex);
            throw new SQLException("Case" + ex.getMessage());

        }
        return list;
    }

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
    public void LogUserAdd(int createdUserID, int adminID) {
        String Query = "INSERT INTO Log VALUES (createdUserID, " + adminID + ")";
        db.query(Query);
    }

    //</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="user">
    @Override
    public Object getUser(int ID) /*throws SQLException*/ {
        // try {
        String Query = "SELECT * FROM System_user WHERE " + ID + " = User_ID";
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
        String Query = "SELECT * FROM System_user WHERE " + username + " = User_ID";
        ResultSet rs = db.query(Query);
        return rs.toString();
    }
    
    @Override
    public String getUserType(String username) {
        String query = "SELECT user_type FROM System_user WHERE username = '" + username + "'";
        ResultSet rs = db.query(query);
        String userType = null;
        
        try {
            while(rs.next()){
                userType = rs.getString("user_type");
            }   } catch (SQLException ex) {
            Logger.getLogger(DataFacade.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return userType;
    }

    @Override
    public int getID(String username) {
        String Query = "SELECT ID FROM System_user WHERE " + username + " = User_ID";
        ResultSet rs = db.query(Query);
        return Integer.parseInt(rs.toString());
    }

    @Override
    public String getName(String username) {
        String Query = "SELECT name FROM System_user WHERE " + username + " = User_ID";
        ResultSet rs = db.query(Query);
        return rs.toString();
    }

    @Override
    public String GetPassword(String username) {
        String Query = "SELECT password FROM System_user WHERE username = '" + username +"'" ;
        ResultSet rs = db.query(Query);
        String password = null;
        try {
            while(rs.next()){
                password = rs.getString("password");
            }   } catch (SQLException ex) {
            Logger.getLogger(DataFacade.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return password;
    }

    @Override
    public void addUser(String username, String password, String UserType) {
        String Query = "INSERT INTO \"public\".\"system_user\" (\"user_id\", \"username\", \"password\", \"user_type\", \"login_attempts\") VALUES (DEFAULT, '" + username + "', '" + password + "', '" + UserType + "', 3)";
        db.query(Query);
    }

    @Override
    public boolean editUser(int UserID, String newUsername, String newPassword) {

        String Query = "UPDATE system_user SET system_user.username=" + newUsername + ",system_user.password=" + newPassword + "WHERE User_ID=" + UserID;
        ResultSet rs = db.query(Query);
        if (rs != null) {
            return true;
        } else {
            return false;
        }

    }

    //</editor-fold>

}
