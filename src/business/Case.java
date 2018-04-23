package business;



import java.util.Date;


public class Case {
    
    public int caseID;
    public Date creationDate;
    public Date lastChanged;
    public String lastChangedBy;
    public String caseDescription;

    public Case(int caseID, Date creationDate, Date lastChanged, String lastChangedBy, String caseDescription) {
        this.caseID = caseID;
        this.creationDate = creationDate;
        this.lastChanged = lastChanged;
        this.lastChangedBy = lastChangedBy;
        this.caseDescription = caseDescription;
    }
    
    
        
        
    }
}
