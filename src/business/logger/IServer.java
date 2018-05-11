/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.logger;

import business.User.Interfaces.User;
import java.sql.Timestamp;

/**
 *
 * @author Lenovo
 */
public interface IServer {

    public String test();

    public void saveLog(String logType, int WorkerID, int CaseID, Timestamp Creation);

    String GetPassword(String username);

    User getUser(String username);
    
}
