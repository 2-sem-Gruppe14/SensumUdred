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

    //<editor-fold defaultstate="collapsed" desc="Layering/TESTS">
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
    public int[] getCaseIDs(int CaseWorker) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Case getCase(int caseID) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void addCase(int caseID, int CPR, String caseContent) throws FileNotFoundException {
        SaveToFile.writeToCase(caseID, CPR, caseContent);
    }

    //</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="user">
    @Override
    public String getName(String Username) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public User getUser(String username) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String GetPassword(String username) {
        return "caseworker";
    }

    @Override
    public User getUser(int ID) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void addUser(User newUser) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    //</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="log">
    @Override
    public void LogUserAdd(int createdUserID, int adminID) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getCaseLog(int caseID) {
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
        }
    }

    @Override
    public void logCaseEditing(int caseID, int caseWorkerID) {
        try {
            SaveToFile.writeToLog(caseID, caseWorkerID, "Edit");
        } catch (FileNotFoundException ex) {
            Logger.getLogger(DataFacade.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void logCaseDeletion(int caseID, int caseWorkerID) {
        try {
            SaveToFile.writeToLog(caseID, caseWorkerID, "Deletion");
        } catch (FileNotFoundException ex) {
            Logger.getLogger(DataFacade.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void logLogin(int UserID) {
        try {
            SaveToFile.writeToLog(UserID, UserID, "login");
        } catch (FileNotFoundException ex) {
            Logger.getLogger(DataFacade.class.getName()).log(Level.SEVERE, null, ex);
        }
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
    public void showLog() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    //</editor-fold>

    @Override
    public String inquiry(String quiry) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
