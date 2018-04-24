package data;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import acquintaince.IData;

/**
 *
 * @author Lenovo
 */
public class DataBaseStump implements IData {

    private IData data;

    @Override
    public IData getData() {
        if (data == null) {
            data = new DataFacade();
            return data;
        }

        return data;
    }

}
