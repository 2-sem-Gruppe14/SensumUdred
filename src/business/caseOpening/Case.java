/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package business.caseOpening;

import java.io.Serializable;
import java.time.LocalDateTime;

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


    public Case(String casePersonName, String caseCPR, String caseDescription) {
        this.creationDate = LocalDateTime.now();
        this.lastChanged = creationDate;
        this.casePersonName= casePersonName;
        this.caseCPR = caseCPR;
       // this.lastChangedBy = CaseWorkerID;
        this.caseDescription = caseDescription;
       // this.caseCreator = CaseWorkerID;
}

    @Override
    public void addCaseInformation() {
    
    }
}
