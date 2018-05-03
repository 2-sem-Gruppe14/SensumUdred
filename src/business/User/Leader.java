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
public class Leader extends User implements ILeader {

    private String name;
    private int LeaderID;
    private String username;
    private String password;

    public Leader(String name, int LeaderID, String username, String password) {
        this.name = name;
        this.LeaderID = LeaderID;
        this.username = username;
        this.password = password;
    }

    @Override
    public void NewCaseWorker(String name, int caseWorkerID, String username, String passwor) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void getDepartmentsCaseWorkers(int departmentID) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public CaseWorker getCaseWorker(int caseWorkerID) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void addCaseWorker(String name, int caseWorkerID, String username, String password) {
       throw new UnsupportedOperationException("Not supported yet.");
        //dataFacade.addCaseWorker(new CaseWorker(name, caseWorkerID, username, password));
    }

    @Override
    public int getID() {
        return LeaderID; }
}
