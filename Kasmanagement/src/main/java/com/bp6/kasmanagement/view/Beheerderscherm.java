/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bp6.kasmanagement.view;

import java.io.File;
import java.util.Optional;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;

/**
 *
 * @author dahir
 */
public class Beheerderscherm extends BorderPane{
    
    
    private HBox menu = new HBox();
    private Button uitloggen = new Button("Uitloggen"),spaceknop = new Button();
    private Inlogscherm inlogscherm;
    private GebruikerBewerken gebruikerBewerkenScherm = new GebruikerBewerken();
    private File file_logo = new File("Res/profielfoto.png");
    private Image image_logo;
    private ImageView imageview;
    private VBox vbox = new VBox(), optiebeheer = new VBox(), welkomstbericht = new VBox(),
            compleet = new VBox();
    private Label rol = new Label("Beheerder"), gebruikersmanagement = new Label("Gebruikersmanagement"),
            kasbeheer = new Label("Kasbeheer"), sensorbeheer = new Label("Sensorbeheeer"),
            gebruikersnaam = new Label("Theo de Visser"),welkom = new Label("Welkom Theo"),
            titel = new Label("Klik hieronder om uw keuze te maken");

    
    
    
    public Beheerderscherm(){
        
        menu.setPadding(new Insets(15, 12, 15, 12));
        menu.setSpacing(10);
        menu.getChildren().addAll(uitloggen);
        menu.setAlignment(Pos.CENTER_RIGHT);
        
        image_logo = new Image(file_logo.toURI().toString());
        imageview = new ImageView(image_logo);
        
        gebruikersnaam.setFont(Font.font("Verdana",FontWeight.BOLD,20));
        rol.setFont(Font.font("Verdana",18));
        
        vbox.getChildren().addAll(imageview,gebruikersnaam,rol);
        vbox.setSpacing(10);
        vbox.setMinWidth(250);
        vbox.setPadding(new Insets(35, 5, 5, 5));
        
        spaceknop.setMinWidth(200);
        spaceknop.setVisible(false);
        
        welkom.setFont(Font.font("Verdana",FontWeight.BOLD,26));
        titel.setFont(Font.font("Verdana",22));
        gebruikersmanagement.setFont(Font.font("Verdana",FontPosture.ITALIC,20));
        kasbeheer.setFont(Font.font("Verdana",FontPosture.ITALIC,20));
        sensorbeheer.setFont(Font.font("Verdana",FontPosture.ITALIC,20));
        
        welkomstbericht.getChildren().addAll(welkom,titel);
        welkomstbericht.setSpacing(5);
        welkomstbericht.setAlignment(Pos.CENTER);
        
        optiebeheer.getChildren().addAll(gebruikersmanagement,kasbeheer,sensorbeheer);
        optiebeheer.setSpacing(15);
        optiebeheer.setPadding(new Insets(5, 5, 5, 5));
        optiebeheer.setAlignment(Pos.CENTER);
        
        compleet.getChildren().addAll(welkomstbericht,optiebeheer);
        compleet.setSpacing(140);
        compleet.setAlignment(Pos.TOP_CENTER);
        
        
        gebruikersmanagement.setOnMousePressed(event -> {

           
        });
        
        kasbeheer.setOnMousePressed(event -> {
            
            this.setCenter(gebruikerBewerkenScherm);
           
        });
        
        sensorbeheer.setOnMousePressed(event -> {

           
        });
        
        
        uitloggen.setOnAction(event -> {

            this.getChildren().clear();
            inlogscherm = new Inlogscherm();
            this.setCenter(inlogscherm);

        });
        
       

        this.setTop(menu);
        this.setLeft(vbox);
        this.setCenter(compleet);
        this.setRight(spaceknop);
        
        

        
    }
    
}
