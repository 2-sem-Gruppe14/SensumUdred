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
    public String inquiry(String quiry);

    Case getCase(int caseID);

    void addCase(Case currentCase);

    Admin addAdmin(Admin newAdmin);

    Leader addLeader(Leader newLeader);

    CaseWorker addCaseWorker(CaseWorker newCaseWorker);

    Citizen addCitizen(Citizen newCitizen);


    /* log functions  */
    void LogCaseViewing(int caseID, int WorkerID);

    void logCaseCreation(int caseID, int WorkerID);

    void logCaseEditing(int caseID, int WorkerID);

    void logCaseDeletion(int caseID, int WorkerID);
    
    void LogAdminAdd(int createdUserID, int adminID);
            
    void LogLeaderAdd(int leaderID, int adminID);

    void logLogin(int UserID);

    void showLog();

    String GetPassword(String username);

    User getUser(String username);

    /*SPRINT 2 imp" */
    String getCaseLog(int caseID);

    /*  TEST METHODS*/
    Admin getAdmin(int adminID);

    Leader getLeader(int leaderID);

    CaseWorker getCaseWorker(int caseWorkerID);

    Citizen getCitizen(int citizenID);

    /*  TEST METHODS END*/

    public Object getUser();

}
