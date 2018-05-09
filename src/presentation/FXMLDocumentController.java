/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation;

import acquintaince.IBusiness;
import business.BusinessFacade;
import business.login.Login;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.animation.Animation;
import javafx.animation.Interpolator;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.PathTransition;
import javafx.animation.Timeline;
import javafx.animation.Transition;
import javafx.animation.TranslateTransition;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.Menu;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.DragEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.util.Duration;

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
    private Menu fileMenubar2;
    @FXML
    private Menu editMenubar2;
    @FXML
    private AnchorPane viewPane;
    @FXML
    private TextField password1Field;
    @FXML
    private TextField password2Field;
    @FXML
    private Button adminSaveButton;
    @FXML
    private CheckBox canLogIn;
    @FXML
    private ListView<?> userLog;
    @FXML
    private ListView<?> caseList;
    @FXML
    private Button newCase;
    @FXML
    private Button editCase;
    @FXML
    private ListView<?> caseLog;
    @FXML
    private Button editUserButton;
    @FXML
    private RadioButton adminRadioButton;
    @FXML
    private RadioButton leaderRadioButton;
    @FXML
    private RadioButton caseworkerRadioButton;
    @FXML
    private TextField usernameCreateField;
    @FXML
    private RowConstraints colunm0;
    @FXML
    private RowConstraints column1;
    @FXML
    private GridPane caseGrid;
    @FXML
    private AnchorPane caseAnchorPane;
    @FXML
    private Pane testtestpane;
    @FXML
    private TextField caseName;
    @FXML
    private TextField caseCPR;
    @FXML
    private TextField caseAddress;

    @Override
    public void initialize(URL url, ResourceBundle rb) {  
       business = UI.getInstance().getBusiness();
       Login login = new Login();
       
       adminGroup.setDisable(true);
       adminGroup.setVisible(false);
       
       caseworkerGroup.setDisable(true);
       caseworkerGroup.setVisible(false);
       
       loginGroup.setDisable(false);
       loginGroup.setVisible(true);

            caseCPR.textProperty().addListener((ObservableValue<? extends String> observable, String oldValue, String newValue) -> {
            if (!newValue.matches("\\d*")) {
                caseCPR.setText(newValue.replaceAll("[^\\d]", ""));
            }
        });

 
    }

    @FXML
    private void logInClick(MouseEvent event) {
        boolean successfullLogin = business.GUILogin(usernameTextField.getText(), 
                passwordTextField.getText());
        if(successfullLogin){
        caseworkerGroup.setDisable(false);
        caseworkerGroup.setVisible(true);
       
        loginGroup.setDisable(true);
        loginGroup.setVisible(false);
        }
    }

    @FXML
    private void testClick(MouseEvent event) {
        System.out.println(business.TestData());
        System.out.println(business.TestCPRAPI());
    }

    @FXML
    private void adminSaveClick(MouseEvent event) {
    }

    @FXML
    private void newCaseClick(MouseEvent event) {
    }

    @FXML
    private void editCaseClick(MouseEvent event) {
    }

    @FXML
    private void newUserClick(MouseEvent event) {
    }

    @FXML
    private void newUserButton(DragEvent event) {
    }

    @FXML
    private void editUserClick(MouseEvent event) {
    }


}
