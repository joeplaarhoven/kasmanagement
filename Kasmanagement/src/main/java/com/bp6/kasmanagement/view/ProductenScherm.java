/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bp6.kasmanagement.view;

import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

/**
 *
 * @author Colin
 */
public class ProductenScherm extends BorderPane {

    private HBox hbox_labels;

    Label productName, idealTemperature, idealHumidity, idealLight, idealGrowth;

    public ProductenScherm() {
        // Creates Hbox    
        hbox_labels = new HBox();
        
        // Set Labels    
        productName = new Label("Naam product");
        idealTemperature = new Label("Ideale tempratuur");
        idealHumidity = new Label("Ideale luchtvochtigheid");
        idealLight = new Label("Ideale belichting intensiteit");
        idealGrowth = new Label("Ideale groei tijd");
        
        // Set Fonts
        productName.setFont(Font.font("Verdana", FontWeight.BOLD, 15));
        idealTemperature.setFont(Font.font("Verdana", FontWeight.BOLD, 15));
        idealHumidity.setFont(Font.font("Verdana", FontWeight.BOLD, 15));
        idealLight.setFont(Font.font("Verdana", FontWeight.BOLD, 15));
        idealGrowth.setFont(Font.font("Verdana", FontWeight.BOLD, 15));
        
        // Places the labels in the Hbox
        hbox_labels.getChildren().addAll(productName, idealTemperature, idealHumidity, idealLight, idealGrowth);
        this.setLeft(hbox_labels);
    }
}
