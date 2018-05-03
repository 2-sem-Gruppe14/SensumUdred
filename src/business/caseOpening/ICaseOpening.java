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
         String caseInquiry,
         String declarationOfConsent, 
         boolean consentRecieved,
         boolean citizenRights,
         boolean citizenRecord,
         boolean citizenAcceptance, 
         boolean citizenWithdrawn, 
         int caseProgress, 
         int caseBenefit, 
         int caseOffer);

}
