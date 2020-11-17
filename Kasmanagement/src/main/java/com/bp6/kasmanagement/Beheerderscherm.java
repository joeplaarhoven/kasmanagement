/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bp6.kasmanagement;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Optional;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

/**
 *
 * @author dahir
 */
public class Beheerderscherm extends BorderPane{
    
    
    private TextField testvak = new TextField();
    
    private Button uitloggen = new Button("Uitloggen"),
            Wissen = new Button("Wissen");
    
    private HBox hbox_tabelview = new HBox(),
            hbox_uitlogknop = new HBox(),
            hbox_wisknop = new HBox(),
            hbox_laco_ul = new HBox();
    
    private VBox vbox_hboxen = new VBox(),
            vbox_tabelview = new VBox();
    
    private Inlogscherm inlogscherm;
    
    private Label sorteerlabel = new Label("Sorteer op:");
    
    private TableView tableView = new TableView();
    
    public Beheerderscherm(){
        
        hbox_uitlogknop.getChildren().add(uitloggen);
        hbox_uitlogknop.setAlignment(Pos.CENTER_RIGHT);
        hbox_uitlogknop.setPadding(new Insets(5, 10, 0, 0));

        hbox_laco_ul.getChildren().addAll(hbox_uitlogknop);
        hbox_laco_ul.setAlignment(Pos.CENTER_RIGHT);
        hbox_laco_ul.setSpacing(780);

        hbox_tabelview.getChildren().add(tableView);
        hbox_tabelview.setPrefWidth(980);
        hbox_tabelview.setPrefHeight(520);
        hbox_tabelview.setAlignment(Pos.CENTER);

        hbox_wisknop.getChildren().add(Wissen);
        hbox_wisknop.setAlignment(Pos.CENTER_RIGHT);
        hbox_wisknop.setPadding(new Insets(5, 10, 0, 0));

        vbox_hboxen.getChildren().addAll(hbox_laco_ul, hbox_tabelview, hbox_wisknop);
        vbox_hboxen.setAlignment(Pos.TOP_CENTER);
        vbox_hboxen.setSpacing(20);
        
        TableColumn column1 = new TableColumn<>("tekst1");
        column1.setPrefWidth(140);
        TableColumn column2 = new TableColumn<>("tekst2");
        column2.setPrefWidth(140);
        TableColumn column3 = new TableColumn<>("tekst3");
        column3.setPrefWidth(140);
        TableColumn column4 = new TableColumn<>("tekst4");
        column4.setPrefWidth(140);
        TableColumn column5 = new TableColumn<>("tekst5");
        column5.setPrefWidth(140);
        
        tableView.setMaxWidth(980);
        tableView.getColumns().addAll(column1, column2, column3, column4, column5);
        
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

        this.setCenter(vbox_hboxen);
        
//        uitloggen.setOnAction(event -> {
//
//            this.getChildren().clear();
//            inlogscherm = new Inlogscherm();
//            this.setCenter(inlogscherm);
        
    }
    
}
