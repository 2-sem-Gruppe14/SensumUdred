/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CPRRegisterAPI;

import acquintaince.ICPRRegisterAPI;

/**
 *
 * @author Lenovo
 */
public class CPRRegister implements ICPRRegisterAPI{

    public CPRRegister() {
    }
    /**
     * a method for demonstrating a possiblity to connect an API to the system.
     * @return a String that prints a confurmation about the API call.
     */
    @Override
    public String callCPRRegister(){
    return "CPR Register called";
    }
    
}
