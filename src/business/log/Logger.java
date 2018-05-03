/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.log;

import acquintaince.IData;
import java.sql.Timestamp;

/**
 *
 * @author Lenovo
 */
public class Logger implements ILogger{

    IData database;
    /**
     * 
     * @param caseID
     * @param caseWorkerID
     * @param Timestamp 
     */
    @Override
    public void LogCaseViewing(int caseID, int caseWorkerID, Timestamp Timestamp) {
        database.LogCaseViewing(caseID, caseWorkerID, Timestamp);
    }
/**
 * 
 * @param caseID
 * @param caseWorkerID
 * @param Timestamp 
 */
    @Override
    public void logCaseCreation(int caseID, int caseWorkerID, Timestamp Timestamp) {
    database.logCaseCreation(caseID, caseWorkerID, Timestamp);
    }
/**
 * 
 * @param caseID
 * @param caseWorkerID
 * @param Timestamp 
 */
    @Override
    public void logCaseEditing(int caseID, int caseWorkerID, Timestamp Timestamp) {
        database.logCaseEditing(caseID, caseWorkerID, Timestamp);}
/**
 * 
 * @param caseID
 * @param caseWorkerID
 * @param Timestamp 
 */
    @Override
    public void logCaseDeletion(int caseID, int caseWorkerID, Timestamp Timestamp) {
    database.logCaseDeletion(caseID, caseWorkerID, Timestamp);
}
}
