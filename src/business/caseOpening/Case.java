package business.caseOpening;

import java.sql.Timestamp;
import java.util.Date;

public class Case implements ICaseOpening{

    /* case details */
    private int caseID;
    private Timestamp creationDate;
    private Date lastChanged;
    private int lastChangedBy;
    private String caseDescription;
    private int caseCreator;

    /* case information */
    private String caseAssessment;
    public String declarationOfConsent;
    public boolean consentRecieved;
    public boolean citizenAcceptance;
    public boolean citizenWithdrawn;
    public int caseProgress;
    public int caseBenefit;
    public int caseOffer;
    

    public Case(int caseID, int CaseWorkerID, String caseDescription) {
        this.caseID = caseID;
        this.creationDate = new Timestamp(System.currentTimeMillis());
        this.lastChanged = creationDate;
        this.lastChangedBy = CaseWorkerID;
        this.caseDescription = caseDescription;
        this.caseCreator = CaseWorkerID;
    }

    @Override
    public void addCaseInformation(String declarationOfConsent, boolean consentRecieved, boolean citizenAcceptance, boolean citizenWithdrawn, int caseProgress, int caseBenefit, int caseOffer) {
        this.declarationOfConsent = declarationOfConsent;
        this.consentRecieved = consentRecieved;
        this.citizenAcceptance = citizenAcceptance;
        this.citizenWithdrawn = citizenWithdrawn;
        this.caseProgress = caseProgress;
        this.caseBenefit = caseBenefit;
        this.caseOffer = caseOffer;
    }
}
