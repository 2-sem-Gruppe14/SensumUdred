/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation;

import acquintaince.IBusiness;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import acquintaince.IPresentation;

/**
 *
 * @author Mikkel Ebjerg
 */
public class UI extends Application implements IPresentation{

    private IBusiness business;
    public UI(){}

    private static UI ui;

    public static UI getInstance() {
        return ui;
    }

    public IBusiness getBusiness() {
        return business;
    }

    @Override
    public void injectBusiness(IBusiness IBusiness) {
        business = IBusiness;
    }

    @Override

    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));

        Scene scene = new Scene(root);

        stage.setScene(scene);
        stage.show();
    }

    public void startApplication(String[] args) {
        ui=this;
        launch(args);
    }

   

}
