/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import acquintaince.IData;
import business.User.Admin;
import business.User.CaseWorker;
import business.User.Citizen;
import business.User.Leader;
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

    private IData data;
    private SaveToFile SaveToFile = new SaveToFile();
    public DataFacade() {
        
    }
    
    
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

    @Override
    public Case getCase(int caseID) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getCaseLog(int caseID) {
      throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
   }

    @Override
    public Admin getAdmin(int adminID) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Leader getLeader(int leaderID) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public CaseWorker getCaseWorker(int caseWorkerID) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Citizen getCitizen(int citizenID) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void addCase(Case currentCase) {
    SaveToFile.writeToCase(0, caseInformation, Timestamp);
    }

    @Override
    public Admin addAdmin(Admin newAdmin) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Leader addLeader(Leader newLeader) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public CaseWorker addCaseWorker(CaseWorker newCaseWorker) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Citizen addCitizen(Citizen newCitizen) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void LogCaseViewing(int caseID, int caseWorkerID) {
        try {
            SaveToFile.writeToLog(caseID, caseWorkerID, "View");
        } catch (FileNotFoundException ex) {
            Logger.getLogger(DataFacade.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void logCaseCreation(int caseID, int caseWorkerID) {
         try {
            SaveToFile.writeToLog(caseID, caseWorkerID, "Creation");
        } catch (FileNotFoundException ex) {
            Logger.getLogger(DataFacade.class.getName()).log(Level.SEVERE, null, ex);
        } }

    @Override
    public void logCaseEditing(int caseID, int caseWorkerID) {
        try {
            SaveToFile.writeToLog(caseID, caseWorkerID, "Edit");
        } catch (FileNotFoundException ex) {
            Logger.getLogger(DataFacade.class.getName()).log(Level.SEVERE, null, ex);
        }  }

    @Override
    public void logCaseDeletion(int caseID, int caseWorkerID) {
         try {
            SaveToFile.writeToLog(caseID, caseWorkerID, "Deletion");
        } catch (FileNotFoundException ex) {
            Logger.getLogger(DataFacade.class.getName()).log(Level.SEVERE, null, ex);
        } }

    @Override
    public String inquiry(String quiry) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void logLogin(int UserID) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void showLog() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String GetPassword(String username) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public User getUser(String username) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void LogAdminAdd(int createdUserID, int adminID) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void LogLeaderAdd(int leaderID, int adminID) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object getUser() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
}
