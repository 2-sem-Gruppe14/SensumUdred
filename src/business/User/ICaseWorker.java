/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.User;

import business.caseOpening.Case;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Lenovo
 */
public interface ICaseWorker extends IUser{
    
    void openCase(int caseID, Date creationDate, Date lastChanged, String lastChangedBy, String caseDescription);
    void saveCase(Case currentCase,int caseWorkerID);
    void CaseWorkerloaded(int UserID, List<Integer> caseIDs);
}
