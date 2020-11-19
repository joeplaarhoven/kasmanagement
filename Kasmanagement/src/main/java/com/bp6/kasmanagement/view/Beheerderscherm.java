/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bp6.kasmanagement.view;

import java.sql.Statement;
import java.time.format.DateTimeFormatter;
import java.util.Optional;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

/**
 *
 * @author dahir
 */
public class Beheerderscherm extends BorderPane{
    
    
    private HBox menu = new HBox(),gebruikerBewerk= new HBox(),
            verandering1= new HBox(),verandering2= new HBox();
    private VBox totaal = new VBox();
    private ChoiceBox gebruiker = new ChoiceBox();
    private CheckBox bewerkkeuze1 = new CheckBox("Bewerken");
    private CheckBox bewerkkeuze2 = new CheckBox("Verwijderen");
    private Label gebruikerslabel = new Label("Gebruikersnaam:         "),veranderingsLabel1 = new Label("Gebruikersnaam:"),
            veranderingslabel2 = new Label("Gebruikersnaam:");
    private Button uitloggen = new Button("Uitloggen"),
            Wissen = new Button("Wissen"), testknop = new Button("verandering2sdsdf");
    private Inlogscherm inlogscherm;
    private TextField veranderingsvak1 = new TextField(),
            veranderingsvak2 = new TextField();
    
    public Beheerderscherm(){
        
        menu.setPadding(new Insets(15, 12, 15, 12));
        menu.setSpacing(10);
        menu.getChildren().addAll(uitloggen);
        menu.setAlignment(Pos.CENTER_RIGHT);
        
        gebruiker.setMinSize(180, 30);
        
        gebruikerslabel.setFont(Font.font("Verdana", FontWeight.BOLD, 12));
        gebruikerslabel.setMinHeight(30);
        veranderingsLabel1.setFont(Font.font("Verdana", FontWeight.BOLD, 12));
        veranderingsLabel1.setMinHeight(30);
        veranderingslabel2.setFont(Font.font("Verdana", FontWeight.BOLD, 12));
        veranderingslabel2.setMinHeight(30);     
        
        veranderingsvak1.setMinSize(180, 30);
        veranderingsvak2.setMinSize(180, 30);
        
        gebruikerBewerk.getChildren().addAll(gebruikerslabel,gebruiker,bewerkkeuze1,bewerkkeuze2);
        gebruikerBewerk.setSpacing(10);
        verandering1.getChildren().addAll(veranderingsLabel1,veranderingsvak1,Wissen);
        verandering1.setSpacing(10);
        verandering2.getChildren().addAll(veranderingslabel2,veranderingsvak2);
        verandering2.setSpacing(10);
        
        testknop.setMinWidth(250);
        testknop.setVisible(false);
        Wissen.setVisible(false);
        veranderingsLabel1.setVisible(false);
        veranderingsvak1.setVisible(false);
        veranderingslabel2.setVisible(false);
        veranderingsvak2.setVisible(false);
        
        totaal.getChildren().addAll(gebruikerBewerk,verandering1,verandering2);
        totaal.setAlignment(Pos.CENTER);
        totaal.setSpacing(10);
        
        
        
        bewerkkeuze1.setOnAction(event->{
            
           if (bewerkkeuze1.isSelected() ) {

                    Wissen.setVisible(true);
                    Wissen.setText("Bewerken");
                    veranderingsLabel1.setVisible(true);
                    veranderingsLabel1.setText("Naam wijzigen:            ");
                    veranderingsvak1.setVisible(true);
                    veranderingslabel2.setVisible(true);
                    veranderingslabel2.setText("Wachtwoord wijzigen: ");
                    veranderingsvak2.setVisible(true);
                    

                } else {

                   
                }
            
        });
        
        bewerkkeuze2.setOnAction(event->{
            
           if (bewerkkeuze2.isSelected() ) {

                    Wissen.setVisible(true);
                    Wissen.setText("Verwijderen");
                    veranderingsLabel1.setVisible(false);
                    veranderingsLabel1.setText("Naam wijzigen:    ");
                    veranderingsvak1.setVisible(false);
                    veranderingslabel2.setVisible(false);
                    veranderingslabel2.setText("Wachtwoord wijzigen:");
                    veranderingsvak1.setVisible(false);
                    veranderingsvak2.setVisible(false);
                    
                } else {

                   
                }
            
        });
    
        uitloggen.setOnAction(event -> {

            this.getChildren().clear();
            inlogscherm = new Inlogscherm();
            this.setCenter(inlogscherm);

        });
        
        Wissen.setOnAction(event -> {

            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            String s = "weet u zeker dat u alle gegevens wilt verwijderen?";
            alert.setContentText(s);

            Optional<ButtonType> result = alert.showAndWait();
            });

        this.setTop(menu);
        this.setLeft(testknop);
        this.setCenter(totaal);
        
        

        
    }
    
}
