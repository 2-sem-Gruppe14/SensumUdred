package data;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import acquintaince.IData;
import business.User.Admin;
import business.User.CaseWorker;
import business.User.Citizen;
import business.User.Leader;
import business.caseOpening.Case;
import java.sql.Timestamp;

/**
 *
 * @author Lenovo
 */
public class DataBaseStump implements IData {

    private IData data;

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
    return new Case(0000, 0000, "dataBase Stump exemple");
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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

    /* 
    STOP HER SEB!!!
    STOP HER SEB!!!
    STOP HER SEB!!!
    STOP HER SEB!!!
    STOP HER SEB!!!
    */
    @Override
    public void LogCaseViewing(int caseID, int caseWorkerID, Timestamp Timestamp) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void logCaseCreation(int caseID, int caseWorkerID, Timestamp Timestamp) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void logCaseEditing(int caseID, int caseWorkerID, Timestamp Timestamp) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void logCaseDeletion(int caseID, int caseWorkerID, Timestamp Timestamp) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
