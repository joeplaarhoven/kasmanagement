/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bp6.kasmanagement;


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
