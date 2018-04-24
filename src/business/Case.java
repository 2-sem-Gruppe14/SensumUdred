package business;



import java.sql.Timestamp;
import java.util.Date;


public class Case {
    /* case details */
    public int caseID;
    Timestamp creationDate;
    public Date lastChanged;
    public int lastChangedBy;
    public String caseDescription;

    /* case information */
     private String caseAssessment;
    
    public Case(int caseID, int CaseWorkerID, String caseDescription) {
        this.caseID = caseID;
        this.creationDate = new Timestamp(System.currentTimeMillis());
        this.lastChanged = creationDate;
        this.lastChangedBy = CaseWorkerID;
        this.caseDescription = caseDescription;
    }
    
    
    }
   
    
        
        
    
