/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import acquintaince.IData;

/**
 *
 * @author BenPaxIndustries
 */
public class DataFacade implements IData {

    private IData data;
    
    public DataFacade() {
        
    }
    
    @Override
    public IData getData() {
        
        if (data == null) {
            data = new DataFacade();
            return data;
        }
        
        return data;
        
    }
    
}
