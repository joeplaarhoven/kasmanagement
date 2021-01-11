/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bp6.kasmanagement.view;

import com.bp6.kasmanagement.controller.ToestemmingController;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;

/**
 *
 * @author dahir
 */
public class ToestemmingScherm extends BorderPane {
    
    private Button testKnop = new Button("test");
    private ToestemmingController toestemmingController = new ToestemmingController();
    
    public ToestemmingScherm(){
         
        testKnop.setOnAction(event->{
//            toestemmingController.setWindToestemming();
            toestemmingController.setLichtToestemming();
        });
        
        this.setCenter(testKnop);
    }
}
