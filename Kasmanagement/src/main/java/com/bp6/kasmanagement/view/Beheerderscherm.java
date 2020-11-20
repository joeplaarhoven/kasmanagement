/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bp6.kasmanagement.view;

import java.io.File;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

/**
 *
 * @author dahir
 */
public class Beheerderscherm extends BorderPane{
    
    
    private HBox menu = new HBox();
    private Button uitloggen = new Button("Uitloggen"),spaceknop = new Button();
    private Inlogscherm inlogscherm;
    private GebruikerBewerken gebruikerBewerkenScherm = new GebruikerBewerken();
    private KasBeheren kasBeheren = new KasBeheren();
    private SensorBeheren sensorBeheren = new SensorBeheren();
    private File file_logo = new File("Res/profielfoto.png");
    private Image image_logo;
    private ImageView imageview;
    private VBox vbox = new VBox(), optiebeheer = new VBox(), welkomstbericht = new VBox(),
            compleet = new VBox();
    private Label rol = new Label("Beheerder"),gebruikersnaam = new Label("Theo de Visser");
    private Text gebruikersmanagement = new Text("Gebruikersmanagement"),kasbeheer = new Text("Kasbeheer"),
            sensorbeheer = new Text("Sensorbeheeer"),welkom = new Text("Welkom Theo"),
            titel = new Text("Klik links om uw keuze te maken");
   

    
    
    
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
        gebruikersmanagement.setFont(Font.font("Verdana",FontWeight.BOLD,16));
        kasbeheer.setFont(Font.font("Verdana",FontWeight.BOLD,16));
        sensorbeheer.setFont(Font.font("Verdana",FontWeight.BOLD,16));
        
        welkomstbericht.getChildren().addAll(welkom,titel);
        welkomstbericht.setSpacing(5);
        welkomstbericht.setAlignment(Pos.TOP_CENTER);
        
        optiebeheer.getChildren().addAll(gebruikersmanagement,kasbeheer,sensorbeheer);
        optiebeheer.setSpacing(15);
        optiebeheer.setPadding(new Insets(5, 5, 5, 5));
        optiebeheer.setAlignment(Pos.CENTER_LEFT);
        
        compleet.getChildren().addAll(vbox,optiebeheer);
        compleet.setSpacing(80);
        compleet.setAlignment(Pos.TOP_CENTER);
        
        
        gebruikersmanagement.setOnMousePressed(event -> {
            this.getChildren().clear();
            this.setTop(menu);
            this.setLeft(compleet);
            this.setCenter(gebruikerBewerkenScherm);
            this.setRight(spaceknop);
           
        });
        gebruikersmanagement.setOnMouseEntered(event -> {
            gebruikersmanagement.setFill(Color.BLUE);
            gebruikersmanagement.setUnderline(true);
            this.setCursor(Cursor.HAND);
        });

        gebruikersmanagement.setOnMouseExited(event -> {
            gebruikersmanagement.setFill(Color.BLACK);
            gebruikersmanagement.setUnderline(false);
            this.setCursor(Cursor.DEFAULT);
        });
        
        kasbeheer.setOnMousePressed(event -> {
            this.getChildren().clear();
            this.setTop(menu);
            this.setLeft(compleet);
            this.setCenter(kasBeheren);
            this.setRight(spaceknop);
        });
        kasbeheer.setOnMouseEntered(event -> {
            kasbeheer.setFill(Color.BLUE);
            kasbeheer.setUnderline(true);
            this.setCursor(Cursor.HAND);
        });

        kasbeheer.setOnMouseExited(event -> {
            kasbeheer.setFill(Color.BLACK);
            kasbeheer.setUnderline(false);
            this.setCursor(Cursor.DEFAULT);
        });
        
        sensorbeheer.setOnMousePressed(event -> {
            this.getChildren().clear();
            this.setTop(menu);
            this.setLeft(compleet);
            this.setCenter(sensorBeheren);
            this.setRight(spaceknop);
           
        });
        sensorbeheer.setOnMouseEntered(event -> {
            sensorbeheer.setFill(Color.BLUE);
            sensorbeheer.setUnderline(true);
            this.setCursor(Cursor.HAND);
        });

        sensorbeheer.setOnMouseExited(event -> {
            sensorbeheer.setFill(Color.BLACK);
            sensorbeheer.setUnderline(false);
            this.setCursor(Cursor.DEFAULT);
        });
        
        uitloggen.setOnAction(event -> {

            this.getChildren().clear();
            inlogscherm = new Inlogscherm();
            this.setCenter(inlogscherm);

        });
        
       

        this.setTop(menu);
        this.setLeft(compleet);
        this.setCenter(welkomstbericht);
        this.setRight(spaceknop);
        
        

        
    }
    
}
