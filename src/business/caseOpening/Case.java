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
    private String caseInquiry;
    private String caseAssessment;
    private String declarationOfConsent;
    private boolean consentRecieved;
    private boolean citizenRights;
    private boolean citizenRecord;
    private boolean citizenAcceptance;
    private boolean citizenWithdrawn;
    private int caseProgress;
    private int caseBenefit;
    private int caseOffer;
    

    public Case(int caseID, int CaseWorkerID, String caseDescription) {
        this.caseID = caseID;
        this.creationDate = new Timestamp(System.currentTimeMillis());
        this.lastChanged = creationDate;
        this.lastChangedBy = CaseWorkerID;
        this.caseDescription = caseDescription;
        this.caseCreator = CaseWorkerID;
    }

    @Override
    public void addCaseInformation(String caseInquiry, String declarationOfConsent, boolean consentRecieved, boolean citizenRights, boolean citizenRecord, boolean citizenAcceptance, boolean citizenWithdrawn, int caseProgress, int caseBenefit, int caseOffer) {
        this.caseInquiry = caseInquiry;
        this.declarationOfConsent = declarationOfConsent;
        this.consentRecieved = consentRecieved;
        this.citizenRights = citizenRights;
        this.citizenRecord = citizenRecord;
        this.citizenAcceptance = citizenAcceptance;
        this.citizenWithdrawn = citizenWithdrawn;
        this.caseProgress = caseProgress;
        this.caseBenefit = caseBenefit;
        this.caseOffer = caseOffer;
    }
}
