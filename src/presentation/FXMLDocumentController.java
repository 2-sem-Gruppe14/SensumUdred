/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation;

import acquintaince.IBusiness;
import business.login.Login;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.Animation;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.Menu;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Tab;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.DragEvent;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.RowConstraints;
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
    private TextArea caseFormaliaAboutTextArea;
    @FXML
    private RowConstraints befordringRow;
    @FXML
    private ScrollPane oneScrollPane;
    @FXML
    private GridPane OneGrid;
    @FXML
    private AnchorPane OneAnchorPane;
    @FXML
    private TextField caseFormaliaName;
    @FXML
    private TextField caseFormaliaCPR;
    @FXML
    private TextField caseFormaliaAddress;
    @FXML
    private CheckBox caseSeekingYesCheckBox;
    @FXML
    private CheckBox caseSeekingNoCheckBox;
    @FXML
    private CheckBox caseActivityServicesCheckBox;
    @FXML
    private CheckBox caseCarriageCheckbox;
    @FXML
    private Pane caseCarriagePane;
    @FXML
    private CheckBox caseCarrige1Checkbox;
    @FXML
    private CheckBox caseCarrige2Checkbox;
    @FXML
    private CheckBox caseCarrige3Checkbox;
    @FXML
    private CheckBox caseCarrige4Checkbox;
    @FXML
    private CheckBox caseCarrige5Checkbox;
    @FXML
    private CheckBox caseCarrige6Checkbox;
    @FXML
    private CheckBox caseCarrige7Checkbox;
    @FXML
    private Pane caseTreatmentPane;
    @FXML
    private CheckBox caseTreatment1CheckBox;
    @FXML
    private CheckBox caseTreatment2CheckBox;
    @FXML
    private CheckBox caseTreatment3CheckBox;
    @FXML
    private CheckBox caseTreatment4CheckBox;
    @FXML
    private CheckBox caseTreatment5CheckBox;
    @FXML
    private CheckBox caseTreatmentCheckBox;
    @FXML
    private CheckBox caseTreatmentCheckbox;
    @FXML
    private CheckBox caseDayReliefCheckBox;
    @FXML
    private CheckBox casePaymentServicesCheckBox;
    @FXML
    private Pane casePaymentServicesPane;
    @FXML
    private CheckBox casePaymentServices1CheckBox;
    @FXML
    private CheckBox casePaymentServices2CheckBox;
    @FXML
    private CheckBox caseControlSchemeCheckBox;
    @FXML
    private Pane caseRessidencePane;
    @FXML
    private CheckBox caseRessidence1CheckBox;
    @FXML
    private CheckBox caseRessidence2CheckBox;
    @FXML
    private CheckBox caseRessidence3CheckBox;
    @FXML
    private CheckBox caseRessidence4CheckBox;
    @FXML
    private CheckBox caseRessidence5CheckBox;
    @FXML
    private CheckBox caseRessidence6CheckBox;
    @FXML
    private CheckBox casePersonalHelpCheckBox;
    @FXML
    private CheckBox casePersonalHelp1CheckBox;
    @FXML
    private CheckBox casePraticalHelpCheckBox;
    @FXML
    private CheckBox casePraticalHelp2CheckBox;
    @FXML
    private CheckBox casePedagagueSupport1CheckBox;
    @FXML
    private Pane caseSocialPedagogueSupportPane;
    @FXML
    private CheckBox casePedagagueSupport2CheckBox;
    @FXML
    private CheckBox casePedagagueSupport3CheckBox;
    @FXML
    private CheckBox casePedagagueSupport4CheckBox;
    @FXML
    private CheckBox casePedagagueSupport5CheckBox;
    @FXML
    private CheckBox casePedagagueSupport6CheckBox;
    @FXML
    private CheckBox casePedagagueSupport7CheckBox;
    @FXML
    private CheckBox casePedagagueSupport8CheckBox;
    @FXML
    private CheckBox casePedagagueSupport9CheckBox;
    @FXML
    private CheckBox caseSupportSchemeCheckBox;
    @FXML
    private Pane caseSupportSchemePane;
    @FXML
    private CheckBox caseSupportScheme1CheckBox;
    @FXML
    private CheckBox caseSupportScheme2CheckBox;
    @FXML
    private CheckBox caseSupportScheme3CheckBox;
    @FXML
    private CheckBox caseSupportScheme4CheckBox;
    @FXML
    private CheckBox caseSupportScheme5CheckBox;
    @FXML
    private CheckBox caseSupportScheme6CheckBox;
    @FXML
    private CheckBox caseSupportScheme7CheckBox;
    @FXML
    private CheckBox caseSupportToolCheckBox;
    @FXML
    private Pane caseSupportToolPane;
    @FXML
    private CheckBox caseSupportTool1CheckBox;
    @FXML
    private CheckBox caseSupportTool2CheckBox;
    @FXML
    private CheckBox caseSupportTool3CheckBox;
    @FXML
    private CheckBox caseSupportTool4CheckBox;
    @FXML
    private CheckBox caseTrainingCheckBox;
    @FXML
    private Pane caseTrainingPane;
    @FXML
    private CheckBox caseTraining1CheckBox;
    @FXML
    private CheckBox caseTraining2CheckBox;
    @FXML
    private CheckBox caseTraining3CheckBox;
    @FXML
    private CheckBox caseTraining4CheckBox;
    @FXML
    private CheckBox caseTraining5CheckBox;
    @FXML
    private CheckBox caseTraining6CheckBox;
    @FXML
    private CheckBox caseTeachingCheckBox;
    @FXML
    private Pane caseTeachingPane;
    @FXML
    private CheckBox caseTeaching1CheckBox;
    @FXML
    private CheckBox caseTeaching2CheckBox;
    @FXML
    private CheckBox caseTeaching3CheckBox;
    @FXML
    private CheckBox caseCouncelingCheckBox;
    @FXML
    private CheckBox caseGuardianCheckBox;
    @FXML
    private Label caseNonServicesTextBox;
    @FXML
    private Pane caseControlSchemePane;
    @FXML
    private CheckBox caseControlScheme1CheckBox;
    @FXML
    private CheckBox caseControlScheme2CheckBox;
    @FXML
    private CheckBox caseControlScheme3CheckBox;
    @FXML
    private CheckBox caseControlScheme4CheckBox;
    @FXML
    private Tab case1Tab;
    @FXML
    private CheckBox caseRessidenceCheckBox;
    @FXML
    private ScrollPane oneScrollPane1;
    @FXML
    private AnchorPane OneAnchorPane1;
    @FXML
    private GridPane OneGrid1;
    @FXML
    private CheckBox caseManagementCheckBox;
    @FXML
    private CheckBox caseCurrentEffortCheckBox;
    @FXML
    private CheckBox caseSeperateCommunityCheckBox;
    @FXML
    private CheckBox caseOtherCheckBox;
    @FXML
    private CheckBox caseInquiryYesCheckbox;
    @FXML
    private CheckBox caseInquiryNoCheckBox;
    @FXML
    private CheckBox caseCitizenCheckBox;
    @FXML
    private CheckBox caseNextOfKinCheckBox;
    @FXML
    private CheckBox caseDoctorCheckBox;
    @FXML
    private CheckBox caseHospitalCheckBox;
    @FXML
    private CheckBox caseGuardianGoalCheckBox;
    @FXML
    private CheckBox caseGuardianGoal2CheckBox;
    @FXML
    private CheckBox caseGuardianGoal3CheckBox;
    @FXML
    private CheckBox caseGuardianGoal31CheckBox;
    @FXML
    private CheckBox caseGuardianGoal4CheckBox;
    @FXML
    private CheckBox caseGuardianGoal5CheckBox;
    @FXML
    private CheckBox caseGuardianGoal6CheckBox;
    @FXML
    private CheckBox caseCitizenRightCheckBox;
    @FXML
    private CheckBox caseRightsYesCheckBox;
    @FXML
    private CheckBox caseRightsNoCheckBox;
    @FXML
    private CheckBox caseConsentYesCheckBox;
    @FXML
    private CheckBox caseConsentNoCheckBox;
    @FXML
    private CheckBox caseConsent1CheckBox;
    @FXML
    private CheckBox caseConsent2CheckBox;
    @FXML
    private CheckBox caseConsent3CheckBox;
    @FXML
    private CheckBox caseConsent4CheckBox;
    @FXML
    private CheckBox caseConsent5CheckBox;
    @FXML
    private CheckBox caseConsent6CheckBox;
    @FXML
    private CheckBox caseConsent7CheckBox;
    @FXML
    private CheckBox caseConsent8CheckBox;
    @FXML
    private CheckBox caseConsent9CheckBox;
    @FXML
    private CheckBox caseConsent10CheckBox;
    @FXML
    private Label caseOthersLabel;
    @FXML
    private CheckBox caseSeperateCommune1CheckBox;
    @FXML
    private CheckBox caseSeperateCommune2CheckBox;
    @FXML
    private Tab case2Tab;
    
    private ArrayList<Node> tab1ArrayList = new ArrayList<>();
    private ArrayList<Node> tab2ArrayList = new ArrayList<>();
    private ArrayList<Node> tabFormaliaList = new ArrayList<>();
    private ArrayList<Node> tabTestArrayList = new ArrayList<>();

    @Override
    public void initialize(URL url, ResourceBundle rb) {  
       business = UI.getInstance().getBusiness();

       
       adminGroup.setDisable(true);
       adminGroup.setVisible(false);
       
       caseworkerGroup.setDisable(true);
       caseworkerGroup.setVisible(false);
       
       loginGroup.setDisable(false);
       loginGroup.setVisible(true);

            caseFormaliaCPR.textProperty().addListener((ObservableValue<? extends String> observable, String oldValue, String newValue) -> {
            if (!newValue.matches("\\d*")) {
                caseFormaliaCPR.setText(newValue.replaceAll("[^\\d]", ""));
            }
        });
            
        UpDownAnimation caseCarriageAnimation = new UpDownAnimation(caseCarriagePane);
        showHide(caseCarriageAnimation, caseCarriageCheckbox);
        
        UpDownAnimation caseTreatmentAnimation = new UpDownAnimation(caseTreatmentPane);
        showHide(caseTreatmentAnimation, caseTreatmentCheckBox);
        
        UpDownAnimation casePaymentServicesAnimation = new UpDownAnimation(casePaymentServicesPane);
        showHide(casePaymentServicesAnimation, casePaymentServicesCheckBox);
        
        UpDownAnimation caseControlSchemeAnimation = new UpDownAnimation(caseControlSchemePane);
        showHide(caseControlSchemeAnimation, caseControlSchemeCheckBox);
        
//        UpDownAnimation caseRessidenceAnimation = new UpDownAnimation(caseRessidencePane);
//        showHide(caseRessidenceAnimation, caseCaseRessidenceCheckBox); //lav den her om
        
        UpDownAnimation casePedagagueSupport1Animation = new UpDownAnimation(caseSocialPedagogueSupportPane);
        showHide(casePedagagueSupport1Animation, casePedagagueSupport1CheckBox);
        
        UpDownAnimation caseSupportToolAnimation = new UpDownAnimation(caseSupportToolPane);
        showHide(caseSupportToolAnimation, caseSupportToolCheckBox);
        
        UpDownAnimation caseTrainingAnimation = new UpDownAnimation(caseTrainingPane);
        showHide(caseTrainingAnimation, caseTrainingCheckBox);
        
        UpDownAnimation caseTeachingAnimation = new UpDownAnimation(caseTeachingPane);
        showHide(caseTeachingAnimation, caseTeachingCheckBox);
        
        nodesToList(caseGrid, tabFormaliaList);
        nodesToList(OneGrid, tab1ArrayList);
        nodesToList(OneGrid1, tab2ArrayList);
        
    }

    @FXML
    private void logInClick(MouseEvent event) {
        
        String password = toSHAHash(passwordTextField.getText());
        
        boolean successfullLogin = business.GUILogin(usernameTextField.getText(), 
                password);
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
        for (Node node : tab1ArrayList){
            if(node instanceof CheckBox){
            ((CheckBox) node).setSelected(false);
            }if(node instanceof TextArea){
            ((TextArea) node).clear();
            }if(node instanceof TextField){
            ((TextField)node).clear();
            }
            
        }
    }

    @FXML
    private void editCaseClick(MouseEvent event) {
        System.out.println(tabTestArrayList);
        for(int i=0; i<tab1ArrayList.size(); i++){
            Node node = tab1ArrayList.get(i);
            Node nodeSaved = tabTestArrayList.get(i);
            if(node instanceof CheckBox){
            ((CheckBox) node).setSelected(((CheckBox)nodeSaved).isSelected());
            }if(node instanceof TextArea){
            ((TextArea) node).setText(((TextArea)nodeSaved).getText());
            }if(node instanceof TextField){
            ((TextField)node).setText(((TextField)nodeSaved).getText());
            }
        }
       
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

    @FXML
    private void caseFormaliaSaveClick(MouseEvent event) {
        String formaliaArray[] = {caseFormaliaName.getText(),
                caseFormaliaCPR.getText(),
                caseFormaliaAddress.getText(),
                caseFormaliaAboutTextArea.getText()};
        
        
        
    }

    private void showHide(UpDownAnimation animation, CheckBox checkBox) {
        if (checkBox.isSelected() == true) {
            animation.show();
        } else {
            animation.hide();
        }

        checkBox.selectedProperty().addListener((ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) -> {
            if (checkBox.isSelected() == true) {
                animation.show();
            } else if (checkBox.isSelected() == false) {
                animation.hide();
            }
        });
    }


    @FXML
    private void caseSave1Click(MouseEvent event) {
        tabTestArrayList.addAll(tab1ArrayList);
    }

    @FXML
    private void caseSave2Click(MouseEvent event) {
    }

    public void nodesToList(Node grid, ArrayList<Node> arrayList){
    
                ((GridPane) grid).getChildren().forEach((node) -> {
            if (node instanceof Pane) {
                ((Pane) node).getChildren().forEach((paneNode) -> {
                    if (paneNode instanceof CheckBox) {
                        arrayList.add(paneNode);
                    } else if (paneNode instanceof TextField) {
                        arrayList.add(paneNode);
                    } else if (paneNode instanceof TextArea) {
                        arrayList.add(paneNode);
                    }
                });
            } else if (node instanceof CheckBox) {
                arrayList.add(node);
            } else if (node instanceof TextArea) {
                arrayList.add(node);
            } else if (node instanceof TextField) {
                arrayList.add(node);
            }
        });
        
    }        

    public String toSHAHash(String text) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hash = digest.digest(text.getBytes("UTF-8"));
            StringBuffer hexString = new StringBuffer();

            for (int i = 0; i < hash.length; i++) {
                String hex = Integer.toHexString(0xff & hash[i]);
                if (hex.length() == 1) {
                    hexString.append('0');
                }
                hexString.append(hex);
            }

            return hexString.toString();
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }

    }

   
    /**
     * 
     * @param event 
     */
    @FXML
    private void verifyPassword(KeyEvent event) {
        // defining booleans for each password rule
        boolean containsAtleast8Characters = true;
        boolean containsAtMost64Characters = true;

        boolean containsLetter = false;
        boolean containsDigit = false;
        boolean containsLowerCaseLetter = false;
        boolean containsUpperCaseLetter = false;

        // getting the password in first textfield
        String password = password1Field.getText();

        // checks if password has a length of at least 8 characters
        if (password.length() < 8) {
            // this password rule condition is not meet
            containsAtleast8Characters = false;

            // displays that the password must contain at least 8 characters
            // -- code here -- //
        }

        // checks if the password has a length of at most 64 characters
        if (password.length() > 64) {
            // this password rule condition is not meet
            containsAtMost64Characters = false;

            // displays that the password can only contain at most 64 characters
            // -- code here -- //
        }

        // checks the following:
        //   *  if the password both letters and digits
        //   *  if the password contains different case letters
        for (int i = 0; i < password.length(); i++) {
            // getting the character of the given index in the string
            char character = password.charAt(i);

            // checks if the given character is a letter
            if (Character.isLetter(character)) {
                containsLetter = true;

                // checks if the given letter is lower case
                if (Character.isLowerCase(character)) {
                    containsLowerCaseLetter = true;
                }

                // checks if the given letter is upper case
                if (Character.isUpperCase(character)) {
                    containsUpperCaseLetter = true;
                }
            }

            // checks if the given character is a digit
            if (containsDigit) {
                containsDigit = true;
            }
        }

        // checks if all the password rule conditions are met
        if (containsAtleast8Characters
                && containsAtMost64Characters
                && containsLetter
                && containsDigit
                && containsLowerCaseLetter
                && containsUpperCaseLetter) {
            // -- code here for when the password is legitimate -- //
            activateNode(password2Field);
        } else {
            // deactivateNode(password2Field);
        }
    }

    /**
     * KeyEvent method that compares the following two text fields, and
     * sets a boolean to true, if their content match
     * 
     * @param event - the event that is thrown when key typed
     */
    @FXML
    private void comparePasswords(KeyEvent event) {
        // getting the password in second textfield
        String password = password2Field.getText();
        
        //checks if the passwords in both text fields are the same
        if (password.equals(password1Field.getText())) {
            // -- code here for when the passwords in both textfield matches -- //
        }
    }
    
    /**
     * Enables and makes the given node visible
     * 
     * @param node - The node to be activated
     */
    private void activateNode(Node node) {
        node.setVisible(true);
        node.setDisable(false);
    }
}
