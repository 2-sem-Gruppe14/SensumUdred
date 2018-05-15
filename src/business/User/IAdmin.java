/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.User;

import java.sql.Timestamp;

/**
 *
 * @author Lenovo
 */
public interface IAdmin {

    void newCaseWorker(String name, int caseWorkerID, String username, String passwor);

    void newLeader(String name, int LeaderID, String username, String password);

    void newAdmin(String name, int adminID, String username, String password);

    void getDepartmentsCaseWorkers(int departmentID);

    User getCaseWorker(int caseWorkerID);

    void getLogCaseViewing(int caseID);

    void getlogCaseCreation(int caseID);

    void getlogCaseediting(int caseID);

    void getlogCaseDeletion(int caseID);

    void getLogCaseWorkerViewing(int caseWorkerID);

    void getlogCaseWorkerCreation(int caseWorkerID);

    void getlogCaseWorkerEditing(int caseWorkerID);

    void getlogCaseWorkerDeletion(int caseWorkerID);
}
