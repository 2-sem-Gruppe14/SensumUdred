/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package acquintaince;

import business.User.User;
import business.caseOpening.Case;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

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

    //String GUILogin(String username, String password);
    //</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="case">

    Case getCase(int caseID);
    
    void getAllCases();
    
    void SaveCase(String casePersonName, String caseCPR, String Address, String caseDescription, HashMap<String,String> formaliaMap);
    void saveCaseInfomation1(int caseID, HashMap<String,String> caseValues);
    void saveCaseInfomation2(int caseID, HashMap<String,String> caseValues);
    boolean addCase(Case caseContent);
    
    List<HashMap<String,String>> getCaseInfo(int case_id);
    
    HashMap<Integer, String> getViewableCases();

    //</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="Add users">
    boolean addAdmin(String username, String password);

    boolean addLeader(String username, String password);

    boolean addCaseWorker(String username, String password);

    public boolean addCitizen(String name, int CPR, String username, String password);

    public HashMap getcaseValue(HashMap<String, String> caseValue);

    boolean editUser(int UserID, String newUsername, String newPassword);

    List getCaseLog(int caseID) throws SQLException;

    List getWorkerLog(int WorkerID) throws SQLException;
    

    //</editor-fold> 
    void Logout();
}
