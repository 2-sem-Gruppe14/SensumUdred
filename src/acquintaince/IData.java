/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package acquintaince;

import business.caseOpening.Case;
import business.*;
import business.User.*;
import java.sql.Timestamp;

/**
 *
 * @author BenPaxIndustries
 */
public interface IData {
    
    /* TEST */
    String DataBaseTest();
    
     /* layering */
    IData getData();

    /* user functions */ 
    
    Case getCase(int caseID);

    String getCaseLog(int caseID);

    Admin getAdmin(int adminID);

    Leader getLeader(int leaderID);

    CaseWorker getCaseWorker(int caseWorkerID);

    Citizen getCitizen(int citizenID);

    void addCase(Case currentCase);

    Admin addAdmin(Admin newAdmin);

    Leader addLeader(Leader newLeader);

    CaseWorker addCaseWorker(CaseWorker newCaseWorker);

    Citizen addCitizen(Citizen newCitizen);
    
    /* log functions  */
    
    void LogCaseViewing(int caseID, int caseWorkerID, Timestamp Timestamp);

    void logCaseCreation(int caseID, int caseWorkerID, Timestamp Timestamp);

    void logCaseEditing(int caseID, int caseWorkerID, Timestamp Timestamp);

    void logCaseDeletion(int caseID, int caseWorkerID, Timestamp Timestamp);
}
