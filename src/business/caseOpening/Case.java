/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package business.caseOpening;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Case implements ICaseOpening, Serializable{

    /* case details */
    private int caseID;
    private LocalDateTime creationDate;
    private LocalDateTime lastChanged;
    private int lastChangedBy;
    private String caseDescription;
    private int caseCreator;
    private HashMap<String,String> caseFormalia;
    private HashMap<String,String> caseValue1;
    private HashMap<String,String> caseValue2;
    private String caseAddress;


    /* case information */
    private String casePersonName;
    private String caseCPR;


    public Case(String casePersonName, String caseCPR, String Address, String caseDescription, HashMap<String,String> formaliaMap) {
        this.creationDate = LocalDateTime.now();
        this.lastChanged = creationDate;
        this.casePersonName= casePersonName;
        this.caseCPR = caseCPR;
        this.caseAddress = Address;
        this.caseFormalia= formaliaMap;
        
       // this.lastChangedBy = CaseWorkerID;
        this.caseDescription = caseDescription;
       // this.caseCreator = CaseWorkerID;
}

    @Override
    public void addCaseInformation1(HashMap<String,String> caseValues){
        this.caseValue1 = caseValues;
    }
    @Override
    public void addCaseInformation2(HashMap<String,String> caseValues) {
        this.caseValue2 = caseValues; 
    }

    @Override
    public int getCaseID() {
        return this.caseID; 
    }
    
    public List<String> getCaseFormalia(){
        List<String> formaliaList = new ArrayList<>();
        
        formaliaList.add(casePersonName);
        formaliaList.add(caseCPR);
        formaliaList.add(caseAddress);
        formaliaList.add(caseDescription);
        
        return formaliaList;
    }
    public HashMap<String,String> getCaseFormaliaMap(){
        
        return caseFormalia;
    }

    /**
     * @return the caseValue1
     */
    @Override
    public HashMap<String,String> getCaseInformation1() {
        return caseValue1;
    }

    /**
     * @return the caseValue2
     */
    @Override
    public HashMap<String,String> getCaseInformation2() {
        return caseValue2;
    }


    /**
     * @return the casePersonName
     */
    @Override
    public String getCasePersonName() {
        return casePersonName;
    }

    /**
     * @param casePersonName the casePersonName to set
     */
    @Override
    public void setCasePersonName(String casePersonName) {
        this.casePersonName = casePersonName;
    }

    /**
     * @return the caseCPR
     */
    @Override
    public String getCaseCPR() {
        return caseCPR;
    }

    /**
     * @param caseCPR the caseCPR to set
     */
    @Override
    public void setCaseCPR(String caseCPR) {
        this.caseCPR = caseCPR;
    }
}
