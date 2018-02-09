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
public class Business implements IBusiness {
    
    private IData data;
    private IBusiness business;
    
    private Business() {
        
    }

    @Override
    public void injectData(IData data) {
        this.data = data;
    }

    @Override
    public IBusiness getBusiness() {
        
        if (business == null) {
            business = new Business();
            return business;
        }
        
        return business;
        
    }
    
    
    
}
