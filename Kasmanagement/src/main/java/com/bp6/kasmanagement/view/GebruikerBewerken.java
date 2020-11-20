/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bp6.kasmanagement.view;

import com.bp6.kasmanagement.controller.DBCPDataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Optional;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

/**
 *
 * @author dahir
 */
public class GebruikerBewerken extends BorderPane{
    
    private HBox menu = new HBox(),gebruikerBewerk= new HBox(),
            verandering1= new HBox(),verandering2= new HBox();
    private VBox totaal = new VBox();
    private ChoiceBox gebruiker = new ChoiceBox();
    private Label gebruikerslabel = new Label("Gebruikersnaam:         "),veranderingsLabel1 = new Label(),
            veranderingslabel2 = new Label();
    private Button Wissen = new Button();
    private TextField veranderingsvak1 = new TextField(),
            veranderingsvak2 = new TextField();
    private RadioButton bewerkkeuze= new RadioButton("Bewerken"), verwijderkeuze = new RadioButton("Verwijderen");
    private ToggleGroup radiogroep = new ToggleGroup();
    
    
    public GebruikerBewerken(){
        
        gebruiker.setMinSize(180, 30);
        
        gebruikerslabel.setFont(Font.font("Verdana", FontWeight.BOLD, 12));
        gebruikerslabel.setMinHeight(30);
        veranderingsLabel1.setFont(Font.font("Verdana", FontWeight.BOLD, 12));
        veranderingsLabel1.setMinHeight(30);
        veranderingslabel2.setFont(Font.font("Verdana", FontWeight.BOLD, 12));
        veranderingslabel2.setMinHeight(30);     
        
        veranderingsvak1.setMinSize(180, 30);
        veranderingsvak2.setMinSize(180, 30);
        
        bewerkkeuze.setToggleGroup(radiogroep);
        verwijderkeuze.setToggleGroup(radiogroep);
        
        gebruikerBewerk.getChildren().addAll(gebruikerslabel,gebruiker,bewerkkeuze,verwijderkeuze);
        gebruikerBewerk.setSpacing(10);
        verandering1.getChildren().addAll(veranderingsLabel1,veranderingsvak1,Wissen);
        verandering1.setSpacing(10);
        verandering2.getChildren().addAll(veranderingslabel2,veranderingsvak2);
        verandering2.setSpacing(10);
        
        Wissen.setVisible(false);
        veranderingsLabel1.setVisible(false);
        veranderingsvak1.setVisible(false);
        veranderingslabel2.setVisible(false);
        veranderingsvak2.setVisible(false);
        
        totaal.getChildren().addAll(gebruikerBewerk,verandering1,verandering2);
        totaal.setAlignment(Pos.CENTER);
        totaal.setSpacing(10);
        
//        Connection con1 = null;
//        try {
//            gebruiker.getItems().clear();
//            
//            con1 = DBCPDataSource.getConnection();
//            Statement stat = con1.createStatement();
//            ResultSet result = stat.executeQuery("select * from gebruiker");
//           
//            while(result.next()){
//                String strGbNaam = result.getString("Gebruikersnaam");
//                gebruiker.getItems().add(strGbNaam);
//               
//            }
//        } catch (SQLException se) {
//            se.printStackTrace();
//        } finally {
//            try {
//                con1.close();
//            } catch (Exception e) {
//
//            }
//        }
        
        bewerkkeuze.setOnAction(event->{
            
           if (bewerkkeuze.isSelected() ) {

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
        
        verwijderkeuze.setOnAction(event->{
            
           if (verwijderkeuze.isSelected() ) {

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
        
        Wissen.setOnAction(event -> {

            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            String s = "weet u zeker dat u alle gegevens wilt verwijderen?";
            alert.setContentText(s);

            Optional<ButtonType> result = alert.showAndWait();
            });
        
        this.setCenter(totaal);
    }
    
    
}
