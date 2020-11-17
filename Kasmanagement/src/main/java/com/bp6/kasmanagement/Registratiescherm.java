/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bp6.kasmanagement;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

/**
 *
 * @author dahir
 */
public class Registratiescherm extends BorderPane {
    
    private TextField naamvak = new TextField(),
            emailvak = new TextField();

    private PasswordField wachtwoordvak = new PasswordField(),
            herhaalvak = new PasswordField();

    private Label naamlabel = new Label("Naam:"),
            emaillabel = new Label("Email:"),
            wachtwoordlabel = new Label("Wachtwoord:"),
            herhaallabel = new Label("Herhaal Wachtwoord:"),
            spacelabel = new Label("");

    private Button registratieknop = new Button("Registreren");

    private VBox vbox_nv_ev_wwv_hhwwv = new VBox(),
            vbox_nl_el_wwl_hhl = new VBox(),
            vbox__hbox = new VBox();

    private HBox hbox_rg = new HBox(),
            hbox__vbox__vbox = new HBox();

    private Inlogscherm inlogscherm;

    private Text registratietext = new Text(),
            fouttext = new Text("Wachtwoorden onjuist, probeer opnieuw!");
    
    public Registratiescherm(){
        
        naamvak.setMaxWidth(250);
        naamvak.setMinHeight(30);

        emailvak.setMaxWidth(250);
        emailvak.setMinHeight(30);

        wachtwoordvak.setMaxWidth(250);
        wachtwoordvak.setFont(new Font(10));
        wachtwoordvak.setMinHeight(30);

        herhaalvak.setMaxWidth(250);
        herhaalvak.setFont(new Font(10));
        herhaalvak.setMinHeight(30);
        
        naamlabel.setFont(Font.font("Verdana", FontWeight.BOLD, 15));

        emaillabel.setFont(Font.font("Verdana", FontWeight.BOLD, 15));
        emaillabel.setPadding(new Insets(0, 0, 3, 0));

        wachtwoordlabel.setFont(Font.font("Verdana", FontWeight.BOLD, 15));
        wachtwoordlabel.setPadding(new Insets(3, 0,0, 0));

        herhaallabel.setFont(Font.font("Verdana", FontWeight.BOLD, 15));
        herhaallabel.setPadding(new Insets(7, 0, 0, 0));
        
        fouttext.setVisible(false);
        fouttext.setFont(Font.font("Verdana", FontWeight.BOLD, 10));
        fouttext.setFill(Color.RED);
        
        spacelabel.setVisible(false);
        
        hbox_rg.getChildren().add(registratieknop);
        hbox_rg.setAlignment(Pos.CENTER_RIGHT);
        
        hbox__vbox__vbox.getChildren().addAll(vbox_nl_el_wwl_hhl, vbox_nv_ev_wwv_hhwwv);
        hbox__vbox__vbox.setSpacing(30);
        hbox__vbox__vbox.setAlignment(Pos.CENTER);
        
        vbox_nl_el_wwl_hhl.getChildren().addAll(naamlabel, emaillabel, wachtwoordlabel, herhaallabel,spacelabel);
        vbox_nl_el_wwl_hhl.setAlignment(Pos.CENTER_LEFT);
        vbox_nl_el_wwl_hhl.setSpacing(22);

        vbox_nv_ev_wwv_hhwwv.getChildren().addAll(naamvak, emailvak, wachtwoordvak, herhaalvak,fouttext, hbox_rg);
        vbox_nv_ev_wwv_hhwwv.setAlignment(Pos.CENTER);
        vbox_nv_ev_wwv_hhwwv.setSpacing(15);
        vbox_nv_ev_wwv_hhwwv.setPadding(new Insets(50, 0, 0, 0));
        vbox_nv_ev_wwv_hhwwv.setMaxWidth(250);
        
        vbox__hbox.getChildren().addAll(registratietext, hbox__vbox__vbox);
        vbox__hbox.setAlignment(Pos.TOP_RIGHT);
        vbox__hbox.setSpacing(180);
        vbox__hbox.setPadding(new Insets(0, 7, 0, 0));
        
        this.setCenter(vbox__hbox);
        
        
        registratietext.setFont(new Font(15));
        registratietext.setText("Kunt u al inloggen? Klik dan hier!");
        registratietext.setOnMousePressed(event -> {

            this.getChildren().clear();
            inlogscherm = new Inlogscherm();
            this.setCenter(inlogscherm);
        });
        
        registratietext.setOnMouseEntered(event -> {
            registratietext.setFill(Color.BLUE);
            registratietext.setUnderline(true);
            this.setCursor(Cursor.HAND);
        });

        registratietext.setOnMouseExited(event -> {
            registratietext.setFill(Color.BLACK);
            registratietext.setUnderline(false);
            this.setCursor(Cursor.DEFAULT);
        });
        
        
    }
}
