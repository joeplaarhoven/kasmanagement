/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bp6.kasmanagement.view;

import com.bp6.kasmanagement.view.Header;
import com.bp6.kasmanagement.view.Footer;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;

/**
 *
 * @author dahir
 */
public class Overzicht extends BorderPane {
     
    private Pane header = new Header();
    private BorderPane footer = new Footer();
    private BorderPane inlogscherm = new Inlogscherm();
    private BorderPane beheerderscherm = new Beheerderscherm();
  
    
    public Overzicht(){
        
       this.setTop(header);
       this.setBottom(footer);
       this.setCenter(inlogscherm);
//       this.setCenter(beheerderscherm);
       
      
    }
}
    

