/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bp6.kasmanagement.view;

import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;

/**
 *
 * @author dahir
 */
public class SensorBeheren extends BorderPane{
    
     private Label HelloWorld = new Label("Bye World");
     
     public SensorBeheren(){
         
         this.setCenter(HelloWorld);
     }
    
}
