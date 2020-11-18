/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bp6.kasmanagement.controller;

import com.bp6.kasmanagement.view.Overzicht;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 *
 * @author laarh
 */
public class main extends Application {

    /**
     * @param args the command line arguments
     */
    public void start (Stage mainStage){
        BorderPane root = new Overzicht();
        Scene scene = new Scene(root,1000,1000);
       
        mainStage.setScene(scene);
        mainStage.setTitle("Kasmonitoringsysteem");
        mainStage.show();
        
    }
    
     public static void main(String [] args){
        launch(args);
    }
}