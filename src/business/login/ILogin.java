/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.login;

import business.User.IUser;

/**
 *
 * @author Lenovo
 */
public interface ILogin {

    public IUser verify(String username, String password) throws NullPointerException;

    void failLoginAttempt();

    boolean attemptControl();
}
