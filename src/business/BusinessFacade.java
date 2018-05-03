/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import acquintaince.*;

/**
 *
 * @author BenPaxIndustries
 */
public class BusinessFacade implements IBusiness {

    private IData dataBase;

    public BusinessFacade() {

    }
    
 public Admin DBGetAdmin(){
 dataBase.getAdmin(0)
 } 

    @Override
    public void injectData(IData data) {
        this.dataBase = data;
    }

    @Override
    public String TestData() {
    return dataBase.DataBaseTest();
    }


}
