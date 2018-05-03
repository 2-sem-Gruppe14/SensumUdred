/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package acquintaince;

import business.User.User;

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

}
