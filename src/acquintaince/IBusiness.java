/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package acquintaince;

import business.User.User;
import business.caseOpening.Case;
import java.util.HashMap;

/**
 *
 * @author BenPaxIndustries
 */
public interface IBusiness {

    //<editor-fold defaultstate="collapsed" desc="LAYERING/TESt">
    abstract void injectData(IData data);

    abstract void injectAPI(ICPRRegisterAPI API);

    String TestData();

    String TestCPRAPI();
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="login">
    String login(String username, String password);

    String GUILogin(String username, String password);
    //</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="case">

    Case getCase(int caseID);

    boolean addCase(int caseID, int CPR, String caseContent);

    //</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="Add users">
    boolean addAdmin(String username, String password);

    boolean addLeader(String username, String password);

    boolean addCaseWorker(String username, String password);


    public boolean addCitizen(String name, int CPR, String username, String password);
    
    public HashMap getcaseValue(HashMap <String,String> caseValue);
    
    //</editor-fold> 
}
