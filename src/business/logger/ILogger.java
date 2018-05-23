/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.logger;

import java.sql.Timestamp;

/**
 *
 * @author Lenovo
 */
public interface ILogger {

    void LogCaseViewing(int caseID, int caseWorkerID);

    void logCaseCreation(int caseID, int caseWorkerID);

    void logCaseEditing(int caseID, int caseWorkerID);

    void logCaseDeletion(int caseID, int caseWorkerID);

    void logAddAdmin(int caseID, int caseWorkerID);

    void logAddLeader(int caseID, int caseWorkerID);

    void logAddCaseWorker(int caseID, int caseWorkerID);

    void logAddCitizen(int caseID, int caseWorkerID);
    
    void logLogin(int userID);
    void logLogOut(int userID);

}
