/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation;

import acquintaince.IBusiness;
import business.login.Login;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

/**
 *
 * @author Mikkel Ebjerg
 */
public class FXMLDocumentController implements Initializable {

    @FXML
    private Label label;

    IBusiness business;

    @FXML
    private void handleButtonAction(ActionEvent event) {
        System.out.println(business.TestData());
        label.setText(business.TestData());
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {  
       business = UI.getInstance().getBusiness();
       Login login = new Login();
       

    }

}
