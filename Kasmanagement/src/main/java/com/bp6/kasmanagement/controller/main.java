package com.bp6.kasmanagement.controller;

import com.bp6.kasmanagement.view.Rootpane;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author laarh
 */
public class main extends Application {

    /**
     * @param mainStage
     * @param args the command line arguments
     */
    public void start (Stage mainStage){
        Rootpane root = new Rootpane();
        Scene scene = new Scene(root,1200,1000);
       
        mainStage.setScene(scene);
        mainStage.setTitle("Kasmonitoringsysteem");
        mainStage.show();
        
    }
    
     public static void main(String [] args){
        launch(args);
    }
}