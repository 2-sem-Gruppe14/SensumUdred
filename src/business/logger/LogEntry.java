/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.logger;

import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.Date;

/**
 *
 * @author Lenovo
 */
public class LogEntry implements java.io.Serializable {

    Timestamp Creation;
    LogType logType;
    int WorkerID;
    int CaseID;
/**
 * constructor for a new log.
 * the creation is generated.
 * 
 * @param logType the type of action that has been taken by a user.
 * @param WorkerID the id of the worker who did something.
 * @param CaseID the case the worker interacted with.
 * @param CreationTime creation time of the log.
 */
    public LogEntry(LogType logType, int WorkerID, int CaseID) {
        this.logType = logType;
        this.WorkerID = WorkerID;
        this.CaseID = CaseID;
        this.Creation = Timestamp.from(Instant.MIN);

    }
/**
 * constructor for a loaded log.
 * the creation time is set.
 * 
 * @param logType the type of action that has been taken by a user.
 * @param WorkerID the id of the worker who did something.
 * @param CaseID the case the worker interacted with.
 * @param CreationTime creation time of the log.
 */
    public LogEntry(LogType logType, int WorkerID, int CaseID, Timestamp CreationTime) {
        this.logType = logType;
        this.WorkerID = WorkerID;
        this.CaseID = CaseID;
        this.Creation = CreationTime;

    }
}
