/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data.Server;

/**
 *
 * @author Lenovo
 */
public interface IServer {

    public void saveLog(String logType, int WorkerID, int CaseID);
}
