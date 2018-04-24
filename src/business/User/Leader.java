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
public class Leader extends User implements ILeader {

    private String name;
    private int LeaderID;
    private String username;
    private String password;

    public Leader(String name, int LeaderID, String username, String password) {
        this.name = name;
        this.LeaderID = LeaderID;
        this.username = username;
        this.password = password;
    }
}
