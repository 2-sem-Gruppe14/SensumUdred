/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.caseOpening;

import java.util.Collection;
import java.util.List;

/**
 *
 * @author Lenovo
 */
public interface IcaseOpening {
    
    /**
     * 
     * @param declarationOfConsent
     * @param consentRecieved
     * @param citizenAcceptance
     * @param citizenWithdrawn
     * @param caseProgress
     * @param caseBenefit
     * @param caseOffer
     * @return boolean to verify the case has been created
     */
   void CaseOpening(
           String declarationOfConsent,
           boolean consentRecieved,
           boolean citizenAcceptance,
           boolean citizenWithdrawn, 
           int caseProgress,
           int caseBenefit, 
           int caseOffer);
   
   void addCaseInformation(List information);
           
    
}
