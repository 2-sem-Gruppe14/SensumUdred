/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package starter;

import CPRRegisterAPI.CPRRegister;
import acquintaince.IBusiness;
import acquintaince.ICPRRegisterAPI;
import acquintaince.IData;
import acquintaince.IPresentation;
import business.BusinessFacade;
import data.DataBaseStump;
import data.DataFacade;
import presentation.UI;

/**
 *
 * @author Lenovo
 */
public class Starter {

    public static void main(String[] args) {

       // IData data = new DataFacade();
       
       IData data = new DataBaseStump(); //test function
       
        IBusiness business = new BusinessFacade();
        ICPRRegisterAPI API = new CPRRegister();
        business.injectData(data);
        business.injectAPI(API);
        IPresentation ui = (IPresentation) new UI();
        ui.injectBusiness(business);
        ui.startApplication(args);
    }

}
