/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package acquintaince;

import business.caseOpening.Case;
import business.*;
import business.User.*;

/**
 *
 * @author BenPaxIndustries
 */
public interface IData {

    IData getData();

    Case getCase(int caseID);

    String getCaseLog(int caseID);

    Admin getAdmin(int adminID);

    Leader getLeader(int leaderID);

    CaseWorker getCaseWorker(int caseWorkerID);

    Citizen getCitizen(int citizenID);
}
