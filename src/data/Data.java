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
public class Data implements IData {

    private IData data;
    
    private Data() {
        
    }
    
    @Override
    public IData getData() {
        
        if (data == null) {
            data = new Data();
            return data;
        }
        
        return data;
        
    }
    
}
