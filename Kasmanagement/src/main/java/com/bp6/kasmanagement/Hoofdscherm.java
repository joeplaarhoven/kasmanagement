/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bp6.kasmanagement;

import javafx.scene.control.Button;
import javafx.scene.control.ToolBar;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

/**
 *
 * @author dahir
 */
public class Hoofdscherm extends GridPane {
    
    ToolBar toolBar = new ToolBar();
    
    public Hoofdscherm(){
        
        Button button1 = new Button("Button 1");
        toolBar.getItems().add(button1);

        Button button2 = new Button("Button 2");
        toolBar.getItems().add(button2);

        VBox vBox = new VBox(toolBar);
        
        
        this.getChildren().addAll(vBox);
        
      
    }
}
