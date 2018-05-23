/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package business.caseOpening;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.HashMap;

public class Case implements ICaseOpening, Serializable{

    /* case details */
    private int caseID;
    private LocalDateTime creationDate;
    private LocalDateTime lastChanged;
    private int lastChangedBy;
    private String caseDescription;
    private int caseCreator;
    private HashMap<String,String> caseValue1;
    private HashMap<String,String> caseValue2;


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


    public void addCaseInformation1(HashMap<String,String> caseValues){
        
        
        
    
    }
    public void addCaseInformation2(HashMap<String,String> caseValues) {
        
    }

    @Override
    public int getCaseID() {
        return this.caseID; }
}
