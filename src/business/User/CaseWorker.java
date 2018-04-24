package business.User;


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
    
  
}
    
