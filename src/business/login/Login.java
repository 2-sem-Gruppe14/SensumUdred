/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.login;

import acquintaince.IData;
import business.User.Citizen;
import business.User.User;

/**
 *
 * @author Lenovo
 */
public class Login implements ILogin {
    int Attempts = 0;
    
    /**
     * check that no more the 3 login attempts has happend
     * @return
     */
    public boolean attemptControl(){
        if (Attempts<3) {
            return true;
        } else {
            return false;
        }
    }
    
    /**
     * adds 1 to login attempts if the login attempt fails do to wrong password or username
     */
    public void failLoginAttempt(){
        Attempts++;
    }
    
}
