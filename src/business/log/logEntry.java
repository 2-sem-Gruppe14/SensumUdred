/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.log;

import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.Date;

/**
 *
 * @author Lenovo
 */
public class logEntry {

Timestamp timestamp;
LogType logType;
int WorkerID;    
int CaseID;

    public logEntry(LogType logType, int WorkerID, int CaseID) {
        this.logType = logType;
        this.WorkerID = WorkerID;
        this.CaseID = CaseID;
        this.timestamp= Timestamp.from(Instant.MIN);
     
    }
     
}
