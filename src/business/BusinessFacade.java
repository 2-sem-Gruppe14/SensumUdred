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

    private IData data;

    public BusinessFacade() {

    }

    @Override
    public void injectData(IData data) {
        this.data = data;
    }

    @Override
    public String TestData() {
    return data.DataBaseTest();
    }


}
