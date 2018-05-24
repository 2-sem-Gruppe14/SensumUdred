/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.caseOpening;

import java.util.HashMap;

/**
 *
 * @author Lenovo
 */
public interface ICaseOpening {
    
 void addCaseInformation1(HashMap<String,String> caseValues);

 void addCaseInformation2(HashMap<String,String> caseValue);

 int getCaseID();
 
 HashMap<String,String> getCaseInformation1();
 
 HashMap<String,String> getCaseInformation2();
 
 String getCasePersonName();
 
 void setCasePersonName(String casePersonName);
 
 String getCaseCPR();
 
 void setCaseCPR(String caseCPR);
 
}
