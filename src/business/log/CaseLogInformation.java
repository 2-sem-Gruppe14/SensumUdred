/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.log;

/**
 *
 * @author Lenovo
 */
public class CaseLogInformation {

    public String citizenInformation;
    public String caseWorkerInformation;
    public String caseAssessment;

    CaseLogInformation(String citizenInformation, String caseWorkerInformation, String caseAssessment) {
        this.citizenInformation = citizenInformation;
        this.caseWorkerInformation = caseWorkerInformation;
        this.caseAssessment = caseAssessment;
    }
}
