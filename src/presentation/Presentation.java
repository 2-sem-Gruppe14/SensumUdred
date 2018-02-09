/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation;

import acquintaince.IBusiness;
import acquintaince.IPresentation;

/**
 *
 * @author BenPaxIndustries
 */
public class Presentation implements IPresentation {
    
    private IBusiness business;
    private IPresentation presentation;
    
    private Presentation() {
        
    }

    @Override
    public void injectBusiness(IBusiness business) {
        this.business = business;
    }

    @Override
    public IPresentation getPresentation() {
        
        if (presentation == null) {
            presentation = new Presentation();
            return presentation;
        }
        
        return presentation;
        
    }
    
    
    
}
