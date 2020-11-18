/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bp6.kasmanagement;

import java.io.File;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

/**
 *
 * @author dahir
 */
public class Hoofdscherm extends BorderPane {
    
   private HBox menu = new HBox();
   private File file_logo = new File("Res/profielfoto.png");
   private Image image_logo;
   private ImageView imageview;
   private HBox hbox = new HBox();
   private VBox vbox = new VBox();
   private Label gebruikersnaam = new Label("Theo de Visser");
   private Label rol = new Label("Beheerder");
   
    
    public Hoofdscherm(){
        
        Button button1 = new Button("Kas 1");
        Button button2 = new Button("Kas 2");        
        Button button3 = new Button("Kas 3");
        
        button1.setPrefSize(100, 20);
        button2.setPrefSize(100, 20);
        button3.setPrefSize(100, 20);
        
        menu.setPadding(new Insets(15, 12, 15, 12));
        menu.setSpacing(10);
        menu.getChildren().addAll(button1, button2, button3);
        
        image_logo = new Image(file_logo.toURI().toString());
        imageview = new ImageView(image_logo);
        
        gebruikersnaam.setFont(Font.font("Verdana",FontWeight.BOLD,20));
        rol.setFont(Font.font("Verdana",18));
        
        vbox.getChildren().addAll(imageview,gebruikersnaam,rol);
        vbox.setSpacing(10);
        vbox.setPadding(new Insets(35, 5, 5, 5));
        
//        hbox.getChildren().add(vbox);
//        hbox.setPadding(new Insets(65, 5, 5, 40));
//        hbox.setMaxSize(10, 50);
        
        
        this.setRight(vbox);
        
        this.setTop(menu);
      
        
        
        
        
        
        
        
      
    }
}
