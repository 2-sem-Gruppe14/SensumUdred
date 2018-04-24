package business.User;


import java.util.*;

public class CaseWorker extends  implements ICaseWorker{
    
    public String name; 
    public int caseWorkerID;
    public String username;
    public String password;
    public String caseOpening;

    public CaseWorker(String name, int caseWorkerID, String username, String password, String caseOpening) {
        this.name = name;
        this.caseWorkerID = caseWorkerID;
        this.username = username;
        this.password = password;
        this.caseOpening = caseOpening;
    }
    
  
}
    
