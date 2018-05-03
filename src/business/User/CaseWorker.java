package business.User;


import business.caseOpening.Case;
import java.util.*;

public class CaseWorker extends User implements ICaseWorker{
    
    private String name; 
    private int caseWorkerID;
    private String username;
    private String password;

    public CaseWorker(String name, int caseWorkerID, String username, String password) {
        this.name = name;
        this.caseWorkerID = caseWorkerID;
        this.username = username;
        this.password = password;
    }

    @Override
    public void openCase(int caseID, Date creationDate, Date lastChanged, String lastChangedBy, String caseDescription) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void saveCase(Case currentCase, int caseWorkerID) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
  
}
    
