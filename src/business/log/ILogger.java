/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.log;

import java.sql.Timestamp;

/**
 *
 * @author Lenovo
 */
public interface ILogger {

    void LogCaseViewing(int caseID, int caseWorkerID, Timestamp Timestamp);

    void logCaseCreation(int caseID, int caseWorkerID, Timestamp Timestamp);

    void logCaseEditing(int caseID, int caseWorkerID, Timestamp Timestamp);

    void logCaseDeletion(int caseID, int caseWorkerID, Timestamp Timestamp);
}
