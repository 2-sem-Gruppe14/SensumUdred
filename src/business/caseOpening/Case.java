/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package business.caseOpening;

import java.io.Serializable;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

public class Case implements ICaseOpening, Serializable{

    /* case details */
    private int caseID;
    private LocalDateTime creationDate;
    private LocalDateTime lastChanged;
    private int lastChangedBy;
    private String caseDescription;
    private int caseCreator;

    /* case information */
    private String casePersonName;
    private String caseCPR;
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
    

    public Case(String casePersonName, String caseCPR, int CaseWorkerID, String caseDescription) {
        this.creationDate = LocalDateTime.now();
        this.lastChanged = creationDate;
        this.casePersonName= casePersonName;
        this.caseCPR = caseCPR;
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
