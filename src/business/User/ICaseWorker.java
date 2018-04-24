/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.User;

import business.Case;
import java.util.Date;

/**
 *
 * @author Lenovo
 */
public interface ICaseWorker {
    
    void openCase(int caseID, Date creationDate, Date lastChanged, String lastChangedBy, String caseDescription);
    void saveCase(Case currentCase,int caseWorkerID);
}
