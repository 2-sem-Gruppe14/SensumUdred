/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.caseOpening;

/**
 *
 * @author Lenovo
 */
public interface ICaseOpening {
    
 public void addCaseInformation(
         String declarationOfConsent, 
         boolean consentRecieved,
         boolean citizenAcceptance, 
         boolean citizenWithdrawn, 
         int caseProgress, 
         int caseBenefit, 
         int caseOffer);

}
