/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.User;

/**
 *
 * @author Lenovo
 */
public interface ILeader {

    void NewCaseWorker(String name, int caseWorkerID, String username, String passwor);

    void getDepartmentsCaseWorkers(int departmentID);
    
    CaseWorker getCaseWorker(int caseWorkerID);
    
    void addCaseWorker(String name, int caseWorkerID, String username, String password);

}
