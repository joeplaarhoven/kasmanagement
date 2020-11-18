package com.bp6.kasmanagement.view;

import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

/**
 *
 * @author dahir
 */
public class Header extends Pane{
    
     public Header(){
       
        this.setBackground(new Background(new BackgroundFill(Color.web("#8B0000"),null,null)));
        this.setPrefHeight(100);
    }
}
