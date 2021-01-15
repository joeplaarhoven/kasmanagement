/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bp6.kasmanagement.view;

import com.bp6.kasmanagement.controller.ToestemmingController;
import javafx.geometry.Insets;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

/**
 *
 * @author dahir
 */
public class ToestemmingScherm extends BorderPane {
    
    private Button huidigeStatus = new Button("Huidige Status");
    private Label windLabel,lichtLabel,bodemVochtLabel,binnenTemplabel,buitenTemplabel,binnenLuchtLabel,buitenLuchtLabel;
    private Text windToestemmingTekst,lichtToestemmingTekst,bodemVochtToestemmingTekst,binnenTempToestemmingTekst,
            buitenTempToestemmingTekst,binnenLuchtVochtToestemmingTekst,buitenLuchtVochtToestemmingTekst;
    private TextField windBar,LichtBar,bodemVochtBar,binnenTempBar,buitenTempBar,binnenLuchtBar,buitenLuchtBar;
    
    private GridPane hoofdPane = new GridPane();
    private ToestemmingController toestemmingController = new ToestemmingController();
    
    public ToestemmingScherm(){
        
        //Labels    
        windLabel = new Label("Windsnelheid:");
        lichtLabel = new Label("Licht:");
        bodemVochtLabel = new Label("Bodemvochtigheid:");
        binnenTemplabel = new Label("Binnen Temperatuur:");
        buitenTemplabel = new Label("Buiten Temperatuur:");
        binnenLuchtLabel= new Label("Binnen Luchtvochtigheid:");
        buitenLuchtLabel= new Label("Buiten luchtvochtigheid:");
        
        //sets padding button
        huidigeStatus.setPadding(new Insets(5, 5, 5, 5));
        
        //Text    
        windToestemmingTekst = new Text();
        lichtToestemmingTekst = new Text();
        bodemVochtToestemmingTekst = new Text();
        binnenTempToestemmingTekst = new Text();
        buitenTempToestemmingTekst = new Text();
        binnenLuchtVochtToestemmingTekst = new Text();
        buitenLuchtVochtToestemmingTekst = new Text();
        
        //textfield
        windBar = new TextField();
        LichtBar = new TextField();
        bodemVochtBar = new TextField();
        binnenTempBar = new TextField();
        buitenTempBar = new TextField();
        binnenLuchtBar = new TextField();
        buitenLuchtBar = new TextField();
        
        
        // Set Fonts labels
        windLabel.setFont(Font.font("Verdana", FontWeight.BOLD, 15));
        lichtLabel.setFont(Font.font("Verdana", FontWeight.BOLD, 15));
        bodemVochtLabel.setFont(Font.font("Verdana", FontWeight.BOLD, 15));
        binnenTemplabel.setFont(Font.font("Verdana", FontWeight.BOLD, 15));
        buitenTemplabel.setFont(Font.font("Verdana", FontWeight.BOLD, 15));
        binnenLuchtLabel.setFont(Font.font("Verdana", FontWeight.BOLD, 15));
        buitenLuchtLabel.setFont(Font.font("Verdana", FontWeight.BOLD, 15));
        
        // Set Fonts Text
        windToestemmingTekst.setFont(Font.font("Verdana",15));
        lichtToestemmingTekst.setFont(Font.font("Verdana",15));
        bodemVochtToestemmingTekst.setFont(Font.font("Verdana",15));
        binnenTempToestemmingTekst.setFont(Font.font("Verdana",15));
        buitenTempToestemmingTekst.setFont(Font.font("Verdana",15));
        binnenLuchtVochtToestemmingTekst.setFont(Font.font("Verdana",15));
        buitenLuchtVochtToestemmingTekst.setFont(Font.font("Verdana",15));
    
       
        // Sets size textfield
        windBar.setMaxSize(60, 17);
        windBar.setMinSize(60, 17);
        LichtBar.setMaxSize(60, 17);
        LichtBar.setMinSize(60, 17);
        bodemVochtBar.setMaxSize(60, 17);
        bodemVochtBar.setMinSize(60, 17);
        binnenTempBar.setMaxSize(60, 17);
        binnenTempBar.setMinSize(60, 17);
        buitenTempBar.setMaxSize(60, 17);
        buitenTempBar.setMinSize(60, 17);
        binnenLuchtBar.setMaxSize(60, 17);
        binnenLuchtBar.setMinSize(60, 17);
        buitenLuchtBar.setMaxSize(60, 17);
        buitenLuchtBar.setMinSize(60, 17);
        
        //setting textfield visablity
        windBar.setVisible(false);
        LichtBar.setVisible(false);
        bodemVochtBar.setVisible(false);
        binnenTempBar.setVisible(false);
        buitenTempBar.setVisible(false);
        binnenLuchtBar.setVisible(false);
        buitenLuchtBar.setVisible(false);
        
        //setting textfield editable
        windBar.setEditable(false);
        LichtBar.setEditable(false);
        bodemVochtBar.setEditable(false);
        binnenTempBar.setEditable(false);
        buitenTempBar.setEditable(false);
        binnenLuchtBar.setEditable(false);
        buitenLuchtBar.setEditable(false);
              
        // set Padding Vbox
        hoofdPane.setPadding(new Insets(50, 5, 5, 100));
     
        //set Vgap and Hgap
        hoofdPane.setVgap(30);
        hoofdPane.setHgap(40);
        
        //Placing the items in the gridPan
        hoofdPane.add(huidigeStatus, 0, 0);
        hoofdPane.add(windLabel, 1, 0);
        hoofdPane.add(lichtLabel, 1, 1);
        hoofdPane.add(bodemVochtLabel, 1, 2);
        hoofdPane.add(binnenTemplabel, 1, 3);
        hoofdPane.add(buitenTemplabel, 1, 4);
        hoofdPane.add(binnenLuchtLabel, 1, 5);
        hoofdPane.add(buitenLuchtLabel, 1, 6);
        hoofdPane.add(windToestemmingTekst, 2, 0);
        hoofdPane.add(lichtToestemmingTekst, 2, 1);
        hoofdPane.add(bodemVochtToestemmingTekst, 2, 2);
        hoofdPane.add(binnenTempToestemmingTekst, 2, 3);
        hoofdPane.add(buitenTempToestemmingTekst, 2, 4);
        hoofdPane.add(binnenLuchtVochtToestemmingTekst, 2, 5);
        hoofdPane.add(buitenLuchtVochtToestemmingTekst, 2, 6);
        hoofdPane.add(windBar, 3, 0);
        hoofdPane.add(LichtBar, 3, 1);
        hoofdPane.add(bodemVochtBar, 3, 2);
        hoofdPane.add(binnenTempBar, 3, 3);
        hoofdPane.add(buitenTempBar, 3, 4);
        hoofdPane.add(binnenLuchtBar, 3, 5);
        hoofdPane.add(buitenLuchtBar, 3, 6);
         
        huidigeStatus.setOnAction(event->{
            String resultWindString =toestemmingController.setWindToestemming();
            String resultLichtString =toestemmingController.setLichtToestemming();
            String resultBodemVochtString =toestemmingController.setBodemVochtToestemming();
            String resultBinnenTempString = toestemmingController.setBinnenTempratuurToestemming();
            String resultBuitenTempString = toestemmingController.setBuitenTempratuurToestemming();
            String resultBinnenLuchtString = toestemmingController.setBinnenLuchtVochtigheidToestemming();
            String resultBuitenLuString = toestemmingController.setBuitenLuchtVochtigheidToestemming();
            
            windToestemmingTekst.setText(resultWindString);
            lichtToestemmingTekst.setText(resultLichtString);
            bodemVochtToestemmingTekst.setText(resultBodemVochtString);
            binnenTempToestemmingTekst.setText(resultBinnenTempString);
            buitenTempToestemmingTekst.setText(resultBuitenTempString);
            binnenLuchtVochtToestemmingTekst.setText(resultBinnenLuchtString);
            buitenLuchtVochtToestemmingTekst.setText(resultBuitenLuString);
            
            if(resultWindString.equalsIgnoreCase("te laag")){
                windBar.setBackground(new Background(new BackgroundFill(Color.web("#FF0000"), null, null)));
                windBar.setVisible(true);
            }
            
            if(resultWindString.equalsIgnoreCase("goed")){
                windBar.setBackground(new Background(new BackgroundFill(Color.web("#00FF00"), null, null)));
                windBar.setVisible(true);
            }
            
            if(resultWindString.equalsIgnoreCase("te hoog")){
                windBar.setBackground(new Background(new BackgroundFill(Color.web("#FF0000"), null, null)));
                windBar.setVisible(true);
                
                Alert alert = new Alert(Alert.AlertType.WARNING);
                    alert.setTitle("Warning!");
                    alert.setHeaderText("Sluit de ramen!");
                    alert.setContentText("De windsnelheid is te hoog!");
                    alert.showAndWait();
            }
            
            
            
            
            if(resultLichtString.equalsIgnoreCase("te laag")){
                LichtBar.setBackground(new Background(new BackgroundFill(Color.web("#FF0000"), null, null)));
                LichtBar.setVisible(true);
                
            }
            
            if(resultLichtString.equalsIgnoreCase("goed")){
                LichtBar.setBackground(new Background(new BackgroundFill(Color.web("#00FF00"), null, null)));
                LichtBar.setVisible(true);
            }
            
            if(resultLichtString.equalsIgnoreCase("te hoog")){
                LichtBar.setBackground(new Background(new BackgroundFill(Color.web("#FF0000"), null, null)));
                LichtBar.setVisible(true);
                
                Alert alert = new Alert(Alert.AlertType.WARNING);
                    alert.setTitle("Warning!");
                    alert.setHeaderText("Dim het licht!");
                    alert.setContentText("Er schijnt te veel licht!");
                    alert.showAndWait();
            }
            
            
            
            if(resultBodemVochtString.equalsIgnoreCase("te laag")){
                bodemVochtBar.setBackground(new Background(new BackgroundFill(Color.web("#FF0000"), null, null)));
                bodemVochtBar.setVisible(true);
            }
            
            if(resultBodemVochtString.equalsIgnoreCase("goed")){
                bodemVochtBar.setBackground(new Background(new BackgroundFill(Color.web("#00FF00"), null, null)));
                bodemVochtBar.setVisible(true);
            }
            
            if(resultBodemVochtString.equalsIgnoreCase("te hoog")){
                bodemVochtBar.setBackground(new Background(new BackgroundFill(Color.web("#FF0000"), null, null)));
                bodemVochtBar.setVisible(true);
                
                Alert alert = new Alert(Alert.AlertType.WARNING);
                    alert.setTitle("Warning!");
                    alert.setHeaderText("Zet de verwarming aan!");
                    alert.setContentText("De bodemvochtigheid is te hoog!");
                    alert.showAndWait();
            }
            
            
            
            if(resultBinnenTempString.equalsIgnoreCase("te laag")){
                binnenTempBar.setBackground(new Background(new BackgroundFill(Color.web("#FF0000"), null, null)));
                binnenTempBar.setVisible(true);
            }
            
            if(resultBinnenTempString.equalsIgnoreCase("goed")){
                binnenTempBar.setBackground(new Background(new BackgroundFill(Color.web("#00FF00"), null, null)));
                binnenTempBar.setVisible(true);
            }
            
            if(resultBinnenTempString.equalsIgnoreCase("te hoog")){
                binnenTempBar.setBackground(new Background(new BackgroundFill(Color.web("#FF0000"), null, null)));
                binnenTempBar.setVisible(true);
                
                Alert alert = new Alert(Alert.AlertType.WARNING);
                    alert.setTitle("Warning!");
                    alert.setHeaderText("Open de ramen!");
                    alert.setContentText("De binnen temperatuur is te hoog!");
                    alert.showAndWait();
            }
            
            
            
            if(resultBuitenTempString.equalsIgnoreCase("te laag")){
                buitenTempBar.setBackground(new Background(new BackgroundFill(Color.web("#FF0000"), null, null)));
                buitenTempBar.setVisible(true);
            }
            
            if(resultBuitenTempString.equalsIgnoreCase("goed")){
                buitenTempBar.setBackground(new Background(new BackgroundFill(Color.web("#00FF00"), null, null)));
                buitenTempBar.setVisible(true);
            }
            
            if(resultBuitenTempString.equalsIgnoreCase("te hoog")){
                buitenTempBar.setBackground(new Background(new BackgroundFill(Color.web("#FF0000"), null, null)));
                buitenTempBar.setVisible(true);
                
                Alert alert = new Alert(Alert.AlertType.WARNING);
                    alert.setTitle("Warning!");
                    alert.setHeaderText("Sluit de ramen!");
                    alert.setContentText("De buiten tempratuur is te hoog!");
                    alert.showAndWait();
            }
            
            
            
            if(resultBinnenLuchtString.equalsIgnoreCase("te laag")){
                binnenLuchtBar.setBackground(new Background(new BackgroundFill(Color.web("#FF0000"), null, null)));
                binnenLuchtBar.setVisible(true);
            }
            
            if(resultBinnenLuchtString.equalsIgnoreCase("goed")){
                binnenLuchtBar.setBackground(new Background(new BackgroundFill(Color.web("#00FF00"), null, null)));
                binnenLuchtBar.setVisible(true);
            }
            
            if(resultBinnenLuchtString.equalsIgnoreCase("te hoog")){
                binnenLuchtBar.setBackground(new Background(new BackgroundFill(Color.web("#FF0000"), null, null)));
                binnenLuchtBar.setVisible(true);
                
                Alert alert = new Alert(Alert.AlertType.WARNING);
                    alert.setTitle("Warning!");
                    alert.setHeaderText("Open de ramen!");
                    alert.setContentText("De binnen luchtvochtigheid is te hoog!");
                    alert.showAndWait();
            }
            
            
            
            if(resultBuitenLuString.equalsIgnoreCase("te laag")){
                buitenLuchtBar.setBackground(new Background(new BackgroundFill(Color.web("#FF0000"), null, null)));
                buitenLuchtBar.setVisible(true);
            }
            
            if(resultBuitenLuString.equalsIgnoreCase("goed")){
                buitenLuchtBar.setBackground(new Background(new BackgroundFill(Color.web("#00FF00"), null, null)));
                buitenLuchtBar.setVisible(true);
            }
            
            if(resultBuitenLuString.equalsIgnoreCase("te hoog")){
                buitenLuchtBar.setBackground(new Background(new BackgroundFill(Color.web("#FF0000"), null, null)));
                buitenLuchtBar.setVisible(true);
                
                Alert alert = new Alert(Alert.AlertType.WARNING);
                    alert.setTitle("Warning!");
                    alert.setHeaderText("Sluit de ramen!");
                    alert.setContentText("De buiten luchtvochtigheid is te hoog!");
                    alert.showAndWait();
            }
        });
        
        this.setCenter(hoofdPane);
    }
}
