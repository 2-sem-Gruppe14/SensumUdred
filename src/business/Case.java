package business;

import java.sql.Timestamp;
import java.util.Date;

public class Case {

    /* case details */
    private int caseID;
    private Timestamp creationDate;
    private Date lastChanged;
    private int lastChangedBy;
    private String caseDescription;
    private int caseCreator;

    /* case information */
    private String caseAssessment;

    public Case(int caseID, int CaseWorkerID, String caseDescription) {
        this.caseID = caseID;
        this.creationDate = new Timestamp(System.currentTimeMillis());
        this.lastChanged = creationDate;
        this.lastChangedBy = CaseWorkerID;
        this.caseDescription = caseDescription;
        this.caseCreator = CaseWorkerID;
    }

}
