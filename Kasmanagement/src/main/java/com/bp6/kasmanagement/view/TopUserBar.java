package com.bp6.kasmanagement.view;

import com.bp6.kasmanagement.controller.TopUserBarController;
import com.bp6.kasmanagement.model.KasInformatie;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

/**
 *
 * @author Colin
 */
public class TopUserBar extends HBox {
    
    Button products, sensorManagement, logout;
    
    KasInformatie selecteer_Kas;
    ComboBox<KasInformatie> cb_kasinformatie;
    
    Label user;

    public TopUserBar(TopUserBarController topUserBarController) {
        
        cb_kasinformatie = new ComboBox<> ();
        sensorManagement = new Button("Sensormanagement");
        products = new Button("Producten");
        logout = new Button("Uitloggen");
                
        selecteer_Kas = new KasInformatie (-1, "Selecter Kas" , "11:11");
        
        cb_kasinformatie.getItems().add(selecteer_Kas);
        cb_kasinformatie.getSelectionModel().select(selecteer_Kas);
        
        // Knoppen logica
        cb_kasinformatie.setOnAction(e -> {
        
        });
        
        sensorManagement.setOnAction(e -> {
            topUserBarController.sensor_Management();
            
        });
        
        products.setOnAction(e -> {
            topUserBarController.products();
        });
        
        logout.setOnAction(e -> {
            topUserBarController.logout();
        });
      
        // Sets Label and size
        user = new Label();
        user.setFont(Font.font("Verdana", FontWeight.BOLD, 15));
        
        // Sets Width
        cb_kasinformatie.setMaxWidth(200);
        cb_kasinformatie.setMinWidth(200);
        user.setPrefWidth(200);
        sensorManagement.setPrefWidth(200);
        products.setPrefWidth(200);
        logout.setPrefWidth(200);
        
        // Sets height
        cb_kasinformatie.setPrefHeight(45);
        user.setPrefHeight(45);
        sensorManagement.setPrefHeight(45);
        products.setPrefHeight(45);
        logout.setPrefHeight(45);
                
        // Sets padding
        cb_kasinformatie.setPadding(new Insets(5, 5, 5, 5));
        user.setPadding(new Insets(5, 5, 5, 5));
        sensorManagement.setPadding(new Insets(5, 5, 5, 5));
        products.setPadding(new Insets(5, 5, 5, 5));
        logout.setPadding(new Insets(5, 5, 5, 5));
        
        // Sets spacing
        this.setSpacing(20);
        this.setPadding(new Insets (5, 5, 5, 5));
        
        this.getChildren().addAll(cb_kasinformatie, products, sensorManagement, logout, user);
    }

    public Label getUser() {
        return user;
    }
    
}
