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
public class KasBeheren extends BorderPane{
    
    private Label HelloWorld = new Label("Hello World");
    
    public KasBeheren(){
        
        this.setCenter(HelloWorld);
    }
}
