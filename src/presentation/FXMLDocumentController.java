/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation;

import acquintaince.IBusiness;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.Menu;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

/**
 *
 * @author Mikkel Ebjerg
 */
public class FXMLDocumentController implements Initializable {

    private Label label;

    IBusiness business;
    @FXML
    private AnchorPane mainPane;
    @FXML
    private Group adminGroup;
    @FXML
    private Color x2;
    @FXML
    private Font x1;
    @FXML
    private ListView<?> userList;
    @FXML
    private Menu fileMenubar;
    @FXML
    private Menu editMenubar;
    @FXML
    private Group loginGroup;
    @FXML
    private TextField usernameTextField;
    @FXML
    private TextField passwordTextField;
    @FXML
    private Button testButton;
    @FXML
    private Group caseworkerGroup;
    @FXML
    private Color x22;
    @FXML
    private Font x12;
    @FXML
    private ListView<?> userList2;
    @FXML
    private Menu fileMenubar2;
    @FXML
    private Menu editMenubar2;

    private void handleButtonAction(ActionEvent event) {
        System.out.println(business.TestData());
        label.setText(business.TestData());
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {  
       business = UI.getInstance().getBusiness();
       

    }

    @FXML
    private void logInClick(MouseEvent event) {
    }

    @FXML
    private void testClick(MouseEvent event) {
    }

}
