/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package acquintaince;

import business.User.Admin;
import business.User.CaseWorker;
import business.User.Citizen;
import business.User.Leader;
import business.User.User;
import business.caseOpening.Case;

/**
 *
 * @author BenPaxIndustries
 */
public interface IBusiness {

    abstract void injectData(IData data);

    abstract void injectAPI(ICPRRegisterAPI API);
    
    
    String TestData();
    String TestCPRAPI();
    User login(String username, String password);
    boolean GUILogin(String username, String password);
    
    Case getCase(int caseID);

    boolean addCase(int caseID, int CPR, String caseContent);

    boolean addAdmin(String name, String username, String password);

    boolean addLeader(String name, String username, String password);

    boolean addCaseWorker(String name, String username, String password);

    boolean addCitizen(String name, int CPR, String citizenAdress);
    
}
