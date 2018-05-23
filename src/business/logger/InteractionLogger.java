
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.logger;

import acquintaince.IData;
import business.BusinessFacade;
import java.sql.Timestamp;
import java.time.Instant;

/**
 *
 * @author Lenovo
 */
public class InteractionLogger implements ILogger {

    BusinessFacade Business;
    LogType logType;
    IData server;

    public InteractionLogger(IData data) {
    this.server=data;
    }

    /**
     * add a log with the information about who view a case, and what case they
     * view.
     *
     * @param caseID ID from the affected file.
     * @param caseWorkerID id from the worker interacting with a case.
     */
    @Override
    public void LogCaseViewing(int caseID, int caseWorkerID) {
        server.saveLog(logType.VIEW.toString(), caseWorkerID, caseID, Timestamp.from(Instant.MIN));
    }

    /**
     * add a log with the information about who created a case, and what case
     * they created.
     *
     * @param caseID ID from the affected file.
     * @param caseWorkerID id from the worker interacting with a case.
     */
    @Override
    public void logCaseCreation(int caseID, int caseWorkerID) {
        server.saveLog(logType.CREATION.toString(), caseWorkerID, caseID, Timestamp.from(Instant.MIN));
    }

    /**
     * add a log with the information about who edited a case, and what case
     * they edited.
     *
     * @param caseID ID from the affected file.
     * @param caseWorkerID id from the worker interacting with a case.
     */
    @Override
    public void logCaseEditing(int caseID, int caseWorkerID) {
        server.saveLog(logType.EDITION.toString(), caseWorkerID, caseID, Timestamp.from(Instant.MIN));
    }

    /**
     * add a log with the information about who Deleted a case, and what case
     * they deleted.
     *
     * @param caseID ID from the affected file.
     * @param caseWorkerID id from the worker interacting with a case.
     */
    @Override
    public void logCaseDeletion(int caseID, int caseWorkerID) {
        server.saveLog(logType.DELETION.toString(), caseWorkerID, caseID, Timestamp.from(Instant.MIN));
    }

    /**
     * add a log with the information about who created a new user, and who the
     * created.
     *
     * @param caseID ID from the affected file.
     * @param caseWorkerID id from the worker interacting with a case.
     */
    @Override
    public void logAddAdmin(int caseID, int caseWorkerID) {
        server.saveLog(logType.ADDADMIN.toString(), caseWorkerID, caseID, Timestamp.from(Instant.MIN));
    }

    /**
     * add a log with the information about who created a new user, and who the
     * created.
     *
     * @param caseID ID from the affected file.
     * @param caseWorkerID id from the worker interacting with a case.
     */
    @Override
    public void logAddLeader(int caseID, int caseWorkerID) {
        server.saveLog(logType.ADDLEADER.toString(), caseWorkerID, caseID, Timestamp.from(Instant.MIN));
    }

    /**
     * add a log with the information about who created a new user, and who the
     * created.
     *
     * @param caseID ID from the affected file.
     * @param caseWorkerID id from the worker interacting with a case.
     */
    @Override
    public void logAddCaseWorker(int caseID, int caseWorkerID) {
        server.saveLog(logType.ADDCASEWORKER.toString(), caseWorkerID, caseID, Timestamp.from(Instant.MIN));
    }

    /**
     * add a log with the information about who created a new user, and who the
     * created.
     *
     * @param caseID ID from the affected file.
     * @param caseWorkerID id from the worker interacting with a case.
     */
    @Override
    public void logAddCitizen(int caseID, int caseWorkerID) {
        server.saveLog(logType.ADDCITIZEN.toString(), caseWorkerID, caseID, Timestamp.from(Instant.MIN));
    }

    @Override
    public LogEntry[] LoadCaseLogs(int caseID) {
        LogEntry[] logs;
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.

        //return logs;
    }

    @Override
    public LogEntry[] LoadWorkerLogs(int WorkerID) {
        LogEntry[] logs;
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        //return logs;
    }
/**
 * logs a login attempt
 * @param userID 
 */
    @Override
    public void logLogin(int userID) {
        server.saveLog(logType.LOGIN.toString(), userID, -1, Timestamp.from(Instant.MIN));
    }
}
