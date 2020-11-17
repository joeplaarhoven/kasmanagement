/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bp6.kasmanagement;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;

/**
 *
 * @author dahir
 */
public class Hoofdscherm extends BorderPane {
    
   private HBox menu = new HBox();
   
    
    public Hoofdscherm(){
        
        Button button1 = new Button("Button 1");
        Button button2 = new Button("Button 2");        
        Button button3 = new Button("Button 3");
        
        button1.setPrefSize(100, 20);
        button2.setPrefSize(100, 20);
        button3.setPrefSize(100, 20);
        
        menu.setPadding(new Insets(15, 12, 15, 12));
        menu.setSpacing(10);
        menu.getChildren().addAll(button1, button2, button3);
        
        
        
        this.setTop(menu);
      
        
        
        
        
        
        
        
      
    }
}
