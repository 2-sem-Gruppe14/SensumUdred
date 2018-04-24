/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.User;

/**
 *
 * @author Lenovo
 */
public class Admin extends User implements IAdmin{
       
    private String name; 
    private int adminID;
     private String username;
    private String password;

    public Admin(String name, int adminID, String username, String password) {
        this.name = name;
        this.adminID = adminID;
        this.username = username;
        this.password = password;
    }
   
}
