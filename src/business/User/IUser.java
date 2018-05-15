/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.User;

import acquintaince.IData;

/**
 *
 * @author Lenovo
 */
public interface IUser {

    public int getUserID();
  
    void loaded(int UserID);
}
