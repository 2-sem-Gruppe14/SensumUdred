/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data.dataBase;

import business.*;

/**
 *
 * @author Lenovo
 */
public interface IDataBase {
  
Case getCase(int caseID);    
CaseLogInformation getCaseLog(int caseId); 

}
