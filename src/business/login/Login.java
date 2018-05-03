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
    
 public String userSeachConditions(String username, String password){
 String query = "SELECT userType,ID FROM users WHERE username =" + username + " AND password=" + password.hashCode();
 return query; }
    
public boolean attemptControl(){
if (Attempts<3) {
   return true;
}
else{return false;}
}
public void failLoginAttempt(){
Attempts++;
}
    
}
